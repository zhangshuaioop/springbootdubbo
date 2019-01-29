package com.teekee.waterdropservice.mapper.sys;


import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.sys.SysCompanyPermission;
import com.teekee.waterdropservice.entity.sys.response.RedisCompanyPermissionApiRes;
import com.teekee.waterdropservice.entity.sys.response.SysCompanyPermissionRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysCompanyPermissionMapper extends BaseMapper<SysCompanyPermission> {

    /**
     * 查询公司个人权限
     * @param sysCompanyPermission
     * @return
     */
    List<SysCompanyPermissionRes> selectPermission(SysCompanyPermission sysCompanyPermission);

    /**
     * 查询公司权限
     * @param sysCompanyPermission
     * @return
     */
    List<SysCompanyPermissionRes> selectCompanyPermission(SysCompanyPermission sysCompanyPermission);

    /**
     * 查询公司平台所有权限
     * @return
     */
    List<RedisCompanyPermissionApiRes> selectRedisApiAll();

}