package com.platform.springboot.mapper.cfg;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.cfg.CfgDataDictionary;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.cfg.CfgDataDictionary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgDataDictionaryMapper extends BaseMapper< CfgDataDictionary> {
    List<CfgDataDictionary> selectListByType(String dtype);

    List<CfgDataDictionary> selectAllList();

    CfgDataDictionary getDictionaryByTypeAndValue(CfgDataDictionary cfgDataDictionary);

    List<CfgDataDictionary> listByPayFrequency(Integer id);
}