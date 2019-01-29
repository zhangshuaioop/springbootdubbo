package com.teekee.blueoceanservice.mapper.sysconsole;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.sysconsole.SysConsoleUserRoleRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysConsoleUserRoleRelationMapper extends BaseMapper<SysConsoleUserRoleRelation> {


    /**
     * 删除用户角色
     * @param sysConsoleUserRoleRelation
     */
    void deleteByUser(SysConsoleUserRoleRelation sysConsoleUserRoleRelation);

    /**
     * 保存用户角色
     * @param userId
     * @param createPerson
     * @param roleIds
     */
    void saveUserRole(@Param("userId") Integer userId,
                      @Param("createPerson") Integer createPerson,
                      @Param("roleIds") String[] roleIds);
}