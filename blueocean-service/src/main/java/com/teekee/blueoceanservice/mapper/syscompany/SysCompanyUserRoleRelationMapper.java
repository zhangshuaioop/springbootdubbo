package com.teekee.blueoceanservice.mapper.syscompany;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.syscompany.SysCompanyUserRoleRelation;
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