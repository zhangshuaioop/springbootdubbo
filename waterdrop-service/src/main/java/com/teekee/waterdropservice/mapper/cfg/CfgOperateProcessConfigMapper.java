package com.teekee.waterdropservice.mapper.cfg;

import com.teekee.waterdropservice.entity.cfg.CfgOperateProcessConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgOperateProcessConfigMapper {


    List<CfgOperateProcessConfig> getDictionaryByNew(CfgOperateProcessConfig cfgDataDictionary);
}
