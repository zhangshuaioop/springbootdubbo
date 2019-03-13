package com.company.springboot.mapper.cfg;

import com.company.springboot.entity.cfg.CfgOperateProcessConfig;
import com.company.springboot.entity.cfg.CfgOperateProcessConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgOperateProcessConfigMapper {


    List<CfgOperateProcessConfig> getDictionaryByNew(CfgOperateProcessConfig cfgDataDictionary);
}
