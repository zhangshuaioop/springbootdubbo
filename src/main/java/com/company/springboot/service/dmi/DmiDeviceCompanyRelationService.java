package com.company.springboot.service.dmi;

import com.alibaba.fastjson.JSON;
import com.company.springboot.entity.bif.BifDevice;
import com.company.springboot.entity.bif.BifDeviceDetail;
import com.company.springboot.entity.bif.BifDeviceInputParam;
import com.company.springboot.entity.bif.BifDeviceRet;
import com.company.springboot.entity.cfg.CfgDeviceTypeCatalog;
import com.company.springboot.entity.dmi.DmiDeviceCompanyRelation;
import com.company.springboot.entity.dmi.DmiEmployee;
import com.company.springboot.entity.dmi.DmiOrganization;
import com.company.springboot.entity.dmi.DmiStore;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.mapper.cfg.CfgDeviceTypeCatalogMapper;
import com.company.springboot.mapper.dmi.DmiDeviceCompanyRelationMapper;
import com.company.springboot.mapper.dmi.DmiEmployeeMapper;
import com.company.springboot.mapper.dmi.DmiOrganizationMapper;
import com.company.springboot.mapper.dmi.DmiStoreMapper;
import com.company.springboot.utils.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.company.springboot.entity.bif.BifDevice;
import com.company.springboot.entity.bif.BifDeviceDetail;
import com.company.springboot.entity.bif.BifDeviceInputParam;
import com.company.springboot.entity.bif.BifDeviceRet;
import com.company.springboot.entity.cfg.CfgDeviceTypeCatalog;
import com.company.springboot.entity.dmi.DmiDeviceCompanyRelation;
import com.company.springboot.entity.dmi.DmiEmployee;
import com.company.springboot.entity.dmi.DmiOrganization;
import com.company.springboot.entity.dmi.DmiStore;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.mapper.cfg.CfgDeviceTypeCatalogMapper;
import com.company.springboot.mapper.dmi.DmiDeviceCompanyRelationMapper;
import com.company.springboot.mapper.dmi.DmiEmployeeMapper;
import com.company.springboot.mapper.dmi.DmiOrganizationMapper;
import com.company.springboot.mapper.dmi.DmiStoreMapper;
import com.company.springboot.utils.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghao
 * @Title: DmiDeviceCompanyRelationService
 * @ProjectName WaterDrop
 * @Description: TODO
 * @date 2018/12/15下午4:31
 */
@Service
public class DmiDeviceCompanyRelationService {
    @Resource
    private DmiDeviceCompanyRelationMapper mapper;
    @Resource
    private CfgDeviceTypeCatalogMapper cfgDeviceTypeCatalogMapper;
    @Resource
    private DmiEmployeeMapper employeeMapper;
    @Resource
    private DmiStoreMapper storeMapper;
    @Resource
    private DmiOrganizationMapper organizationMapper;

    public Result handle(DmiDeviceCompanyRelation dmiDeviceCompanyRelation) {
        SysCompanyUsers sysCompanyUsers =  CurrentUtil.getCurrent();

        // device_id和company_id为空的时候，当前请求为非法请求
        if (dmiDeviceCompanyRelation.getDeviceId() == null || dmiDeviceCompanyRelation.getCompanyId() == null) {
            return ResultUtil.errorExceptionMsg("参数错误");
        }
        // 新增操作
        if (dmiDeviceCompanyRelation.getId() == 0) {
            dmiDeviceCompanyRelation.setCreatePerson(sysCompanyUsers.getId());
            dmiDeviceCompanyRelation.setCreateTime(new Date());
            dmiDeviceCompanyRelation.setFlagDeleted(false);
            dmiDeviceCompanyRelation.setUpdateTime(new Date());
            dmiDeviceCompanyRelation.setUpdatePerson(sysCompanyUsers.getId());
            if (dmiDeviceCompanyRelation.getPurchasePrice() == null) {
                dmiDeviceCompanyRelation.setPurchasePrice(Constant.DEFAULT_DECIMAL_ZERO);
            }
            mapper.insertSelective(dmiDeviceCompanyRelation);

        } else {
            dmiDeviceCompanyRelation.setUpdateTime(new Date());
            dmiDeviceCompanyRelation.setUpdatePerson(sysCompanyUsers.getId());
            mapper.updateByPrimaryKeySelective(dmiDeviceCompanyRelation);
        }
        return ResultUtil.success();
    }

    public Result handleInvalid(Integer id) {
        SysCompanyUsers sysCompanyUsers =  CurrentUtil.getCurrent();
        // id为空的时候，当前请求为非法请求
        if (id == null) {
            return ResultUtil.errorExceptionMsg("参数错误");
        }
        // 失效操作
        DmiDeviceCompanyRelation dmiDeviceCompanyRelation = new DmiDeviceCompanyRelation();
        dmiDeviceCompanyRelation.setUpdatePerson(sysCompanyUsers.getId());
        dmiDeviceCompanyRelation.setUpdateTime(new Date());
        dmiDeviceCompanyRelation.setId(id);
        mapper.updateByPrimaryKeySelective(dmiDeviceCompanyRelation);
        return ResultUtil.success();
    }

    public Result handleDelete(Integer id) {
        SysCompanyUsers sysCompanyUsers =  CurrentUtil.getCurrent();
        // id为空的时候，当前请求为非法请求
        if (id == null) {
            return ResultUtil.errorExceptionMsg("参数错误");
        }
        // 删除操作
        DmiDeviceCompanyRelation dmiDeviceCompanyRelation = new DmiDeviceCompanyRelation();
        dmiDeviceCompanyRelation.setUpdatePerson(sysCompanyUsers.getId());
        dmiDeviceCompanyRelation.setUpdateTime(new Date());
        dmiDeviceCompanyRelation.setFlagDeleted(true);
        dmiDeviceCompanyRelation.setId(id);
        mapper.updateByPrimaryKeySelective(dmiDeviceCompanyRelation);
        return ResultUtil.success();
    }


    public Result list(DmiDeviceCompanyRelation dmiDeviceCompanyRelation) {
        // companyId为空的时候，返回空集合
        if (dmiDeviceCompanyRelation.getCompanyId() == null) {
            return ResultUtil.errorExceptionMsg("参数错误");
        }
        PageHelper.startPage(dmiDeviceCompanyRelation.getPageNum(), dmiDeviceCompanyRelation.getPageSize());
        Page<DmiDeviceCompanyRelation> persons = mapper.queryBycompanyId(dmiDeviceCompanyRelation);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<DmiDeviceCompanyRelation> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

    public Result getListByCompanyId(BifDeviceDetail bifDeviceDetail) {
        // companyId为空的时候，返回空集合
        if (bifDeviceDetail.getCompanyId() == null) {
            return ResultUtil.errorExceptionMsg("参数错误");
        }
        PageHelper.startPage(bifDeviceDetail.getPageNum(), bifDeviceDetail.getPageSize());
        Page<BifDeviceDetail> persons = mapper.queryListByCompanyId(bifDeviceDetail.getCompanyId());
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<BifDeviceDetail> pageInfo = new PageInfo<>(persons);

        return ResultUtil.success(pageInfo);
    }

    public Result getListByCompanyIdAndObject(BifDeviceInputParam bifDeviceInputParam) {
        bifDeviceInputParam = setCatalogIdList(bifDeviceInputParam);
        String assignType = bifDeviceInputParam.getType();
        if ("STORE".equals(assignType)) {
            return ResultUtil.success(mapper.queryListByCompanyIdAndObjectForStore(bifDeviceInputParam));
        } else if ("ORG".equals(assignType)) {
            return ResultUtil.success(mapper.queryListByCompanyIdAndObjectForOrg(bifDeviceInputParam));
        } else if ("PERSON".equals(assignType)) {
            // 根据条件首先查询符合条件的所有员工id集合
            DmiEmployee employee = new DmiEmployee();
            employee.setBelongCompanyId(bifDeviceInputParam.getCompanyId());
            employee.setEmployeeName(bifDeviceInputParam.getEmployeeName());
            employee.setMobile(bifDeviceInputParam.getMobile());
            employee.setEmail(bifDeviceInputParam.getEmail());
            employee.setEmployeeCode(bifDeviceInputParam.getEmployeeCode());
            List<DmiEmployee> employeeList = employeeMapper.selectByObject(employee);
            List<Integer> idList = new ArrayList<Integer>();
            for (DmiEmployee item : employeeList) {
                idList.add(item.getId());
            }
            if (!idList.isEmpty()) {
                bifDeviceInputParam.setPersonIdList(idList);
                // 查询设备
                return ResultUtil.success(mapper.queryListByCompanyIdAndObjectForPerson(bifDeviceInputParam));
            } else {
                return ResultUtil.success(new ArrayList<BifDeviceRet>());
            }
        } else {
            List<BifDeviceRet> result = new ArrayList<BifDeviceRet>();
            List<BifDeviceRet> list = mapper.queryListByCompanyIdAndObject(bifDeviceInputParam);
            for (BifDeviceRet item : list) {
                if ("STORE".equals(item.getAssignType())) {
                    DmiStore store = storeMapper.selectByPrimaryKey(item.getAssignId());
                    item.setAssignName("门店");
                    item.setAssignName(store.getStoreName());
                } else if ("ORG".equals(item.getAssignType())) {
                    DmiOrganization organization = organizationMapper.selectByPrimaryKey(item.getAssignId());
                    item.setAssignName("部门");
                    item.setAssignName(organization.getOrganizationName());
                } else if ("PERSON".equals(item.getAssignType())) {
                    DmiEmployee employee = employeeMapper.selectByPrimaryKey(item.getAssignEmployeeId());
                    item.setAssignName("员工");
                    item.setAssignName(employee.getEmployeeName());
                }
                result.add(item);
            }
            return ResultUtil.success(result);
        }
    }

    private BifDeviceInputParam setCatalogIdList(BifDeviceInputParam bifDeviceInputParam) {
        ArrayList<Integer> paramList = new ArrayList<Integer>();
        paramList.add(bifDeviceInputParam.getCatalogId());

        List<Integer> inputList = new ArrayList<Integer>();
        inputList.add(bifDeviceInputParam.getCatalogId());
        boolean flag = true;

        while (flag) {
            List<CfgDeviceTypeCatalog> list =cfgDeviceTypeCatalogMapper.queryByParentId(inputList);
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

    public Result getDeviceNotInCompany() {
        return  ResultUtil.success(mapper.queryDeviceNotInCompany());
    }

    public Result getDeviceNotInCompanyByObject(BifDeviceInputParam bifDeviceInputParam) {
        bifDeviceInputParam = setCatalogIdList(bifDeviceInputParam);
        List<BifDevice> sqlResuult = mapper.queryDeviceNotInCompanyByObject(bifDeviceInputParam);
       return ResultUtil.success(sqlResuult);
    }
}
