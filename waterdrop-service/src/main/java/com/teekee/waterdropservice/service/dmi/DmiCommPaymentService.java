package com.teekee.waterdropservice.service.dmi;

import com.teekee.commoncomponets.utils.PageInfo;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import com.teekee.waterdropservice.entity.dmi.DmiCommMarketingCampaignReturn;
import com.teekee.waterdropservice.entity.dmi.DmiCommPayment;
import com.teekee.waterdropservice.entity.dmi.ret.dmiCommPayment.PaymentShowRet;
import com.teekee.waterdropservice.entity.sys.SysCompanyUsers;
import com.teekee.waterdropservice.mapper.dmi.DmiCommMarketingCampaignReturnMapper;
import com.teekee.waterdropservice.mapper.dmi.DmiCommPaymentMapper;
import com.teekee.waterdropservice.utils.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-17 16:33
 */
@Service
public class DmiCommPaymentService {


    @Autowired
    private DmiCommPaymentMapper mapper;
    @Autowired
    private DmiCommMarketingCampaignReturnMapper returnMapper;

    public PaymentShowRet showByObject(int objectId, String objectType) {
        PaymentShowRet result = new PaymentShowRet();

        // 付费信息
        DmiCommPayment record = new DmiCommPayment();
        record.setObjectId(objectId);
        record.setObjectType(objectType);
        DmiCommPayment payment = mapper.showByObject(record);
        result.setPaymentInfo(payment);

        // 返还信息
        if ("CAMPAIGN".equals(objectType) && payment != null) {
            result.setReturnInfo(returnMapper.showByContractId(payment.getId()));
        }

        return result;
    }

    public Result list(DmiCommPayment dmiCommPayment) {
        List<DmiCommPayment> list = new ArrayList<>();
        List<DmiCommPayment> result = mapper.list(dmiCommPayment);
        if(result.size()>0){
            if(dmiCommPayment.getPageSize()!=null&&dmiCommPayment.getPageNum()!=null){
                PageHelper.startPage(dmiCommPayment.getPageNum(), dmiCommPayment.getPageSize());
                PageInfo<DmiCommPayment> pageInfo = new PageInfo<>(result);
                return ResultUtil.success(pageInfo);
            }else {
                return ResultUtil.success(result);
            }
        }else{
            return ResultUtil.success(list);
        }
    }

    public Result handle(DmiCommPayment record) {
        DmiCommMarketingCampaignReturn campaignReturn = new DmiCommMarketingCampaignReturn();
        campaignReturn.setReturnAmount(record.getReturnAmount());
        SysCompanyUsers user = CurrentUtil.getCurrent();
        // 合约结束日期不能小于合约开始日期
        if (record.getPaymentStartDate().compareTo(record.getPaymentEndDate()) > 0) {
            return ResultUtil.validateError("操作失败，合约结束日期必须大于合约开始日期！");
        }

        if (record.getPaymentMonths() == null) record.setPaymentMonths(0);
        if (record.getTotalFee() == null) record.setTotalFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (record.getTenementOneTimeFee() == null) record.setTenementOneTimeFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (record.getFiberFee() == null) record.setFiberFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (record.getFiberDeviceFee() == null) record.setFiberDeviceFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (record.getFirstInstallFee() == null) record.setFirstInstallFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (record.getCommPeriodFee() == null) record.setCommPeriodFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (record.getTenementPeriodFee() == null) record.setTenementPeriodFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (record.getEstimatedPaymentFee() == null) record.setEstimatedPaymentFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (record.getEstimatedPaymentTimes() == null) record.setEstimatedPaymentTimes(0);
        if (record.getActualPaymentFee() == null) record.setActualPaymentFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (record.getActualPaymentTimes() == null) record.setActualPaymentTimes(0);
        if (record.getRenewMonths() == null) record.setRenewMonths(0);
        if (record.getFlagAutoRenew() == null) record.setFlagAutoRenew(false);
        if (record.getFlagAutoRenewContract() == null) record.setFlagAutoRenewContract(false);
        if (record.getFlagStartPay() == null) record.setFlagStartPay(false);

        // 新增
        if (record.getId() == null || record.getId() == 0) {
            // 判断有没有时间维度重复的合约
            List<DmiCommPayment> sqlResult = mapper.selectByTimeDimension(record);
            if (sqlResult != null && !sqlResult.isEmpty()) {
                return ResultUtil.validateError("操作失败，您输入的合约起止日期有重复！");
            }

            // 判断最新合约标志
            record.setFlagLastest(true);
            DmiCommPayment last = mapper.selectLast(record);
            if (last != null) {
                if (last.getPaymentStartDate().compareTo(record.getPaymentStartDate()) < 0) {
                    last.setFlagLastest(false);
                    mapper.updateByPrimaryKeySelective(last);
                } else {
                    record.setFlagLastest(false);
                }
            }

            record.setCreateTime(new Date());
            record.setCreatePerson(user.getId());
            record.setUpdatePerson(user.getId());
            record.setUpdateTime(new Date());
            record.setFlagAvaliable(true);
            record.setFlagDeleted(false);
            mapper.insertSelective(record);

            // 新增返还信息
            if (campaignReturn != null && campaignReturn.getReturnAmount() != null) {
                campaignReturn.setContractId(record.getId());
                campaignReturn.setCreateTime(new Date());
                campaignReturn.setCreatePerson(user.getId());
                returnMapper.insertSelective(campaignReturn);
            }

            return ResultUtil.successMsg("新增付费合约成功");
        } else {// 编辑

            // 判断有没有时间维度重复的合约
            List<DmiCommPayment> sqlResult = mapper.selectByTimeDimension(record);
            if (sqlResult != null) {
                for (DmiCommPayment item : sqlResult) {
                    if (item.getId() != record.getId()) {
                        return ResultUtil.validateError("操作失败，您输入的合约起止日期有重复！");
                    }
                }
            }

            record.setUpdatePerson(user.getId());
            record.setUpdateTime(new Date());
            mapper.updateByPrimaryKeySelective(record);

            // 查询是否有返还信息
            DmiCommMarketingCampaignReturn dmiCommMarketingCampaignReturn = returnMapper.showByContractId(record.getId());
            if (dmiCommMarketingCampaignReturn != null) {
                campaignReturn.setUpdateTime(new Date());
                campaignReturn.setUpdatePerson(user.getId());
                campaignReturn.setId(dmiCommMarketingCampaignReturn.getId());
                returnMapper.updateByPrimaryKeySelective(campaignReturn);
            }

            return ResultUtil.successMsg("更新付费合约成功！");
        }
    }

    public Result handleDelete(DmiCommPayment dmiCommPayment) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        dmiCommPayment.setFlagDeleted(true);
        dmiCommPayment.setUpdatePerson(user.getId());
        dmiCommPayment.setUpdateTime(new Date());
        mapper.updateByPrimaryKeySelective(dmiCommPayment);
        return ResultUtil.successMsg("付费合约删除成功！");
    }

    public Result show(int id) {
        PaymentShowRet result = new PaymentShowRet();

        // 付费信息
        result.setPaymentInfo(mapper.selectByPrimaryKey(id));

        // 返还信息
        result.setReturnInfo(returnMapper.showByContractId(id));

        return ResultUtil.success(result);
    }
}
