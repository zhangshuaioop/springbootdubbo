package com.teekee.blackrockservice.mapper.fdp;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blackrockservice.entity.bif.BifServiceListParam;
import com.teekee.blackrockservice.entity.dmi.DmiBrandName;
import com.teekee.blackrockservice.entity.fdp.FdpFaultDispatchHrRelation;
import com.teekee.blackrockservice.entity.fdp.FdpRecentOrderList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FdpFaultDispatchHrRelationMapper extends BaseMapper<FdpFaultDispatchHrRelation>{

    List<FdpRecentOrderList> selectNoticeList(BifServiceListParam serviceListParam);

    FdpFaultDispatchHrRelation selectByOrderId(Integer id);

    void updateMemoById(FdpFaultDispatchHrRelation hrRelation);

    /**
     * 工单筛选品牌
     * @param id
     * @return
     * @Author Chenliwen
     * @Date 2018/11/07
     */
    List<DmiBrandName> selectBrandNameById(Integer id);

    /**
     * 根据orderId提交完工资料
     * @return
     * @Author:Niting
     * @Date:2018/07/23
     */
    int updateByOrderId(FdpFaultDispatchHrRelation param);

    /**
     * 开始处理
     * @param hrRelation
     * @return
     * @Author Chenliwen
     * @Date 2018/11/07
     */
    void updateServiceStartByOrderId(FdpFaultDispatchHrRelation hrRelation);
}