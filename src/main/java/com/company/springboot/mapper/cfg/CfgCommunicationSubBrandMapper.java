package com.company.springboot.mapper.cfg;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.cfg.CfgCommunicationSubBrand;
import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.cfg.CfgCommunicationSubBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgCommunicationSubBrandMapper extends BaseMapper<CfgCommunicationSubBrand> {

    int insertSelective(CfgCommunicationSubBrand record);

    CfgCommunicationSubBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgCommunicationSubBrand record);

    List<CfgCommunicationSubBrand> list(CfgCommunicationSubBrand record);

}