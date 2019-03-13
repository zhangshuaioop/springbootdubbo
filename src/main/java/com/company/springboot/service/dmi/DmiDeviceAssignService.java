package com.company.springboot.service.dmi;

import com.company.springboot.entity.bif.BifDeviceDetail;
import com.company.springboot.entity.bif.BifDeviceInputParam;
import com.company.springboot.entity.dmi.*;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.entity.trc.TrcDeviceOperateLog;
import com.company.springboot.mapper.dmi.*;
import com.company.springboot.mapper.trc.TrcDeviceOperateLogMapper;
import com.company.springboot.utils.CurrentUtil;
import com.company.springboot.utils.PageInfo;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghao
 * @Title: DmiDeviceAssignService
 * @ProjectName WaterDrop
 * @Description: TODO
 * @date 2018/12/15下午4:05
 */
@Service
public class DmiDeviceAssignService {

    @Resource
    private DmiDeviceAssignMapper dmiDeviceAssignMapper;
    @Resource
    private DmiDeviceCompanyRelationMapper deviceCompanyRelationMapper;
    @Resource
    private DmiCompanyInfoMapper companyInfoMapper;
    @Resource
    private DmiEmployeeMapper employeeMapper;
    @Resource
    private DmiStoreMapper storeMapper;
    @Resource
    private DmiOrganizationMapper organizationMapper;
    @Resource
    private TrcDeviceOperateLogMapper deviceOperateLogMapper;


    public Result assign(DmiDeviceAssignWithList record) {

        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();

        Date now = new Date();

        // 获取待分配的设备集合
        List<DmiDeviceAssign> assignIdList = record.getDeviceAssignList();

        // 循环分配
        for (DmiDeviceAssign item : assignIdList) {
            item.setCreatePerson(sysCompanyUsers.getId());
            item.setCreateTime(now);
            item.setAssignDate(now);
            item.setFlagDeleted(false);
            dmiDeviceAssignMapper.insertSelective(item);

            // 修改已分配标记
            DmiDeviceCompanyRelation deviceCompanyRelation = deviceCompanyRelationMapper.selectByDeviceId(item.getDeviceId());
            if (deviceCompanyRelation.getFlagAssign()) {
                return ResultUtil.errorExceptionMsg("合并分配失败，存在已分配的设备！");
            }
            deviceCompanyRelation.setFlagAssign(true);
            deviceCompanyRelationMapper.updateByPrimaryKeySelective(deviceCompanyRelation);

            // 插入设备操作日志
            TrcDeviceOperateLog deviceOperateLog = new TrcDeviceOperateLog();
            deviceOperateLog.setCreatePerson(sysCompanyUsers.getId());
            deviceOperateLog.setCreateTime(now);
            if (item.getAssignType().equals("PERSON")) {
                deviceOperateLog.setOpType("ASSIGN-PERSON");
            } else if (item.getAssignType().equals("STORE")) {
                deviceOperateLog.setOpType("ASSIGN-STORE");
            } else {
                deviceOperateLog.setOpType("ASSIGN-ORG");
            }
            deviceOperateLog.setDeviceId(item.getDeviceId());
            deviceOperateLog.setBelongCompanyId(deviceCompanyRelation.getCompanyId());
            // 操作的起点位置详情
            DmiCompanyInfo companyInfo = companyInfoMapper.selectByPrimaryKey(item.getDeviceCompanyId());
            if (companyInfo != null) {
                deviceOperateLog.setOpFromObjType("COMPANY");
                deviceOperateLog.setOpFromObjId(item.getDeviceCompanyId());
                deviceOperateLog.setOpFromObjName(companyInfo.getCompanyName());
            } else {
                deviceOperateLog.setOpFromObjType("");
                deviceOperateLog.setOpFromObjId(0);
                deviceOperateLog.setOpFromObjName("");
            }
            // 操作的终点位置信息
            if (item.getAssignType().equals("PERSON")) {
                DmiEmployee employee = employeeMapper.selectByPrimaryKey(item.getAssignedEmployeeId());
                if (employee != null) {
                    deviceOperateLog.setOpToObjType("PERSON");
                    deviceOperateLog.setOpToObjId(item.getAssignedEmployeeId());
                    deviceOperateLog.setOpToObjName(employee.getEmployeeName());
                } else {
                    deviceOperateLog.setOpToObjType("");
                    deviceOperateLog.setOpToObjId(0);
                    deviceOperateLog.setOpToObjName("");
                }
            } else if (item.getAssignType().equals("STORE")) {
                DmiStore store = storeMapper.selectByPrimaryKey(item.getAssignedSectionId());
                if (store != null) {
                    deviceOperateLog.setOpToObjType("STORE");
                    deviceOperateLog.setOpToObjId(item.getAssignedSectionId());
                    deviceOperateLog.setOpToObjName(store.getStoreName());
                } else {
                    deviceOperateLog.setOpToObjType("");
                    deviceOperateLog.setOpToObjId(0);
                    deviceOperateLog.setOpToObjName("");
                }
            } else {
                DmiOrganization organization = organizationMapper.selectByPrimaryKey(item.getAssignedSectionId());
                if (organization != null) {
                    deviceOperateLog.setOpToObjType("ORG");
                    deviceOperateLog.setOpToObjId(item.getAssignedSectionId());
                    deviceOperateLog.setOpToObjName(organization.getOrganizationName());
                } else {
                    deviceOperateLog.setOpToObjType("");
                    deviceOperateLog.setOpToObjId(0);
                    deviceOperateLog.setOpToObjName("");
                }
            }
            deviceOperateLog.setOpDescription("从 " + deviceOperateLog.getOpFromObjName() + " 分配给 " + deviceOperateLog.getOpToObjName());
            deviceOperateLogMapper.insertSelective(deviceOperateLog);
        }
        return ResultUtil.success();
    }

    public Result release(DmiDeviceAssignWithList record) {// 获取待回收的设备集合
        List<DmiDeviceAssign> releaseIdList = record.getDeviceAssignList();
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        // 循环回收
        for (DmiDeviceAssign item : releaseIdList) {

            // 修改已分配标记
            DmiDeviceCompanyRelation deviceCompanyRelation = deviceCompanyRelationMapper.selectByDeviceId(item.getDeviceId());
            deviceCompanyRelation.setFlagAssign(false);
            deviceCompanyRelationMapper.updateByPrimaryKeySelective(deviceCompanyRelation);

            // 插入设备操作日志
            TrcDeviceOperateLog deviceOperateLog = new TrcDeviceOperateLog();
            deviceOperateLog.setCreatePerson(sysCompanyUsers.getId());
            deviceOperateLog.setCreateTime(new Date());
            if (item.getAssignType().equals("PERSON")) {
                deviceOperateLog.setOpType("RETRIEVE-PERSON");
            } else if (item.getAssignType().equals("STORE")) {
                deviceOperateLog.setOpType("RETRIEVE-STORE");
            } else {
                deviceOperateLog.setOpType("RETRIEVE-ORG");
            }
            deviceOperateLog.setDeviceId(item.getDeviceId());
            deviceOperateLog.setBelongCompanyId(deviceCompanyRelation.getCompanyId());
            // 操作的起始位置信息
            if (item.getAssignType().equals("PERSON")) {
                DmiEmployee employee = employeeMapper.selectByPrimaryKey(item.getAssignedEmployeeId());
                if (employee != null) {
                    deviceOperateLog.setOpFromObjType("PERSON");
                    deviceOperateLog.setOpFromObjId(item.getAssignedEmployeeId());
                    deviceOperateLog.setOpFromObjName(employee.getEmployeeName());
                } else {
                    deviceOperateLog.setOpFromObjType("");
                    deviceOperateLog.setOpFromObjId(0);
                    deviceOperateLog.setOpFromObjName("");
                }
            } else if (item.getAssignType().equals("STORE")) {
                DmiStore store = storeMapper.selectByPrimaryKey(item.getAssignedSectionId());
                if (store != null) {
                    deviceOperateLog.setOpFromObjType("STORE");
                    deviceOperateLog.setOpFromObjId(item.getAssignedSectionId());
                    deviceOperateLog.setOpFromObjName(store.getStoreName());
                } else {
                    deviceOperateLog.setOpFromObjType("");
                    deviceOperateLog.setOpFromObjId(0);
                    deviceOperateLog.setOpFromObjName("");
                }
            } else {
                DmiOrganization organization = organizationMapper.selectByPrimaryKey(item.getAssignedSectionId());
                if (organization != null) {
                    deviceOperateLog.setOpFromObjType("ORG");
                    deviceOperateLog.setOpFromObjId(item.getAssignedSectionId());
                    deviceOperateLog.setOpFromObjName(organization.getOrganizationName());
                } else {
                    deviceOperateLog.setOpFromObjType("");
                    deviceOperateLog.setOpFromObjId(0);
                    deviceOperateLog.setOpFromObjName("");
                }
            }
            // 操作的终点位置详情
            DmiCompanyInfo companyInfo = companyInfoMapper.selectByPrimaryKey(item.getDeviceCompanyId());
            if (companyInfo != null) {
                deviceOperateLog.setOpToObjType("COMPANY");
                deviceOperateLog.setOpToObjId(item.getDeviceCompanyId());
                deviceOperateLog.setOpToObjName(companyInfo.getCompanyName());
            } else {
                deviceOperateLog.setOpToObjType("");
                deviceOperateLog.setOpToObjId(0);
                deviceOperateLog.setOpToObjName("");
            }
            deviceOperateLog.setOpDescription("从 " + deviceOperateLog.getOpFromObjName() + " 收回");
            deviceOperateLogMapper.insertSelective(deviceOperateLog);

            // 修改分配表数据
            item.setUpdatePerson(sysCompanyUsers.getId());
            item.setUpdateTime(new Date());
            item.setFlagDeleted(true);
            dmiDeviceAssignMapper.updateByDeviceIdAndStoreId(item);
        }
        return ResultUtil.success();

    }

    public Result list(BifDeviceInputParam record) {
        PageHelper.startPage(record.getPageNum(), record.getPageSize());
        Page<BifDeviceDetail> persons = dmiDeviceAssignMapper.selectByStoreIdAndObj(record);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<BifDeviceDetail> pageInfo = new PageInfo<>(persons);
        if(pageInfo.getList()==null||pageInfo.getList().size()==0){
            pageInfo.setPageNum(1);
            pageInfo.setPageSize(10);
        }
        return ResultUtil.success(pageInfo);
    }
}
