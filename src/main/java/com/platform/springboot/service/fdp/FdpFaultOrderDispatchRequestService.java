package com.platform.springboot.service.fdp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.entity.cfg.CfgDispatchRouteDetail;
import com.platform.springboot.entity.cfg.CfgDispatchWarningStatus;
import com.platform.springboot.entity.dmi.DmiStore;
import com.platform.springboot.entity.dmi.ret.dmiStore.ListRet;
import com.platform.springboot.entity.fdp.*;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.entity.sys.SysOperationMessage;
import com.platform.springboot.mapper.cfg.CfgDispatchRouteMapper;
import com.platform.springboot.mapper.cfg.CfgDispatchWarningStatusMapper;
import com.platform.springboot.mapper.dmi.DmiStoreMapper;
import com.platform.springboot.mapper.fdp.*;
import com.platform.springboot.mapper.sys.SysCompanyUsersMapper;
import com.platform.springboot.mapper.sys.SysOperationMessageMapper;
import com.platform.springboot.service.file.FileServiceImpl;
import com.platform.springboot.utils.*;
import com.platform.springboot.utils.ValiDateUtil;

import com.platform.springboot.mapper.fdp.*;
import com.platform.springboot.mapper.sys.SysCompanyUsersMapper;
import com.platform.springboot.mapper.sys.SysOperationMessageMapper;
import com.platform.springboot.service.file.FileServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zhanghao
 * @Title: FdpFaultOrderDispatchRequestService
 * @ProjectName WaterDrop
 * @Description: 派工
 * @date 2018/12/20下午2:32
 */
@Service
public class FdpFaultOrderDispatchRequestService {

    @Resource
    private FdpFaultOrderDispatchRequestMapper fdpFaultOrderDispatchRequestMapper;
    @Resource
    private FdpFaultOrderProcessMapper processMapper;
    @Resource
    private FdpFaultOrderProcessLogMapper processLogMapper;
    @Resource
    private FdpDispatchJobContentMapper contentMapper;
    @Resource
    private FdpFaultDispatchOrderMapper orderMapper;
    @Resource
    private FdpDispatchRequestHistoryMapper fdpDispatchRequestHistoryMapper;
    @Resource
    private CfgDispatchRouteMapper cfgDispatchRouteMapper;
    @Resource
    private SysCompanyUsersMapper sysCompanyUsersMapper;
    @Resource
    private SysOperationMessageMapper sysOperationMessageMapper;
    @Resource
    private FdpDispatchProcessLogMapper fdpDispatchProcessLogMapper;
    @Resource
    private FdpFaultDispatchHrRelationMapper fdpFaultDispatchHrRelationMapper;
    @Resource
    private CfgDispatchWarningStatusMapper cfgDispatchWarningStatusMapper;
    @Resource
    private DmiStoreMapper dmiStoreMapper;
    @Resource
    private FileServiceImpl fileService;
    @Resource
    private FdpFaultDispatchTransferLogMapper fdpFaultDispatchTransferLogMapper;


    public Result handle(FdpFaultOrderDispatchRequest request) {

        SysCompanyUsers users = CurrentUtil.getCurrent();

        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }
        // 当前时间
        Date now = new Date();

        // 根据故障单id，查询故障单详情
        int processId = 0;
        //服务省份为空
        if (request.getServiceProvince() == null || request.getServiceProvince().equals("")) {
            return ResultUtil.validateError("请填写服务省份！");
        }
        //服务城市为空
        if (request.getServiceCity() == null || request.getServiceCity().equals("")) {
            return ResultUtil.validateError("请填写服务城市！");
        }
        //未选择模糊地址
        if (request.getFlagFuzzyAddress() == false) {
            //服务地址为空
            if (request.getServiceAddress() == null || request.getServiceAddress().equals("")) {
                return ResultUtil.validateError("请填写服务地址！");
            }
        }

        //期望回复时间为空
        if (request.getExpectReplyHours() == null) {
            //期望回复时间为空
            return ResultUtil.validateError("期望回复时间为空！");
        }

        if (request.getFlagFixedPrice() == true) {
            if (request.getEstimatedPrice() == null || request.getEstimatedPriceUnit() == null) {
                return ResultUtil.validateError("请填写参考价格！");
            }
        }

        if (request.getFaultOrderId() != null && request.getFaultOrderId() > 0) {
            processId = request.getFaultOrderId();

            FdpFaultOrderProcess processInfo = processMapper.selectByPrimaryKey(processId);

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
            processMapper.updateDispatchRequest(processRequest);

        }

        //是否存草稿
        if (request.getFlagDraft() == false) {
            request.setSubmitTime(now);
        }

        if (request.getId() == null || request.getId() == 0) {
            // 新增派单请求
            request.setFlagDeleted(false);
            request.setFlagAvailable(true);
            request.setCreatePerson(users.getId());
            request.setUpdateTime(now);
            request.setUpdatePerson(users.getId());
            request.setCreatePerson(users.getId());
            request.setCreateTime(now);
            request.setDispatchModelId(request.getDispatchModelId());
            request.setSourceType("SYS");
            request.setFlagHasDispatched(false);
            request.setExpectCompleteTime(request.getExpectCompleteTime());
            request.setOtherSystemNumber(request.getOtherSystemNumber());
            if (request.getExpectReplyHours() != null) {
                Calendar ca = Calendar.getInstance();
                ca.setTime(now);
                ca.add(Calendar.HOUR_OF_DAY, request.getExpectReplyHours());
                request.setExpectReplyTime(ca.getTime());
            }
            fdpFaultOrderDispatchRequestMapper.insertSelective(request);
            //创建新的dispatchOrder表
            newCreateDisptachOrder(request);

            return ResultUtil.success();

        } else {
            //编辑派工要求
            request.setUpdateTime(now);
            request.setFlagRequestModified(true);
            request.setSourceType("SYS");
            request.setCompleteProfileTemplateUpdatePerson(users.getId());
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

            orderMapper.updateDispatchOrderByRequestId(order);
        }

        if (request.getFlagDraft() != true) {
            //新增派工历史
            insertHistory(request, users.getId());
        }

        if (processId > 0) {
            // 更新流程表状态
            FdpFaultOrderProcess process = new FdpFaultOrderProcess();
            process.setId(processId);
            process.setUpdatePerson(users.getId());
            process.setUpdateTime(now);
            process.setOpearteStatus("DEALING");
            processMapper.updateByPrimaryKeySelective(process);

            //查询出process表中ID对应额RootId
            int processRootId = processMapper.selectRootId(processId);

            // 流程日志
            FdpFaultOrderProcessLog processLog = new FdpFaultOrderProcessLog();
            processLog.setFaultOrderProcessId(processId);
            processLog.setTitle("DEALING");
            processLog.setMemo("处理中");
            processLog.setProcessTime(now);
            processLog.setProcessPersonId(users.getId());
            processLog.setFlagConsole(true);
            processLog.setRootId(processRootId);
            processLogMapper.insertSelective(processLog);
        }
        return ResultUtil.success();
    }

    public Result newCreateDisptachOrder(FdpFaultOrderDispatchRequest fdpFaultOrderDispatchRequest) {

        Integer userId;
        String personsStr = "";
        CfgDispatchRouteDetail cfgDispatchRouteDetail = cfgDispatchRouteMapper.selectByPersons(fdpFaultOrderDispatchRequest);
        if (cfgDispatchRouteDetail != null) {
            if (fdpFaultOrderDispatchRequest.getExpectReplyHours() > 4) {
                //不急
                if (cfgDispatchRouteDetail.getNoEmergencyPerson() != null && cfgDispatchRouteDetail.getNoEmergencyPerson().length() > 0) {
                    String[] strList = cfgDispatchRouteDetail.getNoEmergencyPerson().split(",");
                    List<SysCompanyUsers> sysUsersList = sysCompanyUsersMapper.findPersonOpen(fdpFaultOrderDispatchRequest);
                    if (sysUsersList != null && sysUsersList.size() > 0) {
                        for (String str : strList) {
                            for (SysCompanyUsers sysUsers : sysUsersList) {
                                if (str.equals(sysUsers.getId().toString())) {
                                    personsStr += str + ",";
                                }
                            }
                        }
                        personsStr = personsStr.substring(0, personsStr.length() - 1);
                    }

                }

            } else {
                //急
                if (cfgDispatchRouteDetail.getEmergencyPerson() != null && cfgDispatchRouteDetail.getEmergencyPerson().length() > 0) {
                    String[] strList = cfgDispatchRouteDetail.getEmergencyPerson().split(",");
                    List<SysCompanyUsers> sysUsersList = sysCompanyUsersMapper.findPersonOpen(fdpFaultOrderDispatchRequest);
                    if (sysUsersList != null && sysUsersList.size() > 0) {
                        for (String str : strList) {
                            for (SysCompanyUsers sysUsers : sysUsersList) {
                                if (str.equals(sysUsers.getId().toString())) {
                                    personsStr += str + ",";
                                }
                            }
                        }
                        personsStr = personsStr.substring(0, personsStr.length() - 1);
                    }
                }
            }
        }

        if (personsStr != null && personsStr.length() > 0) {
            String[] persons = personsStr.split(",");
            int index = (int) (Math.random() * persons.length);
            userId = Integer.parseInt(persons[index]);

        } else {
            String defaultPersonsStr = cfgDispatchRouteMapper.selectByDefaultPerson();
            if (defaultPersonsStr != null && defaultPersonsStr.length() > 0) {
                String[] defaultPersons = defaultPersonsStr.split(",");
                int index = (int) (Math.random() * defaultPersons.length);
                userId = Integer.parseInt(defaultPersons[index]);
            } else {
                return ResultUtil.errorBusinessMsg("创建派工工单失败！没有设置默认配置！");
            }
        }

        FdpFaultDispatchOrder fdpFaultDispatchOrder = initDispatchOrder(fdpFaultOrderDispatchRequest, userId);
        //创建新的dispatchOrder表
        orderMapper.insertSelective(fdpFaultDispatchOrder);
        //生成新的消息
        selectMessageInfo(fdpFaultDispatchOrder.getId());
        //生成操作记录
        insertDispatchProcessLog(fdpFaultDispatchOrder.getId(), fdpFaultOrderDispatchRequest.getCreatePerson(), "DISPATCH", "", "NEW", "新增派工单", fdpFaultDispatchOrder.getLastDealTime());

        return ResultUtil.success();
    }

    /**
     * 新增派工单历史
     *
     * @param request
     * @return
     * @Author:Niting
     * @Date:2018/10/15
     */
    public Result insertHistory(FdpFaultOrderDispatchRequest request, Integer userId) {
        Date now = new Date();
        Integer version = fdpDispatchRequestHistoryMapper.selectMaxVersionByRequestId(request.getId());
        FdpFaultOrderDispatchRequest dispatchRequest = fdpFaultOrderDispatchRequestMapper.selectByPrimaryKey(request.getId());
        //新增派工历史表
        FdpDispatchRequestHistory history = new FdpDispatchRequestHistory();
        if (version == null) {
            history.setRequestVersionCode("1");
        } else {
            String verCode = String.valueOf(version + 1);
            history.setRequestVersionCode(verCode);
        }
        history.setRootRequestId(request.getId());
        history.setCompanyId(request.getCompanyId());
        history.setStoreId(request.getStoreId());
        history.setFaultOrderId(request.getFaultOrderId());
        history.setRootFaultOrderId(request.getRootFaultOrderId());
        history.setHrCount(request.getHrCount());
        history.setServiceAddress(request.getServiceAddress());
        history.setServiceProvince(request.getServiceProvince());
        history.setServiceCity(request.getServiceCity());
        history.setServiceDistrict(request.getServiceDistrict());
        history.setDispatchModelRequest(request.getDispatchModelRequest());
        history.setEquipmentRequest(request.getEquipmentRequest());
        history.setOtherRequest(request.getOtherRequest());
        history.setDispatchDescription(request.getDispatchDescription());
        history.setMemo(request.getMemo());
        history.setUrgencyRequest(request.getUrgencyRequest());
        history.setServiceDate(request.getServiceDate());
        history.setServiceTimeStart(request.getServiceTimeStart());
        history.setServiceTimeEnd(request.getServiceTimeEnd());
        history.setFlagDeleted(false);
        history.setFlagAvailable(true);
        history.setFlagHasDispatched(false);
        history.setOtherBrand(request.getOtherBrand());
        history.setOtherStore(request.getOtherStore());
        history.setLongitude(request.getLongitude());
        history.setLatitude(request.getLatitude());
        history.setSourceType(request.getSourceType());
        history.setCreatePerson(request.getCreatePerson());
        history.setCreateTime(request.getCreateTime());
        history.setUpdateTime(request.getUpdateTime());
        history.setUpdatePerson(request.getUpdatePerson());
        history.setUploadFileName(request.getUploadFileName());
        history.setUploadFileUrl(request.getUploadFileUrl());
        history.setDispatchModelId(request.getDispatchModelId());
        history.setBackupDeviceRequest(request.getBackupDeviceRequest());
        history.setExpectReplyHours(request.getExpectReplyHours());
        history.setExpectReplyTime(request.getExpectReplyTime());
        history.setExpectCompleteTime(request.getExpectReplyTime());
        history.setOtherSystemNumber(request.getOtherSystemNumber());
        history.setCreateHistoryPerson(userId);
        history.setCreateHistoryTime(now);
        if (dispatchRequest != null) {
            history.setCreateTime(dispatchRequest.getCreateTime());
            history.setCreatePerson(dispatchRequest.getCreatePerson());
        }
        fdpDispatchRequestHistoryMapper.insertSelective(history);

        int orderId = orderMapper.selectFaultOrderId(request.getId());

        if (orderId != 0) {
            //将工单之前的工作内容改为无效
            contentMapper.updateFlagIsLastByFaultOrderId(orderId);

            //新增派工任务表
            String[] description = request.getDispatchDescription().split(";");

            int i = 1;
            for (String string : description) {
                FdpDispatchJobContent content = new FdpDispatchJobContent();
                content.setDispatchRequestId(request.getId());
                content.setDispatchOrderId(orderId);
                content.setFlagIsLast(true);
                content.setCreateTime(now);
                content.setRequestHistoryId(history.getId());
                content.setJobDefineVersion(Integer.parseInt(history.getRequestVersionCode()));
                content.setJobStepIndex(i);
                content.setJobStepDescription(string);
                i++;
                contentMapper.insertSelective(content);
            }
        }
        return ResultUtil.success();
    }


    /**
     * 为每个派工工单设定基础值
     *
     * @param item
     * @param dealPersonId
     * @return 派工工单信息
     */
    private FdpFaultDispatchOrder initDispatchOrder(FdpFaultOrderDispatchRequest item, int dealPersonId) {

        Date date = new Date();
        FdpFaultDispatchOrder fdpFaultDispatchOrder = new FdpFaultDispatchOrder();
        fdpFaultDispatchOrder.setFaultDispatchRequestId(item.getId());
        fdpFaultDispatchOrder.setStoreId(item.getStoreId());
        fdpFaultDispatchOrder.setFaultOrderId(item.getFaultOrderId());
        fdpFaultDispatchOrder.setRootFaultOrderId(item.getRootFaultOrderId());
        fdpFaultDispatchOrder.setFlagAvailable(true);
        fdpFaultDispatchOrder.setHrCount(item.getHrCount());
        fdpFaultDispatchOrder.setFlagDeleted(false);
        fdpFaultDispatchOrder.setFlagFinish(false);
        fdpFaultDispatchOrder.setFlagPaid(false);
        fdpFaultDispatchOrder.setActualCost(BigDecimal.valueOf(-1));
        fdpFaultDispatchOrder.setActualMonetaryUnit("CNY");
        fdpFaultDispatchOrder.setActualPrice(BigDecimal.valueOf(-1));
        fdpFaultDispatchOrder.setActualPriceUnit("CNY");
        fdpFaultDispatchOrder.setActualInvoiceFee(BigDecimal.ZERO);
        fdpFaultDispatchOrder.setActualInvoiceRate(BigDecimal.ZERO);
        fdpFaultDispatchOrder.setFlagAutoCommit(item.isFlagAutoCommit());

        //新增附件 模版 名称 地址信息
        fdpFaultDispatchOrder.setUploadFileName(item.getUploadFileName());
        fdpFaultDispatchOrder.setUploadFileUrl(item.getUploadFileUrl());
        fdpFaultDispatchOrder.setCompleteProfileTemplateName(item.getCompleteProfileTemplateName());
        fdpFaultDispatchOrder.setCompleteProfileTemplateUrl(item.getCompleteProfileTemplateUrl());
        fdpFaultDispatchOrder.setBatchNumber(item.getBatchNumber());
        //是否为草稿
        if (item.getFlagDraft() == true) {
            fdpFaultDispatchOrder.setDispatchStatus("DRAFT");
            //派工单存草稿时 步骤为0
            fdpFaultDispatchOrder.setProcessStage("0");
        } else {
            fdpFaultDispatchOrder.setDispatchStatus("NEW");
            //新增派工单时 步骤为1
            fdpFaultDispatchOrder.setProcessStage("1");
        }

        fdpFaultDispatchOrder.setLastDealTime(date);
        SysCompanyUsers vendor = sysCompanyUsersMapper.selectVendorIdByCreatePersonId(item.getCreatePerson());

        if (!vendor.getActType().equals("DEMAND")) {
            fdpFaultDispatchOrder.setVendorId(vendor.getActObjectId());
            fdpFaultDispatchOrder.setCompanyId(item.getCompanyId());

        } else {
            fdpFaultDispatchOrder.setVendorId(-1);
            fdpFaultDispatchOrder.setCompanyId(vendor.getActObjectId());
        }
        fdpFaultDispatchOrder.setLastDealPersonId(dealPersonId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String str = sdf.format(date);
        str = str.substring(2, str.length());
        fdpFaultDispatchOrder.setDispatchOrderNumber("PG" + "_" + str + "_" + getRandom());
        return fdpFaultDispatchOrder;
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

    // 派工客服给采购推送消息
    public Result selectMessageInfo(Integer id) {

        FdpFaultDispatchOrder order = orderMapper.selectByPrimaryKey(id);

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

            insertMessage.setMessageObjId(0);
            insertMessage.setCreateTime(new Date());
            insertMessage.setFlagRead(false);
            sysOperationMessageMapper.insertSelective(insertMessage);
        }

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

    public Result profile(FdpFaultOrderDispatchRequest dispatchRequest) {
        FdpFaultDispatchOrder fdpFaultDispatchOrder = new FdpFaultDispatchOrder();
        fdpFaultDispatchOrder.setFaultDispatchRequestId(dispatchRequest.getId());
        fdpFaultDispatchOrder.setUploadFileName(dispatchRequest.getUploadFileName() != null ? dispatchRequest.getUploadFileName() : null);
        fdpFaultDispatchOrder.setUploadFileUrl(dispatchRequest.getUploadFileUrl() != null ? dispatchRequest.getUploadFileUrl() : null);
        fdpFaultDispatchOrder.setCompleteProfileTemplateName(dispatchRequest.getCompleteProfileTemplateName() != null ? dispatchRequest.getCompleteProfileTemplateName() : null);
        fdpFaultDispatchOrder.setCompleteProfileTemplateUrl(dispatchRequest.getCompleteProfileTemplateUrl() != null ? dispatchRequest.getCompleteProfileTemplateUrl() : null);
        if (orderMapper.updateDispatchOrderByRequestId(fdpFaultDispatchOrder) > 0) {
            return ResultUtil.success();
        }
        return ResultUtil.errorBusinessMsg("保存失败");

    }

    public Result show(Integer id) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }

        FdpFaultOrderDispatchRequestShow show = fdpFaultOrderDispatchRequestMapper.show(id);
        if (show != null) {
            FdpFaultDispatchHrRelation relation = fdpFaultDispatchHrRelationMapper.selectByRequestId(id);
            //是否安排派工
            if (relation != null) {
                show.setFlagNoHr(true);

                //采购是否评价
                if (relation.getUserAssmAchievePoint() != 0 && relation.getUserAssmCommunicationPoint() != 0 && relation.getUserAssmTimelyPoint() != 0) {
                    show.setFlagNoPoint(true);
                }
            }

            //点击查询更为已读
            setReadPurchase(id, users.getId());
        }
        return ResultUtil.success(show);
    }

    //点击已读
    public void setReadPurchase(Integer requestId, Integer userId) {

        FdpFaultDispatchOrder order = orderMapper.selectByRequestId(requestId);
        SysOperationMessage message = new SysOperationMessage();
        message.setUserId(userId);
        if (order != null) {
            message.setMessageObjCode(order.getDispatchOrderNumber());
        }
        message.setFlagRead(true);
        message.setReadTime(new Date());
        sysOperationMessageMapper.updateSetReadByUserIAndDispatchNumber(message);


    }

    public Result showDispatch(Integer id) {

        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }
        GetFdpFaultDispatchHrRelationShow show = fdpFaultDispatchHrRelationMapper.getDispatchHrShow(id);
        //点击查询更为已读
        //点击查询更为已读
        setReadPurchase(id, users.getId());

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

    public Result getFaultOrderRequestListByObject(ParamFdpFaultDispatchRequestQuery paramFdpFaultDispatchRequestQuery) {

        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }
        paramFdpFaultDispatchRequestQuery.setUserId(users.getId());
        paramFdpFaultDispatchRequestQuery.setActType(users.getActType());
        paramFdpFaultDispatchRequestQuery.setActObjectId(users.getActObjectId());
        PageHelper.startPage(paramFdpFaultDispatchRequestQuery.getPageNum(), paramFdpFaultDispatchRequestQuery.getPageSize());
        Page<FdpFaultDispatchOrderRequestForList> persons = fdpFaultOrderDispatchRequestMapper.selectByPrimaryByselect(paramFdpFaultDispatchRequestQuery);

        Iterator<FdpFaultDispatchOrderRequestForList> it = persons.getResult().iterator();
        while (it.hasNext()) {
            FdpFaultDispatchOrderRequestForList list = it.next();
            Integer workSchedule = 0;
            if (list.getFlagDraft()) {
                list.setWarningName("正常");
                list.setWarningColour("");
                list.setWorkSchedule(0);
            } else {
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
                    Date finish = list.getFinishTime();
                    nowDate = finish.getTime();
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
            }
            if (list.getUpdatePerson() == users.getId()) {
                list.setFlagUserself(true);
            } else {
                list.setFlagUserself(false);
            }
            if (paramFdpFaultDispatchRequestQuery.getWarningStatus() != null && !paramFdpFaultDispatchRequestQuery.getWarningStatus().equals("")) {
                if (!list.getWarningName().equals(paramFdpFaultDispatchRequestQuery.getWarningStatus())) {
                    it.remove();
                }
            }
        }
        return ResultUtil.success(persons);
    }

    public Result showNew(Integer id) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }
        //标记为已读
        setReadPurchase(id, users.getId());
        //返回信息
        return ResultUtil.success(fdpFaultOrderDispatchRequestMapper.selectByPrimaryKeyNew(id));
    }

    public Result selectApplyUser() {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }
        return ResultUtil.success(sysCompanyUsersMapper.selectApplyUser(users.getId()));
    }

    public Result uploadOrderExcel(CommonsMultipartFile file) {
        if (file == null) {
            return ResultUtil.errorBusinessMsg("文件不能为空;");
        }
        //获取文件的名字
        String originalFilename = file.getOriginalFilename();
        if (originalFilename.endsWith(".xls") && originalFilename.endsWith(".xlsx")) {
            return ResultUtil.errorBusinessMsg("文件格式错误;");
        }
        String fileName = System.currentTimeMillis() + ".xls";
        String filePath = ExcelUtil.getLocalFilePath() + fileName;
        File copyFile = new File(filePath);

        if (!copyFile.exists() && !copyFile.isDirectory()) {
            copyFile.mkdir();
        }
        try {
            file.transferTo(copyFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultUtil.errorBusinessMsg("系统保存时发生故障，请联系管理员;");
        }
        return ResultUtil.success(fileName);
    }

    public Result checkModelTitle(String fileName) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("fileName", fileName);
        try {
            //判断文件名称
            if (fileName == null || "".equals(fileName)) {
                return ResultUtil.errorBusinessMsg("文件不能为空;");
            }
            String filePath = ExcelUtil.getLocalFilePath() + fileName;
            File file = new File(filePath);
            //判断文件是否存在
            if (!file.exists() && !file.isDirectory()) {
                return ResultUtil.errorBusinessMsg("文件不存在;");
            }
            Workbook workbook;
            try {
                workbook = new XSSFWorkbook(new FileInputStream(file));
            } catch (Exception ex) {
                workbook = new XSSFWorkbook(new FileInputStream(file));
            }
            StringBuffer str = new StringBuffer();
            //获取第一张表
            Sheet sheet = workbook.getSheetAt(0);
            if (sheet == null) {
                return ResultUtil.errorBusinessMsg("表无效;");
            }
            //校验表头内容
            if (!sheet.getRow(0).getCell(0).getStringCellValue().contains("期望完工日期")) {
                str.append("第" + 1 + "张表头,第" + 1 + "列应为：期望完工日期;");
            }
            if (!sheet.getRow(0).getCell(1).getStringCellValue().contains("其他服务点")) {
                str.append("第" + 1 + "张表头,第" + 2 + "列应为：其他服务点/门店;");
            }
            if (!sheet.getRow(0).getCell(2).getStringCellValue().equals("省份")) {
                str.append("第" + 1 + "张表头,第" + 3 + "列应为：省份;");
            }
            if (!sheet.getRow(0).getCell(3).getStringCellValue().equals("城市")) {
                str.append("第" + 1 + "张表头,第" + 4 + "列应为：城市;");
            }
            if (!sheet.getRow(0).getCell(4).getStringCellValue().equals("行政区")) {
                str.append("第" + 1 + "张表头,第" + 5 + "列应为：行政区;");
            }
            if (!sheet.getRow(0).getCell(5).getStringCellValue().contains("地址")) {
                str.append("第" + 1 + "张表头,第" + 6 + "列应为：地址;");
            }

            if (!"".equals(str.toString())) {
                return ResultUtil.errorBusinessMsg(str.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.errorBusinessMsg("校验异常;");
        }
        return ResultUtil.success();
    }

    public Result checkExcelNumber(String fileName) {
        try {
            //判断文件名称
            if (fileName == null || "".equals(fileName)) {
                return ResultUtil.errorBusinessMsg("文件名不能为空;");
            }
            String filePath = ExcelUtil.getLocalFilePath() + fileName;
            File file = new File(filePath);
            //判断文件是否存在
            if (!file.exists() && !file.isDirectory()) {
                return ResultUtil.errorBusinessMsg("文件不存在;");
            }
            Workbook workbook;
            try {
                workbook = new XSSFWorkbook(new FileInputStream(file));
            } catch (Exception ex) {
                workbook = new XSSFWorkbook(new FileInputStream(file));
            }
            StringBuffer str = new StringBuffer();
            //获取第一张表
            Sheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            if (lastRowNum < 1) {
                str.append("第" + 1 + "张表,数据为空;");
            }
            if (!"".equals(str.toString())) {
                return ResultUtil.errorBusinessMsg(str.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.errorBusinessMsg("校验异常;");
        }
        return ResultUtil.success();
    }

    public Result checkExcel(FdpFaultOrderDispatchRequest dispatchRequest) {
        String fileName = dispatchRequest.getFileName();
        int result = 0;
        try {
            //判断文件名称
            if (fileName == null || "".equals(fileName)) {
                return ResultUtil.errorBusinessMsg("文件不能为空;");
            }
            String filePath = ExcelUtil.getLocalFilePath() + fileName;
            File file = new File(filePath);
            //判断文件是否存在
            if (!file.exists() && !file.isDirectory()) {
                return ResultUtil.errorBusinessMsg("文件不存在;");
            }
            Workbook workbook;
            try {
                workbook = new XSSFWorkbook(new FileInputStream(file));
            } catch (Exception ex) {
                workbook = new XSSFWorkbook(new FileInputStream(file));
            }
            //定义list存入地址
            List<String> address = new ArrayList<String>();
            StringBuffer str = new StringBuffer();

            Cache c = new Cache();
            c.setKey("check_" + fileName);
            c.setTimeOut(3600);
            c.setOutDate(DateUtil.addSeconds(new Date(), 1));
            CacheManager.putCache("check_" + fileName, c);

            String input = "";
            StringBuffer sdb = new StringBuffer();
            //读取省市区json文件
            ClassPathResource resource = new ClassPathResource("province.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            //读取文件内容
            while ((input = br.readLine()) != null) {
                sdb.append(input);
            }
            //将读取的数据转换为JSONObject
            JSONObject jsonObject = JSONObject.fromObject(sdb.toString());
            //获取所有省市区
            JSONArray Array = jsonObject.getJSONArray("list");

            //获取第一张表
            //获取一个sheet也就是一个工作簿
            Sheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            c.setCount(lastRowNum);
            //从第一行开始第一行一般是标题
            for (int j = 1; j <= lastRowNum; j++) {
                Row row = sheet.getRow(j);
                if (!ValiDateUtil.isRowEmpty(row)) {
                    //校验期望完工时间
                    if (dispatchRequest.getExpectCompleteTime() == null) {
                        if (row.getCell(0) == null || row.getCell(0).toString().trim().length() == 0) {
                            str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 1 + "列：期望完工日期不能同时为空;");
                        } else {
                            if (row.getCell(0).toString().trim().length() > 10 || ValiDateUtil.isValidDate(row.getCell(0).toString().trim()) == false) {
                                str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 1 + "列：期望完工日期格式错误;");
                            } else if (ValiDateUtil.isDateBefore(row.getCell(0).toString().trim()) == false) {
                                str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 1 + "列：期望完工日期不能早于当天;");
                            }
                        }
                    }
                    //校验excel其他服务点
                    if (row.getCell(1) != null && row.getCell(1).toString().trim().length() > 100) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 2 + "列：excel其他服务点长度不能超过100;");
                    }
                    //校验省
                    if (row.getCell(2) == null || row.getCell(2).toString().trim().length() == 0) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 3 + "列：省不能为空;");
                    } else if (row.getCell(2).toString().trim().length() > 100) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 3 + "列：省长度不能超过100;");
                    } else if (!Province.isProvince(Array, row.getCell(2).toString().trim())) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 3 + "列：省错误;");
                    }
                    //校验市
                    if (row.getCell(3) == null || row.getCell(3).toString().trim().length() == 0) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 4 + "列：市不能为空;");
                    } else if (row.getCell(3).toString().trim().length() > 100) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 4 + "列：市长度不能超过100;");
                    } else if (!Province.isCity(Array, row.getCell(2).toString().trim(), row.getCell(3).toString().trim())) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 4 + "列：市错误;");
                    }
                    //校验区
                    if (row.getCell(4) != null && row.getCell(4).toString().trim().length() > 100) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 5 + "列：区长度不能超过100;");
                    } else if (row.getCell(4) != null && row.getCell(4).toString().trim().length() > 0 && !Province.isArea(Array, row.getCell(2).toString().trim(), row.getCell(3).toString().trim(), row.getCell(4).toString().trim())) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 5 + "列：区错误;");
                    }
                    //校验地址
                    if (row.getCell(5) == null || row.getCell(5).toString().trim().length() == 0) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 6 + "列：地址不能为空;");
                    } else if (row.getCell(5).toString().trim().length() > 100 || row.getCell(5).toString().trim().length() < 5) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 6 + "列：地址长度为5-100字符;");
                    } else if (address.contains(row.getCell(5).toString().trim())) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 6 + "列：地址不能重复;");
                        //将地址存入list
                        address.add(row.getCell(5).toString());
                    }
                    result++;
                    c.setNewCount(result);
                }
            }
            if (!"".equals(str.toString())) {
                return ResultUtil.errorBusinessMsg(str.toString());

            }
        } catch (Exception e) {
            return ResultUtil.errorBusinessMsg("校验异常;");
        }
        return ResultUtil.success();
    }

    public Result storageExcel(FdpFaultOrderDispatchRequest dispatchRequest) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        String fileName = dispatchRequest.getFileName();
        String uuid = (System.currentTimeMillis()) + "" + ((int) ((Math.random() * 9 + 1) * 100000));
        int result = 0;
        try {
            String filePath = ExcelUtil.getLocalFilePath() + fileName;
            Workbook workbook;
            try {
                workbook = new XSSFWorkbook(new FileInputStream(new File(filePath)));
            } catch (Exception ex) {
                workbook = new XSSFWorkbook(new FileInputStream(new File(filePath)));
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            //定义list存入地址
            List<String> address = new ArrayList<String>();
            StringBuffer str = new StringBuffer();

            //定义缓存对象
            Cache c = new Cache();
            c.setKey(fileName);
            c.setTimeOut(3600);
            c.setOutDate(DateUtil.addSeconds(new Date(), 1));
            CacheManager.putCache(fileName, c);

            String input = "";
            StringBuffer sdb = new StringBuffer();
            //读取省市区json文件
            ClassPathResource resource = new ClassPathResource("province.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            //读取文件内容
            while ((input = br.readLine()) != null) {
                sdb.append(input);
            }
            //将读取的数据转换为JSONObject
            JSONObject jsonObject = JSONObject.fromObject(sdb.toString());
            //获取所有省市区
            JSONArray Array = jsonObject.getJSONArray("list");

            //获取一个sheet也就是一个工作簿
            Sheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            c.setCount(lastRowNum);
            //从第一行开始第一行一般是标题
            for (int j = 1; j <= lastRowNum; j++) {
                Row row = sheet.getRow(j);
                if (!ValiDateUtil.isRowEmpty(row)) {
                    //校验期望完工时间
                    if (dispatchRequest.getExpectCompleteTime() == null) {
                        if (row.getCell(0) == null || row.getCell(0).toString().trim().length() == 0) {
                            str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 1 + "列：期望完工日期不能同时为空;");
                        } else {
                            if (row.getCell(0).toString().trim().length() > 10 || ValiDateUtil.isValidDate(row.getCell(0).toString().trim()) == false) {
                                str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 1 + "列：期望完工日期格式错误;");
                            } else if (ValiDateUtil.isDateBefore(row.getCell(0).toString().trim()) == false) {
                                str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 1 + "列：期望完工日期不能早于当天;");
                            } else {
                                dispatchRequest.setExpectCompleteTime(sdf.parse(row.getCell(0).toString().trim()));
                            }
                        }
                    }
                    //校验excel其他服务点
                    if (row.getCell(1) != null && row.getCell(1).toString().trim().length() > 0) {
                        dispatchRequest.setOtherStore(row.getCell(1).toString().trim());
                    } else if (row.getCell(1) != null && row.getCell(1).toString().length() > 100) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 2 + "列：excel其他服务点长度不能超过100;");
                    }
                    //校验省
                    if (row.getCell(2) == null || row.getCell(2).toString().trim().length() == 0) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 3 + "列：省不能为空;");
                    } else if (row.getCell(2).toString().trim().length() > 100) {
                        str.append("第" + 1 + "张表,第" + j + "行,第" + 3 + "列：省长度不能超过100;");
                    } else if (!Province.isProvince(Array, row.getCell(2).toString().trim())) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 3 + "列：省错误;");
                    } else {
                        dispatchRequest.setServiceProvince(row.getCell(2).toString().trim());
                    }
                    //校验市
                    if (row.getCell(3) == null || row.getCell(3).toString().trim().length() == 0) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 4 + "列：市不能为空;");
                    } else if (row.getCell(3).toString().trim().length() > 100) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 4 + "列：市长度不能超过100;");
                    } else if (!Province.isCity(Array, row.getCell(2).toString().trim(), row.getCell(3).toString().trim())) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 4 + "列：市错误;");
                    } else {
                        dispatchRequest.setServiceCity(row.getCell(3).toString().trim());
                    }
                    //校验区
                    if (row.getCell(4) == null || row.getCell(4).toString().trim().length() == 0) {
                        dispatchRequest.setServiceDistrict("");
                    } else if (row.getCell(4).toString().trim().length() > 100) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 5 + "列：区长度不能超过100;");
                    } else if (!Province.isArea(Array, row.getCell(2).toString().trim(), row.getCell(3).toString().trim(), row.getCell(4).toString().trim())) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 5 + "列：区错误;");
                    } else {
                        dispatchRequest.setServiceDistrict(row.getCell(4).toString().trim());
                    }
                    //校验地址
                    if (row.getCell(5) == null || row.getCell(5).toString().trim().length() == 0) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 6 + "列：地址不能为空;");
                    } else if (row.getCell(5).toString().trim().length() > 100 || row.getCell(5).toString().trim().length() < 5) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 6 + "列：地址长度为5-100字符;");
                    } else if (address.contains(row.getCell(5).toString().trim())) {
                        str.append("第" + 1 + "张表,第" + (j + 1) + "行,第" + 6 + "列：地址不能重复;");
                        //将地址存入list
                        address.add(row.getCell(5).toString().trim());
                    } else {
                        dispatchRequest.setServiceAddress(row.getCell(5).toString().trim());
                    }

                    if ("".equals(str.toString())) {
                        //写入订单表
                        dispatchRequest.setBatchNumber(uuid);
                        handle(dispatchRequest);
                    }
                    result++;
                    c.setNewCount(result);
                }
            }

            if (!"".equals(str.toString())) {
                return ResultUtil.errorBusinessMsg(str.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.errorBusinessMsg("导入异常");
        }
        map.put("batchId", uuid);
        map.put("count", result);
        return ResultUtil.success(map);
    }

    public Result calculatedPercentage(String fileName) {
        Cache c = CacheManager.getCacheInfo(fileName);
        if (c != null) {
            Integer newCount = Integer.parseInt(c.getNewCount().toString());
            Integer count = Integer.parseInt(c.getCount().toString());
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(0);
            df.setMinimumFractionDigits(0);
            String k = df.format(newCount * 100 / count);
            return ResultUtil.success(k);
        } else {
            return ResultUtil.errorExceptionMsg("没有对象信息");
        }
    }

    public Result storeExport(Integer companyId) {
        DmiStore store = new DmiStore();
        store.setCompanyId(companyId);
        List<ListRet> sqlResult = dmiStoreMapper.selectStoreList(store);
        if (sqlResult == null || sqlResult.size() == 0) {
            return ResultUtil.errorExceptionMsg("无门店信息");
        }
        // 下载
        long fileName = System.currentTimeMillis();
        OutputStream out;
        try {
            File filepath = new File(ExcelUtil.getLocalFilePath());
            if (!filepath.exists()) {
                filepath.mkdir();
            }
            String sCurrPath = filepath + ExcelUtil.FILE_SEPARATOR + "EMPLOYEE_" + fileName + ".xls";
            out = new FileOutputStream(sCurrPath);
        } catch (FileNotFoundException e) {
            return ResultUtil.errorExceptionMsg("找不到默认保存文件的目录，请联系管理员!");
        }

        ExcelUtil.exportStoreExcel(sqlResult, out);
        File uploadFile = new File(ExcelUtil.getLocalFilePath() + ExcelUtil.FILE_SEPARATOR + "EMPLOYEE_" + fileName + ".xls");
        try {
            return fileService.upload(fileName + ".xls", new FileInputStream(uploadFile), "excel");
        } catch (FileNotFoundException e) {
            return ResultUtil.errorExceptionMsg("文件没有找到，请联系管理员！");
        }
    }

    public Result dispatchDownLoad(ParamFdpFaultDispatchRequestQuery paramFdpFaultDispatchRequestQuery) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        paramFdpFaultDispatchRequestQuery.setUserId(users.getId());
        paramFdpFaultDispatchRequestQuery.setActType(users.getActType());
        paramFdpFaultDispatchRequestQuery.setActObjectId(users.getActObjectId());
        List<FdpFaultDispatchOrderRequestForList> reqList = fdpFaultOrderDispatchRequestMapper.selectByPrimaryByselect(paramFdpFaultDispatchRequestQuery);
        //获取查询派工信息列表的派工工单集合
        List<String> orderNumber = new ArrayList<String>();
        for (FdpFaultDispatchOrderRequestForList orderListResp : reqList) {
            orderNumber.add(orderListResp.getDispatchOrderNumber());
        }

        File file = null;
        OutputStream os;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String currTime = sdf.format(date);
        String sCurrPath;
        try {
            //派工单临时文件存放路径
            file = new File(ExcelUtil.getLocalFilePath());
            if (!file.exists()) {
                file.mkdirs();
                System.out.println("临时文件夹创建成功");
            }
            List<FdpFaultDispatchOrderRequestForDownload> disOrderList = fdpFaultOrderDispatchRequestMapper.selectByOrderNumber(orderNumber);

            if (disOrderList.size() > 0) {
                //生成派工xls表
                sCurrPath = file.getPath() + ExcelUtil.FILE_SEPARATOR + "Dis_" + currTime + ".xls";
                os = new FileOutputStream(sCurrPath);
                ExcelUtil.exportDispatchExcel(disOrderList, os);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ResultUtil.errorExceptionMsg("文件没有找到，请联系管理员！");
        } catch (IOException e1) {
            e1.printStackTrace();
            return ResultUtil.errorExceptionMsg("程序异常！");
        }

        File uploadFile = new File(file.getPath()+ ExcelUtil.FILE_SEPARATOR + "Dis_" + currTime + ".xls");
        try {
            return fileService.upload(uploadFile.getName() , new FileInputStream(uploadFile), "excel");
        } catch (FileNotFoundException e) {
            return ResultUtil.errorExceptionMsg("文件没有找到，请联系管理员！");
        }

    }

    public Result dispatchForward(HashMap<String, Object> map) {
        SysCompanyUsers users = CurrentUtil.getCurrent();

        if (map.get("id") != null) {
            map.put("idList", map.get("id"));
        }

        Date now = new Date();
        //查询派工单原始人ID
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list = fdpFaultOrderDispatchRequestMapper.selectOldPersonId(map);
        fdpFaultOrderDispatchRequestMapper.dispatchTransmit(map);

        for (Map mapOldId : list) {
            Map mapStransfer = new HashMap<String, Object>();
            mapStransfer.put("transferTime", now);
            mapStransfer.put("transferPersonId", users.getId());
            if (mapOldId.get("lastDealPersonId").equals("0")) {
                return ResultUtil.validateError("");
            }
            if (map.get("newDealPersonId").equals("0")) {
                return ResultUtil.validateError("");
            }
            mapStransfer.put("orgDealPersonId", mapOldId.get("lastDealPersonId"));
            mapStransfer.put("newDealPersonId", map.get("newDealPersonId"));
            mapStransfer.put("dispatchOrderId", orderMapper.findOrderId(Integer.parseInt(mapOldId.get("id").toString())));
            mapStransfer.put("transferType",1);
            fdpFaultDispatchTransferLogMapper.insertDispatchTransferLog(mapStransfer);

            //生成新的消息
            int orderId = Integer.parseInt(String.valueOf(mapStransfer.get("dispatchOrderId")));
            int newDealPersonId = Integer.parseInt(String.valueOf(mapStransfer.get("newDealPersonId")));
            purchaseTransfer(orderId,newDealPersonId,users.getId());
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
        FdpFaultDispatchOrder order= orderMapper.selectByPrimaryKey(dispatchOrderId);
        SysOperationMessage insertMessage = new SysOperationMessage();
        //查询派工单是由谁创建的(传入dispatchRequest表的id)
        insertMessage.setUserId(newDealPersonId);
        insertMessage.setMessageObjCode(order.getDispatchOrderNumber());
        //查询转发人
        SysCompanyUsers users = sysCompanyUsersMapper.selectByPrimaryKey(userId);
        insertMessage.setMessageOperation("HR_PURCHASE_TRANSPOND");
        insertMessage.setContent("你有一条来自["+ users.getUsername()+"]转发的派工工单["+order.getDispatchOrderNumber() + "]需要尽快处理。");
        insertMessage.setMessageObjCode(order.getDispatchOrderNumber());

        SysOperationMessage message = new SysOperationMessage();
        Date now = new Date();
        message.setCreateTime(now);
        message.setFlagRead(false);
        sysOperationMessageMapper.insertSelective(message);
    }
}