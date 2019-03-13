package com.company.springboot.mapper.sys;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.sys.SysCompanyRelation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysCompanyRelationMapper extends BaseMapper<SysCompanyRelation> {

    /**
     * 根据用户id获取当前公司及关联公司
     * @param userId
     * @return
     */
    String selectCompanyIds(Integer userId);


    /**
     * 解除公司关系
     * @param sysCompanyRelation
     * @return
     */
    int deleteRelieveCompany(SysCompanyRelation sysCompanyRelation);
}