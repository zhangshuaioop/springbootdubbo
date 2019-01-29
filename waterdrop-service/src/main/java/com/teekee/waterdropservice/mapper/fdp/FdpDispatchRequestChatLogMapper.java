package com.teekee.waterdropservice.mapper.fdp;

import com.teekee.waterdropservice.entity.fdp.FdpDispatchRequestChatLog;
import com.teekee.waterdropservice.entity.fdp.GetfdpDispatchRequestChatLogList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FdpDispatchRequestChatLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FdpDispatchRequestChatLog record);
    /**
     * 新增调整信息
     *
     * @param record

     * @create 2018年04月26日 13:33
     * @author liukan
     * @return
     */
    int insertSelective(FdpDispatchRequestChatLog record);
    /**
     * 查看调整信息
     *
     * @param id

     * @create 2018年04月26日 13:33
     * @author liukan
     * @return
     */
    List<FdpDispatchRequestChatLog> selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpDispatchRequestChatLog record);

    /**
     * 查询采购未读信息列表
     *
     * @param userId
     * @create 2018年05月11日
     * @author Niting
     * @return
     */
    List<GetfdpDispatchRequestChatLogList> getPurchaseLastList(int userId);
    /**
     * 查询派工未读信息列表
     *
     * @param userId
     * @create 2018年05月11日
     * @author Niting
     * @return
     */
    List<GetfdpDispatchRequestChatLogList> getDispatchLastList(int userId);
    /**
     * 设置沟通消息已读
     *
     * @param requestId
     * @create 2018年05月10日
     * @author Niting
     * @return
     */
    int setRead(int requestId);
    /**
     * 查询是否为采购方
     *
     * @param userId
     * @create 2018年05月11日
     * @author Niting
     * @return
     */
    String getUserType(int userId);
    /**
     * 设置非本人发送沟通消息已读
     *
     * @param chatLog
     * @create 2018年05月11日
     * @author Niting
     * @return
     */
    int setReadNotSend(FdpDispatchRequestChatLog chatLog);
    /**
     * 根据userId查询lastdealPersonid
     *
     * @param chatLog
     * @create 2018年05月18日
     * @author Niting
     * @return
     */
    Integer selectLastPerson(FdpDispatchRequestChatLog chatLog);

    Integer selectCreatePerson(FdpDispatchRequestChatLog chatLog);

    List<GetfdpDispatchRequestChatLogList> selectUnread(int userId);
    /**
     * 查看调整信息
     *
     * @param faultDispatchRequestId

     * @create 2018年05月22日 13:33
     * @author Niting
     * @return
     */
    List<GetfdpDispatchRequestChatLogList> selectChatLogAndHead(Integer faultDispatchRequestId);
}