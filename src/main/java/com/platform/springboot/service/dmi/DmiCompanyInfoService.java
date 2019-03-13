package com.platform.springboot.service.dmi;

import com.github.pagehelper.PageHelper;
import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.dmi.DmiCompanyInfo;
import com.platform.springboot.entity.dmi.DmiOrganization;
import com.platform.springboot.entity.fdp.FdpFaultReportRoute;
import com.platform.springboot.entity.syscompany.*;
import com.platform.springboot.entity.syscompany.response.SysCompanyUsersAdminRes;
import com.platform.springboot.entity.sysconsole.SysConsoleUsers;
import com.platform.springboot.mapper.dmi.DmiCompanyInfoMapper;
import com.platform.springboot.mapper.dmi.DmiOrganizationMapper;
import com.platform.springboot.mapper.fdp.FdpFaultReportRouteMapper;
import com.platform.springboot.mapper.syscompany.*;
import com.platform.springboot.utils.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:雇主公司信息
 * @author: zhangshuai
 * @create: 2018-12-29 16:17
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DmiCompanyInfoService extends BaseService<DmiCompanyInfoMapper,DmiCompanyInfo> {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DmiCompanyInfoMapper dmiCompanyInfoMapper;

    @Autowired
    private SysCompanyPurchaseVersionMapper sysCompanyPurchaseVersionMapper;

    @Autowired
    private SysCompanyPermissionMapper sysCompanyPermissionMapper;

    @Autowired
    private SysCompanyUsersMapper sysCompanyUsersMapper;

    @Autowired
    private SysPublishVersionPermissionMapper sysPublishVersionPermissionMapper;

    @Autowired
    private SysCompanyRolePermissionMapper sysCompanyRolePermissionMapper;

    @Autowired
    private SysCompanyRoleMapper sysCompanyRoleMapper;

    @Autowired
    private SysCompanyUserRoleRelationMapper sysCompanyUserRoleRelationMapper;

    @Autowired
    private FdpFaultReportRouteMapper fdpFaultReportRouteMapper;

    @Autowired
    private DmiOrganizationMapper dmiOrganizationMapper;

    /**
     * 分页列表
     * @param dmiCompanyInfo
     * @return
     */
    public Result findPage(DmiCompanyInfo dmiCompanyInfo){
        PageHelper.startPage(dmiCompanyInfo.getPageNum(), dmiCompanyInfo.getPageSize());
        List<DmiCompanyInfo> persons = dmiCompanyInfoMapper.companyByFlagPlatform(dmiCompanyInfo);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<DmiCompanyInfo> pageInfo = new PageInfo<>(persons);
        if(pageInfo.getList()==null||pageInfo.getList().size()==0){
            pageInfo.setPageNum(1);
            pageInfo.setPageSize(10);
        }
        return ResultUtil.success(pageInfo);
    }

    /**
     * 公司保存/更新
     * @param dmiCompanyInfo
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result saveOrUpdate(DmiCompanyInfo dmiCompanyInfo){

        SysConsoleUsers sysConsoleUsers = CurrentUtil.getCurrent();
        dmiCompanyInfo.setUpdatePerson(sysConsoleUsers.getId());
        if(dmiCompanyInfo != null){

            if(dmiCompanyInfo.getId() != null && dmiCompanyInfo.getId() > 0) {
                logger.info("进入更新业务");
                dmiCompanyInfoMapper.updateByPrimaryKeySelective(dmiCompanyInfo);
                return ResultUtil.success("更新成功");
            }else {
                logger.info("进入保存业务");
                if(dmiCompanyInfoMapper.selectCompanyName(dmiCompanyInfo.getCompanyName()) == null){

                    boolean isNext = true;

                    logger.info("初始化用户账号");
                    while (isNext){
                        String username = MathUtil.getUserName(8);
                        if(sysCompanyUsersMapper.selectByUserName(username) == null){

                            logger.info("开始创建公司");
                            dmiCompanyInfo.setFlagDeleted(false);
                            dmiCompanyInfo.setFlagAvailable(true);
                            dmiCompanyInfo.setFlagIndependence(true);  //是否独立公司
                            dmiCompanyInfo.setCreatePerson(sysConsoleUsers.getId());
                            dmiCompanyInfoMapper.insertGetId(dmiCompanyInfo);

                            logger.info("创建管理员账号");
                            String password = "123456";
                            SysCompanyUsers sysCompanyUsers = new SysCompanyUsers();
                            sysCompanyUsers.setUsername(username);
                            sysCompanyUsers.setPassword(MD5Utils.MD5Encode(password,"utf-8"));
                            sysCompanyUsers.setNickname("超级管理员");
                            sysCompanyUsers.setFlagDeleted(false);
                            sysCompanyUsers.setFlagAvailable(true);
                            sysCompanyUsers.setFlagAdmin(true);
                            sysCompanyUsers.setCompanyId(dmiCompanyInfo.getId());
                            sysCompanyUsersMapper.insertSelective(sysCompanyUsers);

                            logger.info("创建一套报障路径配置");
                            FdpFaultReportRoute fdpFaultReportRoute = new FdpFaultReportRoute();
                            fdpFaultReportRoute.setCompanyId(dmiCompanyInfo.getId());
                            fdpFaultReportRoute.setCreatePerson(sysCompanyUsers.getId());
                            fdpFaultReportRoute.setRouteObject("DEMAND");
                            fdpFaultReportRouteMapper.inserts(fdpFaultReportRoute);

                            logger.info("创建雇主公司组织机构");
                            DmiOrganization dmiOrganization = new DmiOrganization();
                            dmiOrganization.setOrganizationName("全国");
                            dmiOrganization.setOrganizationCode("default_cod");
                            dmiOrganization.setLevel(1);
                            dmiOrganization.setParentId(0);
                            dmiOrganization.setOrderId(0);
                            dmiOrganization.setBelongsCompanyId(dmiCompanyInfo.getId());
                            dmiOrganization.setFlagFiliale(false);
                            dmiOrganization.setBusinessLicenseId(0);
                            dmiOrganization.setFlagDeleted(false);
                            dmiOrganization.setFlagAvailable(true);
                            dmiOrganization.setCreatePerson(sysCompanyUsers.getId());
                            dmiOrganization.setUpdatePerson(sysCompanyUsers.getId());
                            dmiOrganizationMapper.insertSelective(dmiOrganization);

                            logger.info("进入超级管理员赋权");
                            SysCompanyPurchaseVersion sysCompanyPurchaseVersion = new SysCompanyPurchaseVersion();
                            sysCompanyPurchaseVersion.setCompanyId(dmiCompanyInfo.getId());
                            sysCompanyPurchaseVersion.setVersionId(2);     //初始版本
                            sysCompanyPurchaseVersion.setUserId(sysCompanyUsers.getId());
                            Result result = updateCompanyPermission(sysCompanyPurchaseVersion);

                            if(result.getCode()==200){
                                return ResultUtil.success("创建公司成功,初始用户名:"+username+",密码:"+password);
                            }
                            return result;
                        }
                    }

                }
                    return ResultUtil.errorBusinessMsg("公司已存在");


            }

        }else {
            return ResultUtil.validateError("");
        }
    }


    /**
     * 赋予公司版本
     * @param sysCompanyPurchaseVersion
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result updateCompanyPermission(SysCompanyPurchaseVersion sysCompanyPurchaseVersion){

        try {

            logger.info("获取版本权限");
            String permissionIds = sysPublishVersionPermissionMapper.selectPermissionIds(sysCompanyPurchaseVersion);

            logger.info("获取公司超级管理员账号");
            SysCompanyUsersAdminRes sysCompanyUsersAdminRes = sysCompanyUsersMapper.selectByAdmin(sysCompanyPurchaseVersion.getCompanyId());

            //超级管理员角色id
            Integer roleId = 0;

            if(sysCompanyUsersAdminRes != null && sysCompanyUsersAdminRes.getRoleId() != null){
                logger.info("删除当前公司角色权限");
                SysCompanyRolePermission sysCompanyRolePermission = new SysCompanyRolePermission();
                sysCompanyRolePermission.setCompanyId(sysCompanyPurchaseVersion.getCompanyId());
                sysCompanyRolePermission.setRoleId(sysCompanyUsersAdminRes.getRoleId());
                sysCompanyRolePermissionMapper.deleteByRoleAndCompanyId(sysCompanyRolePermission);
            }else {
                sysCompanyUsersAdminRes = new SysCompanyUsersAdminRes();
                sysCompanyUsersAdminRes.setId(sysCompanyPurchaseVersion.getUserId());

                SysConsoleUsers sysConsoleUsers = CurrentUtil.getCurrent();
                logger.info("新建超级管理员角色");
                SysCompanyRole sysCompanyRole = new SysCompanyRole();
                sysCompanyRole.setCompanyId(sysCompanyPurchaseVersion.getCompanyId());
                sysCompanyRole.setCreatePerson(sysConsoleUsers.getId());
                sysCompanyRole.setRoleName("超级管理员");
                sysCompanyRole.setUpdatePerson(sysConsoleUsers.getId());
                sysCompanyRoleMapper.insertGetId(sysCompanyRole);

                roleId = sysCompanyRole.getId();

                logger.info("赋予超级管理员角色");
                SysCompanyUserRoleRelation sysCompanyUserRoleRelation = new SysCompanyUserRoleRelation();
                sysCompanyUserRoleRelation.setCompanyId(sysCompanyPurchaseVersion.getCompanyId());
                sysCompanyUserRoleRelation.setCreatePerson(sysConsoleUsers.getId());
                sysCompanyUserRoleRelation.setRoleId(roleId);
                sysCompanyUserRoleRelation.setUserId(sysCompanyUsersAdminRes.getId());
                sysCompanyUserRoleRelation.setUpdatePerson(sysConsoleUsers.getId());
                sysCompanyUserRoleRelation.setFlagDeleted(false);
                sysCompanyUserRoleRelationMapper.insertSelective(sysCompanyUserRoleRelation);
            }

            logger.info("保存当前公司角色权限");
            sysCompanyRolePermissionMapper.saveRoleAuthority(roleId,sysCompanyPurchaseVersion.getCompanyId(),
                    sysCompanyUsersAdminRes.getId(),sysCompanyUsersAdminRes.getId(),permissionIds.split(","));

            logger.info("赋予公司版本");
            sysCompanyPurchaseVersion.setUpdatePerson(sysCompanyPurchaseVersion.getUserId());
            if(sysCompanyPurchaseVersionMapper.updateByPrimaryKeySelective(sysCompanyPurchaseVersion)==0){
                sysCompanyPurchaseVersion.setFlagDeleted(false);
                sysCompanyPurchaseVersion.setCreatePerson(sysCompanyPurchaseVersion.getUserId());
                sysCompanyPurchaseVersionMapper.insertSelective(sysCompanyPurchaseVersion);
            }
            logger.info("更新redis中角色权限");
            String jsonStr = JsonUtils.getListToJson(sysCompanyPermissionMapper.selectRedisApiAll());
            RedisUtil.set("sys_company_api_all",jsonStr);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.errorExceptionMsg("");
        }
        return ResultUtil.success();
    }

}
