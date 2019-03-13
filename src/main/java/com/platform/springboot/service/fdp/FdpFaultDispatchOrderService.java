package com.platform.springboot.service.fdp;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.entity.bif.BifDispatchHumanResource;
import com.platform.springboot.entity.cfg.CfgDispatchWarningStatus;
import com.platform.springboot.entity.fdp.*;
import com.platform.springboot.entity.sys.ParamSysOperationMessage;
import com.platform.springboot.entity.syscompany.SysOperationMessage;
import com.platform.springboot.mapper.bif.BifDispatchHumanResourceMapper;
import com.platform.springboot.mapper.cfg.CfgDispatchWarningStatusMapper;
import com.platform.springboot.mapper.fdp.*;
import com.platform.springboot.mapper.syscompany.SysOperationMessageMapper;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.PageInfo;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author zhanghao
 * @Title: FdpFaultDispatchOrderService
 * @ProjectName BlueOcean
 * @Description: 派工工单
 * @date 2018/12/29上午10:46
 */
@Service
public class FdpFaultDispatchOrderService {

    @Resource
    private FdpFaultDispatchOrderMapper mapper;
    @Resource
    private FdpDispatchJobPerformanceMapper jobPerformanceMapper;
    @Resource
    private FdpDispatchProcessLogMapper fdpDispatchProcessLogMapper;
    @Resource
    private FdpFaultDispatchChangeLogMapper dispatchChangeLogMapper;
    @Resource
    private FdpFaultOrderProcessMapper processMapper;
    @Resource
    private SysOperationMessageMapper sysOperationMessageMapper;
    @Resource
    private FdpFaultDispatchHrRelationMapper hrMapper;
    @Resource
    private CfgDispatchWarningStatusMapper cfgDispatchWarningStatusMapper;
    @Resource
    private FdpFaultOrderDispatchRequestMapper requestMapper;
    @Resource
    private FdpDispatchCompleteProfileLogMapper completeProfileLogMapper;
    @Resource
    private BifDispatchHumanResourceMapper humanResourceMapper;
    @Resource
    private FdpFaultOrderProcessLogMapper fdpFaultOrderProcessLogMapper;
    @Resource
    private FdpFaultDispatchTransferLogMapper transferLogMapper;

    public Result serOrderList(ParamServiceDispatchOrder param) {
        return ResultUtil.success(mapper.selectServiceListByOrderId(param));
    }

    public Result serOrderShow(Integer orderId) {

        GetSerivceOrderInfoShow result = new GetSerivceOrderInfoShow();
        //查询工单基本信息
        result.setServiceOrderBasicInfo(mapper.selectServiceOrderBasic(orderId));

        //查询工作内容
        List<FdpDispatchJobPerformance> logList = jobPerformanceMapper.selectFirstVersionByOrderId(orderId);

        List<FdpDispatchJobPerformance> logNewList = jobPerformanceMapper.selectNewVersionByOrderId(orderId);

        for (FdpDispatchJobPerformance str : logList) {
            for (FdpDispatchJobPerformance str2 : logNewList) {
                if (str2.getJobStepDescription().equals(str.getJobStepDescription())) {
                    str.setWorkConditionPhoto(str2.getWorkConditionPhoto());
                    str.setWorkConditionPhotoName(str2.getWorkConditionPhotoName());
                    str.setJobPerformanceDescription(str2.getJobPerformanceDescription());
                    str.setFlagUsed(true);
                    if (str2.getVoiceLogUrl() != null && !str2.getVoiceLogUrl().equals("")) {
                        String[] voiceUrl = str2.getVoiceLogUrl().split(";");
                        String[] voiceLong = str2.getVoiceLogLength().split(";");
                        String[] voiceTime = str2.getVoiceLogTime().split(";");
                        GetFdpJobPerformanceVoice voice;
                        List<GetFdpJobPerformanceVoice> voiceList = new ArrayList<GetFdpJobPerformanceVoice>();
                        if (voiceUrl.length > 0) {
                            for (int i = 0; i < voiceUrl.length; i++) {
                                voice = new GetFdpJobPerformanceVoice();
                                voice.setVoiceLogUrl(voiceUrl[i]);
                                voice.setVoiceLogLength(voiceLong[i]);
                                voice.setVoiceLogTime(voiceTime[i]);
                                voiceList.add(voice);
                            }
                            str.setVoiceList(voiceList);
                        }
                    } else {
                        str.setVoiceList(new ArrayList<GetFdpJobPerformanceVoice>());
                    }
                }
            }
        }
        result.setJobPerformanceList(logList);

        //查询完工资料
        result.setServiceCompleteProfile(hrMapper.selectCompleteProFile(orderId));
        return ResultUtil.success(result);
    }

    public Result confirmDispatch(FdpFaultOrderInsertParam insertParam) {
        Integer userId = CurrentUtil.getCurrent().getId();

        BigDecimal num = new BigDecimal("99999999");
        if (insertParam.getEstimatedCost().compareTo(num) == 1) {
            return ResultUtil.errorBusinessMsg("预计成本长度过长（小于等于八位）");
        }
        if (insertParam.getEstimatedPrice().compareTo(num) == 1) {
            return ResultUtil.errorBusinessMsg("预计售价长度过长（小于等于八位）");
        }
        // 当前时间
        Date now = new Date();
        //查询当前订单状态
        String status = mapper.selectStatusById(insertParam.getDispatchOrderId());
        insertDispatchProcessLog(insertParam.getDispatchOrderId(), userId, "PURCHASE", status, "DEALING", "已安排派工", now);
        FdpFaultDispatchOrder updateOrder = new FdpFaultDispatchOrder();
        updateOrder.setMemo(insertParam.getMemo());
        updateOrder.setLastDealTime(insertParam.getLastDealTime());
        updateOrder.setLastDealPersonId(userId);
        updateOrder.setLastDealTime(now);
        updateOrder.setDispatchStatus("DEALING");
        //确认派工 步骤为2
        updateOrder.setProcessStage("2");
        updateOrder.setFlagCustomerConfirm(false);
        updateOrder.setFlagDispatcherConfirm(false);
        updateOrder.setFaultDispatchRequestId(insertParam.getRequestId());
        updateOrder.setEstimatedServiceTime(insertParam.getEstimatedServiceTime());
        updateOrder.setActualInvoiceType(insertParam.getActualInvoiceType());
        updateOrder.setActualInvoiceRate(insertParam.getActualInvoiceRate());
        updateOrder.setPrivateNote(insertParam.getPrivateNote());


        // 修改派工单
        mapper.updateDispatchOrderByRequestId(updateOrder);

        FdpFaultOrderInsertParam param = new FdpFaultOrderInsertParam();
        param.setFaultDispatchRequestId(insertParam.getRequestId());
        param.setEstimatedCost(insertParam.getEstimatedCost());
        param.setEstimatedMonetaryUnit(insertParam.getEstimatedMonetaryUnit());
        param.setEstimatedCostMemo(insertParam.getEstimatedCostMemo());
        if (insertParam.getFlagProvideInvoice() == true) {
            param.setFlagProvideInvoice(insertParam.getFlagProvideInvoice());
        } else {
            param.setFlagProvideInvoice(false);
        }
        //param.setUserAssmMemo(insertParam.getUserAssmMemo());
        param.setDispatchMainHrId(insertParam.getDispatchMainHrId());
        param.setDispatchOrderId(insertParam.getDispatchOrderId());
        param.setHrAccountInfoId(insertParam.getHrAccountInfoId());
        param.setFlagUsed(true);
        param.setEstimatedPrice(insertParam.getEstimatedPrice());
        param.setEstimatedPriceUnit(insertParam.getEstimatedPriceUnit());
        param.setEstimatedPriceMemo(insertParam.getEstimatedPriceMemo());
        param.setEstimatedInvoiceRate(insertParam.getEstimatedInvoiceRate());
        param.setEstimatedInvoiceType(insertParam.getEstimatedInvoiceType());
        hrMapper.insertSelective(param);

        FdpFaultDispatchChangeLog changeLog = new FdpFaultDispatchChangeLog();
        changeLog.setDispatchOrderId(insertParam.getDispatchOrderId());
        changeLog.setHrAccountInfoId(insertParam.getHrAccountInfoId());
        changeLog.setFaultDispatchRequestId(insertParam.getRequestId());
        changeLog.setDispatchMainHrId(insertParam.getDispatchMainHrId());
        changeLog.setHrRelationId(param.getId());
        changeLog.setCreatePerson(userId);
        changeLog.setEstimatedPriceUnit(insertParam.getEstimatedPriceUnit());
        changeLog.setEstimatedPrice(insertParam.getEstimatedPrice());
        changeLog.setEstimatedCost(insertParam.getEstimatedCost());
        changeLog.setEstimatedMonetaryUnit(insertParam.getEstimatedMonetaryUnit());
        changeLog.setCreateTime(now);
        dispatchChangeLogMapper.insertSelective(changeLog);

        // 更新流程表状态
        FdpFaultOrderProcess process = new FdpFaultOrderProcess();
        process.setId(insertParam.getFaultOrderId());
        process.setUpdatePerson(userId);
        process.setUpdateTime(now);
        process.setOpearteStatus("DEALING");
        processMapper.updateByPrimaryKeySelective(process);
        //点击确认派工设为已读
        setReadOther(insertParam.getRequestId());

        return ResultUtil.success();
    }


    public void insertDispatchProcessLog(Integer id, int userId, String dealPersonType, String status, String afterStatus, String dealContent, Date lastDealTime) {
        FdpDispatchProcessLog log = new FdpDispatchProcessLog();
        log.setAfterStatus(afterStatus);
        log.setBeforeStatus(status);
        log.setDealTime(lastDealTime);
        log.setDealPersonId(userId);
        log.setDispatchOrderId(id);
        log.setDealPersonType(dealPersonType);
        log.setDealContent(dealContent);
        fdpDispatchProcessLogMapper.insertSelective(log);
    }

    //客服的已读
    public void setReadOther(int requestId) {

        FdpFaultDispatchOrder order = mapper.selectByRequestId(requestId);

        SysOperationMessage message = new SysOperationMessage();
        message.setUserId(order.getLastDealPersonId());
        message.setMessageObjCode(order.getDispatchOrderNumber());
        message.setFlagRead(true);
        message.setReadTime(new Date());
        sysOperationMessageMapper.updateSetReadByUserIAndDispatchNumber(message);

    }

    public Result getOrderListByObject(GetDispatchOrderListRequest getDispatchOrderListRequest) {

        PageHelper.startPage(getDispatchOrderListRequest.getPageNum(), getDispatchOrderListRequest.getPageSize());
        Page<GetDispatchOrderListResp> persons = mapper.getOrderListByObject(getDispatchOrderListRequest);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<GetDispatchOrderListResp> pageInfo = new PageInfo<>(persons);
        if(pageInfo.getList()==null||pageInfo.getList().size()==0){
            pageInfo.setPageNum(1);
            pageInfo.setPageSize(10);
        }
        List<GetDispatchOrderListResp> dispatchOrderListResp = pageInfo.getList();
        Iterator<GetDispatchOrderListResp> it = dispatchOrderListResp.iterator();
        while (it.hasNext()) {
            GetDispatchOrderListResp list = it.next();
            Integer workSchedule = 0;
            //提交时间
            Long submitTime = list.getSubmitTime() != null ? list.getSubmitTime().getTime() : 0;
            //期望完工时间
            Long expectCompleteTime = null;
            if (list.getExpectCompleteTime() != null) {
                Date expectCTime = list.getExpectCompleteTime();
                Calendar c = Calendar.getInstance();
                c.setTime(expectCTime);
                c.add(Calendar.DAY_OF_MONTH, 1);
                //期望完工时间
                expectCompleteTime = c.getTime().getTime();
            } else {
                expectCompleteTime = Long.valueOf(0);
            }
            Long nowDate;
            if (list.getFinishTime() != null) {
                Date finishTime = list.getFinishTime();
                nowDate = finishTime.getTime();
            } else {
                //当前时间
                nowDate = System.currentTimeMillis();
            }

            //当前时间减去提交时间
            Long now_su = nowDate - submitTime;
            //期望完工时间减去提交时间
            Long ex_su = expectCompleteTime - submitTime;
            //判断当前时间大于期望完工时间
            if (nowDate >= expectCompleteTime) {
                workSchedule = 100;
            } else {
                workSchedule = Integer.parseInt(String.format("%.0f", ((now_su.doubleValue() / ex_su.doubleValue()) * 100)));
            }
            list.setWorkSchedule(workSchedule);

            //判断预警信息
            List<CfgDispatchWarningStatus> cfgDispatchWarningStatus = cfgDispatchWarningStatusMapper.getCfgDispatchWarningStatus(workSchedule);
            if (cfgDispatchWarningStatus != null && cfgDispatchWarningStatus.size() > 0) {
                list.setWarningName(cfgDispatchWarningStatus.get(0).getName());
                list.setWarningColour(cfgDispatchWarningStatus.get(0).getColour());
            } else {
                list.setWarningName("");
                list.setWarningColour("");
            }
            if (list.getLastDealPersonId() == CurrentUtil.getCurrent().getId()) {
                list.setFlagUserself(true);
            } else {
                list.setFlagUserself(false);
            }

            if (getDispatchOrderListRequest.getWarningStatus() != null && !getDispatchOrderListRequest.getWarningStatus().equals("")) {
                if (!list.getWarningName().equals(getDispatchOrderListRequest.getWarningStatus())) {
                    it.remove();
                }
            }
        }
        pageInfo.setList(dispatchOrderListResp);
        return ResultUtil.success(pageInfo);

    }

    public Result showFile(Integer id) {
        return ResultUtil.success(mapper.selectDispatchOrderByfdoId(id));
    }

    public Result dispatchNeedConfirm(FdpFaultDispatchOrder dispatchNeedConfirm) {

        Date now = new Date();
        //查询当前订单状态
        FdpFaultDispatchOrder fdpFaultDispatchOrder = mapper.selectByPrimaryKey(dispatchNeedConfirm.getId());
        insertDispatchProcessLog(dispatchNeedConfirm.getId(), CurrentUtil.getCurrent().getId(), "PURCHASE", fdpFaultDispatchOrder.getDispatchStatus(), "NEEDCONFIRM", "已推送派工信息，待确认", now);

        dispatchNeedConfirm.setLastDealTime(now);
        dispatchNeedConfirm.setLastDealPersonId(CurrentUtil.getCurrent().getId());
        dispatchNeedConfirm.setDispatchStatus("NEEDCONFIRM");
        dispatchNeedConfirm.setFlagFinish(false);
        dispatchNeedConfirm.setSendHrInfoConfirmTime(now);
        //确认派工信息  派工步骤为第3步
        dispatchNeedConfirm.setProcessStage("3");

        mapper.updateStatusByDispatchRequestId(dispatchNeedConfirm);
        //生成新的消息
//        mapper.updateStatusByRequestId(dispatchNeedConfirm);
        //采购回复消息
        purchaseReply(dispatchNeedConfirm.getId());

        return ResultUtil.success();

    }

    // 派工客服给采购推送消息
    public void selectMessageInfo(Integer id) {
        FdpFaultDispatchOrder order = mapper.selectByPrimaryKey(id);

        //判断订单表不能为空
        if (order != null) {
            SysOperationMessage insertMessage = new SysOperationMessage();
            insertMessage.setMessageOperation("HR_PURCHASE_OPERATOR");
            insertMessage.setMessageObjCode(order.getDispatchOrderNumber());
            insertMessage.setUserId(order.getLastDealPersonId());
            if (order.getFaultOrderId() == null || order.getFaultOrderId() == 0) {
                if (order.getVendorId() == 0) {
                    insertMessage.setContent("你有一个来自[系统]的派工工单[" + insertMessage.getMessageObjCode() + "]需要尽快处理。");
                } else if (order.getVendorId() == -1) {
                    String companyName = sysOperationMessageMapper.selectCompanyName(order.getCompanyId());
                    insertMessage.setContent("你有一个来自[" + companyName + "]的派工工单[" + insertMessage.getMessageObjCode() + "]需要尽快处理。");
                } else {
                    // TODO 暂定 系统
                    insertMessage.setContent("你有一个来自[系统]派工工单[" + insertMessage.getMessageObjCode() + "]需要尽快处理。");
                }
            } else {
                if (order.getVendorId() == 0) {
                    insertMessage.setContent("你有一个来自系统的故障工单[" + insertMessage.getMessageObjCode() + "]需要尽快处理。");
                } else if (order.getVendorId() == -1) {
                    String companyName = sysOperationMessageMapper.selectCompanyName(order.getCompanyId());
                    insertMessage.setContent("你有一个来自[" + companyName + "]的故障工单[" + insertMessage.getMessageObjCode() + "]需要尽快处理。");
                } else {
                    insertMessage.setContent("你有一个来自[系统]故障工单[" + insertMessage.getMessageObjCode() + "]需要尽快处理。");
                }
            }

            createMessage(insertMessage);
        }


    }

    public void purchaseReply(Integer id) {
        FdpFaultDispatchOrder order = mapper.selectByPrimaryKey(id);
        SysOperationMessage insertMessage = new SysOperationMessage();
        //查询派工单是由谁创建的(传入dispatchRequest表的id)
        insertMessage.setUserId(requestMapper.selectCreatePerson(order.getFaultDispatchRequestId()));
        insertMessage.setMessageObjCode(order.getDispatchOrderNumber());
        if (order.getFaultOrderId() == null || order.getFaultOrderId() == 0) {
            insertMessage.setMessageOperation("DISPATCH_OPERATOR");
            insertMessage.setContent("由你发起的派工工单[" + insertMessage.getMessageObjCode() + "]有新进展,请尽快处理。");
            insertMessage.setMessageObjCode(order.getDispatchOrderNumber());
        } else {
            String GzNumber = requestMapper.selectGzNumer(order.getFaultDispatchRequestId());
            insertMessage.setMessageOperation("CUSTOMER_SERVICE_OPERATOR");
            insertMessage.setContent("由你发起的故障工单[" + GzNumber + "]有新进展,请尽快处理。");
            insertMessage.setMessageObjCode(GzNumber);
        }

        createMessage(insertMessage);
    }

    public void createMessage(SysOperationMessage message) {
        Date now = new Date();
        message.setMessageObjId(0);
        message.setCreateTime(now);
        message.setFlagRead(false);
        sysOperationMessageMapper.insertSelective(message);
    }

    public Result confirmDispatchComplete(ParamCompleteConfirm paramCompleteConfirm) {
        Integer userId = CurrentUtil.getCurrent().getId();
        // 当前时间
        Date now = new Date();
        // 修改派工请求
        int orderId = mapper.selectFaultOrderId(paramCompleteConfirm.getId());
        String status = mapper.selectStatusById(orderId);
        //处理人 类型 为采购
        String type = "PURCHASE";
        insertDispatchProcessLog(orderId, userId, type, status, "USED", "提交完工资料", now);

        //提交完工资料
        FdpFaultDispatchHrRelation hrRelation = new FdpFaultDispatchHrRelation();
        hrRelation.setFaultDispatchRequestId(paramCompleteConfirm.getId());
        hrRelation.setUserAssmAchievePoint(paramCompleteConfirm.getUserAssmAchievePoint());
        hrRelation.setUserAssmCommunicationPoint(paramCompleteConfirm.getUserAssmCommunicationPoint());
        hrRelation.setUserAssmTimelyPoint(paramCompleteConfirm.getUserAssmTimelyPoint());
        hrRelation.setUserAssmMemo(paramCompleteConfirm.getMemo());
        hrRelation.setUserCompleteProfileFile(paramCompleteConfirm.getUserCompleteProfileFile());
        hrRelation.setUserCompleteProfileFileName(paramCompleteConfirm.getUserCompleteProfileFileName());
        hrRelation.setUserCompleteProfilePhoto(paramCompleteConfirm.getUserCompleteProfilePhoto());
        hrRelation.setUserCompleteProfilePhotoName(paramCompleteConfirm.getUserCompleteProfilePhotoName());
        hrRelation.setUserCompleteTime(paramCompleteConfirm.getUserCompletetime());
        hrRelation.setUserJobPerformance(paramCompleteConfirm.getDispatchDescription());
        hrRelation.setCompleteProfileUserId(userId);
        hrRelation.setCompleteProfileUserType(type);
        if (hrMapper.updateByRequestId(hrRelation) == 0) {
            return ResultUtil.errorBusinessMsg("提交完工资料失败！");
        }
        //查询orderid
        FdpFaultDispatchHrRelation result = hrMapper.selectByRequestId(paramCompleteConfirm.getId());
        //新增客户完工资料日志
        FdpDispatchCompleteProfileLog completeProfileLog = new FdpDispatchCompleteProfileLog();
        completeProfileLog.setFaultDispatchRequestId(hrRelation.getFaultDispatchRequestId());
        completeProfileLog.setDispatchOrderId(result.getDispatchOrderId());
        completeProfileLog.setUserCompleteProfileFile(hrRelation.getUserCompleteProfileFile());
        completeProfileLog.setUserCompleteProfileFileName(hrRelation.getUserCompleteProfileFileName());
        completeProfileLog.setUserCompleteProfilePhoto(hrRelation.getUserCompleteProfilePhoto());
        completeProfileLog.setUserCompleteProfilePhotoName(hrRelation.getUserCompleteProfilePhotoName());
        completeProfileLog.setUserJobPerformance(hrRelation.getUserJobPerformance());
        completeProfileLog.setCreateTime(now);
        completeProfileLog.setMemo(paramCompleteConfirm.getMemo());
        completeProfileLog.setCompleteProfileUserId(userId);
        completeProfileLog.setCompleteProfileUserType(type);
        completeProfileLogMapper.insertSelective(completeProfileLog);
        //查询是否是采购
        FdpFaultDispatchOrder order = mapper.selectByRequestId(hrRelation.getFaultDispatchRequestId());
        order.setActualCost(paramCompleteConfirm.getActualCost());
        order.setActualMonetaryUnit(paramCompleteConfirm.getActualMonetaryUnit());
        order.setActualCostMemo(paramCompleteConfirm.getActualCostMemo());
        order.setLastDealTime(now);
        order.setPrivateNote(paramCompleteConfirm.getPrivateNote());
        //修改实际费用 实际成本
        mapper.updateStatusByDispatchRequestId(order);

        purchaseReply(order.getId());
        setReadPurchase(hrRelation.getFaultDispatchRequestId(), userId);

        return ResultUtil.success();
    }

    //点击已读
    public void setReadPurchase(int requestId, int userId) {

        FdpFaultDispatchOrder order = mapper.selectByRequestId(requestId);
        SysOperationMessage message = new SysOperationMessage();
        message.setUserId(userId);
        if (order != null) {
            message.setMessageObjCode(order.getDispatchOrderNumber());
        }
        message.setFlagRead(true);
        message.setReadTime(new Date());
        sysOperationMessageMapper.updateSetReadByUserIAndDispatchNumber(message);

    }

    public Result confirmActualPrice(ParamCompleteConfirm paramCompleteConfirm) {

        BigDecimal num = new BigDecimal("99999999");
        if (paramCompleteConfirm.getActualCost().compareTo(num) == 1) {
            return ResultUtil.errorBusinessMsg("预计成本长度过长（小于等于八位）");
        }
        if (paramCompleteConfirm.getActualPrice().compareTo(num) == 1) {
            return ResultUtil.errorBusinessMsg("预计售价长度过长（小于等于八位）");
        }
        FdpFaultDispatchOrder order = new FdpFaultDispatchOrder();
        //zhanghao 确认售价记录 预计成本 预计成本单位 预计成本备注
        order.setActualCost(paramCompleteConfirm.getActualCost());
        order.setActualCostMemo(paramCompleteConfirm.getActualCostMemo());
        order.setActualMonetaryUnit(paramCompleteConfirm.getActualMonetaryUnit());

        order.setFaultDispatchRequestId(paramCompleteConfirm.getRequestId());
        order.setActualPrice(paramCompleteConfirm.getActualPrice());
        order.setActualPriceUnit(paramCompleteConfirm.getActualPriceUnit());
        order.setActualPriceMemo(paramCompleteConfirm.getActualPriceMemo());
        order.setFlagNoPrice(paramCompleteConfirm.getFlagNoPrice());
        order.setPrivateNote(paramCompleteConfirm.getPrivateNote());
        //修改实际费用
        if (mapper.updateStatusByDispatchRequestId(order) > 0) {
            return ResultUtil.success();
        }
        return ResultUtil.errorBusinessMsg("失败");
    }

    public Result purchaseFinishConfirm(String json) {
        Integer userId = CurrentUtil.getCurrent().getId();

        FdpFaultDispatchOrder dispatchComplete = JSON.parseObject(json, FdpFaultDispatchOrder.class);
        ParamFdpFaultDispatchOrderConfirm dispatchCompleteHr = JSON.parseObject(json, ParamFdpFaultDispatchOrderConfirm.class);

        // 当前时间
        Date now = new Date();
        FdpFaultDispatchHrRelation hrRelation = new FdpFaultDispatchHrRelation();
        hrRelation.setFaultDispatchRequestId(dispatchComplete.getId());
        hrRelation.setUserAssmAchievePoint(dispatchCompleteHr.getUserAssmAchievePoint());
        hrRelation.setUserAssmCommunicationPoint(dispatchCompleteHr.getUserAssmCommunicationPoint());
        hrRelation.setUserAssmTimelyPoint(dispatchCompleteHr.getUserAssmTimelyPoint());
        hrMapper.updateByRequestId(hrRelation);

        if (dispatchCompleteHr.getUserAssmAchievePoint() == null && dispatchCompleteHr.getUserAssmCommunicationPoint() == null && dispatchCompleteHr.getUserAssmTimelyPoint() == null) {
            return ResultUtil.errorBusinessMsg("请评价！");
        }
        if (dispatchCompleteHr.getUserAssmAchievePoint() == null) dispatchCompleteHr.setUserAssmAchievePoint(0);
        if (dispatchCompleteHr.getUserAssmCommunicationPoint() == null)
            dispatchCompleteHr.setUserAssmCommunicationPoint(0);
        if (dispatchCompleteHr.getUserAssmTimelyPoint() == null) dispatchCompleteHr.setUserAssmTimelyPoint(0);
        //查询派工人员
        FdpFaultDispatchHrRelation result = hrMapper.selectByRequestId(dispatchComplete.getId());
        //查询派工人员评价
        BifDispatchHumanResource record = humanResourceMapper.selectByPrimaryKey(result.getDispatchMainHrId());
        //计算完工效果评估平均分数
        BigDecimal achieveAvg = new BigDecimal(dispatchCompleteHr.getUserAssmAchievePoint() + record.getUserAssmAchieveTotalPoint()).divide(new BigDecimal((record.getUserAssessmentCount() + 1)), 2, BigDecimal.ROUND_HALF_UP);
        //计算沟通效果评估平均分数
        BigDecimal communicationAvg = new BigDecimal(dispatchCompleteHr.getUserAssmCommunicationPoint() + record.getUserAssmCommunicationTotalPoint()).divide(new BigDecimal(record.getUserAssessmentCount() + 1), 2, BigDecimal.ROUND_HALF_UP);
        //计算及时率平均分数
        BigDecimal timelyAvg = new BigDecimal(dispatchCompleteHr.getUserAssmTimelyPoint() + record.getUserAssmTimelyTotalPoint()).divide(new BigDecimal(record.getUserAssessmentCount() + 1), 2, BigDecimal.ROUND_HALF_UP);
        //计算用户评估总分
        BigDecimal userAchievePoint;
        userAchievePoint = achieveAvg.add(communicationAvg);
        userAchievePoint = userAchievePoint.add(timelyAvg);
        BifDispatchHumanResource resource = new BifDispatchHumanResource();
        resource.setId(record.getId());
        resource.setUserAssessmentCount(record.getUserAssessmentCount() + 1);
        resource.setUserAssmAchieveTotalPoint(dispatchCompleteHr.getUserAssmAchievePoint() + record.getUserAssmTimelyTotalPoint());
        resource.setUserAssmAchieveAvgPoint(achieveAvg);
        resource.setUserAssmCommunicationTotalPoint(dispatchCompleteHr.getUserAssmCommunicationPoint() + record.getUserAssmCommunicationTotalPoint());
        resource.setUserAssmCommunicationAvgPoint(communicationAvg);
        resource.setUserAssmTimelyTotalPoint(dispatchCompleteHr.getUserAssmTimelyPoint() + record.getUserAssmCommunicationTotalPoint());
        resource.setUserAssmTimelyAvgPoint(timelyAvg);
        resource.setUserEvaluatePoint(userAchievePoint.add(record.getContactAssmTotalPoint()));
        humanResourceMapper.updateByPrimaryKeySelective(resource);

        //采购完工确认时  派工步骤为第5步
        dispatchComplete.setProcessStage("5");
        dispatchComplete.setLastDealTime(now);
        dispatchComplete.setFlagDispatcherConfirm(true);
        dispatchComplete.setFaultDispatchRequestId(dispatchComplete.getId());
        dispatchComplete.setPrivateNote(dispatchComplete.getPrivateNote());
        FdpFaultDispatchOrder customerResult = mapper.selectCustomerConfirm(dispatchComplete.getId());
        FdpFaultDispatchOrder order = mapper.selectByRequestId(dispatchComplete.getId());

        Integer orderId = 0;

        //是否有processId
        if (order.getFaultOrderId() != null) {
            //更新user_assm
            FdpFaultOrderProcess process = new FdpFaultOrderProcess();
            process.setId(order.getFaultOrderId());
            process.setFlagUserAssm(true);
            processMapper.updateByPrimaryKeySelective(process);
        }

        if (customerResult.getFlagCustomerConfirm() == false) {
            //客户未完工
            dispatchComplete.setFlagFinish(false);
            dispatchComplete.setDispatcherFinalConfirmTime(now);
            dispatchComplete.setDispatchStatus("FILENEEDCONFIRM");
            mapper.updateStatusByRequestId(dispatchComplete);

            orderId = mapper.selectFaultOrderId(dispatchComplete.getFaultDispatchRequestId());
            //查询当前订单状态
            String status = mapper.selectStatusById(orderId);
            insertDispatchProcessLog(orderId, userId, "PURCHASE", status, "USED", " 已确认派工资料符合要求，派工工作已完成", now);


        } else {//客户已完工  修改完工状态
            dispatchComplete.setFlagCustomerConfirm(true);
            dispatchComplete.setFlagFinish(true);
            dispatchComplete.setFinishType("COMPLETE");
            dispatchComplete.setDispatchStatus("COMPLETE");
            dispatchComplete.setLastDealTime(now);
            dispatchComplete.setDispatcherFinalConfirmTime(now);
            mapper.updateStatusByRequestId(dispatchComplete);

            //修改派工人员派工状态
            FdpFaultDispatchHrRelation relation = new FdpFaultDispatchHrRelation();
            relation.setFaultDispatchRequestId(dispatchComplete.getId());
            relation.setHrDispatchStatus("COMPLETE");
            hrMapper.updateByRequestId(relation);

            //增加派工成功次数
            resource.setId(record.getId());
            resource.setDispatchSuccessfulCount(record.getDispatchSuccessfulCount() + 1);
            humanResourceMapper.updateByPrimaryKeySelective(resource);

            orderId = mapper.selectFaultOrderId(dispatchComplete.getFaultDispatchRequestId());
            //查询当前订单状态
            String status = mapper.selectStatusById(orderId);
            insertDispatchProcessLog(orderId, userId, "PURCHASE", status, "COMPLETE", " 已确认派工资料符合要求，派工工作已完成", now);

        }

        //生成新的消息
        purchaseReply(orderId);
        setReadPurchase(dispatchComplete.getFaultDispatchRequestId(), userId);

        return ResultUtil.success();
    }

    public Result abandonDispatch(FdpFaultDispatchOrder dispatchAbandon) {
        Integer userId = CurrentUtil.getCurrent().getId();

        Date now = new Date();
        //查询当前订单状态
        String status = mapper.selectStatusById(dispatchAbandon.getId());
        insertDispatchProcessLog(dispatchAbandon.getId(), userId, "PURCHASE", status, "FAULTCONFIRMED", "已放弃派工", now);

        dispatchAbandon.setLastDealTime(now);
        dispatchAbandon.setLastDealPersonId(userId);
        dispatchAbandon.setDispatchStatus("ABANDON");
        dispatchAbandon.setFlagFinish(false);
        dispatchAbandon.setFinishTime(now);
        //放弃 派工步骤为8
        dispatchAbandon.setProcessStage("8");
        //更改为requestid修改
//        mapper.updateStatusByRequestId(dispatchAbandon);
        mapper.updateStatusByDispatchRequestId(dispatchAbandon);
        if (dispatchAbandon.getFaultOrderId() != 0 && dispatchAbandon.getFaultOrderId() != null) {
            //修改流程表
            FdpFaultOrderProcess process = new FdpFaultOrderProcess();
            process.setId(dispatchAbandon.getFaultOrderId());
            process.setOpearteStatus("FAULTCONFIRMED");
            processMapper.updateProcessStatusByProcessId(process);
            //根据process查询rootid
            int processRootId = processMapper.selectRootId(process.getId());
            //修改流程表日志
            FdpFaultOrderProcessLog processLog = new FdpFaultOrderProcessLog();
            processLog.setProcessTime(now);
            processLog.setTitle("FAULTCONFIRMED");
            processLog.setMemo("故障已确认");
            processLog.setFlagConsole(true);
            processLog.setFaultOrderProcessId(process.getId());
            processLog.setRootId(processRootId);
            processLog.setProcessPersonId(userId);
            fdpFaultOrderProcessLogMapper.insertSelective(processLog);
        }
        //生成新的消息
        selectMessageInfo(dispatchAbandon.getId());
        ParamSysOperationMessage message = new ParamSysOperationMessage();

        //查询派工单是由谁创建的
        message.setUserId(requestMapper.selectCreatePerson(dispatchAbandon.getFaultDispatchRequestId()));
        message.setMessageObjCode(mapper.selectNumber(dispatchAbandon.getFaultDispatchRequestId()));
        if (dispatchAbandon.getFaultOrderId() == 0 || dispatchAbandon.getFaultOrderId() == null) {
            message.setMessageOperation("DISPATCH_OPERATOR");
        } else {
            message.setMessageOperation("CUSTOMER_SERVICE_OPERATOR");
        }
        message.setVendorId(dispatchAbandon.getVendorId());
        message.setCompanyId(dispatchAbandon.getCompanyId());
        //id为dispatchRequestId
        setReadPurchase(dispatchAbandon.getFaultDispatchRequestId(), userId);
        return ResultUtil.success();
    }

    public Result dispatchTransmit(HashMap<String, Object> map) {
        Integer userId = CurrentUtil.getCurrent().getId();

        if (map.get("id") != null) {
            map.put("idList", map.get("id"));
        }
        Date now = new Date();
        //查询派工单原始人ID
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list = mapper.selectOldPersonId(map);
        mapper.dispatchTransmit(map);

        for (Map mapOldId : list) {
            Map mapStransfer = new HashMap<String, Object>();
            mapStransfer.put("transferTime", now);
            mapStransfer.put("transferPersonId", userId);
            if (mapOldId.get("lastDealPersonId").equals("0")) {
                return ResultUtil.errorBusinessMsg("请求参数有误");
            }
            if (map.get("newDealPersonId").equals("0")) {
                return ResultUtil.errorBusinessMsg("请求参数有误");
            }
            mapStransfer.put("orgDealPersonId", mapOldId.get("lastDealPersonId"));
            mapStransfer.put("newDealPersonId", map.get("newDealPersonId"));
            mapStransfer.put("dispatchOrderId", mapOldId.get("id"));
            System.out.println(mapStransfer);
            transferLogMapper.insertDispatchTransferLog(mapStransfer);

            //生成新的消息
            int orderId = Integer.parseInt(String.valueOf(mapStransfer.get("dispatchOrderId")));
            int newDealPersonId = Integer.parseInt(String.valueOf(mapStransfer.get("newDealPersonId")));
            purchaseTransfer(orderId,newDealPersonId,userId);
        }
        return ResultUtil.success();
    }

    /**
     * 采购转发提示信息
     *
     * @param dispatchOrderId
     * @Author：Niting
     * @Date:2018/09/06
     */
    public void purchaseTransfer(int dispatchOrderId, int newDealPersonId, Integer userId) {
        FdpFaultDispatchOrder order = mapper.selectByPrimaryKey(dispatchOrderId);
        SysOperationMessage insertMessage = new SysOperationMessage();
        //查询派工单是由谁创建的(传入dispatchRequest表的id)
        insertMessage.setUserId(newDealPersonId);
        insertMessage.setMessageObjCode(order.getDispatchOrderNumber());
        //查询转发人
        insertMessage.setMessageOperation("HR_PURCHASE_TRANSPOND");
        insertMessage.setContent("你有一条来自[" + CurrentUtil.getCurrent().getUsername() + "]转发的派工工单[" + order.getDispatchOrderNumber() + "]需要尽快处理。");
        insertMessage.setMessageObjCode(order.getDispatchOrderNumber());
        createMessage(insertMessage);
    }

    public Result disparkProfile(HashMap<String, List<Integer>> reqJsonMap) {

        FdpFaultDispatchHrRelation relation;
        List<Integer> orderId = reqJsonMap.get("id");
        if(orderId.size() > 0){
            for(Integer item :orderId){
                relation = new FdpFaultDispatchHrRelation();
                relation.setFlagEnableModifyProfile(true);
                relation.setDispatchOrderId(item);
                hrMapper.updateFlagEnableModifyProfile(relation);
            }
            return ResultUtil.success();
        }
        return ResultUtil.errorBusinessMsg("开放完工资料失败！");
    }
}
