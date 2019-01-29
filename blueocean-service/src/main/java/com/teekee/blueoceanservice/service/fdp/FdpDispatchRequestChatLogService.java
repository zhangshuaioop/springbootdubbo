package com.teekee.blueoceanservice.service.fdp;

import com.teekee.blueoceanservice.entity.fdp.FdpDispatchRequestChatLog;
import com.teekee.blueoceanservice.entity.fdp.FdpFaultOrderProcess;
import com.teekee.blueoceanservice.entity.fdp.GetfdpDispatchRequestChatLogList;
import com.teekee.blueoceanservice.entity.sysconsole.SysConsoleUsers;
import com.teekee.blueoceanservice.mapper.fdp.FdpDispatchRequestChatLogMapper;
import com.teekee.blueoceanservice.mapper.fdp.FdpFaultDispatchOrderMapper;
import com.teekee.blueoceanservice.mapper.fdp.FdpFaultOrderProcessMapper;
import com.teekee.blueoceanservice.utils.CurrentUtil;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author Chenliwen
 * @Date 2019/1/8 15:01
 **/
@Service
public class FdpDispatchRequestChatLogService {
    @Resource
    private FdpDispatchRequestChatLogMapper fdpDispatchRequestChatLogMapper;
    @Resource
    private FdpFaultDispatchOrderMapper fdpFaultDispatchOrderMapper;
    @Resource
    private FdpFaultOrderProcessMapper fdpFaultOrderProcessMapper;


    public Result handle(FdpDispatchRequestChatLog request) {
        SysConsoleUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }

        //查询接收方id
        FdpDispatchRequestChatLog chatLog = new FdpDispatchRequestChatLog();
        chatLog.setProcessPersonId(users.getId());
        chatLog.setFaultDispatchRequestId(request.getFaultDispatchRequestId());

        // 当前时间
        Date now = new Date();
        request.setProcessPersonId(users.getId());
        request.setProcessTime(now);
        request.setFlagRead(false);
        request.setUploadFileName(request.getUploadFileName());
        request.setUploadFileUrl(request.getUploadFileUrl());
        request.setImageFileName(request.getImageFileName());
        request.setImageFileUrl(request.getImageFileUrl());
        //request.setFlagConsole(true);
        //判断沟通方是采购还是派工
        int dealPerson = 0;
        if (request.getUserType().equals("DISPATCHREQ")) {
            request.setUserType("DISPATCHREQ");
            dealPerson = fdpDispatchRequestChatLogMapper.selectLastPerson(chatLog);
        } else if (request.getUserType().equals("HRPURCHASE")) {
            request.setUserType("HRPURCHASE");
            dealPerson = fdpDispatchRequestChatLogMapper.selectCreatePerson(chatLog);
        }
        request.setTargetPersonId(dealPerson);
        //查询工单编号
        String number = fdpFaultDispatchOrderMapper.selectNumber(request.getFaultDispatchRequestId());
        request.setDispatchOrderNumber(number);
        //判断是否有文件或是图片上传
        if (!request.getUploadFileUrl().equals("") || !request.getImageFileUrl().equals("")) {
            //生成附件提示消息
            request.setContent("您有一条附件消息");
            fdpDispatchRequestChatLogMapper.insertSelective(request);
        } else {
            fdpDispatchRequestChatLogMapper.insertSelective(request);
        }
        return ResultUtil.success();
    }


    public Result list(FdpDispatchRequestChatLog request) {
        List<GetfdpDispatchRequestChatLogList> list = fdpDispatchRequestChatLogMapper.selectChatLogAndHead(request.getFaultDispatchRequestId());
        return ResultUtil.success(list);
    }


    public Result listLast() {
        SysConsoleUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }

        List<GetfdpDispatchRequestChatLogList> list = fdpDispatchRequestChatLogMapper.selectUnread(users.getId());
        List<FdpFaultOrderProcess> processList = fdpFaultOrderProcessMapper.selectProcessByCreatePerson(users.getId());
        for (GetfdpDispatchRequestChatLogList item : list) {
            if (item.getUserType().equals("DISPATCHREQ")) {
                item.setUserType("HRPURCHASE");
            } else {
                item.setUserType("DISPATCHREQ");
            }
            if (processList.size() > 0) {
                for (FdpFaultOrderProcess record : processList) {
                    //判断客服的创建人与沟通记录的接收方是否一致
                    if (item.getTargetPersonId() == record.getCreatePerson()) {
                        //获取故障工单编号
                        item.setFaultOrderNumber(record.getFaultOrderNumber());
                    }
                }
            }
        }
        return ResultUtil.success(list);
    }


    public Result setRead(int requestId) {
        fdpDispatchRequestChatLogMapper.setRead(requestId);
        return ResultUtil.success();
    }


    /**
     * 设置非本人发送沟通消息已读
     *
     * @param requestId
     * @return
     * @create 2018年05月11日
     * @author Niting
     */
    public Result setReadNotSend(int requestId) {
        SysConsoleUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }

        FdpDispatchRequestChatLog chatLog = new FdpDispatchRequestChatLog();
        chatLog.setFaultDispatchRequestId(requestId);
        chatLog.setProcessPersonId(users.getId());
        fdpDispatchRequestChatLogMapper.setReadNotSend(chatLog);
        return ResultUtil.success();
    }
}
