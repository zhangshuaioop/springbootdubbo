package com.teekee.blueoceanservice.mapper.syscompany;


import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.syscompany.SysCompanyPermission;
import com.teekee.blueoceanservice.entity.syscompany.response.RedisCompanyPermissionApiRes;
import com.teekee.blueoceanservice.entity.syscompany.response.SysCompanyPermissionRes;
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
     * 公司权限列表树(供平台使用)
     * @return
     */
    List<SysCompanyPermissionRes> selectConsolePermission();

    /**
     * 查询公司平台所有权限
     * @return
     */
    List<RedisCompanyPermissionApiRes> selectRedisApiAll();

}