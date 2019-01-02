package com.platform.springboot.service.fdp;

import com.platform.springboot.entity.fdp.*;
import com.platform.springboot.entity.syscompany.SysOperationMessage;
import com.platform.springboot.mapper.fdp.*;
import com.platform.springboot.mapper.syscompany.SysOperationMessageMapper;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        Integer userId =CurrentUtil.getCurrent().getId();

        BigDecimal num = new BigDecimal("99999999");
        if(insertParam.getEstimatedCost().compareTo(num)==1){
            return ResultUtil.errorBusinessMsg("预计成本长度过长（小于等于八位）");
        }
        if(insertParam.getEstimatedPrice().compareTo(num)==1){
            return ResultUtil.errorBusinessMsg("预计售价长度过长（小于等于八位）");
        }
        // 当前时间
        Date now = new Date();
        //查询当前订单状态
        String status = mapper.selectStatusById(insertParam.getDispatchOrderId());
        insertDispatchProcessLog(insertParam.getDispatchOrderId(),userId, "PURCHASE", status, "DEALING", "已安排派工", now);
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

        FdpFaultDispatchOrder order =  mapper.selectByRequestId(requestId);

        SysOperationMessage message = new SysOperationMessage();
        message.setUserId(order.getLastDealPersonId());
        message.setMessageObjCode(order.getDispatchOrderNumber());
        message.setFlagRead(true);
        message.setReadTime(new Date());
        sysOperationMessageMapper.updateSetReadByUserIAndDispatchNumber(message);

    }
}
