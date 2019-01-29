package com.teekee.blueoceanservice.mapper.cfg;

import com.teekee.blueoceanservice.entity.cfg.CfgRegion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgRegionMapper {
    CfgRegion selectByPrimaryKey(Integer id);

    List<CfgRegion> selectListByParentId(Integer parentId);
    /**
     * 查看第三级别节点信息（城市）
     * @return
     * @Author:Niting
     * @Date:2018/10/08
     */
    List<CfgRegion> getCityList();

    /**
     * 获取省市区列表根据条件
     * @return
     * @Author:zhanghao
     * @Date:2018/11/28
     */
    List<CfgRegion> getCfgRegionList(CfgRegion cfgRegion);
}