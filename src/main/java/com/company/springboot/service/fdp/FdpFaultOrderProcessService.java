package com.company.springboot.service.fdp;

import com.company.springboot.entity.dmi.DmiContact;
import com.company.springboot.entity.fdp.*;
import com.company.springboot.mapper.dmi.DmiContactMapper;
import com.company.springboot.mapper.fdp.*;
import com.company.springboot.utils.CurrentUtil;
import com.company.springboot.utils.PageInfo;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhanghao
 * @Title: FdpFaultOrderProcessService
 * @ProjectName WaterDrop
 * @Description: 报障工单
 * @date 2019/1/11上午10:21
 */
@Service
public class FdpFaultOrderProcessService {

    @Resource
    private FdpFaultOrderProcessMapper fdpFaultOrderProcessMapper;
    @Resource
    private FdpFaultOrderProcessLogMapper fdpFaultOrderProcessLogMapper;
    @Resource
    private FdpFaultReportInfoMapper fdpFaultReportInfoMapper;
    @Resource
    private FdpFaultOrderProcessTransferLogMapper fdpFaultOrderProcessTransferLogMapper;
    @Resource
    private DmiContactMapper dmiContactMapper;
    @Resource
    private FdpFaultOrderRelatedDeviceService fdpFaultOrderRelatedDeviceService;
    @Resource
    private FdpFaultOrderRelatedCommProductMapper fdpFaultOrderRelatedCommProductMapper;
    @Resource
    private FdpFaultOrderRelatedDeviceMapper fdpFaultOrderRelatedDeviceMapper;
    @Resource
    private FdpFaultOrderRelatedCommProductService fdpFaultOrderRelatedCommProductService;

    public Result getFaultOrderListByObject(GetFaultOrderListRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        Page<GetFaultOrderList> result = fdpFaultOrderProcessMapper.queryFaultOrderListByObject(request);
        PageInfo<GetFaultOrderList> pageInfo = new PageInfo<>(result);
        if(pageInfo.getList()==null||pageInfo.getList().size()==0){
            pageInfo.setPageNum(1);
            pageInfo.setPageSize(10);
        }
        for (GetFaultOrderList list : pageInfo.getList()) {
            if (list.getDealpersonId() == CurrentUtil.getCurrent().getId()) {
                list.setFlagUserself(true);
            } else {
                list.setFlagUserself(false);
            }
        }
        return ResultUtil.success(pageInfo);
    }

    public Result getFaultOrderListByRootId(Integer rootId) {

        List<GetFaultOrderList> orderLists = fdpFaultOrderProcessMapper.getFaultOrderListByRootId(rootId);
        for (GetFaultOrderList item : orderLists) {
            //判断是否派工
            if (item.getRequestId() == null || item.getRequestId() == 0) {
                item.setFlagUserself(false);
            } else {
                //客服创建人与当前用户是否一致
                if (item.getCreatePerson() == CurrentUtil.getCurrent().getId()) {
                    item.setFlagUserself(true);
                } else {
                    item.setFlagUserself(false);
                }
            }

        }
        return ResultUtil.success(orderLists);
    }

    public Result show(Integer id) {
        FdpFaultOrderProcess process = fdpFaultOrderProcessMapper.showProcess(id);
        if (process != null && process.getResponsesType() != null) {
            if (process.getResponsesType().equals("4HOURS")) {
                process.setResponsesType("4小时");
            } else if (process.getResponsesType().equals("24HOURS")) {
                process.setResponsesType("24小时");
            } else if (process.getResponsesType().equals("48HOURS")) {
                process.setResponsesType("48小时");
            }
        }
        return ResultUtil.success(process);
    }

    public Result confirm(Integer id, Integer rootId) {
        Integer userId = CurrentUtil.getCurrent().getId();
        // 当前时间
        Date now = new Date();
        // 更新流程表状态
        FdpFaultOrderProcess process = new FdpFaultOrderProcess();
        process.setId(id);
        process.setUpdatePerson(userId);
        process.setUpdateTime(now);
        process.setFaultInfoConfirmTime(now);
        process.setOpearteStatus("FAULTCONFIRMED");
        fdpFaultOrderProcessMapper.updateByPrimaryKeySelective(process);

        // 流程日志
        FdpFaultOrderProcessLog processLog = new FdpFaultOrderProcessLog();
        processLog.setFaultOrderProcessId(id);
        processLog.setTitle("FAULTCONFIRMED");
        processLog.setMemo("故障已确认");
        processLog.setProcessTime(now);
        processLog.setProcessPersonId(userId);
        processLog.setFlagConsole(true);
        processLog.setRootId(rootId);
        fdpFaultOrderProcessLogMapper.insertSelective(processLog);

        return ResultUtil.success();
    }

    public Result cancel(FdpFaultOrderProcess process) {

        Integer userId = CurrentUtil.getCurrent().getId();
        // 当前时间
        Date now = new Date();
        // 更新流程表状态
        process.setUpdatePerson(userId);
        process.setUpdateTime(now);
        process.setOpearteStatus("CANCEL");
        process.setCancelReason(process.getCancelReason());
        fdpFaultOrderProcessMapper.updateByPrimaryKeySelective(process);

        // 流程日志
        FdpFaultOrderProcessLog processLog = new FdpFaultOrderProcessLog();
        processLog.setFaultOrderProcessId(process.getId());
        processLog.setTitle("CANCEL");
        processLog.setMemo("已取消");
        processLog.setProcessTime(now);
        processLog.setProcessPersonId(userId);
        processLog.setFlagConsole(true);
        fdpFaultOrderProcessLogMapper.insertSelective(processLog);
        return ResultUtil.success();
    }

    public Result showFaultInfo(Integer id) {

        FdpFaultOrderProcess fdpFaultOrderProcess = fdpFaultOrderProcessMapper.selectByPrimaryKey(id);
        FdpFaultReportInfo faultReportInfo;

        if (fdpFaultOrderProcess.getSourceReportId() != null && fdpFaultOrderProcess.getSourceReportId() != 0) {
            faultReportInfo = fdpFaultReportInfoMapper.selectByPrimaryKey(fdpFaultOrderProcess.getSourceReportId());

            if (faultReportInfo != null && faultReportInfo.getId() != null && faultReportInfo.getId() != 0) {
                return ResultUtil.success(faultReportInfo);
            }
        }
        return ResultUtil.success(fdpFaultOrderProcess);
    }

    public Result deleteProcessById(HashMap<String, Object> reqJsonMap) {

        if (reqJsonMap != null && reqJsonMap.get("id") != null) {
            reqJsonMap.put("idList", reqJsonMap.get("id"));
            reqJsonMap.put("updatePerson", CurrentUtil.getCurrent().getId());
            reqJsonMap.put("flagDeleted", true);
            fdpFaultOrderProcessMapper.deleteProcessById(reqJsonMap);
            return ResultUtil.success();
        } else {
            return ResultUtil.errorBusinessMsg("数据错误");
        }
    }

    public Result updateBelongPersonId(HashMap<String, Object> reqJsonMap) {
        if (reqJsonMap != null && reqJsonMap.get("id") != null) {
            reqJsonMap.put("belongPersonId", new Integer(reqJsonMap.get("dealPersonId").toString()));
            reqJsonMap.put("idList", reqJsonMap.get("id"));
            Integer userId = CurrentUtil.getCurrent().getId();
            Date now = new Date();
            reqJsonMap.put("updatePerson", userId);
            reqJsonMap.put("updateTime", now);
            List<Map<String, Object>> list = fdpFaultOrderProcessMapper.selectOrgDealPersonId(reqJsonMap);
            fdpFaultOrderProcessMapper.updateBelongPersonIdByUserId(reqJsonMap);

            for (Map processMap : list) {
                HashMap mapStransfer = new HashMap<String, Object>();
                mapStransfer.put("transferTime", now);
                mapStransfer.put("transferPersonId", userId);
                if (processMap.get("orgDealPersonId").equals("0")) {
                    return ResultUtil.errorBusinessMsg("请求参数有误");
                }
                if (reqJsonMap.get("belongPersonId").equals("0")) {
                    return ResultUtil.errorBusinessMsg("请求参数有误");
                }
                mapStransfer.put("newDealPersonId", reqJsonMap.get("dealPersonId"));
                mapStransfer.put("orgDealPersonId", processMap.get("belongPersonId"));
                mapStransfer.put("transferType", "BELONG");
                mapStransfer.put("faultOrderId", processMap.get("id"));
                fdpFaultOrderProcessTransferLogMapper.insertTransferLog(mapStransfer);
            }
            return ResultUtil.success();
        } else {
            return ResultUtil.errorBusinessMsg("数据错误");
        }

    }

    public Result updateDealPerson(HashMap<String, Object> reqJsonMap) {

        if (reqJsonMap != null && reqJsonMap.get("id") != null) {
            Integer userId = CurrentUtil.getCurrent().getId();
            reqJsonMap.put("dealPersonId", new Integer(reqJsonMap.get("dealPersonId").toString()));
            reqJsonMap.put("idList", reqJsonMap.get("id"));
            Date now = new Date();
            reqJsonMap.put("updatePerson", userId);
            reqJsonMap.put("updateTime", now);

            List<Map<String, Object>> list = fdpFaultOrderProcessMapper.selectOrgDealPersonId(reqJsonMap);

            fdpFaultOrderProcessMapper.updateByUserId(reqJsonMap);

            for (Map processMap : list) {
                HashMap mapStransfer = new HashMap<String, Object>();
                mapStransfer.put("transferTime", now);
                mapStransfer.put("transferPersonId", userId);
                mapStransfer.put("newDealPersonId", reqJsonMap.get("dealPersonId"));
                mapStransfer.put("orgDealPersonId", processMap.get("orgDealPersonId"));
                mapStransfer.put("faultOrderId", processMap.get("id"));
                mapStransfer.put("transferType", "DEAL");
                fdpFaultOrderProcessTransferLogMapper.insertTransferLog(mapStransfer);
            }
            return ResultUtil.success();
        } else {
            return ResultUtil.errorBusinessMsg("数据错误");
        }

    }

    public Result handle(FdpFaultOrderProcess process) {
        // 当前时间
        Date now = new Date();
        Integer userId = CurrentUtil.getCurrent().getId();
        if (process.getId() == null || process.getId() == 0) {
            return handleFaultReport(process, userId, now);
        } else {
            if (process.getFaultType() == null) {
                process.setFaultType("");
            }
            // 编辑
            DmiContact con = dmiContactMapper.selectByNameMobile(process);
            if (con == null) {
                // 新增联系人
                DmiContact contact = new DmiContact();
                contact.setContactName(process.getContactName());
                contact.setMobile(process.getMobile());
                contact.setFlagAvailable(true);
                contact.setFlagDeleted(false);
                contact.setBelongCompanyId(process.getCompanyId());
                contact.setSourceType("FAULT");
                contact.setCreateTime(now);
                contact.setUpdateTime(now);
                contact.setCreatePerson(userId);
                contact.setUpdatePerson(userId);
                contact.setStoreId(process.getStoreId() + "");
                dmiContactMapper.insertSelective(contact);

                process.setUpdatePerson(userId);
                process.setUpdateTime(new Date());
                process.setTelephone(process.getMobile());
                process.setContactId(contact.getId());
                process.setInputType(process.getInputType());
                fdpFaultOrderProcessMapper.updateByPrimaryKeySelective(process);
            } else {
                process.setUpdatePerson(userId);
                process.setUpdateTime(new Date());
                process.setTelephone(process.getMobile());
                process.setInputType(process.getInputType());
                process.setContactId(con.getId());
                fdpFaultOrderProcessMapper.updateByPrimaryKeySelective(process);
                fdpFaultOrderRelatedCommProductService.updateProductParm(process, userId);
                //编辑设备
                FdpFaultOrderRelatedDevice device = new FdpFaultOrderRelatedDevice();
                device.setFaultOrderProcessId(process.getId());
                device.setStoreId(process.getStoreId());
                device.setDevice(process.getDevice());
                fdpFaultOrderRelatedDeviceService.updateByProcessId(device, userId);
            }

            return ResultUtil.success();

        }
    }

    private Result handleFaultReport(FdpFaultOrderProcess record, int userId, Date now) {

        if (record.getContactName() == null || record.getMobile() == null) {
            return ResultUtil.errorBusinessMsg("请填写姓名和手机号");
        }
        // 获取联系人Id
        SelectContactExistInStore selectContactExistInStore = new SelectContactExistInStore();
        selectContactExistInStore.setContactName(record.getContactName());
        selectContactExistInStore.setStoreId(record.getStoreId());
        selectContactExistInStore.setMobile(record.getMobile());
        SelectExistInStoreResp existInStoreResp = dmiContactMapper.selectExistInStore(selectContactExistInStore);
        // 需要新增联系人
        if (existInStoreResp == null) {
            // 新增联系人
            DmiContact contact = new DmiContact();
            contact.setContactName(record.getContactName());
            contact.setMobile(record.getMobile());
            contact.setFlagAvailable(true);
            contact.setFlagDeleted(false);
            contact.setBelongCompanyId(record.getCompanyId());
            contact.setSourceType("FAULT");
            contact.setCreateTime(now);
            contact.setUpdateTime(now);
            contact.setCreatePerson(userId);
            contact.setUpdatePerson(userId);
            contact.setStoreId(record.getStoreId() + "");
            dmiContactMapper.insertSelective(contact);
            record.setStoreId(record.getStoreId());
            record.setCompanyId(record.getCompanyId());
            record.setContactId(contact.getId());
        } else {
            record.setContactId(existInStoreResp.getContactId());
        }

        // 新增报障流程
        record.setOpearteStatus("NEW");
        record.setFlagDeleted(false);
        record.setFlagAvailable(true);
        record.setFlagSimilarFault(false);
        record.setSimilarFaultId(0);
        record.setFinalCost(BigDecimal.ZERO);
        record.setMonetaryUnit(" ");
        record.setFlagDispatchRequest(false);
        record.setOtherFaultDevices("2222");
        record.setFlagLastOrder(true);
        record.setFlagFirstOrder(true);
        record.setFlagHasMultiple(false);
        record.setCreateTime(now);
        record.setUpdateTime(now);
        record.setFlagUserAssm(false);
        record.setFlagClientAssm(false);
        record.setUpdatePerson(userId);
        record.setCreatePerson(userId);
        record.setSourceReportId(record.getId());
        record.setSortId(1);
        record.setBelongPersonId(userId);
        record.setDealPersonId(userId);
        record.setInputType(record.getInputType());
        record.setTelephone(record.getMobile());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String str = sdf.format(date);
        str = str.substring(2, str.length());

        record.setFaultOrderNumber("GZ" + "_" + str + "_" + getRandom());
        record.setFaultType(record.getFaultType());
        fdpFaultOrderProcessMapper.insertSelective(record);

        FdpFaultOrderProcess setRootId = new FdpFaultOrderProcess();
        setRootId.setRootId(record.getId());
        setRootId.setId(record.getId());
        fdpFaultOrderProcessMapper.updateRootId(setRootId);

        //判断是否选中线路
        if (record.getProduct() != null) {

            List<FdpFaultOrderRelatedCommProduct> product = record.getProduct();
            for (FdpFaultOrderRelatedCommProduct item : product
            ) {
                item.setFaultReportId(record.getSourceReportId());
                item.setFaultOrderProcessId(record.getId());
                item.setStoreId(record.getStoreId());
                item.setUpdatePerson(userId);
                item.setUpdateTime(new Date());
                item.setFlagDeleted(false);
                fdpFaultOrderRelatedCommProductMapper.insertSelective(item);
            }

        }
        //判断是否选中设备
        if (record.getDevice() != null) {
            List<FdpFaultOrderRelatedDevice> device = record.getDevice();
            for (FdpFaultOrderRelatedDevice item : device) {
                item.setFaultReportId(record.getSourceReportId());
                item.setFlagDeleted(false);
                item.setStoreId(record.getStoreId());
                item.setFaultOrderProcessId(record.getId());
                item.setUpdatePerson(userId);
                item.setUpdateTime(new Date());
                fdpFaultOrderRelatedDeviceMapper.insertSelective(item);
            }

        }

        // 新增报障日志
        FdpFaultOrderProcessLog processLog = new FdpFaultOrderProcessLog();
        processLog.setFaultOrderProcessId(record.getId());
        processLog.setTitle("NEW");
        processLog.setMemo("新增");
        processLog.setProcessTime(now);
        processLog.setFlagConsole(true);
        processLog.setProcessPersonId(userId);
        processLog.setRootId(record.getId());
        fdpFaultOrderProcessLogMapper.insertSelective(processLog);

        return ResultUtil.success();
    }

    private String getRandom() {

        String result = "";

        while (result.length() < 3) {
            String str = String.valueOf((int) (Math.random() * 10));
            if (result.indexOf(str) == -1) {
                result += str;
            }
        }
        return result;
    }
}
