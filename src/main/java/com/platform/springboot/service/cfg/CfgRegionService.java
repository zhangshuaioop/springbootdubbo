package com.platform.springboot.service.cfg;

import com.platform.springboot.entity.cfg.CfgRegion;
import com.platform.springboot.mapper.cfg.CfgRegionMapper;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Chenliwen
 * @Date 2019/1/3 10:28
 **/
@Service
public class CfgRegionService {

    private Logger log = Logger.getLogger(CfgRegionService.class);

    @Resource
    private CfgRegionMapper cfgRegionMapper;


    /**
     * 获取某个父级节点下的所有地址列表
     *
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
