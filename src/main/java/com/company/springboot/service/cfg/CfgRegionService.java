package com.company.springboot.service.cfg;

import com.company.springboot.entity.cfg.CfgRegion;
import com.company.springboot.mapper.cfg.CfgRegionMapper;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;


/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-27 18:09
 */
@Service
public class CfgRegionService {

    @Autowired
    private CfgRegionMapper cfgRegionMapper;

    /**
     * 获取某个父级节点下的所有地址列表
     * @param parentId
     * @return
     */
    public Result getRegionList(int parentId) {
        List<CfgRegion> list = cfgRegionMapper.selectListByParentId(parentId);
        Iterator<CfgRegion> it = list.iterator();
        while (it.hasNext()) {
            CfgRegion cfgRegion = it.next();
            if (cfgRegion.getRegionName() != null && cfgRegion.getRegionName().length() == 0) {
                it.remove();
            }
        }
        return ResultUtil.success(list);
    }

    public Result getCityList() {
        return ResultUtil.success(cfgRegionMapper.getCityList());
    }

    public Result selectRegion(Integer id) {
        return ResultUtil.success(cfgRegionMapper.selectByPrimaryKey(id));
    }
}
