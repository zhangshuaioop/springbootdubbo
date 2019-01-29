package com.teekee.blackrockservice.mapper.cfg;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blackrockservice.entity.cfg.CfgDataDictionary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CfgDataDictionaryMapper extends BaseMapper<CfgDataDictionary>{
    List<CfgDataDictionary> selectListByType(String dtype);
}