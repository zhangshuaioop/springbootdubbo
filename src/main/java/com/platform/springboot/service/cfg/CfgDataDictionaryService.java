package com.platform.springboot.service.cfg;

import com.github.pagehelper.PageHelper;
import com.platform.springboot.entity.cfg.CfgDataDictionary;
import com.platform.springboot.mapper.cfg.CfgDataDictionaryMapper;
import com.platform.springboot.utils.PageInfo;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
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
            if(pageInfo.getList()==null||pageInfo.getList().size()==0){
                pageInfo.setPageNum(1);
                pageInfo.setPageSize(10);
            }
            return ResultUtil.success(pageInfo);
        }
        return ResultUtil.success(sqlResult == null ? new ArrayList<CfgDataDictionary>() : sqlResult);
    }
}
