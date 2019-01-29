package com.teekee.blackrockservice.service.cfg;

import com.teekee.commoncomponets.base.BaseService;
import com.teekee.blackrockservice.entity.cfg.CfgRegion;
import com.teekee.blackrockservice.entity.cfg.CfgRegionList;
import com.teekee.blackrockservice.mapper.cfg.CfgRegionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Niting
 * @date 2018/11/7
 **/
@Service
public class CfgRegionService extends BaseService<CfgRegionMapper,CfgRegion> {
    @Resource
    CfgRegionMapper mapper;

    /**
     * 查询第二级省份信息
     * @param
     * @return
     * @Author:Niting
     * @Date:2018/11/07
     */
    public List<CfgRegionList> queryProvice() {
        return mapper.queryProvice();
    }

    /**
     * 查询第三级城市信息
     * @param
     * @param parentId
     * @return
     * @Author:Niting
     * @Date:2018/11/07
     */
    public List<CfgRegionList> queryCity(Integer parentId) {
        return mapper.queryCity(parentId);
    }
}
