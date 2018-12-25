package com.platform.springboot.service.sys;

import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.sys.SysCompanyUserRoleRelation;
import com.platform.springboot.mapper.sys.SysCompanyUserRoleRelationMapper;
import com.platform.springboot.mapper.sys.SysCompanyUserRoleRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @description:公司账号角色
 * @author: zhangshuai
 * @create: 2018-12-12 10:50
 */
@Service
public class SysCompanyUserRoleRelationService extends BaseService<SysCompanyUserRoleRelationMapper,SysCompanyUserRoleRelation> {

    @Autowired
    private SysCompanyUserRoleRelationMapper sysCompanyUserRoleRelationMapper;

    /**
     * 查询当前角色
     * @return
     */
    public List<SysCompanyUserRoleRelation> findRole(SysCompanyUserRoleRelation sysCompanyUserRoleRelation){
        return sysCompanyUserRoleRelationMapper.selectRole(sysCompanyUserRoleRelation);
    }
}
