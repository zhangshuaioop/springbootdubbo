package com.teekee.waterdropservice.Thread;

import com.teekee.waterdropservice.entity.dmi.DmiEmployee;
import com.teekee.waterdropservice.entity.dmi.DmiOrganization;
import com.teekee.waterdropservice.entity.trc.TrcDmiBatchEmpolyeeImport;
import com.teekee.waterdropservice.mapper.dmi.DmiEmployeeMapper;
import com.teekee.waterdropservice.mapper.dmi.DmiOrganizationMapper;
import com.teekee.waterdropservice.mapper.trc.TrcDmiBatchEmpolyeeImportMapper;
import com.teekee.waterdropservice.utils.ExcelUtil;
import com.google.common.collect.Maps;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Component
public class ImportThread implements Runnable {

    @Resource
    private DmiEmployeeMapper employeeMapper;
    @Resource
    private TrcDmiBatchEmpolyeeImportMapper batchEmpolyeeImportMapper;
    @Resource
    private DmiOrganizationMapper organizationMapper;

    private ImportDTO importDTO;

    public synchronized ImportDTO getImportDTO() {
        ImportDTO result = this.importDTO;
        this.importDTO = null;
        notifyAll();
        return result;
    }

    public synchronized void setImportDTO(ImportDTO importDTO) {
        if (this.importDTO != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.importDTO = importDTO;
    }

    public void run() {

        ImportDTO importDTO = getImportDTO();
        Date now = new Date();

        // 插入批次表
        TrcDmiBatchEmpolyeeImport batchEmpolyeeImport = new TrcDmiBatchEmpolyeeImport();
        batchEmpolyeeImport.setCreateTime(now);
        batchEmpolyeeImport.setOperatorId(importDTO.getUserId());
        batchEmpolyeeImport.setCompanyId(importDTO.getBelongCompanyId());
        batchEmpolyeeImport.setStatus("PROCESSING");
        batchEmpolyeeImport.setBatchInsertCode(importDTO.getBatchInsertCode());
        batchEmpolyeeImport.setImportCount(0);
        batchEmpolyeeImportMapper.insertSelective(batchEmpolyeeImport);

        File file = new File(ExcelUtil.getLocalFilePath() + importDTO.getFileName());
        HSSFWorkbook wb = null;
        try {
            wb = new HSSFWorkbook(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
            updateErrorBatchImport(batchEmpolyeeImport.getId(), importDTO.getUserId());
        }
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row;
        HSSFCell cell;
        List<DmiEmployee> list = new ArrayList<DmiEmployee>();
        List<String> orgList = new ArrayList<String>();
        Map<String, Object> map = Maps.newHashMap();
        for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            DmiEmployee employee = new DmiEmployee();
            row = sheet.getRow(i);
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                String value = ExcelUtil.getStringValForExcel(cell);
                employee.setCreateTime(now);
                employee.setBatchInsertCode(importDTO.getBatchInsertCode());
                employee.setBelongCompanyId(importDTO.getBelongCompanyId());
                map.put("belongsCompanyId", importDTO.getBelongCompanyId());
                employee.setCreatePerson(importDTO.getUserId());
                employee.setFlagDeleted(false);
                employee.setFlagAvailable(true);
                employee.setFlagManual(false);
                // 联系人姓名
                if (j == 0) {
                    employee.setEmployeeName(value);
                }
                // 联系人英文名
                if (j == 1) {
                    employee.setEmployeeNameEn(value);
                }
                // 工号
                if (j == 2) {
                    employee.setEmployeeCode(value);
                }
                // 组织机构编码
                if (j == 3) {
                    orgList.add(value);
                }
                // 性别
                if (j == 4) {
                    if ("男".equals(value)) {
                        employee.setSex("Male");
                    } else {
                        employee.setSex("Female");
                    }
                }
                // 职位不能超过25个汉字，不能为空 学历不能超过25个汉字，不能为空
                if (j == 5) {
                    employee.setPosition(value);
                }
                // 学历
                if (j == 6) {
                    employee.setEducationCertification(value);
                }
                // 联系电话-座机(手机)不能超过50位，除了数字和“-”以及半角的括号和逗号，别的字符不允许出现
                if (j == 7) {
                    employee.setTelephone(value);
                }
                // 手机
                if (j == 8) {
                    employee.setMobile(value);
                }
                // 籍贯
                if (j == 9) {
                    employee.setNativePlace(value);
                }
                // 名族
                if (j == 10) {
                    employee.setNation(value);
                }
                // 证件类型
                if (j == 11) {
                    employee.setIdType(value);
                }
                // 证件号不能超过100位，只能是半角英数
                if (j == 12) {
                    employee.setIdCode(value);
                }
                // 住址不能超过200位
                if (j == 13) {
                    employee.setAddress(value);
                }
                // 邮箱
                if (j == 14) {
                    employee.setEmail(value);
                }
                // 备注
                if (j == 15) {
                    employee.setMemo(value);
                }
            }
            list.add(employee);
        }
        map.put("list", orgList);
        importDate(list, map, importDTO.getUserId(), batchEmpolyeeImport.getId());
    }

    private void updateErrorBatchImport(int id, int operatorId) {
        TrcDmiBatchEmpolyeeImport batchEmpolyeeImport = new TrcDmiBatchEmpolyeeImport();
        batchEmpolyeeImport.setUpdateTime(new Date());
        batchEmpolyeeImport.setOperatorId(operatorId);
        batchEmpolyeeImport.setId(id);
        batchEmpolyeeImport.setStatus("FAILURE");
        batchEmpolyeeImportMapper.updateByPrimaryKeySelective(batchEmpolyeeImport);
    }

    @Transactional(rollbackFor = Exception.class)
    public void importDate(List<DmiEmployee> list, Map<String, Object> map, int userId, int batchId) {
        // 查询组织机构
        List<DmiOrganization> organizationList = organizationMapper.getIdListByCompanyIdAndCode(map);
        List<String> orgList = (List) map.get("list");
        for (int i = 0; i < orgList.size(); i++) {
            Iterator<DmiOrganization> iterator = organizationList.iterator();
            while (iterator.hasNext()) {
                DmiOrganization dmiOrganization = iterator.next();
                if (orgList.get(i).equals(dmiOrganization.getOrganizationCode())) {
                    list.get(i).setCatalogId(dmiOrganization.getId());
                    break;
                }
            }
        }

        // 分批插入
        int a = 1000;//每次提交1000条
        int loop = (int) Math.ceil(list.size() / (double) a);

        List<DmiEmployee> tempList = new ArrayList<DmiEmployee>(a);
        int start, stop;
        for (int i = 0; i < loop; i++) {
            tempList.clear();
            start = i * a;
            stop = Math.min(i * a + a - 1, list.size() - 1);
            for (int j = start; j <= stop; j++) {
                tempList.add(list.get(j));
            }
            employeeMapper.insertDmiEmployeeList(tempList);
            System.out.println("已经插入" + (stop + 1) + " 条");
        }

        TrcDmiBatchEmpolyeeImport batchEmpolyeeImport = new TrcDmiBatchEmpolyeeImport();
        batchEmpolyeeImport.setUpdateTime(new Date());
        batchEmpolyeeImport.setOperatorId(userId);
        batchEmpolyeeImport.setId(batchId);
        batchEmpolyeeImport.setStatus("SUCCESS");
        batchEmpolyeeImport.setImportCount(list.size());
        batchEmpolyeeImportMapper.updateByPrimaryKeySelective(batchEmpolyeeImport);
    }


}
