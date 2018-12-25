package com.platform.springboot.mapper.sys;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.sys.SysCompanyUserRoleRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SysCompanyUserRoleRelationMapper extends BaseMapper<SysCompanyUserRoleRelation> {

    /**
     * 查询当前角色
     * @param sysCompanyUserRoleRelation
     * @return
     */
    List<SysCompanyUserRoleRelation> selectRole(SysCompanyUserRoleRelation sysCompanyUserRoleRelation);
}