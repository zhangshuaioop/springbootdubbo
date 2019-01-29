package com.teekee.waterdropservice.mapper.cfg;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.cfg.CfgDataDictionary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgDataDictionaryMapper extends BaseMapper< CfgDataDictionary> {
    List<CfgDataDictionary> selectListByType(String dtype);

    List<CfgDataDictionary> selectAllList();

    CfgDataDictionary getDictionaryByTypeAndValue(CfgDataDictionary cfgDataDictionary);

    List<CfgDataDictionary> listByPayFrequency(Integer id);
}