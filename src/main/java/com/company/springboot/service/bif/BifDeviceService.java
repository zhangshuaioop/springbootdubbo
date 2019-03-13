package com.company.springboot.service.bif;

import com.alibaba.fastjson.JSON;
import com.company.springboot.entity.bif.*;
import com.company.springboot.entity.cfg.CfgDeviceTypeCatalog;
import com.company.springboot.entity.dmi.*;
import com.company.springboot.entity.file.DeleteFile;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.entity.trc.TrcDeviceOperateLog;
import com.company.springboot.mapper.bif.BifDeviceMapper;
import com.company.springboot.mapper.bif.BifDeviceUploadFileMapper;
import com.company.springboot.mapper.bif.BifSupplyCompanyMapper;
import com.company.springboot.mapper.cfg.CfgDeviceTypeCatalogMapper;
import com.company.springboot.mapper.dmi.*;
import com.company.springboot.mapper.trc.TrcDeviceOperateLogMapper;
import com.company.springboot.service.file.FileServiceImpl;
import com.company.springboot.utils.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author zhanghao
 * @Title: BifDeviceService
 * @ProjectName WaterDrop
 * @Description: 设备相关
 * @date 2018/12/14下午6:31
 */
@Service
public class BifDeviceService {

    @Resource
    private BifDeviceMapper bifDeviceMapper;
    @Resource
    private DmiDeviceCompanyRelationMapper deviceCompanyRelationMapper;
    @Resource
    private CfgDeviceTypeCatalogMapper cfgDeviceTypeCatalogMapper;
    @Resource
    private BifDeviceUploadFileMapper deviceUploadFileMapper;
    @Resource
    private DmiDeviceAssignMapper dmiDeviceAssignMapper;
    @Resource
    private DmiEmployeeMapper employeeMapper;
    @Resource
    private DmiStoreMapper storeMapper;
    @Resource
    private DmiOrganizationMapper organizationMapper;
    @Resource
    private BifSupplyCompanyMapper bifSupplyCompanyMapper;
    @Resource
    private DmiCompanyInfoMapper dmiCompanyInfoMapper;
    @Resource
    private TrcDeviceOperateLogMapper deviceOperateLogMapper;
    @Autowired
    private FileServiceImpl fileService;
    @Value("${filepath}")
    private String filePath;


    public Result getDeviceList(BifDevice bifDevice) {
        PageHelper.startPage(bifDevice.getPageNum(), bifDevice.getPageSize());
        Page<BifDeviceDetail> persons = bifDeviceMapper.findListPage(bifDevice);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<BifDeviceDetail> pageInfo = new PageInfo<>(persons);
        if(pageInfo.getList()==null||pageInfo.getList().size()==0){
            pageInfo.setPageNum(1);
            pageInfo.setPageSize(10);
        }
        return ResultUtil.success(pageInfo);
    }

    public Result getListByObject(BifDeviceInputParam bifDeviceInputParam) {
        PageHelper.startPage(bifDeviceInputParam.getPageNum(), bifDeviceInputParam.getPageSize());
        bifDeviceInputParam = setCatalogIdList(bifDeviceInputParam);
        Page<BifDeviceRet> persons = bifDeviceMapper.queryListByObject(bifDeviceInputParam);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<BifDeviceRet> pageInfo = new PageInfo<>(persons);
        if(pageInfo.getList()==null||pageInfo.getList().size()==0){
            pageInfo.setPageNum(1);
            pageInfo.setPageSize(10);
        }
        return ResultUtil.success(pageInfo);
    }


    public Result deviceShow(Integer id) {
        BifDeviceDetail result = bifDeviceMapper.selectDeviceDetailById(id);
        if (result != null) {
            // 获取父级分类名称
            CfgDeviceTypeCatalog cfgDeviceTypeCatalog = cfgDeviceTypeCatalogMapper.selectByPrimaryKey(result.getCatalogId());
            if(cfgDeviceTypeCatalog!=null){
                int level = cfgDeviceTypeCatalog.getLevel();
                if (level == 3) {
                    result.setChildNode(cfgDeviceTypeCatalog.getCatalogName());
                    CfgDeviceTypeCatalog father = cfgDeviceTypeCatalogMapper.selectByPrimaryKey(cfgDeviceTypeCatalog.getParentId());
                    result.setFatherNode(father.getCatalogName());
                    CfgDeviceTypeCatalog grandfather = cfgDeviceTypeCatalogMapper.selectByPrimaryKey(father.getParentId());
                    result.setGrandFatherNode(grandfather.getCatalogName());
                }
                if (level == 2) {
                    result.setFatherNode(cfgDeviceTypeCatalog.getCatalogName());
                    CfgDeviceTypeCatalog grandfather = cfgDeviceTypeCatalogMapper.selectByPrimaryKey(cfgDeviceTypeCatalog.getParentId());
                    result.setGrandFatherNode(grandfather.getCatalogName());
                }
                if (level == 1) {
                    result.setGrandFatherNode(cfgDeviceTypeCatalog.getCatalogName());
                }
            }
            // 获取绑定的雇主信息
            DmiDeviceCompanyRelation dmiDeviceCompanyRelation = deviceCompanyRelationMapper.selectByDeviceId(id);
            if(dmiDeviceCompanyRelation!=null){
                BifSupplyCompany supplyCompany = bifSupplyCompanyMapper.selectByPrimaryKey(dmiDeviceCompanyRelation.getSupplyCompanyId());
                if (supplyCompany != null) {
                    result.setSupplyCompanyName(supplyCompany.getCompanyName());
                }
                result.setSupplyCompanyId(dmiDeviceCompanyRelation.getSupplyCompanyId());
                result.setMonetaryUnit(dmiDeviceCompanyRelation.getMonetaryUnit());
                result.setAssetSn(dmiDeviceCompanyRelation.getAssetSn());
                result.setPurchaseDate(dmiDeviceCompanyRelation.getPurchaseDate());
                result.setPurchasePrice(dmiDeviceCompanyRelation.getPurchasePrice());
            }
            // 设备资料
            result.setDeviceUploadFileList(deviceUploadFileMapper.selectByDeviceId(id));
            // 设备使用信息
            DmiDeviceAssign dmiDeviceAssign = dmiDeviceAssignMapper.selectByDeviceId(id);
            if (dmiDeviceAssign != null) {
                result.setAssignDate(dmiDeviceAssign.getAssignDate());
                String temp = dmiDeviceAssign.getAssignType();
                Integer sectionId = dmiDeviceAssign.getAssignedSectionId();
                Integer employeeId = dmiDeviceAssign.getAssignedEmployeeId();
                if ("PERSON".equals(temp)) {
                    result.setAssignType("员工");
                    DmiEmployee employee = employeeMapper.selectByPrimaryKey(employeeId);
                    result.setAssignTypeName(employee.getEmployeeName());
                    result.setOrg(employee.getCatalogSourceList());
                    result.setAssignId(employeeId);
                }
                if ("STORE".equals(temp)) {
                    result.setAssignType("门店");
                    DmiStore store = storeMapper.selectByPrimaryKey(sectionId);
                    if(store != null){

                        result.setAssignTypeName(store.getStoreName());
                        Integer areaId = store.getAreaId();
                        if (areaId != null) {
                            DmiOrganization organization = organizationMapper.selectByPrimaryKey(areaId);
                            int sqlLevel = organization.getLevel();
                            String orgName = organization.getOrganizationName() + " | " + store.getStoreName();
                            while (sqlLevel != 1) {
                                organization = organizationMapper.selectByPrimaryKey(organization.getParentId());
                                orgName = organization.getOrganizationName() + " | " + orgName;
                                sqlLevel = organization.getLevel();
                            }
                            result.setOrg(orgName);
                            result.setAssignId(sectionId);
                        }

                    }

                }
                if ("ORG".equals(temp)) {
                    result.setAssignType("公司部门");
                    DmiOrganization organization = organizationMapper.selectByPrimaryKey(sectionId);
                    result.setAssignId(sectionId);
                    result.setAssignTypeName(organization.getOrganizationName());
                    int sqlLevel = organization.getLevel();
                    String orgName = organization.getOrganizationName();
                    while (sqlLevel != 1) {
                        organization = organizationMapper.selectByPrimaryKey(organization.getParentId());
                        orgName = organization.getOrganizationName() + " | " + orgName;
                        sqlLevel = organization.getLevel();
                    }
                    result.setOrg(orgName);
                }
            }


        }
        return ResultUtil.success(result);
    }

    public Result handle(String requestJson) {
        try {
            BifDevice device = JSON.parseObject(requestJson, BifDevice.class);
            DmiDeviceCompanyRelation dmiDeviceCompanyRelation = JSON.parseObject(requestJson, DmiDeviceCompanyRelation.class);
            SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
            Date now = new Date();
            //新增设备信息
            if(device.getId()==null || device.getId()==0){
                // 新增设备
                device.setCreatePerson(sysCompanyUsers.getId());
                device.setCreateTime(now);
                device.setUpdatePerson(sysCompanyUsers.getId());
                device.setUpdateTime(now);
                device.setFlagDeleted(false);
                if (device.getUseExpireDate() != null && device.getUseExpireDate().before(now)) {
                    // 停用日期不为空并且在当前日期之前，则设备设置成不可用状态
                    device.setFlagUsable(false);
                } else {
                    device.setFlagUsable(true);
                }
                if (device.getWarrantyExpireDate() == null || device.getWarrantyExpireDate().before(now)) {
                    // 停保日期为空或者停保日期在当前日期之前的情况下，设备设置成停保状态
                    device.setFlagWarranty(false);
                } else {
                    device.setFlagWarranty(true);
                }
                bifDeviceMapper.insertSelective(device);
                // 将设备绑定到公司
                dmiDeviceCompanyRelation.setDeviceId(device.getId());
                dmiDeviceCompanyRelation.setFlagAssign(false);
                dmiDeviceCompanyRelation.setFlagDeleted(false);
                dmiDeviceCompanyRelation.setCreatePerson(sysCompanyUsers.getId());
                dmiDeviceCompanyRelation.setCreateTime(now);
                deviceCompanyRelationMapper.insertSelective(dmiDeviceCompanyRelation);

                // 插入设备操作日志
                TrcDeviceOperateLog deviceOperateLog = new TrcDeviceOperateLog();
                deviceOperateLog.setCreatePerson(sysCompanyUsers.getId());
                deviceOperateLog.setCreateTime(now);
                deviceOperateLog.setOpType("BUY");
                deviceOperateLog.setDeviceId(device.getId());
                deviceOperateLog.setBelongCompanyId(dmiDeviceCompanyRelation.getCompanyId());
                // 操作的起始位置信息
                BifSupplyCompany supplyCompany = bifSupplyCompanyMapper.selectByPrimaryKey(dmiDeviceCompanyRelation.getSupplyCompanyId());
                if (supplyCompany != null) {
                    deviceOperateLog.setOpFromObjType("SUPPLY");
                    deviceOperateLog.setOpFromObjId(dmiDeviceCompanyRelation.getSupplyCompanyId());
                    deviceOperateLog.setOpFromObjName(supplyCompany.getCompanyName());
                } else {
                    deviceOperateLog.setOpFromObjType("");
                    deviceOperateLog.setOpFromObjId(0);
                    deviceOperateLog.setOpFromObjName("");
                }
                // 操作的终点位置详情
                DmiCompanyInfo companyInfo = dmiCompanyInfoMapper.selectByPrimaryKey(dmiDeviceCompanyRelation.getCompanyId());
                if (companyInfo != null) {
                    deviceOperateLog.setOpToObjType("COMPANY");
                    deviceOperateLog.setOpToObjId(dmiDeviceCompanyRelation.getCompanyId());
                    deviceOperateLog.setOpToObjName(companyInfo.getCompanyName());
                } else {
                    deviceOperateLog.setOpToObjType("");
                    deviceOperateLog.setOpToObjId(0);
                    deviceOperateLog.setOpToObjName("");
                }
                deviceOperateLog.setOpDescription("从 " + deviceOperateLog.getOpFromObjName() + " 采购");
                deviceOperateLogMapper.insertSelective(deviceOperateLog);

                // 设备资料
                BifDeviceUploadFile record = new BifDeviceUploadFile();
                record.setId(null);
                record.setDeviceId(device.getId());
                record.setCreatePerson(sysCompanyUsers.getId());
                record.setCreateTime(now);
                record.setFlagDeleted(false);
                BifDeviceUploadFileWithList deviceUploadFileWithList = JSON.parseObject(requestJson, BifDeviceUploadFileWithList.class);
                List<BifDeviceUploadFile> deviceUploadFileList = deviceUploadFileWithList.getList();
                for (int i = 0; i < deviceUploadFileList.size(); i++) {
                    record.setFileName(deviceUploadFileList.get(i).getFileName());
                    record.setFileUrl(deviceUploadFileList.get(i).getFileUrl());
                    record.setFileType(deviceUploadFileList.get(i).getFileType());
                    deviceUploadFileMapper.insertSelective(record);
                }
            }else {
                // 更新设备
                device.setUpdatePerson(sysCompanyUsers.getId());
                device.setUpdateTime(now);
                if (device.getUseExpireDate() != null && device.getUseExpireDate().before(now)) {
                    // 停用日期不为空并且在当前日期之前，则设备设置成不可用状态
                    device.setFlagUsable(false);
                } else {
                    device.setFlagUsable(true);
                }
                if (device.getWarrantyExpireDate() == null || device.getWarrantyExpireDate().before(now)) {
                    // 停保日期为空或者停保日期在当前日期之前的情况下，设备设置成停保状态
                    device.setFlagWarranty(false);
                } else {
                    device.setFlagWarranty(true);
                }
                bifDeviceMapper.updateByPrimaryKeySelective(device);

                // 更新设备与雇主关系
                DmiDeviceCompanyRelation relation = deviceCompanyRelationMapper.selectByDeviceId(device.getId());
                dmiDeviceCompanyRelation.setId(relation.getId());
                dmiDeviceCompanyRelation.setUpdatePerson(sysCompanyUsers.getId());
                dmiDeviceCompanyRelation.setUpdateTime(now);
                deviceCompanyRelationMapper.updateByPrimaryKeySelective(dmiDeviceCompanyRelation);

                // 查询该设备所有的设备资料
                List<BifDeviceUploadFile> sqlResultList = deviceUploadFileMapper.selectByDeviceId(device.getId());
                Map<Integer, BifDeviceUploadFile> sqlResultMap = Maps.newHashMap();
                List<Integer> sqlResultIdList = new ArrayList<Integer>();
                for (BifDeviceUploadFile item : sqlResultList) {
                    sqlResultMap.put(item.getId(), item);
                    sqlResultIdList.add(item.getId());
                }
                BifDeviceUploadFileWithList deviceUploadFileWithList = JSON.parseObject(requestJson, BifDeviceUploadFileWithList.class);
                // 获取页面参数传入的所有设备资料
                List<BifDeviceUploadFile> paramList = deviceUploadFileWithList.getList();
                Map<Integer, BifDeviceUploadFile> paramMap = Maps.newHashMap();
                List<Integer> paramIdList = new ArrayList<Integer>();
                for (BifDeviceUploadFile item : paramList) {
                    paramMap.put(item.getId(), item);
                    paramIdList.add(item.getId());
                }

                // 计算得到需要添加和删除的资料集合
                List<Integer> addList = new ArrayList<Integer>();
                List<Integer> delList = new ArrayList<Integer>();
                for (Integer item : paramIdList) {
                    if (!sqlResultIdList.contains(item)) addList.add(item);
                }
                for (Integer item : sqlResultIdList) {
                    if (!paramIdList.contains(item)) delList.add(item);
                }
                // 删除资料
                for (Integer item : delList) {
                    BifDeviceUploadFile deleteItem = sqlResultMap.get(item);
                    deleteItem.setFlagDeleted(true);
                    deviceUploadFileMapper.updateByPrimaryKeySelective(deleteItem);
                    // 调用删除接口
                    DeleteFile deleteFile = new DeleteFile();
                    String url = sqlResultMap.get(item).getFileUrl();
                    String key = url.substring(url.lastIndexOf(".com/") + 5);
                    String type = url.substring(7, url.indexOf("."));
                    deleteFile.setKey(key);
                    deleteFile.setType(type);
                    fileService.delete(deleteFile);
                }
                // 上传资料
                for (Integer item : addList) {
                    BifDeviceUploadFile addItem = paramMap.get(item);
                    addItem.setId(null);
                    addItem.setDeviceId(device.getId());
                    addItem.setCreateTime(now);
                    addItem.setCreatePerson(sysCompanyUsers.getId());
                    addItem.setFlagDeleted(false);
                    deviceUploadFileMapper.insertSelective(addItem);
                }
            }

            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.errorExceptionMsg("异常");
        }

    }

    public Result handleDelete(Integer id) {
        DmiDeviceCompanyRelation dmiDeviceCompanyRelation = deviceCompanyRelationMapper.selectByDeviceId(id);
        if(dmiDeviceCompanyRelation!=null){
            return ResultUtil.errorExceptionMsg("设备已分配无法删除!");
        }
        // 设定删除
        BifDevice bifDevice = new BifDevice();
        bifDevice.setFlagDeleted(true);
        bifDevice.setUpdateTime(new Date());
        bifDevice.setUpdatePerson(CurrentUtil.getCurrent().getId());
        bifDevice.setId(id);
        bifDeviceMapper.updateByPrimaryKeySelective(bifDevice);
        return ResultUtil.success();
    }

    public Result disable(BifDisableDevice bifDisableDevice) {
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        if(sysCompanyUsers==null){
            return ResultUtil.JurisdictionError("");
        }
        List<BifDevice> bifDevicList = bifDisableDevice.getList();
        for (BifDevice bifDevice:bifDevicList) {
            bifDevice.setFlagUsable(false);
            bifDevice.setUpdatePerson(sysCompanyUsers.getId());
            bifDevice.setUpdateTime(new Date());
            bifDevice.setUseExpireDate(new Date());
            bifDeviceMapper.updateByPrimaryKeySelective(bifDevice);
        }
        return ResultUtil.success();
    }

    public Result downloadDeviceList(BifDeviceInputParam record) {
        List<BifDeviceListDownloadRet> deviceList;
        // 根据条件查询设备列表
        record = setCatalogIdList(record);
        String assignType = record.getType();
        if ("STORE".equals(assignType)) {
            deviceList = bifDeviceMapper.queryListByCompanyIdAndObjectForStore(record);
        } else if ("ORG".equals(assignType)) {
            deviceList = bifDeviceMapper.queryListByCompanyIdAndObjectForOrg(record);
        } else if ("PERSON".equals(assignType)) {
            // 根据条件首先查询符合条件的所有员工id集合
            DmiEmployee employee = new DmiEmployee();
            employee.setBelongCompanyId(record.getCompanyId());
            employee.setEmployeeName(record.getEmployeeName());
            employee.setMobile(record.getMobile());
            employee.setEmail(record.getEmail());
            employee.setEmployeeCode(record.getEmployeeCode());
            List<DmiEmployee> employeeList = employeeMapper.selectByObject(employee);
            List<Integer> idList = new ArrayList<Integer>();
            for (DmiEmployee item : employeeList) {
                idList.add(item.getId());
            }
            if (!idList.isEmpty()) {
                record.setPersonIdList(idList);
                // 查询设备
                deviceList = bifDeviceMapper.queryListByCompanyIdAndObjectForPerson(record);
            } else {
                deviceList = new ArrayList<BifDeviceListDownloadRet>();
            }
        } else {
            deviceList = bifDeviceMapper.queryListByCompanyIdAndObject(record);
        }


        long fileName = System.currentTimeMillis();
        OutputStream out;
        try {
            File filepath = new File(filePath);
            if (!filepath.exists()) {
                filepath.mkdir();
            }
            String sCurrPath = filepath +"/DEVICE_" + fileName + ".xls";
            out = new FileOutputStream(sCurrPath);
        } catch (FileNotFoundException e) {
            return ResultUtil.errorExceptionMsg("\"找不到默认保存文件的目录，请联系管理员！\"");
        }
        ExcelUtil.exportDeviceExcel(deviceList, out);
        File uploadFile = new File(filePath +  "/DEVICE_" + fileName + ".xls");
        try {
            return fileService.upload(fileName + ".xls", new FileInputStream(uploadFile), "excel");
        } catch (FileNotFoundException e) {
            return ResultUtil.errorExceptionMsg("文件没有找到，请联系管理员！");
        }
    }

    private BifDeviceInputParam setCatalogIdList(BifDeviceInputParam bifDeviceInputParam) {
        ArrayList<Integer> paramList = new ArrayList<Integer>();
        paramList.add(bifDeviceInputParam.getCatalogId());

        List<Integer> inputList = new ArrayList<Integer>();
        inputList.add(bifDeviceInputParam.getCatalogId());
        boolean flag = true;

        while (flag) {
            List<CfgDeviceTypeCatalog> list = cfgDeviceTypeCatalogMapper.queryByParentId(inputList);
            if (list == null || list.isEmpty()) {
                flag = false;
            } else {
                inputList.clear();
                for (int i = 0; i < list.size(); i++) {
                    paramList.add(list.get(i).getId());
                    inputList.add(list.get(i).getId());
                }
            }
        }
        bifDeviceInputParam.setCatalogIdList(paramList);
        return bifDeviceInputParam;
    }
}
