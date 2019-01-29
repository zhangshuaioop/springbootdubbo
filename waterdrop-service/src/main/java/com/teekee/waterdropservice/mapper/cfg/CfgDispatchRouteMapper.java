package com.teekee.waterdropservice.mapper.cfg;


import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.cfg.CfgDispatchRoute;
import com.teekee.waterdropservice.entity.cfg.CfgDispatchRouteDetail;
import com.teekee.waterdropservice.entity.fdp.FdpFaultOrderDispatchRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CfgDispatchRouteMapper extends BaseMapper<CfgDispatchRoute> {
    int deleteByPrimaryKey(Integer id);

    int insert(CfgDispatchRoute record);

    int insertSelective(CfgDispatchRoute record);

    CfgDispatchRoute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgDispatchRoute record);

    int updateByPrimaryKey(CfgDispatchRoute record);

    /**
     * 查询所有
     * @return
     */
    List<CfgDispatchRoute> selectAll();

    /**
     * 默认项目条数
     * @return
     */
    int selectByIsNoDefault();

    /**
     * 派工规则分配人员
     * @param fdpFaultOrderDispatchRequest
     * @return
     */
    CfgDispatchRouteDetail selectByPersons(FdpFaultOrderDispatchRequest fdpFaultOrderDispatchRequest);


    /**
     * 派工规则默认分配人员
     * @return
     */
    String selectByDefaultPerson();

    /**
     * 非特定项目条数
     * @return
     */
    int selectByIsNoProject();
}