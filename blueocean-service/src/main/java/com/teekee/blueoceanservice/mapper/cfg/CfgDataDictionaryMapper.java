package com.teekee.blueoceanservice.mapper.cfg;

import com.teekee.blueoceanservice.entity.cfg.CfgDataDictionary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgDataDictionaryMapper {
    List<CfgDataDictionary> selectListByType(String dtype);

    List<CfgDataDictionary> selectAllList();

    CfgDataDictionary getDictionaryByTypeAndValue(CfgDataDictionary cfgDataDictionary);

    List<CfgDataDictionary> listByPayFrequency(Integer id);
}