package com.company.springboot.mapper.cfg;


import com.company.springboot.entity.cfg.CfgDispatchRoute;
import com.company.springboot.entity.cfg.CfgDispatchRouteDetail;
import com.company.springboot.entity.fdp.FdpFaultOrderDispatchRequest;
import com.company.springboot.base.BaseMapper;
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