package com.platform.springboot.mapper.cfg;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.cfg.CfgCommunicationSubBrand;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.cfg.CfgCommunicationSubBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgCommunicationSubBrandMapper extends BaseMapper<CfgCommunicationSubBrand> {

    int insertSelective(CfgCommunicationSubBrand record);

    CfgCommunicationSubBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgCommunicationSubBrand record);

    List<CfgCommunicationSubBrand> list(CfgCommunicationSubBrand record);

}