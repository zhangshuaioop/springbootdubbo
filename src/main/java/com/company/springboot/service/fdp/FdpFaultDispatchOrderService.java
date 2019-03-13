package com.company.springboot.service.fdp;

import com.alibaba.fastjson.JSON;
import com.company.springboot.entity.bif.BifDispatchHumanResource;
import com.company.springboot.entity.cfg.CfgDispatchWarningStatus;
import com.company.springboot.entity.fdp.*;
import com.company.springboot.entity.sys.ParamSysOperationMessage;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.entity.sys.SysOperationMessage;
import com.company.springboot.entity.wp.WpProcessOperateLog;
import com.company.springboot.mapper.bif.BifDispatchHumanResourceMapper;
import com.company.springboot.mapper.cfg.CfgDispatchWarningStatusMapper;
import com.company.springboot.mapper.fdp.*;
import com.company.springboot.mapper.sys.SysCompanyUsersMapper;
import com.company.springboot.mapper.sys.SysOperationMessageMapper;
import com.company.springboot.service.wp.WpCfgFrameProcessService;
import com.company.springboot.utils.CurrentUtil;
import com.company.springboot.utils.PageInfo;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author zhanghao
 * @Title: FdpFaultDispatchOrderService
 * @ProjectName WaterDrop
 * @Description: 派工订单
 * @date 2018/12/21下午3:09
 */
@Service
public class FdpFaultDispatchOrderService {

    @Resource
    private FdpFaultDispatchOrderMapper fdpFaultDispatchOrderMapper;

    @Resource
    private FdpDispatchProcessLogMapper fdpDispatchProcessLogMapper;

    @Resource
    private FdpFaultOrderProcessMapper fdpFaultOrderProcessMapper;

    @Resource
    private FdpFaultDispatchHrRelationMapper fdpFaultDispatchHrRelationMapper;

    @Resource
    private BifDispatchHumanResourceMapper bifDispatchHumanResourceMapper;

    @Resource
    private FdpFaultOrderProcessLogMapper fdpFaultOrderProcessLogMapper;

    @Resource
    private SysOperationMessageMapper sysOperationMessageMapper;

    @Resource
    private SysCompanyUsersMapper sysCompanyUsersMapper;

    @Resource
    private FdpFaultOrderDispatchRequestMapper fdpFaultOrderDispatchRequestMapper;

    @Resource
    private FdpDispatchJobContentMapper fdpDispatchJobContentMapper;

    @Resource
    private FdpDispatchJobPerformanceMapper fdpDispatchJobPerformanceMapper;

    @Resource
    private FdpFaultDispatchChangeLogMapper fdpFaultDispatchChangeLogMapper;

    @Resource
    private CfgDispatchWarningStatusMapper cfgDispatchWarningStatusMapper;

    @Resource
    private FdpDispatchCompleteProfileLogMapper completeProfileLogMapper;

    @Resource
    private FdpFaultDispatchTransferLogMapper transferLogMapper;
    @Resource
    private WpCfgFrameProcessService wpCfgFrameProcessService;


    public Result confirmDispatchCancel(FdpFaultDispatchOrder dispatchCancel) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }

        //查询当前订单状态
        FdpFaultDispatchOrder fdpFaultDispatchOrder = fdpFaultDispatchOrderMapper.selectByRequestId(dispatchCancel.getId());
        if (fdpFaultDispatchOrder == null) {
            return ResultUtil.errorBusinessMsg("取消派工失败");
        }
        String status = fdpFaultDispatchOrder.getDispatchStatus();

        Date now = new Date();
        dispatchCancel.setLastDealTime(now);
        dispatchCancel.setDispatchStatus("CANCEL");
        dispatchCancel.setCancelReason(dispatchCancel.getCancelReason());
        dispatchCancel.setFinishTime(now);
        //取消派工 派工步骤为7
        dispatchCancel.setProcessStage("7");

        //生成操作记录
        String afterStatus = "CANCEL";
        String dealContent = "已取消派工";
        String dealPersonType = "DISPATCH";
        insertDispatchProcessLog(fdpFaultDispatchOrder.getId(), users.getId(), dealPersonType, status, afterStatus, dealContent, dispatchCancel.getLastDealTime());

        fdpFaultDispatchOrderMapper.updateStatusByRequestId(dispatchCancel);

        //保存自定义流程日志记录
        WpProcessOperateLog wpProcessOperateLog = new WpProcessOperateLog();
        wpProcessOperateLog.setOrderId(fdpFaultDispatchOrder.getId());
        wpProcessOperateLog.setDescription("取消派工");
        CurrentUtil.recordLog(wpProcessOperateLog);

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

    public Result customerFinishConfirm(Integer id) {

        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }
        // 当前时间
        Date now = new Date();
        Integer orderId = 0;
        // 修改派工工单
        FdpFaultDispatchOrder dispatchOrder = new FdpFaultDispatchOrder();
        dispatchOrder.setFaultDispatchRequestId(id);
        dispatchOrder.setFlagCustomerConfirm(true);
        //客户确认完工 派工步骤为6
        dispatchOrder.setProcessStage("6");
        dispatchOrder.setFinishTime(now);
        //查询采购是否确认完工
        FdpFaultDispatchOrder dispatchRsult = fdpFaultDispatchOrderMapper.selectDispatchConfirm(dispatchOrder.getFaultDispatchRequestId());
        if (dispatchRsult != null && dispatchRsult.getFlagDispatcherConfirm() == false) {//确认采购是否确认完工
            dispatchOrder.setFlagFinish(false);
            dispatchOrder.setCustomerFinalConfirmTime(now);
            fdpFaultDispatchOrderMapper.updateStatusByDispatchRequestId(dispatchOrder);

            orderId = fdpFaultDispatchOrderMapper.selectFaultOrderId(id);
            //查询当前订单状态
            String status = fdpFaultDispatchOrderMapper.selectStatusById(orderId);
            insertDispatchProcessLog(orderId, users.getId(), "DISPATCH", status, "USED", " 已确认派工资料符合要求，派工工作已完成", now);

        } else {
            orderId = fdpFaultDispatchOrderMapper.selectFaultOrderId(id);
            //查询当前订单状态
            String status = fdpFaultDispatchOrderMapper.selectStatusById(orderId);
            insertDispatchProcessLog(orderId, users.getId(), "DISPATCH", status, "COMPLETE", " 已确认派工资料符合要求，派工工作已完成", now);

            dispatchOrder.setFlagDispatcherConfirm(true);
            dispatchOrder.setFlagFinish(true);
            dispatchOrder.setFinishType("COMPLETE");
            dispatchOrder.setDispatchStatus("COMPLETE");
            dispatchOrder.setLastDealTime(now);
            dispatchOrder.setCustomerFinalConfirmTime(now);
            fdpFaultDispatchOrderMapper.updateStatusByDispatchRequestId(dispatchOrder);

            //修改派工人员派工状态
            FdpFaultDispatchHrRelation relation = new FdpFaultDispatchHrRelation();
            relation.setFaultDispatchRequestId(id);
            relation.setHrDispatchStatus("COMPLETE");
            fdpFaultDispatchHrRelationMapper.updateByRequestId(relation);

            //查询派工人员
            FdpFaultDispatchHrRelation result = fdpFaultDispatchHrRelationMapper.selectByRequestId(dispatchOrder.getFaultDispatchRequestId());
            //查询派工人员评价
            BifDispatchHumanResource record = bifDispatchHumanResourceMapper.selectByPrimaryKey(result.getDispatchMainHrId());
            //更新派工资源表中的派工成功数量
            BifDispatchHumanResource dispatchHumanResource = new BifDispatchHumanResource();
            if (record != null) {
                dispatchHumanResource.setId(result.getDispatchMainHrId());
                dispatchHumanResource.setDispatchSuccessfulCount(record.getDispatchSuccessfulCount() + 1);
                bifDispatchHumanResourceMapper.updateByPrimaryKeySelective(dispatchHumanResource);
            }
        }

        selectMessageInfo(orderId);

        //保存操作记录
        //确认派工人员
        orderId = fdpFaultDispatchOrderMapper.selectFaultOrderId(id);
        WpProcessOperateLog wpProcessOperateLog = new WpProcessOperateLog();
        wpProcessOperateLog.setOrderId(orderId);
        wpProcessOperateLog.setDescription("确认派工人员");
        //调用保存操作方法
        CurrentUtil.recordLog(wpProcessOperateLog);
        //找/存下一个处理人
        CurrentUtil.nextDeal(orderId);

        return ResultUtil.success("客户确认完工，成功！");

    }

    // 派工客服给采购推送消息
    public void selectMessageInfo(Integer id) {
        FdpFaultDispatchOrder order = fdpFaultDispatchOrderMapper.selectByPrimaryKey(id);

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
                    String vendorName = sysCompanyUsersMapper.selectVendorName(order.getVendorId());
                    insertMessage.setContent("你有一个来自[" + vendorName + "]派工工单[" + insertMessage.getMessageObjCode() + "]需要尽快处理。");
                }
            } else {
                if (order.getVendorId() == 0) {
                    insertMessage.setContent("你有一个来自系统的故障工单[" + insertMessage.getMessageObjCode() + "]需要尽快处理。");
                } else if (order.getVendorId() == -1) {
                    String companyName = sysOperationMessageMapper.selectCompanyName(order.getCompanyId());
                    insertMessage.setContent("你有一个来自[" + companyName + "]的故障工单[" + insertMessage.getMessageObjCode() + "]需要尽快处理。");
                } else {
                    String vendorName = sysCompanyUsersMapper.selectVendorName(order.getVendorId());
                    insertMessage.setContent("你有一个来自[" + vendorName + "]故障工单[" + insertMessage.getMessageObjCode() + "]需要尽快处理。");
                }
            }

            createMessage(insertMessage);
        }


    }

    public void createMessage(SysOperationMessage message) {
        Date now = new Date();
        message.setMessageObjId(0);
        message.setCreateTime(now);
        message.setFlagRead(false);
        sysOperationMessageMapper.insertSelective(message);
    }

    public Result rebutComplete(FdpFaultDispatchOrder order) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }
        Date now = new Date();
        //客户驳回完工资料时  派工步骤返回第4步
        order.setProcessStage("4");
        order.setDispatchStatus("REJECTFILE");
        order.setFlagCustomerConfirm(false);
        Integer orderId = fdpFaultDispatchOrderMapper.findOrderId(order.getFaultDispatchRequestId());

        if (fdpFaultDispatchOrderMapper.updateDispatchOrderByRequestId(order) > 0) {
            insertDispatchProcessLog(order.getId(), users.getId(), "DISPATCH_HR", order.getDispatchStatus(), "REJECTFILE", "客户驳回完工资料", now);

            WpProcessOperateLog wpProcessOperateLog = new WpProcessOperateLog();
            wpProcessOperateLog.setOrderId(orderId);
            wpProcessOperateLog.setDescription("客户驳回完工资料-成功");
            CurrentUtil.recordLog(wpProcessOperateLog);  //日志

            CurrentUtil.topDeal(orderId);   //上一个处理人

            return ResultUtil.success("驳回成功！");
        }

        WpProcessOperateLog wpProcessOperateLog = new WpProcessOperateLog();
        wpProcessOperateLog.setOrderId(orderId);
        wpProcessOperateLog.setDescription("客户驳回完工资料-驳回失败");
        CurrentUtil.recordLog(wpProcessOperateLog);  //日志
        return ResultUtil.errorBusinessMsg("驳回失败！");
    }

    public Result cancelDispatchPerson(FdpFaultDispatchOrder fdpFaultDispatchOrder) {

        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }

        Date now = new Date();
        //生成新的消息
        int order = fdpFaultDispatchOrderMapper.selectDispatchOrder(fdpFaultDispatchOrder.getFaultDispatchRequestId());

        //查询当前订单状态
        String status = fdpFaultDispatchOrderMapper.selectStatusById(order);
        insertDispatchProcessLog(order, users.getId(), "DISPATCH", status, "DISPATCHAGAIN", "派工信息不合要求，需要重新派工", now);

        fdpFaultOrderDispatchRequestMapper.selectHrIdByRequestId(fdpFaultDispatchOrder.getFaultDispatchRequestId());
        FdpFaultDispatchOrder ordercancel = new FdpFaultDispatchOrder();
        ordercancel.setLastDealTime(now);
        ordercancel.setDispatchStatus("DISPATCHAGAIN");
        ordercancel.setId(fdpFaultDispatchOrder.getFaultDispatchRequestId());
        //不使用已派工人员   步骤返回第2步
        ordercancel.setProcessStage("2");
        fdpFaultDispatchOrderMapper.updateStatusByRequestId(ordercancel);

        //增加驳回派工人员原因
        FdpFaultDispatchHrRelation rejectCause = new FdpFaultDispatchHrRelation();
        rejectCause.setFaultDispatchRequestId(fdpFaultDispatchOrder.getFaultDispatchRequestId());
        rejectCause.setPersonRejectCauseContext(fdpFaultDispatchOrder.getPersonRejectCauseContext());
        fdpFaultDispatchHrRelationMapper.updateByRequestId(rejectCause);

        //给采购发送消息
        selectMessageInfo(order);

        Integer orderId = fdpFaultDispatchOrderMapper.findOrderId(fdpFaultDispatchOrder.getFaultDispatchRequestId());

        WpProcessOperateLog wpProcessOperateLog = new WpProcessOperateLog();
        wpProcessOperateLog.setOrderId(orderId);
        wpProcessOperateLog.setDescription("驳回派工人员-成功");
        CurrentUtil.recordLog(wpProcessOperateLog); //日志

        CurrentUtil.topDeal(orderId); //上一个处理人

        return ResultUtil.success();
    }

    public Result confirmDispatchPerson(Integer faultDispatchRequestId) {

        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }
        // 当前时间
        Date now = new Date();
        //查询orderId
        int dispatchOrderId = fdpFaultDispatchOrderMapper.selectFaultOrderId(faultDispatchRequestId);

        //查询当前订单状态
        String status = fdpFaultDispatchOrderMapper.selectStatusById(dispatchOrderId);
        insertDispatchProcessLog(dispatchOrderId, users.getId(), "DISPATCH", status, "USED", " 派工信息用户已确认", now);
        FdpFaultDispatchOrder order = new FdpFaultDispatchOrder();
        order.setLastDealTime(now);
        order.setDispatchStatus("USED");
        order.setId(faultDispatchRequestId);
        order.setCustomerHrInfoConfirmTime(now);
        //确认已使用派工人员  步骤为第4步
        order.setProcessStage("4");
        fdpFaultDispatchOrderMapper.updateStatusByRequestId(order);

        //这一句方便后面使用
        order.setFaultDispatchRequestId(faultDispatchRequestId);

        //修改派工订单人员表
        FdpFaultDispatchHrRelation relation = new FdpFaultDispatchHrRelation();
        relation.setFaultDispatchRequestId(order.getFaultDispatchRequestId());
        relation.setHrDispatchStatus("NEEDHRCONFIRM");
        fdpFaultDispatchHrRelationMapper.updateByRequestId(relation);

        //查询hrid
        FdpFaultDispatchHrRelation hrRelation = fdpFaultDispatchHrRelationMapper.selectByRequestId(order.getFaultDispatchRequestId());
        if (hrRelation != null) {
            //查询派工人员信息
            BifDispatchHumanResource resource = bifDispatchHumanResourceMapper.selectByPrimaryKey(hrRelation.getDispatchMainHrId());
            resource.setId(hrRelation.getDispatchMainHrId());
            //确认人员负面评价除0.98
            BigDecimal total = resource.getContactAssmTotalPoint().divide(new BigDecimal(0.98), 2, BigDecimal.ROUND_HALF_UP);
            //大于默认值5
            if (total.compareTo(new BigDecimal(5)) == 1) {
                resource.setContactAssmTotalPoint(new BigDecimal(5));
            } else {
                resource.setContactAssmTotalPoint(total);
            }
            //第一次派工计算总分
            if (resource.getDispatchSuccessfulCount() == 0) {
                resource.setUserEvaluatePoint(resource.getContactAssmTotalPoint().add(new BigDecimal(13)));
            } else {
                BigDecimal userPoint = resource.getUserAssmTimelyAvgPoint().add(resource.getUserAssmAchieveAvgPoint().add(resource.getUserAssmCommunicationAvgPoint()));
                resource.setUserEvaluatePoint(resource.getContactAssmTotalPoint().add(userPoint));
            }
            bifDispatchHumanResourceMapper.updateByPrimaryKeySelective(resource);
        }
        //生成新的消息
        int orderId = fdpFaultDispatchOrderMapper.selectDispatchOrder(order.getFaultDispatchRequestId());
        //给采购发送消息
        selectMessageInfo(orderId);
        //更新派工人员资源中的派工次数
        FdpFaultDispatchHrRelation hr = fdpFaultDispatchHrRelationMapper.selectIdByOrderId(dispatchOrderId);
        BifDispatchHumanResource dispatchHumanResource = bifDispatchHumanResourceMapper.selectByPrimaryKey(hr.getDispatchMainHrId());
        if (dispatchHumanResource != null) {
            dispatchHumanResource.setDispatchCount(dispatchHumanResource.getDispatchCount() + 1);
            bifDispatchHumanResourceMapper.updateByPrimaryKeySelective(dispatchHumanResource);
        }

        List<FdpDispatchJobContent> list = fdpDispatchJobContentMapper.seleteByDispatchRequestId(order.getFaultDispatchRequestId());
        if (list != null && list.size() > 0) {
            FdpFaultOrderDispatchRequest fdpFaultOrderDispatchRequest = fdpFaultOrderDispatchRequestMapper.selectByPrimaryKey(order.getFaultDispatchRequestId());
            Integer jobDefineVersion = list.get(0).getJobDefineVersion();
            //新增派工任务表
            String[] split = fdpFaultOrderDispatchRequest.getDispatchDescription().split(";");
            int i = 1;
            for (String string : split) {
                FdpDispatchJobPerformance jobPerformance = new FdpDispatchJobPerformance();
                jobPerformance.setDispatchRequestId(fdpFaultOrderDispatchRequest.getId());
                jobPerformance.setDispatchOrderId(dispatchOrderId);
                jobPerformance.setFlagIsLast(true);
                jobPerformance.setCreateTime(order.getLastDealTime());
                jobPerformance.setJobPerformanceVersion(1);
                jobPerformance.setFlagJobFinish(false);
                jobPerformance.setJobStepIndex(i);
                jobPerformance.setJobStepDescription(string);
                jobPerformance.setJobDefineVersion(jobDefineVersion);
                fdpDispatchJobPerformanceMapper.insertSelective(jobPerformance);
            }
        }

        //保存操作记录
        //确认派工人员
        WpProcessOperateLog wpProcessOperateLog = new WpProcessOperateLog();
        wpProcessOperateLog.setOrderId(dispatchOrderId);
        wpProcessOperateLog.setDescription("确认派工人员");
        //调用保存操作方法
        CurrentUtil.recordLog(wpProcessOperateLog);
        //找/存下一个处理人
        CurrentUtil.nextDeal(dispatchOrderId);

        return ResultUtil.success("已确认派工人员！");

    }

    public Result serOrderList(ParamServiceDispatchOrder param) {

        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<GetServiceDispatchOrderList> persons = fdpFaultDispatchOrderMapper.selectServiceListByOrderId(param);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<GetServiceDispatchOrderList> pageInfo = new PageInfo<>(persons);
        if(pageInfo.getList()==null||pageInfo.getList().size()==0){
            pageInfo.setPageNum(1);
            pageInfo.setPageSize(10);
        }
        return ResultUtil.success(pageInfo);
    }

    public Result serOrderShow(Integer orderId) {

        GetSerivceOrderInfoShow result = new GetSerivceOrderInfoShow();
        //查询工单基本信息
        result.setServiceOrderBasicInfo(fdpFaultDispatchOrderMapper.selectServiceOrderBasic(orderId));

        //查询工作内容
        List<FdpDispatchJobPerformance> logList = fdpDispatchJobPerformanceMapper.selectFirstVersionByOrderId(orderId);

        List<FdpDispatchJobPerformance> logNewList = fdpDispatchJobPerformanceMapper.selectNewVersionByOrderId(orderId);

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
        result.setServiceCompleteProfile(fdpFaultDispatchHrRelationMapper.selectCompleteProFile(orderId));
        return ResultUtil.success(result);
    }

    public Result confirmDispatch(FdpFaultOrderInsertParam insertParam) {

        SysCompanyUsers users = CurrentUtil.getCurrent();

        Integer userId = CurrentUtil.getCurrent().getId();

        BigDecimal num = new BigDecimal("99999999");

        if(insertParam.getEstimatedCost()==null){
            return ResultUtil.errorBusinessMsg("请输入预计成本");
        }
        if(insertParam.getEstimatedPrice()==null){
            return ResultUtil.errorBusinessMsg("请输入预计售价");
        }

        if (insertParam.getEstimatedCost().compareTo(num) == 1) {
            return ResultUtil.errorBusinessMsg("预计成本长度过长（小于等于八位）");
        }
        if (insertParam.getEstimatedPrice().compareTo(num) == 1) {
            return ResultUtil.errorBusinessMsg("预计售价长度过长（小于等于八位）");
        }
        // 当前时间
        Date now = new Date();
        //查询当前订单状态
        String status = fdpFaultDispatchOrderMapper.selectStatusById(insertParam.getDispatchOrderId());
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
        fdpFaultDispatchOrderMapper.updateDispatchOrderByRequestId(updateOrder);

        FdpFaultDispatchHrRelation flag = new FdpFaultDispatchHrRelation();
        flag.setFlagUsed(false);
        flag.setDispatchOrderId(insertParam.getDispatchOrderId());
        fdpFaultDispatchHrRelationMapper.updateFlagUsedByOrderId(flag);

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
        param.setDispatchMainHrId(insertParam.getDispatchMainHrId());
        param.setDispatchOrderId(insertParam.getDispatchOrderId());
        param.setHrAccountInfoId(insertParam.getHrAccountInfoId());
        param.setFlagUsed(true);
        param.setEstimatedPrice(insertParam.getEstimatedPrice());
        param.setEstimatedPriceUnit(insertParam.getEstimatedPriceUnit());
        param.setEstimatedPriceMemo(insertParam.getEstimatedPriceMemo());
        param.setEstimatedInvoiceRate(insertParam.getEstimatedInvoiceRate());
        param.setEstimatedInvoiceType(insertParam.getEstimatedInvoiceType());
        param.setFlagDeleted(false);
        param.setFlagAvailable(true);
        fdpFaultDispatchHrRelationMapper.insertSelective(param);

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
        fdpFaultDispatchChangeLogMapper.insertSelective(changeLog);

        // 更新流程表状态
        FdpFaultOrderProcess process = new FdpFaultOrderProcess();
        process.setId(insertParam.getFaultOrderId());
        process.setUpdatePerson(userId);
        process.setUpdateTime(now);
        process.setOpearteStatus("DEALING");
        fdpFaultOrderProcessMapper.updateByPrimaryKeySelective(process);
        //点击确认派工设为已读
        setReadOther(insertParam.getRequestId());


        //保存操作记录
        //预约派工
        WpProcessOperateLog wpProcessOperateLog = new WpProcessOperateLog();
        wpProcessOperateLog.setOrderId(insertParam.getDispatchOrderId());
        wpProcessOperateLog.setDescription("预约派工");
        //调用保存操作方法
        CurrentUtil.recordLog(wpProcessOperateLog);
        //找/存下一个处理人
        CurrentUtil.nextDeal(insertParam.getDispatchOrderId());

        return ResultUtil.success();
    }

    //客服的已读
    public void setReadOther(int requestId) {

        FdpFaultDispatchOrder order = fdpFaultDispatchOrderMapper.selectByRequestId(requestId);

        SysOperationMessage message = new SysOperationMessage();
        message.setUserId(order.getLastDealPersonId());
        message.setMessageObjCode(order.getDispatchOrderNumber());
        message.setFlagRead(true);
        message.setReadTime(new Date());
        sysOperationMessageMapper.updateSetReadByUserIAndDispatchNumber(message);

    }

    public Result getOrderListByObject(GetDispatchOrderListRequest getDispatchOrderListRequest) {

        if (getDispatchOrderListRequest.getPageNum() == null || getDispatchOrderListRequest.getPageNum() == 0) {
            getDispatchOrderListRequest.setPageNum(1);
        }
        if (getDispatchOrderListRequest.getPageSize() == null || getDispatchOrderListRequest.getPageSize() == 0) {
            getDispatchOrderListRequest.setPageSize(10);
        }
        getDispatchOrderListRequest.setUserCompanyId(CurrentUtil.getCurrent().getCompanyId());
        PageHelper.startPage(getDispatchOrderListRequest.getPageNum(), getDispatchOrderListRequest.getPageSize());
        Page<GetDispatchOrderListResp> persons = fdpFaultDispatchOrderMapper.getOrderListByObject(getDispatchOrderListRequest);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<GetDispatchOrderListResp> pageInfo = new PageInfo<>(persons);
        List<GetDispatchOrderListResp> dispatchOrderListResp = pageInfo.getList();
        if(dispatchOrderListResp==null || dispatchOrderListResp.size()==0){
            pageInfo.setPageNum(1);
            pageInfo.setPageSize(10);
        }
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
            //百分比超过百分之百后继续增长
            try {
                workSchedule = Integer.parseInt(String.format("%.0f", ((now_su.doubleValue() / ex_su.doubleValue()) * 100)));
            } catch (NumberFormatException e) {
                workSchedule = 0;
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
            //判断是否需要审核
            Map<Object, Object> map= wpCfgFrameProcessService.findRedis(list.getDispatchOrderId(),list.getWpFrameProcessId());
            Object obj = map.get("users");
            if(obj!=null){
                List<Integer> listUser = (List<Integer>) obj;
                if(listUser.contains(CurrentUtil.getCurrent().getId())){
                    list.setExamineStatus(true);
                }else{
                    list.setExamineStatus(false);
                }
            }
        }
        return ResultUtil.success(pageInfo);

    }

    public Result showFile(Integer id) {
        return ResultUtil.success(fdpFaultDispatchOrderMapper.selectDispatchOrderByfdoId(id));
    }

    public Result dispatchNeedConfirm(FdpFaultDispatchOrder dispatchNeedConfirm) {

        Date now = new Date();
        //查询当前订单状态
        FdpFaultDispatchOrder fdpFaultDispatchOrder = fdpFaultDispatchOrderMapper.selectByPrimaryKey(dispatchNeedConfirm.getId());
        insertDispatchProcessLog(dispatchNeedConfirm.getId(), CurrentUtil.getCurrent().getId(), "PURCHASE", fdpFaultDispatchOrder.getDispatchStatus(), "NEEDCONFIRM", "已推送派工信息，待确认", now);

        dispatchNeedConfirm.setLastDealTime(now);
        dispatchNeedConfirm.setLastDealPersonId(CurrentUtil.getCurrent().getId());
        dispatchNeedConfirm.setDispatchStatus("NEEDCONFIRM");
        dispatchNeedConfirm.setFlagFinish(false);
        dispatchNeedConfirm.setSendHrInfoConfirmTime(now);
        //确认派工信息  派工步骤为第3步
        dispatchNeedConfirm.setProcessStage("3");
        fdpFaultDispatchOrderMapper.updateStatusByDispatchRequestId(dispatchNeedConfirm);
        //采购回复消息
        purchaseReply(dispatchNeedConfirm.getId());

        //保存操作记录
        //派工信息确认
        WpProcessOperateLog wpProcessOperateLog = new WpProcessOperateLog();
        wpProcessOperateLog.setOrderId(dispatchNeedConfirm.getId());
        wpProcessOperateLog.setDescription("派工信息确认");
        //调用保存操作方法
        CurrentUtil.recordLog(wpProcessOperateLog);
        //找/存下一个处理人
        CurrentUtil.nextDeal(dispatchNeedConfirm.getId());

        return ResultUtil.success();

    }

    public void purchaseReply(Integer id) {
        FdpFaultDispatchOrder order = fdpFaultDispatchOrderMapper.selectByPrimaryKey(id);
        SysOperationMessage insertMessage = new SysOperationMessage();
        //查询派工单是由谁创建的(传入dispatchRequest表的id)
        insertMessage.setUserId(fdpFaultOrderDispatchRequestMapper.selectCreatePerson(order.getFaultDispatchRequestId()));
        insertMessage.setMessageObjCode(order.getDispatchOrderNumber());
        if (order.getFaultOrderId() == null || order.getFaultOrderId() == 0) {
            insertMessage.setMessageOperation("DISPATCH_OPERATOR");
            insertMessage.setContent("由你发起的派工工单[" + insertMessage.getMessageObjCode() + "]有新进展,请尽快处理。");
            insertMessage.setMessageObjCode(order.getDispatchOrderNumber());
        } else {
            String GzNumber = fdpFaultOrderDispatchRequestMapper.selectGzNumer(order.getFaultDispatchRequestId());
            insertMessage.setMessageOperation("CUSTOMER_SERVICE_OPERATOR");
            insertMessage.setContent("由你发起的故障工单[" + GzNumber + "]有新进展,请尽快处理。");
            insertMessage.setMessageObjCode(GzNumber);
        }

        createMessage(insertMessage);
    }

    public Result confirmDispatchComplete(ParamCompleteConfirm paramCompleteConfirm) {
        Integer userId = CurrentUtil.getCurrent().getId();
        // 当前时间
        Date now = new Date();
        // 修改派工请求  id 是requestId
        FdpFaultDispatchOrder fdpFaultDispatchOrder = fdpFaultDispatchOrderMapper.selectByRequestId(paramCompleteConfirm.getId());
        //处理人 类型 为采购
        String type = "PURCHASE";
        insertDispatchProcessLog(fdpFaultDispatchOrder.getId(), userId, type, fdpFaultDispatchOrder.getDispatchStatus(), "USED", "提交完工资料", now);

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
        hrRelation.setUserCompleteTime(paramCompleteConfirm.getUserCompleteTime());
        hrRelation.setUserJobPerformance(paramCompleteConfirm.getDispatchDescription());
        hrRelation.setCompleteProfileUserId(userId);
        hrRelation.setCompleteProfileUserType(type);
        if (fdpFaultDispatchHrRelationMapper.updateByRequestId(hrRelation) == 0) {
            return ResultUtil.errorBusinessMsg("提交完工资料失败！");
        }
        //查询orderid
        FdpFaultDispatchHrRelation result = fdpFaultDispatchHrRelationMapper.selectByRequestId(paramCompleteConfirm.getId());
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
        FdpFaultDispatchOrder order = fdpFaultDispatchOrderMapper.selectByRequestId(hrRelation.getFaultDispatchRequestId());
        order.setActualCost(paramCompleteConfirm.getActualCost());
        order.setActualMonetaryUnit(paramCompleteConfirm.getActualMonetaryUnit());
        order.setActualCostMemo(paramCompleteConfirm.getActualCostMemo());
        order.setLastDealTime(now);
        order.setPrivateNote(paramCompleteConfirm.getPrivateNote());
        //修改实际费用 实际成本
        fdpFaultDispatchOrderMapper.updateStatusByDispatchRequestId(order);

        purchaseReply(order.getId());
        setReadPurchase(hrRelation.getFaultDispatchRequestId(), userId);

        //保存日志记录
        WpProcessOperateLog wpProcessOperateLog = new WpProcessOperateLog();
        wpProcessOperateLog.setOrderId(order.getId());
        wpProcessOperateLog.setDescription("提交完工资料");
        CurrentUtil.recordLog(wpProcessOperateLog);
        //找存下一步处理人
        CurrentUtil.nextDeal(order.getId());

        return ResultUtil.success();
    }

    //根据requestId点击已读
    public void setReadPurchase(int requestId, int userId) {

        FdpFaultDispatchOrder order = fdpFaultDispatchOrderMapper.selectByRequestId(requestId);
        SysOperationMessage message = new SysOperationMessage();
        message.setUserId(userId);
        if (order != null) {
            message.setMessageObjCode(order.getDispatchOrderNumber());
        }
        message.setFlagRead(true);
        message.setReadTime(new Date());
        sysOperationMessageMapper.updateSetReadByUserIAndDispatchNumber(message);

    }

    //根据orderId点击已读
    public void setReadPurchaseByOrderId(int orderId, int userId) {

        FdpFaultDispatchOrder order = fdpFaultDispatchOrderMapper.selectByPrimaryKey(orderId);
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

        Integer orderId = fdpFaultDispatchOrderMapper.findOrderId(paramCompleteConfirm.getRequestId());

        //修改实际费用
        if (fdpFaultDispatchOrderMapper.updateStatusByDispatchRequestId(order) > 0) {


            //保存日志
            WpProcessOperateLog wpProcessOperateLog = new WpProcessOperateLog();
            wpProcessOperateLog.setOrderId(orderId);
            wpProcessOperateLog.setDescription("价格确认-成功");
            CurrentUtil.recordLog(wpProcessOperateLog);

            //找/存下一个处理人
            CurrentUtil.nextDeal(orderId);

            return ResultUtil.success();
        }

        //保存日志
        WpProcessOperateLog wpProcessOperateLog = new WpProcessOperateLog();
        wpProcessOperateLog.setOrderId(orderId);
        wpProcessOperateLog.setDescription("价格确认-失败");
        CurrentUtil.recordLog(wpProcessOperateLog);

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
        fdpFaultDispatchHrRelationMapper.updateByRequestId(hrRelation);

        if (dispatchCompleteHr.getUserAssmAchievePoint() == null && dispatchCompleteHr.getUserAssmCommunicationPoint() == null && dispatchCompleteHr.getUserAssmTimelyPoint() == null) {
            return ResultUtil.errorBusinessMsg("请评价！");
        }
        if (dispatchCompleteHr.getUserAssmAchievePoint() == null) dispatchCompleteHr.setUserAssmAchievePoint(0);
        if (dispatchCompleteHr.getUserAssmCommunicationPoint() == null)
            dispatchCompleteHr.setUserAssmCommunicationPoint(0);
        if (dispatchCompleteHr.getUserAssmTimelyPoint() == null) dispatchCompleteHr.setUserAssmTimelyPoint(0);
        //查询派工人员
        FdpFaultDispatchHrRelation result = fdpFaultDispatchHrRelationMapper.selectByRequestId(dispatchComplete.getId());
        //查询派工人员评价
        BifDispatchHumanResource record = bifDispatchHumanResourceMapper.selectByPrimaryKey(result.getDispatchMainHrId());
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
        bifDispatchHumanResourceMapper.updateByPrimaryKeySelective(resource);

        //采购完工确认时  派工步骤为第5步
        dispatchComplete.setProcessStage("5");
        dispatchComplete.setLastDealTime(now);
        dispatchComplete.setFlagDispatcherConfirm(true);
        dispatchComplete.setFaultDispatchRequestId(dispatchComplete.getId());
        dispatchComplete.setPrivateNote(dispatchComplete.getPrivateNote());
        FdpFaultDispatchOrder customerResult = fdpFaultDispatchOrderMapper.selectCustomerConfirm(dispatchComplete.getId());
        FdpFaultDispatchOrder order = fdpFaultDispatchOrderMapper.selectByRequestId(dispatchComplete.getId());

        Integer orderId = 0;

        //是否有processId
        if (order.getFaultOrderId() != null) {
            //更新user_assm
            FdpFaultOrderProcess process = new FdpFaultOrderProcess();
            process.setId(order.getFaultOrderId());
            process.setFlagUserAssm(true);
            fdpFaultOrderProcessMapper.updateByPrimaryKeySelective(process);
        }

        if (customerResult.getFlagCustomerConfirm() == false) {
            //客户未完工
            dispatchComplete.setFlagFinish(false);
            dispatchComplete.setDispatcherFinalConfirmTime(now);
            dispatchComplete.setDispatchStatus("FILENEEDCONFIRM");
            fdpFaultDispatchOrderMapper.updateStatusByRequestId(dispatchComplete);

            orderId = fdpFaultDispatchOrderMapper.selectFaultOrderId(dispatchComplete.getFaultDispatchRequestId());
            //查询当前订单状态
            String status = fdpFaultDispatchOrderMapper.selectStatusById(orderId);
            insertDispatchProcessLog(orderId, userId, "PURCHASE", status, "USED", " 已确认派工资料符合要求，派工工作已完成", now);


        } else {//客户已完工  修改完工状态
            dispatchComplete.setFlagCustomerConfirm(true);
            dispatchComplete.setFlagFinish(true);
            dispatchComplete.setFinishType("COMPLETE");
            dispatchComplete.setDispatchStatus("COMPLETE");
            dispatchComplete.setLastDealTime(now);
            dispatchComplete.setDispatcherFinalConfirmTime(now);
            fdpFaultDispatchOrderMapper.updateStatusByRequestId(dispatchComplete);

            //修改派工人员派工状态
            FdpFaultDispatchHrRelation relation = new FdpFaultDispatchHrRelation();
            relation.setFaultDispatchRequestId(dispatchComplete.getId());
            relation.setHrDispatchStatus("COMPLETE");
            fdpFaultDispatchHrRelationMapper.updateByRequestId(relation);

            //增加派工成功次数
            resource.setId(record.getId());
            resource.setDispatchSuccessfulCount(record.getDispatchSuccessfulCount() + 1);
            bifDispatchHumanResourceMapper.updateByPrimaryKeySelective(resource);

            orderId = fdpFaultDispatchOrderMapper.selectFaultOrderId(dispatchComplete.getFaultDispatchRequestId());
            //查询当前订单状态
            String status = fdpFaultDispatchOrderMapper.selectStatusById(orderId);
            insertDispatchProcessLog(orderId, userId, "PURCHASE", status, "COMPLETE", " 已确认派工资料符合要求，派工工作已完成", now);

        }

        //保存操作记录
        //采购完工确认
        WpProcessOperateLog wpProcessOperateLog = new WpProcessOperateLog();
        wpProcessOperateLog.setOrderId(dispatchComplete.getId());
        wpProcessOperateLog.setDescription("采购完工确认");
        //调用保存操作方法
        CurrentUtil.recordLog(wpProcessOperateLog);
        //找/存下一个处理人
        CurrentUtil.nextDeal(dispatchComplete.getId());

        //生成新的消息
        purchaseReply(orderId);
        //标记已读
        setReadPurchase(dispatchComplete.getFaultDispatchRequestId(), userId);

        return ResultUtil.success();
    }


    public Result abandonDispatch(FdpFaultDispatchOrder dispatchAbandon) {

        SysCompanyUsers users = CurrentUtil.getCurrent();

        Integer userId = CurrentUtil.getCurrent().getId();

        Date now = new Date();
        //查询当前订单状态
        String status = fdpFaultDispatchOrderMapper.selectStatusById(dispatchAbandon.getId());
        insertDispatchProcessLog(dispatchAbandon.getId(), userId, "PURCHASE", status, "FAULTCONFIRMED", "已放弃派工", now);

        dispatchAbandon.setLastDealTime(now);
        dispatchAbandon.setLastDealPersonId(userId);
        dispatchAbandon.setDispatchStatus("ABANDON");
        dispatchAbandon.setFlagFinish(false);
        dispatchAbandon.setFinishTime(now);
        //放弃 派工步骤为8
        dispatchAbandon.setProcessStage("8");
        //更改为requestid修改
        fdpFaultDispatchOrderMapper.updateStatusByDispatchRequestId(dispatchAbandon);
        if (dispatchAbandon.getFaultOrderId() != null && dispatchAbandon.getFaultOrderId() != 0) {
            //修改流程表
            FdpFaultOrderProcess process = new FdpFaultOrderProcess();
            process.setId(dispatchAbandon.getFaultOrderId());
            process.setOpearteStatus("FAULTCONFIRMED");
            fdpFaultOrderProcessMapper.updateProcessStatusByProcessId(process);
            //根据process查询rootid
            int processRootId = fdpFaultOrderProcessMapper.selectRootId(process.getId());
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
        message.setUserId(fdpFaultOrderDispatchRequestMapper.selectCreatePerson(dispatchAbandon.getFaultDispatchRequestId()));
        message.setMessageObjCode(fdpFaultDispatchOrderMapper.selectNumber(dispatchAbandon.getFaultDispatchRequestId()));
        if (dispatchAbandon.getFaultOrderId() == null && dispatchAbandon.getFaultOrderId() == 0) {
            message.setMessageOperation("DISPATCH_OPERATOR");
        } else {
            message.setMessageOperation("CUSTOMER_SERVICE_OPERATOR");
        }
        message.setVendorId(dispatchAbandon.getVendorId());
        message.setCompanyId(dispatchAbandon.getCompanyId());
        //id为dispatchRequestId
        setReadPurchase(dispatchAbandon.getFaultDispatchRequestId(), userId);

        //保存操作记录
        //放弃派工
        WpProcessOperateLog wpProcessOperateLog = new WpProcessOperateLog();
        wpProcessOperateLog.setOrderId(dispatchAbandon.getId());
        wpProcessOperateLog.setDescription("放弃派工");
        //调用保存操作方法
        CurrentUtil.recordLog(wpProcessOperateLog);
        //找/存下一个处理人
        CurrentUtil.nextDeal(dispatchAbandon.getId());



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
        list = fdpFaultDispatchOrderMapper.selectOldPersonId(map);
        fdpFaultDispatchOrderMapper.dispatchTransmit(map);

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
            purchaseTransfer(orderId, newDealPersonId, userId);
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
        FdpFaultDispatchOrder order = fdpFaultDispatchOrderMapper.selectByPrimaryKey(dispatchOrderId);
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
        if (orderId.size() > 0) {
            for (Integer item : orderId) {
                relation = new FdpFaultDispatchHrRelation();
                relation.setFlagEnableModifyProfile(true);
                relation.setDispatchOrderId(item);
                fdpFaultDispatchHrRelationMapper.updateFlagEnableModifyProfile(relation);
            }
            return ResultUtil.success();
        }
        return ResultUtil.errorBusinessMsg("开放完工资料失败！");
    }
}
