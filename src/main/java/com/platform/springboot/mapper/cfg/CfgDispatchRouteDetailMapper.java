package com.platform.springboot.mapper.cfg;


import com.platform.springboot.entity.cfg.CfgDispatchRouteDetail;
import com.platform.springboot.entity.cfg.CfgDispatchRouteDetail;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CfgDispatchRouteDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CfgDispatchRouteDetail record);

    int insertSelective(CfgDispatchRouteDetail record);

    CfgDispatchRouteDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgDispatchRouteDetail record);

    int updateByPrimaryKey(CfgDispatchRouteDetail record);

    int updateBatch(List<CfgDispatchRouteDetail> record);

    int insertBatch(List<CfgDispatchRouteDetail> record);

    List<CfgDispatchRouteDetail> selectCfgDispatchRouteDetailList(Integer routeId);

    int deleteByRoute(Integer routeId);
}