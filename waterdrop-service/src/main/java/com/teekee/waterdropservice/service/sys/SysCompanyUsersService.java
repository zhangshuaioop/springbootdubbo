package com.teekee.waterdropservice.service.sys;

import com.teekee.commoncomponets.base.BaseService;
import com.teekee.commoncomponets.utils.*;
import com.teekee.waterdropservice.entity.dmi.DmiCompanyInfo;
import com.teekee.waterdropservice.entity.sys.SysCompanyPermission;
import com.teekee.waterdropservice.entity.sys.SysCompanyUserRoleRelation;
import com.teekee.waterdropservice.entity.sys.SysCompanyUsers;
import com.teekee.waterdropservice.entity.sys.request.SysCompanyUserPassword;
import com.teekee.waterdropservice.entity.sys.response.Meta;
import com.teekee.waterdropservice.entity.sys.response.SysCompanyPermissionRes;
import com.teekee.waterdropservice.entity.trc.TrcUserWorkLog;
import com.teekee.waterdropservice.mapper.dmi.DmiCompanyInfoMapper;
import com.teekee.waterdropservice.mapper.sys.SysCompanyPermissionMapper;
import com.teekee.waterdropservice.mapper.sys.SysCompanyUserRoleRelationMapper;
import com.teekee.waterdropservice.mapper.sys.SysCompanyUsersMapper;
import com.teekee.waterdropservice.mapper.trc.TrcUserWorkLogMapper;
import com.teekee.waterdropservice.utils.*;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 公司用户账号
 * @author: zhangshuai
 * @create: 2018-12-12 09:20
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysCompanyUsersService extends BaseService<SysCompanyUsersMapper,SysCompanyUsers> {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysCompanyUsersMapper sysCompanyUsersMapper;

    @Autowired
    private SysCompanyPermissionMapper sysCompanyPermissionMapper;

    @Autowired
    private DmiCompanyInfoMapper dmiCompanyInfoMapper;

    @Autowired
    private SysCompanyUserRoleRelationMapper sysCompanyUserRoleRelationMapper;

    @Resource
    private TrcUserWorkLogMapper trcUserWorkLogMapper;

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public SysCompanyUsers findUserName(String username){
        return sysCompanyUsersMapper.selectByUserName(username);
    }


    /**
     * 当前权限及相关信息
     * @return
     */
    public Result findUserView() {

        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        SysCompanyPermission sysCompanyPermission = new SysCompanyPermission();
        sysCompanyPermission.setCompanyId(sysCompanyUsers.getCompanyId());
        sysCompanyPermission.setUserId(sysCompanyUsers.getId());
        sysCompanyPermission.setFlagIsMenu(true);

        String relationCompanyIds = CurrentUtil.getCompanyIds(sysCompanyUsers.getId());
        logger.info("查询当前关联公司，入参：relationCompanyIds="+relationCompanyIds);
        List<DmiCompanyInfo> dmiCompanyInfos = dmiCompanyInfoMapper.companyByUserList(relationCompanyIds);
        logger.info("查询当前关联公司，出参：dmiCompanyInfos="+dmiCompanyInfos.toString());

        logger.info("查询权限，入参：sysCompanyPermission="+sysCompanyPermission.toString());
        List<SysCompanyPermissionRes> sysCompanyPermissionResList = sysCompanyPermissionMapper.selectPermission(sysCompanyPermission);
        logger.info("查询权限，出参：permissionTree="+sysCompanyPermissionResList.toString());

        if(sysCompanyPermissionResList != null){
            for (SysCompanyPermissionRes sysCompanyPermissionoo: sysCompanyPermissionResList) {
                if(sysCompanyPermissionoo.getId()==2){
                    //封装关联公司信息
                    for (DmiCompanyInfo dmiCompanyInfo: dmiCompanyInfos) {
                        SysCompanyPermissionRes sysCompanyPermissionRes = new SysCompanyPermissionRes();
                        sysCompanyPermissionRes.setPath("company");
                        sysCompanyPermissionRes.setName("company_page"+dmiCompanyInfo.getId());
                        Meta meta = new Meta();
                        meta.setIcon("md-crop");
                        meta.setTitle(dmiCompanyInfo.getCompanyName());
                        meta.setId(dmiCompanyInfo.getId());
                        sysCompanyPermissionRes.setMeta(meta);
                        sysCompanyPermissionRes.setParentId(2);
                        sysCompanyPermissionRes.setComponent("company-manage/company/company.vue");
                        sysCompanyPermissionResList.add(sysCompanyPermissionRes);
                    }
                    break;
                }
            }
        }

        logger.info("生成权限树");
        List<SysCompanyPermissionRes> permissionTree = TreeUtils.formatTree(sysCompanyPermissionResList,false);

        sysCompanyPermission.setFlagIsMenu(false);
        Map<String,Object> map = new HashMap<>();
        map.put("sysUsers", sysCompanyUsers);
        map.put("permissionsTree",permissionTree);
        map.put("permissions",sysCompanyPermissionMapper.selectPermission(sysCompanyPermission));
        map.put("dmiCompanyInfos",dmiCompanyInfos);

        return ResultUtil.success(map);
    }


    /**
     * 分页查询
     *
     * @param sysCompanyUsers
     * @return
     */
    public Result findPage(SysCompanyUsers sysCompanyUsers) {
        SysCompanyUsers sysCompanyUsers1 = CurrentUtil.getCurrent();
        sysCompanyUsers.setCompanyId(sysCompanyUsers1.getCompanyId());
//        sysCompanyUsers.setRelationCompanyIds(sysCompanyUsers1.getRelationCompanyIds());
        PageHelper.startPage(sysCompanyUsers.getPageNum(), sysCompanyUsers.getPageSize());
        List<SysCompanyUsers> persons = sysCompanyUsersMapper.selectAll(sysCompanyUsers);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<SysCompanyUsers> pageInfo = new PageInfo<>(persons);

        return ResultUtil.success(pageInfo);
    }


    /**
     * 账号保存/修改
     * @param sysCompanyUsers
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result saveOrUpdateUsers(SysCompanyUsers sysCompanyUsers){

        if(sysCompanyUsers != null){

            if(sysCompanyUsers.getId() != null && sysCompanyUsers.getId() > 0) {
                logger.info("进入账号修改业务");
                if(sysCompanyUsers.getPassword() != null && sysCompanyUsers.getPassword().length() > 0){
                    sysCompanyUsers.setPassword(MD5Utils.MD5Encode(sysCompanyUsers.getPassword(),"utf-8"));
                }
                sysCompanyUsersMapper.updateByPrimaryKeySelective(sysCompanyUsers);
                return ResultUtil.successMsg("更新成功");
            }else {

                if(sysCompanyUsers != null && sysCompanyUsers.getUsername() != null &&
                        sysCompanyUsers.getUsername().length() > 0 && sysCompanyUsers.getPassword() != null &&
                        sysCompanyUsers.getPassword().length() > 0){

                    logger.info("进入账号保存业务");
                    if(sysCompanyUsersMapper.selectByUserName(sysCompanyUsers.getUsername()) == null){
                        SysCompanyUsers sysCompanyUsers1 = CurrentUtil.getCurrent();
                        sysCompanyUsers.setPassword(MD5Utils.MD5Encode(sysCompanyUsers.getPassword(),"utf-8"));
                        sysCompanyUsers.setFlagDeleted(false);
                        sysCompanyUsers.setFlagAvailable(true);
                        sysCompanyUsers.setCompanyId(sysCompanyUsers1.getCompanyId());
                        sysCompanyUsersMapper.insertSelective(sysCompanyUsers);

                        logger.info("将当前公司更新成独立公司");
                        DmiCompanyInfo dmiCompanyInfo = new DmiCompanyInfo();
                        dmiCompanyInfo.setId(sysCompanyUsers1.getCompanyId());
                        dmiCompanyInfo.setFlagIndependence(true);  //是否独立公司
                        dmiCompanyInfoMapper.updateByPrimaryKeySelective(dmiCompanyInfo);

                        return ResultUtil.successMsg("注册成功");
                    }
                    return ResultUtil.errorBusinessMsg("用户已存在");

                }else {
                    return ResultUtil.validateError("");
                }

            }

        }else {
            return ResultUtil.validateError("");
        }



    }


    /**
     * 赋予账号角色
     * @param sysCompanyUserRoleRelation
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result updateUserRole(SysCompanyUserRoleRelation sysCompanyUserRoleRelation) {
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        try {
            logger.info("删除当前公司用户角色");
            sysCompanyUserRoleRelation.setCompanyId(sysCompanyUsers.getCompanyId());
            sysCompanyUserRoleRelationMapper.deleteByUserAndCompanyId(sysCompanyUserRoleRelation);
            logger.info("保存当前用户角色");
            sysCompanyUserRoleRelationMapper.saveUserRole(sysCompanyUserRoleRelation.getUserId(),sysCompanyUsers.getCompanyId(),
                    sysCompanyUsers.getId(),sysCompanyUsers.getId(),sysCompanyUserRoleRelation.getRoleIds().split(","));

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
     * 修改密码
     * @param sysCompanyUserPassword
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result updatePassword(SysCompanyUserPassword sysCompanyUserPassword) {

        if(sysCompanyUserPassword != null){

            SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
            if(sysCompanyUserPassword.getPassword() == null || sysCompanyUserPassword.getPassword().length()==0){
                return ResultUtil.validateError("请输入原密码");
            }

            if(sysCompanyUserPassword.getNewPassword() == null || sysCompanyUserPassword.getNewPassword().length()==0){
                return ResultUtil.validateError("请输入新密码");
            }

            if(!sysCompanyUsersMapper.selectByPrimaryKey(sysCompanyUsers.getId()).getPassword().equals(MD5Utils.MD5Encode(sysCompanyUserPassword.getPassword(),"utf-8"))){
                return ResultUtil.validateError("原密码错误");
            }

            SysCompanyUsers sysCompanyUsers1 = new SysCompanyUsers();
            sysCompanyUsers1.setId(sysCompanyUsers.getId());
            sysCompanyUsers1.setPassword(MD5Utils.MD5Encode(sysCompanyUserPassword.getNewPassword(),"utf-8"));
            sysCompanyUsersMapper.updateByPrimaryKeySelective(sysCompanyUsers1);

        }else {
            return ResultUtil.validateError("");
        }
        return ResultUtil.success();
    }




    /**
     * 重置密码
     * @param userId
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result resetPassword(Integer userId) {

        if(userId != null){
            SysCompanyUsers sysCompanyUsers1 = new SysCompanyUsers();
            sysCompanyUsers1.setId(userId);
            sysCompanyUsers1.setPassword(MD5Utils.MD5Encode("123456","utf-8"));
            sysCompanyUsersMapper.updateByPrimaryKeySelective(sysCompanyUsers1);
        }else {
            return ResultUtil.validateError("");
        }
        return ResultUtil.success();
    }


    /**
     * 更新redis中角色权限
     * @return
     */
    public Result updateRedisPermission() {

        logger.info("更新redis中角色权限");
        String jsonStr = JsonUtils.getListToJson(sysCompanyPermissionMapper.selectRedisApiAll());
        RedisUtil.set("sys_company_api_all",jsonStr);
        return ResultUtil.success();
    }


    @Transactional
    public Result userOpenClose(Integer id, boolean status) {
        //修改用户状态
        SysCompanyUsers user = new SysCompanyUsers();
        user.setId(id);
        user.setFlagOpenStatus(status);
        sysCompanyUsersMapper.updateByPrimaryKeySelective(user);
        //记录打开时间或者关闭时间
        TrcUserWorkLog trcUserWorkLog = new TrcUserWorkLog();
        trcUserWorkLog.setUserId(id);
        trcUserWorkLog.setStatus(status);
        trcUserWorkLog.setWorkTime(new Date());
        trcUserWorkLogMapper.insertSelective(trcUserWorkLog);
        return ResultUtil.success();
    }

    /**
     * 查询有效用户列表
     * @return
     */
    public Result findUserList(){
        return ResultUtil.success(sysCompanyUsersMapper.selectApplyUser(CurrentUtil.getCurrent().getCompanyId()));
    }




}
