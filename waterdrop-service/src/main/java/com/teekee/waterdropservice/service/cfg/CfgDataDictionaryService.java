package com.teekee.waterdropservice.service.cfg;

import com.teekee.commoncomponets.base.BaseService;
import com.teekee.waterdropservice.entity.cfg.CfgDataDictionary;
import com.teekee.waterdropservice.mapper.cfg.CfgDataDictionaryMapper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Niting
 * @date 2018/12/18
 **/
@Service
public class CfgDataDictionaryService extends BaseService<CfgDataDictionaryMapper, CfgDataDictionary> {
    private Logger log = Logger.getLogger(CfgDataDictionaryService.class);

    @Resource
    private CfgDataDictionaryMapper mapper;

    /**
     * 按照类型，查看配置信息
     *
     * @param dtype
     * @return
     */
    public List<CfgDataDictionary> getDictionaryByType(String dtype) {
        log.info("dtype：" + dtype);
        List<CfgDataDictionary> sqlResult = mapper.selectListByType(dtype);
        return sqlResult == null ? new ArrayList<CfgDataDictionary>() : sqlResult;
    }

    public List<CfgDataDictionary> getAllDictionary() {
        List<CfgDataDictionary> sqlResult = mapper.selectAllList();
        return sqlResult == null ? new ArrayList<CfgDataDictionary>() : sqlResult;
    }

    public CfgDataDictionary getDictionaryByTypeAndValue(String type, String value) {
        CfgDataDictionary cfgDataDictionary = new CfgDataDictionary();
        cfgDataDictionary.setType(type);
        cfgDataDictionary.setValue(value);
        return mapper.getDictionaryByTypeAndValue(cfgDataDictionary);
    }

    public List<CfgDataDictionary> listByPayFrequency(int id) {
        return mapper.listByPayFrequency(id);
    }
}
