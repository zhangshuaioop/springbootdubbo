package com.company.springboot.mapper.fdp;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.fdp.*;
import com.github.pagehelper.Page;
import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.fdp.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface FdpFaultOrderDispatchRequestMapper extends BaseMapper<FdpFaultOrderDispatchRequest> {



    int insertSelective(FdpFaultOrderDispatchRequest record);

    FdpFaultOrderDispatchRequest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpFaultOrderDispatchRequest record);

    FdpFaultOrderDispatchRequestShow show(Integer requestId);

    /**
     * 修改派工请求
     *
     * @param record
     * @return
     * @create 2018年04月26日 13:33
     * @author liukan
     */
    int updateByProcessIdSelective(FdpFaultOrderDispatchRequest record);
    /**
     * 查询派工信息
     *
     * @param paramFdpFaultDispatchRequestQuery

     * @author liukan
     * @create 2018年04月25日 10:39
     * @return
     */
    Page<FdpFaultDispatchOrderRequestForList> selectByPrimaryByselect(ParamFdpFaultDispatchRequestQuery paramFdpFaultDispatchRequestQuery);


    /**
     * 查看派工信息
     *
     * @param requestId
     * @author liukan
     * @create 2018年04月25日 10:39
     * @return
     */
    FdpFaultOrderDispatchRequest selectByPrimaryKeyNew(Integer requestId);

    int selectHrIdByRequestId(int requestId);

    /**
     * 通过派工工单查询导出xsl列表
     *@param:  派工工单集合
     *@return: 导出列表集合
     *@Author Niting
     *@date: 2018/4/26
     **/
    List<FdpFaultDispatchOrderRequestForDownload> selectByOrderNumber(List<String> list);


    Integer selectCreatePerson(Integer faultDispatchRequestId);

    String selectGzNumer(Integer faultDispatchRequestId);

    void updateHasDispatched(FdpFaultOrderDispatchRequest request);




    List<Map<String,Object>> selectOldPersonId(HashMap<String, Object> map);


    void dispatchTransmit(HashMap<String, Object> map);

}