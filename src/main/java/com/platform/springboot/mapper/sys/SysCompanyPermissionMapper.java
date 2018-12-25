package com.platform.springboot.mapper.sys;


import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.sys.SysCompanyPermission;
import com.platform.springboot.entity.sys.response.SysCompanyPermissionRes;
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

}