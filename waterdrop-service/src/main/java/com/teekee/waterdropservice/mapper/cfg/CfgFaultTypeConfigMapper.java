package com.teekee.waterdropservice.mapper.cfg;

import com.teekee.waterdropservice.entity.cfg.CfgFaultTypeConfig;
import com.teekee.waterdropservice.entity.cfg.CfgFaultTypeModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgFaultTypeConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CfgFaultTypeConfig record);

    int insertSelective(CfgFaultTypeConfig record);

    CfgFaultTypeConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgFaultTypeConfig record);

    int updateByPrimaryKey(CfgFaultTypeConfig record);

    List<CfgFaultTypeConfig> selectByModelId(Integer modelId);


    List<CfgFaultTypeConfig> selectMaxVersionConfig(CfgFaultTypeModel model);

    List<CfgFaultTypeConfig> selectCustomerConfig(Integer modelId);
}