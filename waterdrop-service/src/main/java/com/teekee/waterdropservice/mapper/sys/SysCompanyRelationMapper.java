package com.teekee.waterdropservice.mapper.sys;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.sys.SysCompanyRelation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysCompanyRelationMapper extends BaseMapper<SysCompanyRelation> {

    /**
     * 根据用户id获取当前公司及关联公司
     * @param userId
     * @return
     */
    String selectCompanyIds(Integer userId);
}