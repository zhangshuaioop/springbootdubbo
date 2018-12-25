package com.platform.springboot.mapper.fdp;


import com.platform.springboot.entity.fdp.*;
import com.platform.springboot.entity.fdp.ParamFdpProcessDetailed;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface FdpFaultOrderProcessMapper {

    int insertSelective(FdpFaultOrderProcess record);

    FdpFaultOrderProcess selectByPrimaryKey(Integer id);


    /**
     * 更新故障工单表
     *
     * @param record
     * @return
     * @author liukan
     * @create 2018年04月25日 10:39
     */
    int updateByPrimaryKeySelective(FdpFaultOrderProcess record);

    List<GetFaultOrderList> queryFaultOrderListByObject(GetFaultOrderListRequest record);

    EntityFaultReportInfoDetail show(Integer id);

    FdpFaultOrderProcess queryBySourceReportId(Integer id);

    List<HistoryRecordList> historyRecordList(Integer storeId);

    FdpFaultOrderProcess selectNextId();
    /**
     * 更改故障状态
     *
     * @param updateProcess
     * @return
     * @author liukan
     * @create 2018年04月25日 10:39
     */
    int updateById(FdpFaultOrderProcess updateProcess);

    void insertTransferLog(HashMap<String, Object> map);

//    void updateProcessOpearteStatusById(HashMap<String, Object> map);

    void deleteProcessById(HashMap<String, Object> map);


    void updateBelongPersonIdByUserId(HashMap<String, Object> map);


    void updateByUserId(HashMap<String, Object> map);

    void updateRootId(FdpFaultOrderProcess setRootId);

    FdpFaultOrderProcess showProcess(int id);


    List<Map<String, Object>> selectOrgDealPersonId(Object idList);
    /**
     * 查询故障单下所有信息列表
     *
     * @param rootId
     * @author Niting
     * @create 2018年04月28日
     * @return
     */
    List<GetFaultOrderList> getFaultOrderListByRootId(int rootId);


    void updateFlagHasMultiple(FdpFaultOrderProcess updateFlagHasMultiple);


    void updateFlagLastOrderByRootId(FdpFaultOrderProcess flagLastOrder);

    void updateDispatchRequest(FdpFaultOrderProcess processRequest);

    /**
     * 修改流程表状态
     * @param process
     * @author Niting
     * @create 2018年05月07日
     */
    void updateProcessStatusByProcessId(FdpFaultOrderProcess process);

    int selectRootId(int processId);
    /**
     * 通过userid查询故障单
     * @param createPerson
     * @author Niting
     * @create 2018年05月07日
     */
    List<FdpFaultOrderProcess> selectProcessByCreatePerson(Integer createPerson);
    /**
     * 查询客服工单清单
     * @param param
     * @return
     * @Author Niting
     * @Date 2018/06/13
     */
    List<GetFdpProcessDetailedList> getProcessListByObject(ParamFdpProcessDetailed param);


    List<GetDemandCollectList> selectDemandList(ParamFdpProcessDetailed param);
    /**
     * 查询客服工单汇总
     * @param param
     * @return
     * @Author Niting
     * @Date 2018/06/13
     */
    GetFdpProcessCollectList selectProcessCollect(ParamFdpProcessDetailed param);
    /**
     * 查询客服工单处理人汇总
     * @param param
     * @return
     * @Author Niting
     * @Date 2018/06/18
     */
    List<GetBelongPersonCollerctList> selectDealPersonList(ParamFdpProcessDetailed param);
}