package com.platform.springboot.service.fdp;

import com.platform.springboot.entity.fdp.*;
import com.platform.springboot.mapper.fdp.FdpDispatchJobContentMapper;
import com.platform.springboot.mapper.fdp.FdpDispatchRequestHistoryMapper;
import com.platform.springboot.mapper.fdp.FdpFaultDispatchOrderMapper;
import com.platform.springboot.mapper.fdp.FdpFaultOrderDispatchRequestMapper;
import com.platform.springboot.utils.DateUtil;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghao
 * @Title: FdpDispatchRequestHistoryService
 * @ProjectName BlueOcean
 * @Description: 派工历史记录
 * @date 2019/1/9下午1:30
 */
@Service
public class FdpDispatchRequestHistoryService {

    @Resource
    private FdpDispatchRequestHistoryMapper fdpDispatchRequestHistoryMapper;

    @Resource
    private FdpFaultOrderDispatchRequestMapper fdpFaultOrderDispatchRequestMapper;

    @Resource
    private FdpFaultDispatchOrderMapper fdpFaultDispatchOrderMapper;

    @Resource
    private FdpDispatchJobContentMapper fdpDispatchJobContentMapper;

    /**
     * 新增派工单历史
     *
     * @param request
     * @return
     * @Author:Niting
     * @Date:2018/10/15
     */
    public Result insertHistory(FdpFaultOrderDispatchRequest request, Integer userId) {
        Date now = new Date();
        Integer version = fdpDispatchRequestHistoryMapper.selectMaxVersionByRequestId(request.getId());
        FdpFaultOrderDispatchRequest dispatchRequest = fdpFaultOrderDispatchRequestMapper.selectByPrimaryKey(request.getId());
        //新增派工历史表
        FdpDispatchRequestHistory history = new FdpDispatchRequestHistory();
        if (version == null) {
            history.setRequestVersionCode("1");
        } else {
            String verCode = String.valueOf(version + 1);
            history.setRequestVersionCode(verCode);
        }
        history.setRootRequestId(request.getId());
        history.setCompanyId(request.getCompanyId());
        history.setStoreId(request.getStoreId());
        history.setFaultOrderId(request.getFaultOrderId());
        history.setRootFaultOrderId(request.getRootFaultOrderId());
        history.setHrCount(request.getHrCount());
        history.setServiceAddress(request.getServiceAddress());
        history.setServiceProvince(request.getServiceProvince());
        history.setServiceCity(request.getServiceCity());
        history.setServiceDistrict(request.getServiceDistrict());
        history.setDispatchModelRequest(request.getDispatchModelRequest());
        history.setEquipmentRequest(request.getEquipmentRequest());
        history.setOtherRequest(request.getOtherRequest());
        history.setDispatchDescription(request.getDispatchDescription());
        history.setMemo(request.getMemo());
        history.setUrgencyRequest(request.getUrgencyRequest());
        history.setServiceDate(request.getServiceDate());
        history.setServiceTimeStart(request.getServiceTimeStart());
        history.setServiceTimeEnd(request.getServiceTimeEnd());
        history.setFlagDeleted(false);
        history.setFlagAvailable(true);
        history.setFlagHasDispatched(false);
        history.setOtherBrand(request.getOtherBrand());
        history.setOtherStore(request.getOtherStore());
        history.setLongitude(request.getLongitude());
        history.setLatitude(request.getLatitude());
        history.setSourceType(request.getSourceType());
        history.setCreatePerson(request.getCreatePerson());
        history.setCreateTime(request.getCreateTime());
        history.setUpdateTime(request.getUpdateTime());
        history.setUpdatePerson(request.getUpdatePerson());
        history.setUploadFileName(request.getUploadFileName());
        history.setUploadFileUrl(request.getUploadFileUrl());
        history.setDispatchModelId(request.getDispatchModelId());
        history.setBackupDeviceRequest(request.getBackupDeviceRequest());
        history.setExpectReplyHours(request.getExpectReplyHours());
        history.setExpectReplyTime(request.getExpectReplyTime());
        history.setExpectCompleteTime(request.getExpectReplyTime());
        history.setOtherSystemNumber(request.getOtherSystemNumber());
        history.setCreateHistoryPerson(userId);
        history.setCreateHistoryTime(now);
        if (dispatchRequest != null) {
            history.setCreateTime(dispatchRequest.getCreateTime());
            history.setCreatePerson(dispatchRequest.getCreatePerson());
        }
        fdpDispatchRequestHistoryMapper.insertSelective(history);

        int orderId = fdpFaultDispatchOrderMapper.selectFaultOrderId(request.getId());

        if (orderId != 0) {
            //将工单之前的工作内容改为无效
            fdpDispatchJobContentMapper.updateFlagIsLastByFaultOrderId(orderId);

            //新增派工任务表
            String[] description = request.getDispatchDescription().split(";");

            int i = 1;
            for (String string : description) {
                FdpDispatchJobContent content = new FdpDispatchJobContent();
                content.setDispatchRequestId(request.getId());
                content.setDispatchOrderId(orderId);
                content.setFlagIsLast(true);
                content.setCreateTime(now);
                content.setRequestHistoryId(history.getId());
                content.setJobDefineVersion(Integer.parseInt(history.getRequestVersionCode()));
                content.setJobStepIndex(i);
                content.setJobStepDescription(string);
                i++;
                fdpDispatchJobContentMapper.insertSelective(content);
            }
        }
        return ResultUtil.success();
    }

    /**
     * 查询派工单历史
     *
     * @param requestId
     * @return
     * @Author:Niting
     * @Date:2018/10/16
     */
    public Result getHistoryList(int requestId) {
        List<FdpDispatchRequestHistory> historyLists = fdpDispatchRequestHistoryMapper.getListByRequestId(requestId);
        List<GetFdpRequestHistoryList> result = new ArrayList<GetFdpRequestHistoryList>();
        for (FdpDispatchRequestHistory item : historyLists) {
            GetFdpRequestHistoryList history = new GetFdpRequestHistoryList();
            history.setVersion(DateUtil.getNoSecondFormat(item.getCreateHistoryTime()));
            history.setRequestId(item.getRootRequestId());
            history.setId(item.getId());
            result.add(history);
        }
        return ResultUtil.success(result);
    }

    /**
     * 查询派工单历史详情
     *
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/10/16
     */
    public Result showHistory(int id) {
        FdpDispatchRequestHistoryShow history = fdpDispatchRequestHistoryMapper.show(id);

        //查询派工要求工作内容历史
        List<FdpDispatchJobContent> contents = fdpDispatchJobContentMapper.selectByHistoryId(history.getId());
        StringBuffer job = new StringBuffer();
        if (contents.size() != 0) {
            //工作内容为一个
            if (contents.size() == 1) {
                history.setDispatchDescription(contents.get(0).getJobStepDescription());
            } else {
                for (int i = 0; i < contents.size(); i++) {
                    if (!"".equals(contents.get(i).getJobStepDescription()) && i == 0) {
                        job.append(contents.get(i).getJobStepDescription());
                    } else {
                        job.append(";" + contents.get(i).getJobStepDescription());
                    }
                }
                history.setDispatchDescription(job.toString());
            }
        }
        return ResultUtil.success(history);
    }
}
