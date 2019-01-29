package com.teekee.blueoceanservice.mapper.cfg;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.cfg.CfgDispatchRoute;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CfgDispatchRouteMapper extends BaseMapper<CfgDispatchRoute> {

    /**
     * 默认项目条数
     * @return
     */
    int selectByIsNoDefault();


    /**
     * 非特定项目条数
     * @return
     */
    int selectByIsNoProject();
}