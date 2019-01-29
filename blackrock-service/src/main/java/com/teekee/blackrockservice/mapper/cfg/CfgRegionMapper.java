package com.teekee.blackrockservice.mapper.cfg;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blackrockservice.entity.cfg.CfgRegion;
import com.teekee.blackrockservice.entity.cfg.CfgRegionList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgRegionMapper extends BaseMapper<CfgRegion>{

    List<CfgRegion> selectListByParentId(Integer parentId);
    /**
     * 查询第二级省份信息
     * @param
     * @return
     * @Author:Niting
     * @Date:2018/07/24
     */
    List<CfgRegionList> queryProvice();
    /**
     * 查询第二级省份信息
     * @param
     * @return
     * @Author:Niting
     * @Date:2018/07/24
     */
    List<CfgRegionList> queryCity(Integer parentId);
}