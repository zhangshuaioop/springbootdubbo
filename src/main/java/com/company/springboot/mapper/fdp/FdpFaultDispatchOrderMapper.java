package com.company.springboot.mapper.fdp;

import com.company.springboot.entity.fdp.*;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.entity.bif.BifDispatchHumanResource;
import com.company.springboot.entity.bif.DispatchHumanResourceList;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface FdpFaultDispatchOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FdpFaultDispatchOrder record);

    int insertSelective(FdpFaultDispatchOrder record);

    FdpFaultDispatchOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpFaultDispatchOrder record);

    int updateByPrimaryKey(FdpFaultDispatchOrder record);




    List<Map<String,Object>> selectNextDealPersonId(List<SysCompanyUsers> userList);
    /**
     * 更新故障工单表
     *
     * @param updateOrder
     * @return
     * @author liukan
     * @create 2018年04月25日 10:39
     */
    int updateDispatchOrderByRequestId(FdpFaultDispatchOrder updateOrder);

    Page<GetDispatchOrderListResp> getOrderListByObject(GetDispatchOrderListRequest record);

    int updateStatusByRequestId(FdpFaultDispatchOrder order);

    int updateStatusByDispatchRequestId(FdpFaultDispatchOrder order);

    List<Map<String,Object>> selectOldPersonId(HashMap<String, Object> map);

    void dispatchTransmit(HashMap<String, Object> map);
    /**
     * 修改派工工单
     *
     * @param dispatchOrder
     * @return
     * @create 2018年04月26日 13:33
     * @author liukan
     */
    int updateByProcessIdSelective(FdpFaultDispatchOrder dispatchOrder);

    List<BifDispatchHumanResource> dispatchMainHrIdList(DispatchHumanResourceList dispatchHumanResourceList);

    void updateServerTimeById(FdpFaultDispatchHrRelation hrRelation);


    FdpFaultDispatchOrder selectByRequestId(int requestId);

    /**
     * 查询客户是否确认完工
     *
     * @param faultDispatchRequestId
     * @return
     * @create 2018年05月09日
     * @author Niting
     */
    FdpFaultDispatchOrder selectCustomerConfirm(Integer faultDispatchRequestId);
    /**
     * 查询采购是否确认完工
     *
     * @param faultDispatchRequestId
     * @return
     * @create 2018年05月09日
     * @author Niting
     */
    FdpFaultDispatchOrder selectDispatchConfirm(Integer faultDispatchRequestId);

    String selectNumber(Integer id);


    int selectDispatchOrder(Integer faultDispatchRequestId);

    int selectFaultOrderId(Integer faultDispatchRequestId);

    Page<FdpFaultdispatchRequestList> selectOrderList(GetFaultDispatchRequestList getFaultDispatchRequestList);

    List<FdpFaultdispatchRequestList> selectOrderListDemand(GetFaultDispatchRequestList getFaultDispatchRequestList);

    Page<FdpFaultDispatchOrderList> selectDispatchOrderList(GetFdpFaultdispatchOrderList getFdpFaultdispatchOrderList);

    int selectRequestCount(GetFaultDispatchRequestList getFaultDispatchRequestList);

    FaultOrderRequestCount selectRequestCompletePrice(GetFaultDispatchRequestList getFaultDispatchRequestList);

    List<FaultOrderRequestCountByCompany> selectRequestByCompanyAll(GetFaultDispatchRequestList getFaultDispatchRequestList);

    List<FaultOrderRequestCount> selectRequestByCompanyComplete(GetFaultDispatchRequestList getFaultDispatchRequestList);

    List<FaultOrderRequestCount> selectRequestByCompanyUnComplete(GetFaultDispatchRequestList getFaultDispatchRequestList);

    List<FaultOrderRequestCountByCompany> selectRequestByCreatePersonyAll(GetFaultDispatchRequestList getFaultDispatchRequestList);

    List<FaultOrderRequestCount> selectRequestByCreatePersonyComplete(GetFaultDispatchRequestList getFaultDispatchRequestList);

    List<FaultOrderRequestCount> selectRequestByCreatePersonyUnComplete(GetFaultDispatchRequestList getFaultDispatchRequestList);

    int selectOrderCount(GetFaultDispatchRequestList getFaultDispatchRequestList);

    FaultOrderCount selectOrderCounts(GetFaultDispatchRequestList getFaultDispatchRequestList);

    FaultOrderCount selectOrderCompletePrice(GetFaultDispatchRequestList getFaultDispatchRequestList);

    List<FaultOrderRequestCountByCompany> selectOrderByCompanyAll(GetFaultDispatchRequestList getFaultDispatchRequestList);

    List<FaultOrderCount> selectOrderByCompanyComplete(GetFaultDispatchRequestList getFaultDispatchRequestList);

    List<FaultOrderCount> selectOrderByCompanyUnComplete(GetFaultDispatchRequestList getFaultDispatchRequestList);

    Page<FaultOrderRequestCountByCompany> selectOrderByDealPersonAll(GetFaultDispatchRequestList getFaultDispatchRequestList);

    List<FaultOrderCount> selectOrderByCreatePersonComplete(GetFaultDispatchRequestList getFaultDispatchRequestList);

    List<FaultOrderCount> selectOrderByCreatePersonUnComplete(GetFaultDispatchRequestList getFaultDispatchRequestList);

    String selectStatusById(Integer id);

    /**
     * 服务商接单状态数量统计
     * @return
     * @Author:Niting
     * @Date:2018/08/20
     */
    GetDispatchOrderServiceStatusList selectStatusCollect(FdpFaultDispatchOrder order);
    /**
     * 服务商工单列表
     * @param param
     * @Date 2018/08/21
     * @author Niting
     * @return
     */
    List<GetServiceDispatchOrderList> selectServiceListByOrderId(ParamServiceDispatchOrder param);
    /**
     * 服务商查看工单信息
     * @param orderId
     * @Date 2018/08/21
     * @author Niting
     * @return
     */
    GetServiceOderInfoShow serOrderInfo(Integer orderId);
    /**
     * 服务商查看工单基础信息
     * @param orderId
     * @Date 2018/08/21
     * @author Niting
     * @return
     */
    GetServiceOrderBasicInfo selectServiceOrderBasic(Integer orderId);
    /**
     * 客户驳回完工资料
     * @param id
     * @Date 2018/10/19
     * @author Chenliwen
     * @return
     */
    int updateCompleteById(Integer id);
    /**
     * 自动完工定时任务 获取工单列表
     * @Date 2018/08/21
     * @author zhanghao
     * @return
     */
    List<FdpFaultDispatchOrder> selectFdpFaultDispatchOrderList();
    /**
     * 获取附件模版信息
     * @param id
     * @return
     */
    FdpFaultDispatchOrder selectDispatchOrderByfdoId(Integer id);


    /**
     * 查询orderid
     * @param requestId
     * @return
     */
    Integer findOrderId(Integer requestId);


    /**
     * 编辑预计服务时间
     * @param estimatedServiceTime
     * @param requestId
     * @return
     */
    Integer updateServiceTime(@Param("estimatedServiceTime") String estimatedServiceTime,  @Param("requestId") Integer requestId);

    /**
     * 根据短工单号查询工单
     * @param shortOrderCode
     * @return
     */
    Integer findOrderByShortOrderCode(@Param("shortOrderCode") String shortOrderCode);
}