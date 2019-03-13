package com.platform.springboot.service.fdp;

import com.platform.springboot.entity.fdp.*;
import com.platform.springboot.mapper.fdp.*;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhanghao
 * @Title: FdpFaultOrderDispatchRequestService
 * @ProjectName BlueOcean
 * @Description: 派工工单信息
 * @date 2019/1/4上午9:26
 */
@Service
public class FdpFaultOrderDispatchRequestService {

    private Logger log = Logger.getLogger(Logger.class);

    @Resource
    private FdpFaultOrderDispatchRequestMapper fdpFaultOrderDispatchRequestMapper;

    @Resource
    private FdpFaultDispatchHrRelationMapper fdpFaultDispatchHrRelationMapper;

    @Resource
    private FdpFaultDispatchOrderService fdpFaultDispatchOrderService;

    @Resource
    private FdpFaultOrderProcessMapper fdpFaultOrderProcessMapper;

    @Resource
    private FdpFaultOrderProcessLogMapper fdpFaultOrderProcessLogMapper;

    @Resource
    private FdpFaultDispatchOrderMapper fdpFaultDispatchOrderMapper;

    @Resource
    private FdpDispatchRequestHistoryService fdpDispatchRequestHistoryService;


    /**
     * 　* @Description: 查看派工人员信息
     * 　* @param requestId
     * 　* @return ${return_type}
     * 　* @author zhanghao
     * 　* @date 2019/1/9 上午9:31
     *
     */
    public Result showDispatch(Integer requestId) {
        log.info("查看派工人员信息sql执行");
        GetFdpFaultDispatchHrRelationShow show = fdpFaultDispatchHrRelationMapper.getDispatchHrShow(requestId);
        //点击查询更为已读
        fdpFaultDispatchOrderService.setReadPurchase(requestId, CurrentUtil.getCurrent().getId());

        if (show != null) {
            if (!show.getFlagDisplay()) {
                if (show.getMobile() != null) {
                    String mobile = show.getMobile();
                    mobile = mobile.replaceAll("(\\d{3})\\d{6}(\\d{2})", "$1******$2");
                    show.setMobile(mobile);
                }
            }

        }
        return ResultUtil.success(show);
    }

    /**
     * 　* @Description: 查看工单信息
     * 　* @param requestId
     * 　* @return ${return_type}
     * 　* @author zhanghao
     * 　* @date 2019/1/9 上午9:31
     *
     */
    public Result showNew(Integer requestId) {
        log.info("点击查询更为已读");
        fdpFaultDispatchOrderService.setReadPurchase(requestId, CurrentUtil.getCurrent().getId());
        return ResultUtil.success(fdpFaultOrderDispatchRequestMapper.selectByPrimaryKeyNew(requestId));
    }

    /**
    　* @Description: 采购编辑工单
    　* @author zhanghao
    　* @date 2019/1/9 下午1:42
    　*/
    public Result handle(FdpFaultOrderDispatchRequest request) {

        Integer userId = CurrentUtil.getCurrent().getId();

        // 当前时间
        Date now = new Date();

        // 根据故障单id，查询故障单详情
        int processId = 0;
        //服务省份为空
        if (request.getServiceProvince() == null || request.getServiceProvince().equals("")) {
            return ResultUtil.errorBusinessMsg("请填写服务省份！");
        }
        //服务城市为空
        if (request.getServiceCity() == null || request.getServiceCity().equals("")) {
            return ResultUtil.errorBusinessMsg("请填写服务城市！");
        }
        //未选择模糊地址
        if (request.getFlagFuzzyAddress() == false) {
            //服务地址为空
            if (request.getServiceAddress() == null || request.getServiceAddress().equals("")) {
                return ResultUtil.errorBusinessMsg("请填写服务地址！");
            }
        }

        //期望回复时间为空
        if (request.getExpectReplyHours() == null) {
            //期望回复时间为空
            return ResultUtil.errorBusinessMsg("期望回复时间为空！");
        }

        if (request.getFlagFixedPrice() == true) {
            if (request.getEstimatedPrice() == null || request.getEstimatedPriceUnit() == null) {
                return ResultUtil.errorBusinessMsg("请填写参考价格！");
            }
        }

        if (request.getFaultOrderId() != null && request.getFaultOrderId() > 0) {
            processId = request.getFaultOrderId();

            FdpFaultOrderProcess processInfo = fdpFaultOrderProcessMapper.selectByPrimaryKey(processId);

            // 将故障工单相
            // 信息放入派工信息当中
            request.setCompanyId(processInfo.getCompanyId());
            request.setStoreId(processInfo.getStoreId());
            request.setRootFaultOrderId(processInfo.getRootId());
            request.setFaultOrderNumber(processInfo.getFaultOrderNumber());
            request.setServiceAddress(processInfo.getServiceAddress());
            request.setUrgencyRequest(processInfo.getUrgencyRequest());
            request.setServiceDate(processInfo.getServiceDate());
            request.setServiceTimeStart(processInfo.getServiceTimeStart());
            request.setServiceTimeEnd(processInfo.getServiceTimeEnd());
            FdpFaultOrderProcess processRequest = new FdpFaultOrderProcess();
            processRequest.setFlagDispatchRequest(true);
            processRequest.setId(request.getFaultOrderId());
            fdpFaultOrderProcessMapper.updateDispatchRequest(processRequest);

        }

        //是否存草稿
        if (request.getFlagDraft() == false) {
            request.setSubmitTime(now);
        }

        if (request.getId() == null || request.getId() == 0) {
            return ResultUtil.validateError("参数错误");
        } else {
            //编辑派工要求
            request.setUpdateTime(now);
            request.setFlagRequestModified(true);
            request.setSourceType("SYS");
            request.setCompleteProfileTemplateUpdatePerson(userId);
            request.setCompleteProfileTemplateUpdateTime(new Date());
            fdpFaultOrderDispatchRequestMapper.updateByPrimaryKeySelective(request);

            //编辑派工
            FdpFaultDispatchOrder order = new FdpFaultDispatchOrder();
            order.setFaultDispatchRequestId(request.getId());
            //编辑派工单时保存附件和完工资料模板信息
            if (request.getUploadFileName() != null) {
                order.setUploadFileName(request.getUploadFileName());
            }
            if (request.getUploadFileUrl() != null) {
                order.setUploadFileUrl(request.getUploadFileUrl());
            }
            if (request.getCompleteProfileTemplateName() != null) {
                order.setCompleteProfileTemplateName(request.getCompleteProfileTemplateName());
            }
            if (request.getCompleteProfileTemplateUrl() != null) {
                order.setCompleteProfileTemplateUrl(request.getCompleteProfileTemplateUrl());
            }

            if (request.getFlagSubmit() == true) {
                //编辑派工
                order.setDispatchStatus("NEW");
                order.setProcessStage("1");
            }

            fdpFaultDispatchOrderMapper.updateDispatchOrderByRequestId(order);
        }

        if (request.getFlagDraft() != true) {
            //新增派工历史
            fdpDispatchRequestHistoryService.insertHistory(request, userId);
        }

        if (processId > 0) {
            // 更新流程表状态
            FdpFaultOrderProcess process = new FdpFaultOrderProcess();
            process.setId(processId);
            process.setUpdatePerson(userId);
            process.setUpdateTime(now);
            process.setOpearteStatus("DEALING");
            fdpFaultOrderProcessMapper.updateByPrimaryKeySelective(process);

            //查询出process表中ID对应额RootId
            int processRootId = fdpFaultOrderProcessMapper.selectRootId(processId);

            // 流程日志
            FdpFaultOrderProcessLog processLog = new FdpFaultOrderProcessLog();
            processLog.setFaultOrderProcessId(processId);
            processLog.setTitle("DEALING");
            processLog.setMemo("处理中");
            processLog.setProcessTime(now);
            processLog.setProcessPersonId(userId);
            processLog.setFlagConsole(true);
            processLog.setRootId(processRootId);
            fdpFaultOrderProcessLogMapper.insertSelective(processLog);
        }
        return ResultUtil.success();
    }

    public Result profile(FdpFaultOrderDispatchRequest dispatchRequest) {
        FdpFaultDispatchOrder fdpFaultDispatchOrder = new FdpFaultDispatchOrder();
        fdpFaultDispatchOrder.setFaultDispatchRequestId(dispatchRequest.getId());
        fdpFaultDispatchOrder.setUploadFileName(dispatchRequest.getUploadFileName() != null ? dispatchRequest.getUploadFileName() : null);
        fdpFaultDispatchOrder.setUploadFileUrl(dispatchRequest.getUploadFileUrl() != null ? dispatchRequest.getUploadFileUrl() : null);
        fdpFaultDispatchOrder.setCompleteProfileTemplateName(dispatchRequest.getCompleteProfileTemplateName() != null ? dispatchRequest.getCompleteProfileTemplateName() : null);
        fdpFaultDispatchOrder.setCompleteProfileTemplateUrl(dispatchRequest.getCompleteProfileTemplateUrl() != null ? dispatchRequest.getCompleteProfileTemplateUrl() : null);
        if (fdpFaultDispatchOrderMapper.updateDispatchOrderByRequestId(fdpFaultDispatchOrder) > 0) {
            return ResultUtil.success();
        }
        return ResultUtil.errorBusinessMsg("保存失败");

    }
}
