package com.lxg.springboot.mapper.sysuser;

import com.lxg.springboot.base.BaseMapper;
import com.lxg.springboot.entity.sysuser.SysCompanyUserRoleRelation;
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