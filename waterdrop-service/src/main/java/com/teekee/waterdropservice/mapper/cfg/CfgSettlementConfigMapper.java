package com.teekee.waterdropservice.mapper.cfg;

import com.teekee.waterdropservice.entity.cfg.CfgSettlementConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CfgSettlementConfigMapper {

    int insertSelective(CfgSettlementConfig record);

    CfgSettlementConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgSettlementConfig record);

}