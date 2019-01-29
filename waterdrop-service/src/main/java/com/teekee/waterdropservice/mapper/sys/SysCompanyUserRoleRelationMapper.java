package com.teekee.waterdropservice.mapper.sys;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.sys.SysCompanyUserRoleRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface SysCompanyUserRoleRelationMapper extends BaseMapper<SysCompanyUserRoleRelation> {

    /**
     * 查询当前角色
     * @param sysCompanyUserRoleRelation
     * @return
     */
    List<SysCompanyUserRoleRelation> selectRole(SysCompanyUserRoleRelation sysCompanyUserRoleRelation);


    /**
     * 删除当前用户角色
     * @param sysConsoleRolePermission
     */
    void deleteByUserAndCompanyId(SysCompanyUserRoleRelation sysConsoleRolePermission);


    /**
     * 保存当前用户角色
     * @param userId
     * @param companyId
     * @param createPerson
     * @param updatePerson
     * @param roleIds
     */
    void saveUserRole(@Param("userId") Integer userId, @Param("companyId") Integer companyId,
                      @Param("createPerson") Integer createPerson,
                      @Param("updatePerson") Integer updatePerson,
                      @Param("roleIds") String[] roleIds);
}