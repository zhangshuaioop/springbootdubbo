package com.teekee.waterdropservice.mapper.cfg;

import com.teekee.waterdropservice.entity.cfg.CfgCommunicationArea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgCommunicationAreaMapper {

    int insertSelective(CfgCommunicationArea record);

    CfgCommunicationArea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgCommunicationArea record);

    List<CfgCommunicationArea> list(CfgCommunicationArea record);

}