package com.teekee.waterdropservice.service.dmi;

import com.teekee.commoncomponets.base.BaseService;
import com.teekee.commoncomponets.utils.*;
import com.teekee.waterdropservice.entity.bif.BifMd5CodePool;
import com.teekee.waterdropservice.entity.dmi.DmiCompanyInfo;
import com.teekee.waterdropservice.entity.dmi.DmiCompanyInfoWithBusinessLicense;
import com.teekee.waterdropservice.entity.dmi.DmiOrganization;
import com.teekee.waterdropservice.entity.fdp.FdpFaultReportRoute;
import com.teekee.waterdropservice.entity.sys.*;
import com.teekee.waterdropservice.entity.sys.response.SysCompanyUsersAdminRes;
import com.teekee.waterdropservice.mapper.bif.BifMd5CodePoolMapper;
import com.teekee.waterdropservice.mapper.dmi.DmiCompanyInfoMapper;
import com.teekee.waterdropservice.mapper.dmi.DmiOrganizationMapper;
import com.teekee.waterdropservice.mapper.fdp.FdpFaultReportRouteMapper;
import com.teekee.waterdropservice.mapper.sys.*;
import com.teekee.waterdropservice.service.file.FileServiceImpl;
import com.teekee.waterdropservice.utils.*;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 公司信息
 * @author: zhangshuai
 * @create: 2018-12-14 18:35
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DmiCompanyInfoService extends BaseService<DmiCompanyInfoMapper, DmiCompanyInfo> {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DmiCompanyInfoMapper dmiCompanyInfoMapper;

    @Autowired
    private FileServiceImpl fileService;

    @Autowired
    private DmiOrganizationService dmiOrganizationService;

    @Autowired
    private BifMd5CodePoolMapper md5CodePoolMapper;

    @Autowired
    private FdpFaultReportRouteMapper fdpFaultReportRouteMapper;


    @Autowired
    private SysCompanyUsersMapper sysCompanyUsersMapper;

    @Autowired
    private SysCompanyRelationMapper sysCompanyRelationMapper;

    @Autowired
    private SysCompanyPurchaseVersionMapper sysCompanyPurchaseVersionMapper;

    @Autowired
    private SysCompanyPermissionMapper sysCompanyPermissionMapper;


    @Autowired
    private SysPublishVersionPermissionMapper sysPublishVersionPermissionMapper;

    @Autowired
    private SysCompanyRolePermissionMapper sysCompanyRolePermissionMapper;

    @Autowired
    private SysCompanyRoleMapper sysCompanyRoleMapper;

    @Autowired
    private SysCompanyUserRoleRelationMapper sysCompanyUserRoleRelationMapper;

    @Autowired
    private DmiOrganizationMapper dmiOrganizationMapper;
    /**
     * 新增/编辑子公司
     * @param dmiCompanyInfo
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result saveOrUpdate(DmiCompanyInfo dmiCompanyInfo){

        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        dmiCompanyInfo.setUpdatePerson(sysCompanyUsers.getId());
        if(dmiCompanyInfo != null){

            try {
                if(dmiCompanyInfo.getId() != null && dmiCompanyInfo.getId() > 0) {
                    logger.info("进入更新业务");
                    dmiCompanyInfoMapper.updateByPrimaryKeySelective(dmiCompanyInfo);
                    return ResultUtil.success("更新成功");
                }else {
                    logger.info("进入保存业务");
                    if(dmiCompanyInfoMapper.selectByCompanyName(dmiCompanyInfo.getCompanyName()) == null){

                        boolean isNext = true;

                        logger.info("初始化用户账号");
                        while (isNext){
                            String username = MathUtil.getUserName(8);
                            if(sysCompanyUsersMapper.selectByUserName(username) == null){

                                logger.info("开始创建公司");
                                dmiCompanyInfo.setCreatePerson(sysCompanyUsers.getId());
                                dmiCompanyInfo.setFlagDeleted(false);
                                dmiCompanyInfo.setFlagAvailable(true);
                                dmiCompanyInfo.setFlagIndependence(false);   //是否独立公司
                                dmiCompanyInfoMapper.insertGetId(dmiCompanyInfo);

                                logger.info("设置公司关联关系");
                                SysCompanyRelation sysCompanyRelation = new SysCompanyRelation();
                                sysCompanyRelation.setEmpowerCompanyId(sysCompanyUsers.getCompanyId());
                                sysCompanyRelation.setCreateTime(new Date());
                                sysCompanyRelation.setAuthorizedCompanyId(dmiCompanyInfo.getId());
                                sysCompanyRelationMapper.insertSelective(sysCompanyRelation);

                                logger.info("创建管理员账号");
                                String password = "123456";
                                SysCompanyUsers newSysCompanyUsers = new SysCompanyUsers();
                                newSysCompanyUsers.setUsername(username);
                                newSysCompanyUsers.setPassword(MD5Utils.MD5Encode(password,"utf-8"));
                                newSysCompanyUsers.setNickname("超级管理员");
                                newSysCompanyUsers.setFlagDeleted(false);
                                newSysCompanyUsers.setFlagAvailable(true);
                                newSysCompanyUsers.setFlagAdmin(true);
                                newSysCompanyUsers.setCompanyId(dmiCompanyInfo.getId());
                                sysCompanyUsersMapper.insertSelective(newSysCompanyUsers);

                                logger.info("创建一套报障路径配置");
                                FdpFaultReportRoute fdpFaultReportRoute = new FdpFaultReportRoute();
                                fdpFaultReportRoute.setCompanyId(dmiCompanyInfo.getId());
                                fdpFaultReportRoute.setCreatePerson(newSysCompanyUsers.getId());
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
                                dmiOrganization.setCreatePerson(newSysCompanyUsers.getId());
                                dmiOrganization.setUpdatePerson(newSysCompanyUsers.getId());
                                dmiOrganizationMapper.insertSelective(dmiOrganization);

                                logger.info("进入超级管理员赋权");
                                SysCompanyPurchaseVersion sysCompanyPurchaseVersion = new SysCompanyPurchaseVersion();
                                sysCompanyPurchaseVersion.setCompanyId(dmiCompanyInfo.getId());
                                sysCompanyPurchaseVersion.setVersionId(1);     //初始版本
                                sysCompanyPurchaseVersion.setUserId(newSysCompanyUsers.getId());
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
            } catch (Exception e) {
                e.printStackTrace();
                return ResultUtil.errorExceptionMsg("");
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

                SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
                logger.info("新建超级管理员角色");
                SysCompanyRole sysCompanyRole = new SysCompanyRole();
                sysCompanyRole.setCompanyId(sysCompanyPurchaseVersion.getCompanyId());
                sysCompanyRole.setCreatePerson(sysCompanyUsers.getId());
                sysCompanyRole.setRoleName("超级管理员");
                sysCompanyRole.setUpdatePerson(sysCompanyUsers.getId());
                sysCompanyRoleMapper.insertGetId(sysCompanyRole);

                roleId = sysCompanyRole.getId();

                logger.info("赋予超级管理员角色");
                SysCompanyUserRoleRelation sysCompanyUserRoleRelation = new SysCompanyUserRoleRelation();
                sysCompanyUserRoleRelation.setCompanyId(sysCompanyPurchaseVersion.getCompanyId());
                sysCompanyUserRoleRelation.setCreatePerson(sysCompanyUsers.getId());
                sysCompanyUserRoleRelation.setRoleId(roleId);
                sysCompanyUserRoleRelation.setUserId(sysCompanyUsersAdminRes.getId());
                sysCompanyUserRoleRelation.setUpdatePerson(sysCompanyUsers.getId());
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


    /**
     * 新增/编辑雇主基础信息
     *
     * @param dmiCompanyInfo
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public Result handle(DmiCompanyInfo dmiCompanyInfo) {

        SysCompanyUsers user = CurrentUtil.getCurrent();

        if (dmiCompanyInfo == null || dmiCompanyInfo.getCompanyName() == null ||
                dmiCompanyInfo.getCompanyFullName() == null) {
            return ResultUtil.validateError("参数错误");
        } else {

            if (dmiCompanyInfo.getId() > 0) {
                // 执行更新操作
                dmiCompanyInfo.setUpdatePerson(user.getId());
                dmiCompanyInfo.setUpdateTime(new Date());

                updateCompanyInfo(dmiCompanyInfo);

                return ResultUtil.successMsg("更新成功");
            } else {
                // 执行新增操作
                dmiCompanyInfo.setCreatePerson(user.getId());
                dmiCompanyInfo.setCreateTime(new Date());
                dmiCompanyInfo.setFlagAvailable(true);
                dmiCompanyInfo.setFlagDeleted(false);

                if (user != null && "VENDOR".equals(user.getActType()))
                    dmiCompanyInfo.setVendorId(user.getActObjectId());
                else dmiCompanyInfo.setVendorId(1);
                int companyId = insertCompanyInfo(dmiCompanyInfo);
                Date now = new Date();

                while (true) {

                    String companyToken = CompanyToken(now);
                    dmiCompanyInfo.setCompanyToken(companyToken);
                    Integer md5Id = md5CodePoolMapper.selectMd5(companyToken);

                    if (md5Id == null) {

                        BifMd5CodePool pool = new BifMd5CodePool();
                        pool.setMd5Code(companyToken);
                        pool.setSource("dmi-company-info");
                        pool.setObjectId(companyId);
                        pool.setCreateTime(now);
                        pool.setCreatePerson(user.getId());
                        md5CodePoolMapper.insertSelective(pool);
                        dmiCompanyInfoMapper.updateCompanyToken(pool);

                        break;

                    }

                }


                String companyToken = dmiCompanyInfo.getCompanyToken();

                SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
                String st = sd.format(now);

                String imgPatch = st + random() + ".jpg";

                File file = new File("/home/temp_image/" + imgPatch);


                try {
                    QRCodeUtil.encode(companyToken, imgPatch, "/home/temp_image/", true);
                    Result result = fileService.uploadLocal(file, "qrcode", "image");
                    dmiCompanyInfo.setCompanyTokenImage(result.getMsg());
                    dmiCompanyInfo.setId(companyId);
                    dmiCompanyInfoMapper.updateCompanyUrl(dmiCompanyInfo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 新增一个默认的组织结构
                DmiOrganization dmiOrganization = new DmiOrganization();
                dmiOrganization.setId(0);
                dmiOrganization.setOrganizationName("全国");
                dmiOrganization.setOrganizationCode("default_code");
                dmiOrganization.setParentId(0);
                dmiOrganization.setOrderId(1);
                dmiOrganization.setBelongsCompanyId(companyId);
                dmiOrganization.setLevel(1);
                dmiOrganization.setCreatePerson(user.getId());
                dmiOrganization.setUpdatePerson(user.getId());
                dmiOrganization.setUpdateTime(new Date());
                Result result = dmiOrganizationService.handle(user.getId(), companyId, dmiOrganization);
                return result;
            }
        }
    }


    /**
     * 查看雇主公司基础信息
     *
     * @param id
     * @return
     */
    public Result getCompanyBasicInfo(int id) {
        HashMap<String, Object> orgMap = (HashMap<String, Object>) dmiCompanyInfoMapper.selectBasicInfoByPrimaryKey(id);
        return ResultUtil.success(new DmiCompanyInfoWithBusinessLicense(orgMap));
    }


    private boolean updateCompanyInfo(DmiCompanyInfo dmiCompanyInfo) {
        int effectRows = dmiCompanyInfoMapper.updateByPrimaryKeySelective(dmiCompanyInfo);

        if (effectRows > 0) {
            return true;
        } else {
            return false;
        }
    }


    private int insertCompanyInfo(DmiCompanyInfo dmiCompanyInfo) {
        dmiCompanyInfoMapper.insertSelective(dmiCompanyInfo);
        return dmiCompanyInfo.getId();
    }


    private String CompanyToken(Date now) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String str = sdf.format(now);
        String random = random();
        String companyToken = "8a2i" + Encrypt.getMD5Str(str) + random;
        return companyToken;
    }


    private String random() {


        String result = "";

        while (result.length() < 6) {
            String str = String.valueOf((int) (Math.random() * 10));
            if (result.indexOf(str) == -1) {
                result += str;
            }
        }
        return result;
    }

    public int getCompanyCountByBusinessLicenseId(int id) {
        return dmiCompanyInfoMapper.selectByBusinessLicenseId(id);
    }

    public Result companyList() {
        //查询关联公司
        List<DmiCompanyInfo> list=dmiCompanyInfoMapper.companyByUserList(CurrentUtil.getCompanyIds(CurrentUtil.getCurrent().getId()));
        return ResultUtil.success(list);
    }

    public Result companyRalationList(DmiCompanyInfo dmiCompanyInfo) {
        String companyIds = CurrentUtil.getCompanyIds(CurrentUtil.getCurrent().getId());
        if(dmiCompanyInfo != null && dmiCompanyInfo.getPageNum() != null && dmiCompanyInfo.getPageSize() != null){
            PageHelper.startPage(dmiCompanyInfo.getPageNum(), dmiCompanyInfo.getPageSize());
            List<DmiCompanyInfo> list = dmiCompanyInfoMapper.companyByUserList(companyIds);
            // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            PageInfo<DmiCompanyInfo> pageInfo = new PageInfo<>(list);
            return ResultUtil.success(pageInfo);
        }else {
            List<DmiCompanyInfo> list = dmiCompanyInfoMapper.companyByUserList(companyIds);
            return ResultUtil.success(list);
        }

    }
}
