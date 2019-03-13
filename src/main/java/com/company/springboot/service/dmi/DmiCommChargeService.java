package com.company.springboot.service.dmi;

import com.company.springboot.entity.dmi.DmiCommCharge;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.mapper.dmi.DmiCommChargeMapper;
import com.company.springboot.utils.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-17 16:38
 */
@Service
public class DmiCommChargeService {

    @Autowired
    private DmiCommChargeMapper dmiCommChargeMapper;

    public DmiCommCharge showByObjectId(DmiCommCharge dmiCommCharge) {
        return dmiCommChargeMapper.showByObjectId(dmiCommCharge);
    }

    public Result list(DmiCommCharge dmiCommCharge) {
        List<DmiCommCharge> list = new ArrayList<>();
        List<DmiCommCharge> result = dmiCommChargeMapper.list(dmiCommCharge);
        if(result.size()>0){
            if(dmiCommCharge.getPageSize()!=null&&dmiCommCharge.getPageNum()!=null){
                PageHelper.startPage(dmiCommCharge.getPageNum(), dmiCommCharge.getPageSize());
                PageInfo<DmiCommCharge> pageInfo = new PageInfo<>(result);
                if(pageInfo.getList()==null||pageInfo.getList().size()==0){
                    pageInfo.setPageNum(1);
                    pageInfo.setPageSize(10);
                }
                return ResultUtil.success(pageInfo);
            }else {
                return ResultUtil.success(result);
            }
        }else{
            return ResultUtil.success(list);
        }
    }


    public Result handle(DmiCommCharge dmiCommCharge) {

        SysCompanyUsers user = CurrentUtil.getCurrent();
        // 合约结束日期不能小于合约开始日期
        if (dmiCommCharge.getChargeStartDate().compareTo(dmiCommCharge.getChargeEndDate()) > 0) {
            return ResultUtil.validateError("操作失败，合约结束日期必须大于合约开始日期！");
        }
        // 参数转换
        if (dmiCommCharge.getChargeMonths() == null) dmiCommCharge.setChargeMonths(0);
        if (dmiCommCharge.getTotalFee() == null) dmiCommCharge.setTotalFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (dmiCommCharge.getTenementOneTimeFee() == null) dmiCommCharge.setTenementOneTimeFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (dmiCommCharge.getFiberFee() == null) dmiCommCharge.setFiberFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (dmiCommCharge.getCommOneTimeFee() == null) dmiCommCharge.setCommOneTimeFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (dmiCommCharge.getCommPeriodFee() == null) dmiCommCharge.setCommPeriodFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (dmiCommCharge.getTenementPeriodFee() == null) dmiCommCharge.setTenementPeriodFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (dmiCommCharge.getEstimatedChargeFee() == null) dmiCommCharge.setEstimatedChargeFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (dmiCommCharge.getEstimatedChargeTimes() == null) dmiCommCharge.setEstimatedChargeTimes(0);
        if (dmiCommCharge.getActualChargeFee() == null) dmiCommCharge.setActualChargeFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (dmiCommCharge.getActualChargeTimes() == null) dmiCommCharge.setActualChargeTimes(0);
        if (dmiCommCharge.getRenewMonths() == null) dmiCommCharge.setRenewMonths(0);
        if (dmiCommCharge.getFlagAutoRenew() == null) dmiCommCharge.setFlagAutoRenew(false);
        if (dmiCommCharge.getFlagAutoRenewContract() == null) dmiCommCharge.setFlagAutoRenewContract(false);

        if (dmiCommCharge.getId() == null || dmiCommCharge.getId() == 0) {

            // 判断有没有时间维度重复的合约
            List<DmiCommCharge> sqlResult = dmiCommChargeMapper.selectByTimeDimension(dmiCommCharge);
            if (sqlResult != null && !sqlResult.isEmpty()) {
                return ResultUtil.validateError("操作失败，您输入的合约起止日期有重复！");
            }

            // 判断最新合约标志
            dmiCommCharge.setFlagLastest(true);
            DmiCommCharge last = dmiCommChargeMapper.selectLast(dmiCommCharge);
            if (last != null) {
                if (last.getChargeStartDate().compareTo(dmiCommCharge.getChargeStartDate()) < 0) {
                    last.setFlagLastest(false);
                    dmiCommChargeMapper.updateByPrimaryKeySelective(last);
                } else {
                    dmiCommCharge.setFlagLastest(false);
                }
            }

            insert(dmiCommCharge, user.getId());
            return ResultUtil.successMsg("新增收费合约成功！");
        } else {
            // 判断有没有时间维度重复的合约
            List<DmiCommCharge> sqlResult = dmiCommChargeMapper.selectByTimeDimension(dmiCommCharge);
            if (sqlResult != null) {
                for (DmiCommCharge item : sqlResult) {
                    if (item.getId() != dmiCommCharge.getId()) {
                        return ResultUtil.validateError("操作失败，您输入的合约起止日期有重复！");
                    }
                }
            }

            // 已经开始收费的合约不能编辑
            if (dmiCommChargeMapper.selectByPrimaryKey(dmiCommCharge.getId()).getFlagStartCharge()) {
                return ResultUtil.validateError("操作失败，该合约已经开始收费！");
            }

            update(dmiCommCharge, user.getId());
            return ResultUtil.successMsg("新增收费合约成功！");
        }
    }

    public void insert(DmiCommCharge commCharge, int userId) {
        commCharge.setId(null);
        if (commCharge.getTotalFee() == null) commCharge.setTotalFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (commCharge.getTenementOneTimeFee() == null) commCharge.setTenementOneTimeFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (commCharge.getFiberFee() == null) commCharge.setFiberFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (commCharge.getCommPeriodFee() == null) commCharge.setCommPeriodFee(Constant.DEFAULT_DECIMAL_ZERO);
        if (commCharge.getTenementPeriodFee() == null) commCharge.setTenementPeriodFee(Constant.DEFAULT_DECIMAL_ZERO);
        commCharge.setCreateTime(new Date());
        commCharge.setCreatePerson(userId);
        commCharge.setFlagAvaliable(true);
        commCharge.setFlagDeleted(false);
        commCharge.setFlagStartCharge(false);
        commCharge.setUpdatePerson(userId);
        commCharge.setUpdateTime(new Date());
        dmiCommChargeMapper.insertSelective(commCharge);
    }

    public void update(DmiCommCharge dmiCommCharge, int userId) {
        dmiCommCharge.setUpdatePerson(userId);
        dmiCommCharge.setUpdateTime(new Date());
        dmiCommChargeMapper.updateByPrimaryKeySelective(dmiCommCharge);
    }

    public Result handleDelete(DmiCommCharge dmiCommCharge) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        dmiCommCharge.setFlagDeleted(true);
        dmiCommCharge.setUpdatePerson(user.getId());
        dmiCommCharge.setUpdateTime(new Date());
        dmiCommChargeMapper.updateByPrimaryKeySelective(dmiCommCharge);
        return ResultUtil.successMsg("删除收费合约成功！");
    }

    public Result show(int id) {
        return ResultUtil.success(dmiCommChargeMapper.selectByPrimaryKey(id));
    }
}
