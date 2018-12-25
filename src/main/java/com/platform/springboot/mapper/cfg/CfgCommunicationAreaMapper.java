package com.platform.springboot.mapper.cfg;

import com.platform.springboot.entity.cfg.CfgCommunicationArea;
import com.platform.springboot.entity.cfg.CfgCommunicationArea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgCommunicationAreaMapper {

    int insertSelective(CfgCommunicationArea record);

    CfgCommunicationArea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgCommunicationArea record);

    List<CfgCommunicationArea> list(CfgCommunicationArea record);

}