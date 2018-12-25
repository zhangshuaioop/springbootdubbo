package com.platform.springboot.mapper.cfg;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.cfg.CfgCommunicationBrand;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.cfg.CfgCommunicationBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgCommunicationBrandMapper extends BaseMapper<CfgCommunicationBrand> {


    int insertSelective(CfgCommunicationBrand record);

    CfgCommunicationBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgCommunicationBrand record);

    List<CfgCommunicationBrand> list(CfgCommunicationBrand record);

}