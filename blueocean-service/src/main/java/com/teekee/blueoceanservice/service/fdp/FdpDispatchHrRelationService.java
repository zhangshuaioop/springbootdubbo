package com.teekee.blueoceanservice.service.fdp;

import com.alibaba.fastjson.JSON;
import com.teekee.blueoceanservice.entity.fdp.*;
import com.teekee.blueoceanservice.mapper.fdp.FdpDispatchJobPerformanceMapper;
import com.teekee.blueoceanservice.mapper.fdp.FdpFaultDispatchChangeLogMapper;
import com.teekee.blueoceanservice.mapper.fdp.FdpFaultDispatchHrRelationMapper;
import com.teekee.blueoceanservice.mapper.fdp.FdpFaultDispatchOrderMapper;
import com.teekee.blueoceanservice.utils.CurrentUtil;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghao
 * @Title: FdpDispatchHrRelationService
 * @ProjectName BlueOcean
 * @Description: 人力服务商
 * @date 2019/1/9下午2:01
 */
@Service
public class FdpDispatchHrRelationService {

    @Resource
    FdpFaultDispatchHrRelationMapper fdpFaultDispatchHrRelationMapper;

    @Resource
    private FdpDispatchJobPerformanceMapper fdpDispatchJobPerformanceMapper;

    @Resource
    private FdpFaultDispatchOrderMapper fdpFaultDispatchOrderMapper;

    @Resource
    private FdpFaultDispatchChangeLogMapper fdpFaultDispatchChangeLogMapper;

    @Resource
    private FdpFaultDispatchOrderService fdpFaultDispatchOrderService;

    public Result profileLogShow(Integer dispatchOrderId) {

        //查询之前是否上传完工资料
        GetFdpFaultDispatchHrRelationShowRequest result = fdpFaultDispatchHrRelationMapper.selectConfirmFile(dispatchOrderId);

        List<FdpDispatchJobPerformance> logList = fdpDispatchJobPerformanceMapper.selectFirstVersionByOrderId(dispatchOrderId);

        List<FdpDispatchJobPerformance> logNewList = fdpDispatchJobPerformanceMapper.selectNewVersionByOrderId(dispatchOrderId);


        for (FdpDispatchJobPerformance str : logList) {
            for (FdpDispatchJobPerformance str2 : logNewList) {
                if (str2.getJobStepDescription().equals(str.getJobStepDescription())) {
                    str.setWorkConditionPhoto(str2.getWorkConditionPhoto());
                    str.setWorkConditionPhotoName(str2.getWorkConditionPhotoName());
                    str.setJobPerformanceDescription(str2.getJobPerformanceDescription());
                    str.setFlagUsed(true);
                    if (null != str2.getVoiceLogUrl() && !str2.getVoiceLogUrl().equals("")) {
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
        result.setJobPerformances(logList);

        return ResultUtil.success(result);

    }

    public Result extendProfile(String json) {

        FdpFaultDispatchHrRelation hrRelation = JSON.parseObject(json, FdpFaultDispatchHrRelation.class);
        FdpFaultDispatchOrder order = JSON.parseObject(json, FdpFaultDispatchOrder.class);

        FdpFaultDispatchHrRelation hr = fdpFaultDispatchHrRelationMapper.selectIdByOrderId(hrRelation.getDispatchOrderId());

        hr.setExtendProfileName(hrRelation.getExtendProfileName());
        hr.setExtendProfileUrl(hrRelation.getExtendProfileUrl());
        hr.setExtendProfileMemo(hrRelation.getExtendProfileMemo());
        fdpFaultDispatchHrRelationMapper.updateExtendProfile(hr);

        FdpFaultDispatchOrder od = fdpFaultDispatchOrderMapper.selectByPrimaryKey(hrRelation.getDispatchOrderId());

        od.setPrivateNote(order.getPrivateNote());
        fdpFaultDispatchOrderMapper.updateByPrimaryKeySelective(od);

        return ResultUtil.success();
    }

    public Result changeDispatchHr(FdpFaultDispatchHrRelation hrRelation) {
        Integer userId = CurrentUtil.getCurrent().getId();
        BigDecimal num = new BigDecimal("99999999");
        if (hrRelation.getEstimatedCost() != null && hrRelation.getEstimatedCost().compareTo(num) == 1) {
            return ResultUtil.errorBusinessMsg("预计成本长度过长（小于等于八位）");
        }
        if (hrRelation.getEstimatedPrice() != null && hrRelation.getEstimatedPrice().compareTo(num) == 1) {
            return ResultUtil.errorBusinessMsg("预计售价长度过长（小于等于八位）");
        }
        Date now = new Date();

        FdpFaultDispatchHrRelation hr = fdpFaultDispatchHrRelationMapper.selectIdByOrderId(hrRelation.getDispatchOrderId());

        FdpFaultDispatchHrRelation flag = new FdpFaultDispatchHrRelation();
        flag.setFlagUsed(false);
        flag.setDispatchOrderId(hrRelation.getDispatchOrderId());
        fdpFaultDispatchHrRelationMapper.updateFlagUsedByOrderId(flag);
        hr.setDispatchMainHrId(hrRelation.getDispatchMainHrId());
        hr.setHrAccountInfoId(hrRelation.getHrAccountInfoId());
        hr.setEstimatedInvoiceRate(hrRelation.getEstimatedInvoiceRate());
        hr.setEstimatedInvoiceType(hrRelation.getEstimatedInvoiceType());
        hr.setFlagProvideInvoice(hrRelation.getFlagProvideInvoice());
        hr.setFlagUsed(true);
        hr.setEstimatedPrice(hrRelation.getEstimatedPrice());
        hr.setEstimatedPriceMemo(hrRelation.getEstimatedPriceMemo());
        hr.setEstimatedPriceUnit(hrRelation.getEstimatedPriceUnit());
        hr.setEstimatedCost(hrRelation.getEstimatedCost());
        hr.setEstimatedMonetaryUnit(hrRelation.getEstimatedMonetaryUnit());
        hr.setEstimatedCostMemo(hrRelation.getEstimatedCostMemo());
        hr.setId(null);
        fdpFaultDispatchHrRelationMapper.insertHrRelation(hr);

        FdpFaultDispatchOrder order = new FdpFaultDispatchOrder();
        order.setId(hrRelation.getDispatchOrderId());
        //采购更换人员 修改派工状态
        if (hrRelation.getFlagPurchase() == true) {
            order.setDispatchStatus("DEALING");
        }
        order.setPrivateNote(hrRelation.getPrivateNote());
        fdpFaultDispatchOrderMapper.updateByPrimaryKeySelective(order);

        FdpFaultDispatchChangeLog changeLog = new FdpFaultDispatchChangeLog();
        changeLog.setHrRelationId(hr.getId());
        changeLog.setDispatchMainHrId(hr.getDispatchMainHrId());
        changeLog.setHrAccountInfoId(hr.getHrAccountInfoId());
        changeLog.setDispatchOrderId(hrRelation.getDispatchOrderId());
        changeLog.setFaultDispatchRequestId(hr.getFaultDispatchRequestId());
        changeLog.setChangeType("HR");
        changeLog.setEstimatedPriceUnit(hrRelation.getEstimatedPriceUnit());
        changeLog.setEstimatedPrice(hrRelation.getEstimatedPrice());
        changeLog.setEstimatedCost(hrRelation.getEstimatedCost());
        changeLog.setEstimatedMonetaryUnit(hrRelation.getEstimatedMonetaryUnit());
        changeLog.setCreateTime(now);
        changeLog.setCreatePerson(userId);
        fdpFaultDispatchChangeLogMapper.insertSelective(changeLog);
        //点击确认派工设为已读
        fdpFaultDispatchOrderService.setReadPurchase(hr.getFaultDispatchRequestId(), userId);
        return ResultUtil.success();
    }

    public Result changeDispatchCost(FdpFaultDispatchHrRelation hrRelation) {
        Integer userId = CurrentUtil.getCurrent().getId();
        BigDecimal num = new BigDecimal("99999999");
        if (hrRelation.getEstimatedCost() != null && hrRelation.getEstimatedCost().compareTo(num) == 1) {
            return ResultUtil.errorBusinessMsg("预计成本长度过长（小于等于八位）");
        }
        if (hrRelation.getEstimatedPrice() != null && hrRelation.getEstimatedPrice().compareTo(num) == 1) {
            return ResultUtil.errorBusinessMsg("预计售价长度过长（小于等于八位）");
        }
        FdpFaultDispatchHrRelation hr = fdpFaultDispatchHrRelationMapper.selectIdByOrderId(hrRelation.getDispatchOrderId());
        FdpFaultDispatchHrRelation hr_new = new FdpFaultDispatchHrRelation();
        hr_new.setEstimatedCost(hrRelation.getEstimatedCost());
        hr_new.setEstimatedMonetaryUnit(hrRelation.getEstimatedMonetaryUnit());
        hr_new.setEstimatedCostMemo(hrRelation.getEstimatedCostMemo());
        hr_new.setEstimatedPrice(hrRelation.getEstimatedPrice());
        hr_new.setEstimatedPriceUnit(hrRelation.getEstimatedPriceUnit());
        hr_new.setEstimatedPriceMemo(hrRelation.getEstimatedPriceMemo());
        hr_new.setFlagUsed(true);
        if (hr == null) {
            hr_new.setId(null);
            fdpFaultDispatchHrRelationMapper.insertHrRelation(hr_new);
        } else {
            hr_new.setId(hr.getId());
            fdpFaultDispatchHrRelationMapper.updateByPrimaryKeySelective(hr_new);
        }

        FdpFaultDispatchOrder order = new FdpFaultDispatchOrder();
        order.setId(hrRelation.getDispatchOrderId());
        order.setFlagNoPrice(hrRelation.getFlagNoPrice());
        order.setPrivateNote(hrRelation.getPrivateNote());
        fdpFaultDispatchOrderMapper.updateByPrimaryKeySelective(order);

        Date now = new Date();
        FdpFaultDispatchChangeLog changeLog = new FdpFaultDispatchChangeLog();
        changeLog.setHrRelationId(hr.getId());
        changeLog.setDispatchMainHrId(hr.getDispatchMainHrId());
        changeLog.setHrAccountInfoId(hr.getHrAccountInfoId());
        changeLog.setDispatchOrderId(hrRelation.getDispatchOrderId());
        changeLog.setFaultDispatchRequestId(hr.getFaultDispatchRequestId());
        changeLog.setEstimatedCost(hr.getEstimatedCost());
        changeLog.setEstimatedMonetaryUnit(hr.getEstimatedMonetaryUnit());
        changeLog.setEstimatedPrice(hr.getEstimatedPrice());
        changeLog.setEstimatedPriceUnit(hr.getEstimatedPriceUnit());
        changeLog.setChangeType("COST");
        changeLog.setCreateTime(now);
        changeLog.setCreatePerson(userId);
        fdpFaultDispatchChangeLogMapper.insertSelective(changeLog);
        fdpFaultDispatchOrderService.setReadPurchase(hr.getFaultDispatchRequestId(), userId);
        return ResultUtil.success();

    }
}
