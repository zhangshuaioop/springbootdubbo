package com.teekee.waterdropservice.mapper.cfg;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.cfg.CfgCommunicationSubBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgCommunicationSubBrandMapper extends BaseMapper<CfgCommunicationSubBrand> {

    int insertSelective(CfgCommunicationSubBrand record);

    CfgCommunicationSubBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgCommunicationSubBrand record);

    List<CfgCommunicationSubBrand> list(CfgCommunicationSubBrand record);

}