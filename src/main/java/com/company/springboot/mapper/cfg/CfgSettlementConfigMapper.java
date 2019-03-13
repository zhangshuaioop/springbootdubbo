package com.company.springboot.mapper.cfg;

import com.company.springboot.entity.cfg.CfgSettlementConfig;
import com.company.springboot.entity.cfg.CfgSettlementConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CfgSettlementConfigMapper {

    int insertSelective(CfgSettlementConfig record);

    CfgSettlementConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgSettlementConfig record);

}