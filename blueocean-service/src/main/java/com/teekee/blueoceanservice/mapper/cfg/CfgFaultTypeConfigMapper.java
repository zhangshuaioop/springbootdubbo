package com.teekee.blueoceanservice.mapper.cfg;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.cfg.CfgFaultTypeConfig;
import com.teekee.blueoceanservice.entity.cfg.CfgFaultTypeModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgFaultTypeConfigMapper extends BaseMapper<CfgFaultTypeConfig> {
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