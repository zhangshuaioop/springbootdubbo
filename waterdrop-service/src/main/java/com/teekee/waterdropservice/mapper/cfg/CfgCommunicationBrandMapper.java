package com.teekee.waterdropservice.mapper.cfg;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.cfg.CfgCommunicationBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgCommunicationBrandMapper extends BaseMapper<CfgCommunicationBrand>{


    int insertSelective(CfgCommunicationBrand record);

    CfgCommunicationBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgCommunicationBrand record);

    List<CfgCommunicationBrand> list(CfgCommunicationBrand record);

}