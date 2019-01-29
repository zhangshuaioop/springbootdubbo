package com.teekee.blueoceanservice.service.cfg;

import com.github.pagehelper.PageHelper;
import com.teekee.blueoceanservice.entity.cfg.CfgDataDictionary;
import com.teekee.blueoceanservice.mapper.cfg.CfgDataDictionaryMapper;
import com.teekee.commoncomponets.utils.PageInfo;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Chenliwen
 * @Date 2019/1/3 11:38
 **/
@Service
public class CfgDataDictionaryService {

    @Resource
    private CfgDataDictionaryMapper mapper;

    public Result getAllDictionary(CfgDataDictionary cfgDataDictionary) {
        List<CfgDataDictionary> sqlResult = mapper.selectAllList();
        if(cfgDataDictionary.getPageNum()!=null&&cfgDataDictionary.getPageNum()!=0&&cfgDataDictionary.getPageSize()!=null&&cfgDataDictionary.getPageSize()!=0){
            PageHelper.startPage(cfgDataDictionary.getPageNum(), cfgDataDictionary.getPageSize());
            PageInfo<CfgDataDictionary> pageInfo = new PageInfo<>(sqlResult);
            if(sqlResult.size() > 0){
                return ResultUtil.success(pageInfo);
            }
            return ResultUtil.success(new PageInfo<CfgDataDictionary>());
        }
        return ResultUtil.success(sqlResult == null ? new ArrayList<CfgDataDictionary>() : sqlResult);
    }
}
