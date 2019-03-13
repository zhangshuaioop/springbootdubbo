package com.company.springboot.mapper.cfg;


import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.cfg.CfgDispatchRouteDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgDispatchRouteDetailMapper extends BaseMapper<CfgDispatchRouteDetail> {
    int deleteByPrimaryKey(Integer id);

    int insert(CfgDispatchRouteDetail record);

    int insertSelective(CfgDispatchRouteDetail record);

    CfgDispatchRouteDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgDispatchRouteDetail record);

    int updateByPrimaryKey(CfgDispatchRouteDetail record);

    /**
     * 项目细则配置列表
     * @param routeId
     * @return
     */
    List<CfgDispatchRouteDetail> selectCfgDispatchRouteDetailList(Integer routeId);


    /**
     * 根据routeId删除
     * @param routeId
     * @return
     */
    int deleteByRoute(Integer routeId);


    /**
     * 批量保存
     * @param record
     * @return
     */
    int insertBatch(List<CfgDispatchRouteDetail> record);


    /**
     * 批量更新
     * @param record
     * @return
     */
    int updateBatch(List<CfgDispatchRouteDetail> record);

}