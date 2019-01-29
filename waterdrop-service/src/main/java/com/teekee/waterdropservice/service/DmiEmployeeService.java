package com.teekee.waterdropservice.service;

import com.teekee.commoncomponets.utils.PageInfo;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import com.teekee.waterdropservice.Thread.ImportDTO;
import com.teekee.waterdropservice.Thread.ImportThread;
import com.teekee.waterdropservice.entity.dmi.DmiEmployee;
import com.teekee.waterdropservice.entity.dmi.DmiEmployeeExport;
import com.teekee.waterdropservice.entity.dmi.DmiEmployeeUniqueness;
import com.teekee.waterdropservice.entity.sys.SysCompanyUsers;
import com.teekee.waterdropservice.mapper.dmi.DmiEmployeeMapper;
import com.teekee.waterdropservice.mapper.trc.TrcDmiBatchEmpolyeeImportMapper;
import com.teekee.waterdropservice.service.dmi.DmiOrganizationService;
import com.teekee.waterdropservice.service.file.FileServiceImpl;
import com.teekee.waterdropservice.utils.*;
import com.github.pagehelper.PageHelper;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Chenliwen
 * @Date 2019/1/9 18:26
 **/
@Service
public class DmiEmployeeService {

    @Resource
    private DmiEmployeeMapper dmiEmployeeMapper;
    @Resource
    private DmiOrganizationService organizationService;
    @Resource
    private ImportThread importThread;
    @Resource
    private TrcDmiBatchEmpolyeeImportMapper batchEmpolyeeImportMapper;
    @Resource
    private FileServiceImpl fileService;

    /**
     * 定义一个线程池
     */
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

    public Result list(DmiEmployee dmiEmployee) {
        dmiEmployee.setCatalogSourceListId("," + dmiEmployee.getCatalogId());
        dmiEmployee.setCatalogSourceList(dmiEmployee.getCatalogId() + ",");
        List<DmiEmployee> record = new ArrayList<>();
        List<DmiEmployee> employee = dmiEmployeeMapper.list(dmiEmployee);
        if(employee.size()>0) {
            if (dmiEmployee.getPageNum() != null & dmiEmployee.getPageSize() != null) {
                PageHelper.startPage(dmiEmployee.getPageNum(), dmiEmployee.getPageSize());
                PageInfo<DmiEmployee> result = new PageInfo<>(employee);
                return ResultUtil.success(result);
            }
            return ResultUtil.success(employee);
        }
        return ResultUtil.success(record);
    }

    public Result handle(DmiEmployee record) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        Date now = new Date();
        if (record.getId() == 0) {
            record.setFlagManual(true);
            record.setFlagDeleted(false);
            record.setFlagAvailable(true);
            record.setCreateTime(now);
            record.setCreatePerson(user.getId());
            record.setUpdatePerson(user.getId());
            record.setUpdateTime(now);
            dmiEmployeeMapper.insertSelective(record);
            return ResultUtil.successMsg("新增员工成功！");
        } else {
            record.setUpdatePerson(user.getId());
            record.setUpdateTime(now);
            dmiEmployeeMapper.updateByPrimaryKeySelective(record);
            return ResultUtil.successMsg("更新员工成功！");
        }
    }


    /**
     * 校验数据
     *
     * @param file
     * @param uniqueness
     * @return
     */
    public Result check(CommonsMultipartFile file, String uniqueness) {

        SysCompanyUsers user = CurrentUtil.getCurrent();

        HSSFWorkbook wb;
        try {
            wb = new HSSFWorkbook(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return ResultUtil.validateError("发生严重错误，预判是传入的文件出现严重错误，请人工处理后再次处理");
        }
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row;
        HSSFCell cell;
        StringBuffer message = new StringBuffer("");
        List<DmiEmployeeUniqueness> uniquenessList = new ArrayList<DmiEmployeeUniqueness>();
        int temp;
        if ("mobile".equals(uniqueness)) {
            temp = 8;
        } else if ("name".equals(uniqueness)) {
            temp = 0;
        } else if ("jobNumber".equals(uniqueness)) {
            temp = 2;
        } else if ("idNumber".equals(uniqueness)) {
            temp = 12;
        } else if ("email".equals(uniqueness)) {
            temp = 14;
        } else {
            temp = -1;
        }
        for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            boolean saveFlag = true;
            row = sheet.getRow(i);
            if (row == null) {
                message.append("第 " + (i + 1) + " 行， 为空；");
                continue;
            }
            StringBuffer column = new StringBuffer(" ");
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                String value = ExcelUtil.getStringValForExcel(cell);
                // 联系人姓名 中文不得超过25位，英文不得超过50位，不能为空
                if (j == 0) {
                    if (value.equals("") || ValiDateUtil.length(value) > 50 || ValiDateUtil.hasNumeric(value)) {
                        column.append((j + 1) + " | ");
                        saveFlag = false;
                    }
                    if (j == temp) {
                        DmiEmployeeUniqueness employeeUniqueness = new DmiEmployeeUniqueness();
                        employeeUniqueness.setFieldName("联系人姓名");
                        employeeUniqueness.setFieldValue(value);
                        employeeUniqueness.setRow(i + 1);
                        uniquenessList.add(employeeUniqueness);
                    }
                }
                // 联系人英文名（不得超过100位，只能是半角英文，空格，不能为空）
                if (j == 1) {
                    if (value.equals("") || ValiDateUtil.length(value) > 100 || !ValiDateUtil.isAllHalfAlpha(value)) {
                        column.append((j + 1) + " | ");
                        saveFlag = false;
                    }
                }
                // 工号（不得超过50位，只能是半角英数，符号，不能为空）
                if (j == 2) {
                    if (value.equals("") || ValiDateUtil.length(value) > 50 || !ValiDateUtil.isAllHalf(value)) {
                        column.append((j + 1) + " | ");
                        saveFlag = false;
                    }
                    if (j == temp) {
                        DmiEmployeeUniqueness employeeUniqueness = new DmiEmployeeUniqueness();
                        employeeUniqueness.setFieldName("工号");
                        employeeUniqueness.setFieldValue(value);
                        employeeUniqueness.setRow(i + 1);
                        uniquenessList.add(employeeUniqueness);
                    }
                }
                // 组织机构编码，必须是英文数字或者下划线，不能超过50个，并且必须是有效的组织结构编码，不能为空
                if (j == 3) {
                    if (value.equals("") || ValiDateUtil.length(value) > 50 || !ValiDateUtil.isAllHalf(value) || organizationService
                            .getOragnizationByCompanyIdAndCode(user.getCompanyId(), value) == null) {
                        column.append((j + 1) + " | ");
                        saveFlag = false;
                    }
                }
                // 性别必须是“男”或者“女”，不能为空
                if (j == 4) {
                    if (!"男".equals(value) && !"女".equals(value)) {
                        column.append((j + 1) + " | ");
                        saveFlag = false;
                    }
                }
                // 职位不能超过25个汉字，不能为空 学历不能超过25个汉字，不能为空
                if (j == 5 || j == 6) {
                    if (value.equals("") || ValiDateUtil.length(value) > 50 || !ValiDateUtil.isChinese(value)) {
                        column.append((j + 1) + " | ");
                        saveFlag = false;
                    }
                }
                // 联系电话-座机(手机)不能超过50位，除了数字和“-”以及半角的括号和逗号，别的字符不允许出现
                if ((j == 7 || j == 8) && !value.equals("")) {
                    if (ValiDateUtil.length(value) > 50 || !ValiDateUtil.isAllHalfNum(value)) {
                        column.append((j + 1) + " | ");
                        saveFlag = false;
                    }
                    if (j == temp) {
                        DmiEmployeeUniqueness employeeUniqueness = new DmiEmployeeUniqueness();
                        employeeUniqueness.setFieldName("手机");
                        employeeUniqueness.setFieldValue(value);
                        employeeUniqueness.setRow(i + 1);
                        uniquenessList.add(employeeUniqueness);
                    }
                }
                // 籍贯，名族，证件类型 只能是汉字，不能超过25个汉字
                if ((j == 9 || j == 10 || j == 11) && !value.equals("")) {
                    if (ValiDateUtil.length(value) > 50 || !ValiDateUtil.isChinese(value)) {
                        column.append((j + 1) + " | ");
                        saveFlag = false;
                    }
                }
                // 证件号不能超过100位，只能是半角英数
                if ((j == 12) && !value.equals("")) {
                    if (ValiDateUtil.length(value) > 100 || !ValiDateUtil.isAllHalf(value) || !ValiDateUtil.isAlphanumeric(value)) {
                        column.append((j + 1) + " | ");
                        saveFlag = false;
                    }
                    if (j == temp) {
                        DmiEmployeeUniqueness employeeUniqueness = new DmiEmployeeUniqueness();
                        employeeUniqueness.setFieldName("证件号");
                        employeeUniqueness.setFieldValue(value);
                        employeeUniqueness.setRow(i + 1);
                        uniquenessList.add(employeeUniqueness);
                    }
                }
                // 住址不能超过200位
                if ((j == 13) && !value.equals("")) {
                    if (ValiDateUtil.length(value) > 200) {
                        column.append((j + 1) + " | ");
                        saveFlag = false;
                    }
                }
                // 邮箱
                if ((j == 14) && !value.equals("")) {
                    if (ValiDateUtil.length(value) > 200 || !ValiDateUtil.isEmail(value)) {
                        column.append((j + 1) + " | ");
                        saveFlag = false;
                    }
                    if (j == temp) {
                        DmiEmployeeUniqueness employeeUniqueness = new DmiEmployeeUniqueness();
                        employeeUniqueness.setFieldName("邮箱");
                        employeeUniqueness.setFieldValue(value);
                        employeeUniqueness.setRow(i + 1);
                        uniquenessList.add(employeeUniqueness);
                    }
                }
            }
            if (!saveFlag) message.append("第 " + (i + 1) + " 行， 第 " + column + " 列，数据有误；");
        }

        // 检测重复字段
        if (!uniquenessList.isEmpty()) {
            // 定义放置重复字段行数的集合
            List<Integer> repeatRowList = new ArrayList<Integer>();
            // 循环待检测字段的集合
            for (DmiEmployeeUniqueness item : uniquenessList) {
                for (int j = 0; j < uniquenessList.size(); j++) {
                    String value = item.getFieldValue();
                    String comparedValue = uniquenessList.get(j).getFieldValue();
                    if (value.equals(comparedValue)) {
                        if (!repeatRowList.contains(item.getRow())) {
                            repeatRowList.add(item.getRow());
                        }
                    }
                }
            }
            if (!repeatRowList.isEmpty()) {
                StringBuffer repeatRowString = new StringBuffer("");
                for (Integer item : repeatRowList) {
                    repeatRowString.append(item + "| ");
                }
                message.append("第 " + repeatRowString + " 行， " + uniquenessList.get(0).getFieldName() + " 数据重复；");
            } else {
                // 检测字段与数据库中是否重复
                DmiEmployee employee = new DmiEmployee();
                employee.setBelongCompanyId(user.getCompanyId());
                for (DmiEmployeeUniqueness item : uniquenessList) {
                    if ("mobile".equals(uniqueness)) {
                        employee.setMobile(item.getFieldValue());
                    } else if ("name".equals(uniqueness)) {
                        employee.setEmployeeName(item.getFieldValue());
                    } else if ("jobNumber".equals(uniqueness)) {
                        employee.setEmployeeCode(item.getFieldValue());
                    } else if ("idNumber".equals(uniqueness)) {
                        employee.setIdCode(item.getFieldValue());
                    } else if ("email".equals(uniqueness)) {
                        employee.setEmail(item.getFieldValue());
                    } else {
                        continue;
                    }
                    if (dmiEmployeeMapper.selectByCompanyAndObject(employee) != null) {
                        repeatRowList.add(item.getRow());
                    }
                }
                if (!repeatRowList.isEmpty()) {
                    StringBuffer repeatRowString = new StringBuffer("");
                    for (Integer item : repeatRowList) {
                        repeatRowString.append(item + "| ");
                    }
                    message.append("第 " + repeatRowString + " 行， " + uniquenessList.get(0).getFieldName() + " 数据在系统中已经存在；");
                }
            }
        }

        if (!"".equals(message.toString())) {
            return ResultUtil.validateError(message.toString());
        } else {
            String fileName = System.currentTimeMillis() + ".xls";
            String filePath = ExcelUtil.getLocalFilePath() + fileName;
            File copyFile = new File(filePath);
            try {
                file.transferTo(copyFile);
            } catch (IOException e) {
                e.printStackTrace();
                return ResultUtil.validateError("文件校验通过，系统保存时发生故障，强联系管理员！");
            }
            return ResultUtil.successMsg(fileName);
        }

    }

    public Result importEmployee(ImportDTO importDTO) {

        SysCompanyUsers user = CurrentUtil.getCurrent();

        importDTO.setBelongCompanyId(user.getCompanyId());
        importDTO.setUserId(user.getId());
        importDTO.setBatchInsertCode("IE_" + System.currentTimeMillis());
        importThread.setImportDTO(importDTO);
        executor.execute(importThread);
        return ResultUtil.successMsg(importDTO.getBatchInsertCode());
    }

    public Result importCallBack(String batchInsertCode) {
        return ResultUtil.success(batchEmpolyeeImportMapper.selectByBatchInsertCode(batchInsertCode));
    }

    public Result transfer(DmiEmployee dmiEmployee) {
        SysCompanyUsers user = CurrentUtil.getCurrent();

        dmiEmployee.setUpdatePerson(user.getId());
        dmiEmployee.setUpdateTime(new Date());
        dmiEmployeeMapper.updateByPrimaryKeySelective(dmiEmployee);
        return ResultUtil.successMsg("转岗成功！");
    }

    public Result handleDelete(DmiEmployee dmiEmployee) {
        SysCompanyUsers user = CurrentUtil.getCurrent();

        Date now = new Date();
        dmiEmployee.setUpdatePerson(user.getId());
        dmiEmployee.setUpdateTime(now);
        dmiEmployee.setFlagDeleted(true);
        dmiEmployeeMapper.updateByPrimaryKeySelective(dmiEmployee);
        return ResultUtil.successMsg("员工删除成功!");
    }

    public Result handleInvalid(DmiEmployee dmiEmployee) {
        SysCompanyUsers user = CurrentUtil.getCurrent();

        Date now = new Date();
        dmiEmployee.setUpdatePerson(user.getId());
        dmiEmployee.setUpdateTime(now);
        dmiEmployee.setFlagAvailable(false);
        dmiEmployeeMapper.updateByPrimaryKeySelective(dmiEmployee);
        return ResultUtil.successMsg("失效成功");
    }

    public Result show(int id) {
        return ResultUtil.success(dmiEmployeeMapper.selectByPrimaryKey(id));
    }

    public Result export(DmiEmployee dmiEmployee) {
        // 根据条件查询符合条件的员工列表
        List<DmiEmployeeExport> sqlResult = dmiEmployeeMapper.listForExport(dmiEmployee);

        // 下载
        long fileName = System.currentTimeMillis();
        OutputStream out;
        try {
            File filepath = new File("/usr/local/tempFile_xls");
            if (!filepath.exists()) {
                filepath.mkdir();
            }
            String sCurrPath = filepath + ExcelUtil.FILE_SEPARATOR + "EMPLOYEE_" + fileName + ".xls";
            out = new FileOutputStream(sCurrPath);
        } catch (FileNotFoundException e) {
            return ResultUtil.validateError("找不到默认保存文件的目录，请联系管理员！");
        }

        ExcelUtil.exportEmployeeExcel(sqlResult, out);
        File uploadFile = new File("/usr/local/tempFile_xls" + ExcelUtil.FILE_SEPARATOR + "EMPLOYEE_" + fileName + ".xls");
        try {
            return fileService.upload(fileName + ".xls", new FileInputStream(uploadFile), "excel");
        } catch (FileNotFoundException e) {
            return ResultUtil.validateError("文件没有找到，请联系管理员！");
        }
    }
}
