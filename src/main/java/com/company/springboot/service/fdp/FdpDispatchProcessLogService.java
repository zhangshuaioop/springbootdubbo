package com.company.springboot.service.fdp;

import com.company.springboot.entity.fdp.*;
import com.company.springboot.mapper.fdp.FdpDispatchProcessLogMapper;
import com.company.springboot.mapper.fdp.FdpFaultDispatchOrderMapper;
import com.company.springboot.mapper.fdp.FdpFaultDispatchTransferLogMapper;
import com.company.springboot.mapper.fdp.FdpFaultOrderDispatchRequestMapper;
import com.company.springboot.mapper.sys.SysCompanyUsersMapper;
import com.company.springboot.utils.DateUtil;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghao
 * @Title: FdpDispatchProcessLogService
 * @ProjectName WaterDrop
 * @Description: 派工流程
 * @date 2018/12/22下午1:54
 */
@Service
public class FdpDispatchProcessLogService {

    @Resource
    private FdpDispatchProcessLogMapper fdpDispatchProcessLogMapper;
    @Resource
    private FdpFaultDispatchTransferLogMapper fdpFaultDispatchTransferLogMapper;
    @Resource
    private SysCompanyUsersMapper sysCompanyUsersMapper;
    @Resource
    private FdpFaultDispatchOrderMapper fdpFaultDispatchOrderMapper;
    @Resource
    private FdpFaultOrderDispatchRequestMapper fdpFaultOrderDispatchRequestMapper;

    public Result show(Integer orderId) {
        List<FdpDispatchProcessLogShow> result = new ArrayList<FdpDispatchProcessLogShow>();
        FdpDispatchProcessLogShow show;
        //查询派工流程
        List<FdpDispatchProcessLog> process = fdpDispatchProcessLogMapper.selectByOrderId(orderId);

        if (process != null && process.size() > 0) {

            //查询工单
            FdpFaultDispatchOrder order = fdpFaultDispatchOrderMapper.selectByPrimaryKey(orderId);
            //查询派工要求
            FdpFaultOrderDispatchRequest request = fdpFaultOrderDispatchRequestMapper.selectByPrimaryKey(order.getFaultDispatchRequestId());

            //派工流程list
            boolean zhuangtai = true;
            String userName = null;
            for (int i = 0; i <= process.size(); i++) {
                if (i < process.size()) {
                    show = new FdpDispatchProcessLogShow();
                    userName = sysCompanyUsersMapper.selectByPrimaryKey(process.get(i).getDealPersonId()).getNickname();
                    show.setInfo("【" + userName + "】:  " + process.get(i).getDealContent() + "，");
                    show.setDealTime(process.get(i).getDealTime());
                    show.setFlagTransfer(false);
                    result.add(show);
                    if (process.get(i).getAfterStatus().equals("COMPLETE") || process.get(i).getAfterStatus().equals("CANCEL")) {
                        zhuangtai = false;
                        break;
                    }
                } else {
                    if (order.getDispatchStatus().equals("NEEDCONFIRM") || order.getFlagDispatcherConfirm() == true) {
                        userName = sysCompanyUsersMapper.selectByPrimaryKey(request.getUpdatePerson()).getNickname();
                    } else {
                        userName = sysCompanyUsersMapper.selectByPrimaryKey(order.getLastDealPersonId()).getNickname();
                    }
                    show = new FdpDispatchProcessLogShow();
                    show.setInfo("下一个处理人：" + "【" + userName + "】");
                    show.setDealTime(new Date());
                    show.setFlagTransfer(false);
                    result.add(show);
                }
            }

            //查询转发记录
            List<FdpFaultDispatchTransferLogShowResp> transfershow = FdpFaultDispatchTransferLogShowList(orderId);
            //转发记录list（排序）
            for (FdpFaultDispatchTransferLogShowResp tranList : transfershow) {
                if (zhuangtai) {
                    for (int i = 0; i < result.size(); i++) {
                        if (tranList.getTransferTime().getTime() <= result.get(i).getDealTime().getTime()) {
                            show = new FdpDispatchProcessLogShow();
                            show.setInfo(tranList.getInfo());
                            show.setDealTime(tranList.getTransferTime());
                            show.setFlagTransfer(true);
                            show.setTransferType(tranList.getTransferType());
                            result.add(i, show);
                            break;
                        } else if (tranList.getTransferTime().getTime() > result.get(result.size() - 2).getDealTime().getTime()) {
                            show = new FdpDispatchProcessLogShow();
                            show.setInfo(tranList.getInfo());
                            show.setDealTime(tranList.getTransferTime());
                            show.setFlagTransfer(true);
                            show.setTransferType(tranList.getTransferType());
                            result.add(result.size() - 1, show);
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < result.size(); i++) {
                        if (tranList.getTransferTime().getTime() <= result.get(i).getDealTime().getTime()) {
                            show = new FdpDispatchProcessLogShow();
                            show.setInfo(tranList.getInfo());
                            show.setDealTime(tranList.getTransferTime());
                            show.setFlagTransfer(true);
                            show.setTransferType(tranList.getTransferType());
                            result.add(i, show);
                        } else if (tranList.getTransferTime().getTime() >= result.get(result.size() - 1).getDealTime().getTime()) {
                            show = new FdpDispatchProcessLogShow();
                            show.setInfo(tranList.getInfo());
                            show.setDealTime(tranList.getTransferTime());
                            show.setFlagTransfer(true);
                            show.setTransferType(tranList.getTransferType());
                            result.add(result.size(), show);
                            break;
                        }
                        break;
                    }
                }
            }
            //计算耗用时长
            for (int i = result.size() - 1; i >= 0; i--) {
                if (i != 0) {
                    long buringTimeLong = result.get(i).getDealTime().getTime() - result.get(i - 1).getDealTime().getTime();
                    result.get(i).setBurningTime(DateUtil.formatTime(buringTimeLong));
                } else {
                    result.get(i).setBurningTime("0分钟");
                }
            }
        }
        return ResultUtil.success(result);
    }

    public List<FdpFaultDispatchTransferLogShowResp> FdpFaultDispatchTransferLogShowList(int dispatchOrderId) {

        List<FdpFaultDispatchTransferLog> sqlResult = fdpFaultDispatchTransferLogMapper.show(dispatchOrderId);

        List<FdpFaultDispatchTransferLogShowResp> result = new ArrayList<FdpFaultDispatchTransferLogShowResp>();

        for (FdpFaultDispatchTransferLog item : sqlResult) {
            FdpFaultDispatchTransferLogShowResp outItem = new FdpFaultDispatchTransferLogShowResp();

            outItem.setTransferType(item.getTransferType()); //转移类型0采购转发1派工转发

            outItem.setTransferTime(item.getTransferTime());

            if (item.getOrgDealPersonId() == null || item.getOrgDealPersonId() == 0) {
                String name = sysCompanyUsersMapper.selectByPrimaryKey(item.getNewDealPersonId()).getNickname();
                outItem.setInfo("【" + name + "】  接收派工本");
            } else {
                String oldName = sysCompanyUsersMapper.selectByPrimaryKey(item.getOrgDealPersonId()).getNickname();
                String newName = sysCompanyUsersMapper.selectByPrimaryKey(item.getNewDealPersonId()).getNickname();

                outItem.setInfo("【" + oldName + "】  转给   【" + newName + "】");
            }
            result.add(outItem);
        }

        return result;
    }
}
