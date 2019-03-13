package com.platform.springboot.mapper.cfg;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.cfg.CfgDispatchRoute;
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