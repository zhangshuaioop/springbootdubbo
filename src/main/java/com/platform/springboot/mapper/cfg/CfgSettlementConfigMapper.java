package com.platform.springboot.mapper.cfg;

import com.platform.springboot.entity.cfg.CfgSettlementConfig;
import com.platform.springboot.entity.cfg.CfgSettlementConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CfgSettlementConfigMapper {

    int insertSelective(CfgSettlementConfig record);

    CfgSettlementConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgSettlementConfig record);

}