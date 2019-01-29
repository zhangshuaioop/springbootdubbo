package com.teekee.blackrockservice.service.cfg;

import com.teekee.commoncomponets.base.BaseService;
import com.teekee.blackrockservice.entity.cfg.CfgDataDictionary;
import com.teekee.blackrockservice.mapper.cfg.CfgDataDictionaryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Niting
 * @date 2018/11/7
 **/
@Service
public class CfgDataDictionaryService extends BaseService<CfgDataDictionaryMapper,CfgDataDictionary> {
    @Resource
    CfgDataDictionaryMapper mapper;

    /**
     * 按照类型，查看配置信息
     *
     * @param dtype
     * @return
     * @Author:Niting
     * @Date:2018/11/07
     */
    public List<CfgDataDictionary> getDictionaryByType(String dtype) {
        //log.info("dtype：" + dtype);
        List<CfgDataDictionary> sqlResult = mapper.selectListByType(dtype);
        return sqlResult == null ? new ArrayList<CfgDataDictionary>() : sqlResult;
    }
}
