package com.platform.springboot.service.fdp;

import com.platform.springboot.entity.bif.BifDispatchHumanResource;
import com.platform.springboot.entity.fdp.*;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.entity.sys.SysOperationMessage;
import com.platform.springboot.mapper.bif.BifDispatchHumanResourceMapper;
import com.platform.springboot.mapper.fdp.*;
import com.platform.springboot.mapper.sys.SysCompanyUsersMapper;
import com.platform.springboot.mapper.sys.SysOperationMessageMapper;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import com.platform.springboot.mapper.fdp.*;
import com.platform.springboot.mapper.sys.SysCompanyUsersMapper;
import com.platform.springboot.mapper.sys.SysOperationMessageMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
    private Mapper dozer;

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

    public Result customerFinishConfirm(ParamCompleteConfirm paramCompleteConfirm) {

        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }
        // 当前时间
        Date now = new Date();
        //客服未派工直接确认派工
        if (paramCompleteConfirm.getProcessId() != 0 && paramCompleteConfirm.getId() == 0) {
            FdpFaultOrderProcess process = new FdpFaultOrderProcess();
            process.setId(paramCompleteConfirm.getProcessId());
            process.setOpearteStatus("COMPLETE");
            process.setUpdateTime(now);
            fdpFaultOrderProcessMapper.updateById(process);
            return ResultUtil.success();
        } else {
            Integer orderId = 0;
            // 修改派工工单
            FdpFaultDispatchOrder dispatchOrder = dozer.map(paramCompleteConfirm, FdpFaultDispatchOrder.class);
            dispatchOrder.setFaultDispatchRequestId(paramCompleteConfirm.getId());
            dispatchOrder.setFlagCustomerConfirm(true);
            dispatchOrder.setActualPrice(paramCompleteConfirm.getActualPrice());
            dispatchOrder.setActualPriceUnit(paramCompleteConfirm.getActualPriceUnit());
            //客户确认完工 派工步骤为6
            dispatchOrder.setProcessStage("6");
            dispatchOrder.setFinishTime(now);
            //查询采购是否确认完工
            FdpFaultDispatchOrder dispatchRsult = fdpFaultDispatchOrderMapper.selectDispatchConfirm(dispatchOrder.getFaultDispatchRequestId());
            if (dispatchRsult != null && dispatchRsult.getFlagDispatcherConfirm() == false) {//确认采购是否确认完工
                dispatchOrder.setFlagFinish(false);
                dispatchOrder.setCustomerFinalConfirmTime(now);
                fdpFaultDispatchOrderMapper.updateStatusByDispatchRequestId(dispatchOrder);

                orderId = fdpFaultDispatchOrderMapper.selectFaultOrderId(paramCompleteConfirm.getId());
                //查询当前订单状态
                String status = fdpFaultDispatchOrderMapper.selectStatusById(orderId);
                insertDispatchProcessLog(orderId, users.getId(), "DISPATCH", status, "USED", " 已确认派工资料符合要求，派工工作已完成", now);

            } else {
                orderId = fdpFaultDispatchOrderMapper.selectFaultOrderId(paramCompleteConfirm.getId());
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
                relation.setFaultDispatchRequestId(paramCompleteConfirm.getId());
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

            if (paramCompleteConfirm.getProcessId() != 0) {
                // 修改流程工单
                FdpFaultOrderProcess process = new FdpFaultOrderProcess();
                process.setId(paramCompleteConfirm.getProcessId());
                process.setOpearteStatus("COMPLETE");
                process.setUpdateTime(now);
                fdpFaultOrderProcessMapper.updateByPrimaryKeySelective(process);


                //通过processid查询rootid
                Integer rootId = fdpFaultOrderProcessMapper.selectRootId(paramCompleteConfirm.getProcessId());
                // 新增报障日志
                FdpFaultOrderProcessLog processLog = new FdpFaultOrderProcessLog();
                processLog.setFaultOrderProcessId(paramCompleteConfirm.getProcessId());
                processLog.setTitle("COMPLETE");
                processLog.setMemo("已完工");
                processLog.setProcessTime(now);
                processLog.setFlagConsole(true);
                processLog.setRootId(rootId);
                processLog.setProcessPersonId(users.getId());
                fdpFaultOrderProcessLogMapper.insertSelective(processLog);
                return ResultUtil.success("客户确认完工，成功！");
            }

            selectMessageInfo(orderId);
            return ResultUtil.success("客户确认完工，成功！");
        }

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

    public Result rebutComplete(Integer id) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }
        //id为requestId
        FdpFaultDispatchOrder order = fdpFaultDispatchOrderMapper.selectByRequestId(id);
        if (order != null) {
            Date now = new Date();
            FdpFaultDispatchOrder or = new FdpFaultDispatchOrder();
            or.setFaultDispatchRequestId(id);
            //客户驳回完工资料时  派工步骤返回第4步
            or.setProcessStage("4");
            or.setDispatchStatus("REJECTFILE");
            or.setFlagCustomerConfirm(false);
            if (fdpFaultDispatchOrderMapper.updateDispatchOrderByRequestId(or) > 0) {
                insertDispatchProcessLog(order.getId(), users.getId(), "DISPATCH_HR", order.getDispatchStatus(), "REJECTFILE", "客户驳回完工资料", now);
                return ResultUtil.success("驳回成功！");
            }
        }
        return ResultUtil.errorBusinessMsg("驳回失败！");
    }

    public Result cancelDispatchPerson(Integer faultDispatchRequestId) {

        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }

        Date now = new Date();
        //生成新的消息
        int order = fdpFaultDispatchOrderMapper.selectDispatchOrder(faultDispatchRequestId);

        //查询当前订单状态
        String status = fdpFaultDispatchOrderMapper.selectStatusById(order);
        insertDispatchProcessLog(order, users.getId(), "DISPATCH", status, "DISPATCHAGAIN", "派工信息不合要求，需要重新派工", now);

        fdpFaultOrderDispatchRequestMapper.selectHrIdByRequestId(faultDispatchRequestId);
        FdpFaultDispatchOrder ordercancel = new FdpFaultDispatchOrder();
        ordercancel.setLastDealTime(now);
        ordercancel.setDispatchStatus("DISPATCHAGAIN");
        ordercancel.setId(faultDispatchRequestId);
        //不使用已派工人员   步骤返回第2步
        ordercancel.setProcessStage("2");
        fdpFaultDispatchOrderMapper.updateStatusByRequestId(ordercancel);

        //给采购发送消息
        selectMessageInfo(order);

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

        return ResultUtil.success("已确认派工人员！");

    }
}
