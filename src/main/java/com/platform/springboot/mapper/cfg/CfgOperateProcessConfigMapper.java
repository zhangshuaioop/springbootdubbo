package com.platform.springboot.mapper.cfg;

import com.platform.springboot.entity.cfg.CfgOperateProcessConfig;
import com.platform.springboot.entity.cfg.CfgOperateProcessConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgOperateProcessConfigMapper {


    List<CfgOperateProcessConfig> getDictionaryByNew(CfgOperateProcessConfig cfgDataDictionary);
}
