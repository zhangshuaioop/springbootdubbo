package com.platform.springboot.service.fdp;


import com.github.pagehelper.PageHelper;

import com.platform.springboot.entity.fdp.*;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.mapper.fdp.FdpFaultDispatchOrderMapper;
import com.platform.springboot.mapper.fdp.FdpFaultOrderProcessMapper;
import com.platform.springboot.mapper.sys.SysCompanyUsersMapper;
import com.platform.springboot.service.file.FileServiceImpl;
import com.platform.springboot.utils.*;
import com.platform.springboot.mapper.fdp.FdpFaultDispatchOrderMapper;
import com.platform.springboot.mapper.fdp.FdpFaultOrderProcessMapper;
import com.platform.springboot.mapper.sys.SysCompanyUsersMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Chenliwen
 * @Date 2018/12/21 10:45
 **/
@Service
public class FdpFaultDispatchListService {

    @Resource
    private FdpFaultOrderProcessMapper processMapper;
    @Resource
    protected FileServiceImpl fileService;
    @Resource
    private SysCompanyUsersMapper sysCompanyUsersMapper;
    @Resource
    private FdpFaultDispatchOrderMapper orderMapper;

    public Result getProcessListByObject(ParamFdpProcessDetailed param) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        param.setUserId(user.getId());
        List<GetFdpProcessDetailedList> result = processMapper.getProcessListByObject (param);
        for(GetFdpProcessDetailedList item :result){
            //双方都确认完工
            if(item.getFlagFinish()==true){
                item.setUserCompleteTime(item.getLastDealTime());
            }
            if(item.getFlagFinish()==false ){//双方为确认完工
                item.setUserCompleteTime(item.getUserCompleteTime());
            }
            if(item.getLastDealTime()== null && item.getOpearteStatus().equals("COMPLETE")){//客服未派工直接确认完工
                item.setUpdateTime(item.getUpdateTime());
            }
            if(!item.getOpearteStatus().equals("COMPLETE")){
                item.setUpdateTime(null);
            }
        }
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<GetFdpProcessDetailedList> pageInfo = new PageInfo<>(result);
        return ResultUtil.success(pageInfo);
//        if(result.size() >0){
//            return ResultUtil.success(result);
//        }
//        return ResultUtil.success(list);
    }

    public Result processListDownload(ParamFdpProcessDetailed param) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String currTime = sdf.format(date);
        //查询客服工单清单
        List<GetFdpProcessDetailedList> detailedLists = getProcessListByObjectByDown(param,user.getId());
        File file = null;
        OutputStream os;
        try {
            file = new File("/usr/local/tempFile_xls");
            if (!file.exists()) {
                file.mkdirs();
                System.out.println("临时文件夹创建成功");
            }
            if (detailedLists.size() > 0) {
                //生成派工xls表
                String sCurrPath = file.getPath() + ExcelUtil.FILE_SEPARATOR + "ProcessList_" + currTime + ".xls";
                os = new FileOutputStream(sCurrPath);
                ExcelUtil.exportProcessListExcel(detailedLists, os);
            }

        } catch (FileNotFoundException e) {
            return ResultUtil.validateError("找不到默认保存文件的目录，请联系管理员！");
        }
        File uploadFile = new File(file.getPath()+ ExcelUtil.FILE_SEPARATOR + "ProcessList_" + currTime + ".xls");
        try {
            return fileService.upload(uploadFile.getName() , new FileInputStream(uploadFile), "excel");

        } catch (FileNotFoundException e) {
            return ResultUtil.validateError("文件没有找到，请联系管理员！");
        }
    }

    public List<GetFdpProcessDetailedList> getProcessListByObjectByDown(ParamFdpProcessDetailed param,int userId){
        param.setUserId(userId);
        List<GetFdpProcessDetailedList> result = processMapper.getProcessListByObject (param);
        //List<GetFdpProcessDetailedList> result = new ArrayList<GetFdpProcessDetailedList>();
        for(GetFdpProcessDetailedList item :result){
            //双方都确认完工
            if(item.getFlagFinish()==true){
                item.setUserCompleteTime(item.getLastDealTime());
            }
            if(item.getFlagFinish()==false ){//双方为确认完工
                item.setUserCompleteTime(item.getUserCompleteTime());
            }
            if(item.getLastDealTime()== null && item.getOpearteStatus().equals("COMPLETE")){//客服未派工直接确认完工
                item.setUpdateTime(item.getUpdateTime());
            }
            if(!item.getOpearteStatus().equals("COMPLETE")){
                item.setUpdateTime(null);
            }
        }
        if(result.size() >0){
            return result;
        }
        return new ArrayList<GetFdpProcessDetailedList>();
    }

    public Result getProcesscollectByObject(ParamFdpProcessDetailed param) {
        SysCompanyUsers user = CurrentUtil.getCurrent();

        GetFdpProcessCollectList result = new GetFdpProcessCollectList();
        param.setUserId(user.getId());
        GetFdpProcessCollectList collect;
        //获取本系统数量
        param.setSource("SYS");
        collect = processMapper.selectProcessCollect(param);
        result.setSysNum(collect.getProcessTotal());
        result.setProcessTotal(collect.getProcessTotal());
        //获取微信数量
        param.setSource("WECHAT");
        collect = processMapper.selectProcessCollect(param);
        result.setWechatNum(collect.getProcessTotal());
        //获取伯俊数量
        param.setSource("POS");
        collect = processMapper.selectProcessCollect(param);
        result.setPosNum(collect.getProcessTotal());
        //获取故障单总数量
        //param.setSource("process");
        //collect = processMapper.selectProcessCollect(param);
        //result.setProcessTotal(collect.getProcessTotal());
        //获取报账单总数量
        param.setSource("report");
        collect = processMapper.selectProcessCollect(param);
        result.setReportTotal(collect.getProcessTotal());
        //获取已完成数量以及完成预计与实际费用
        param.setStatus("COMPLETE");
        param.setSource(null);
        collect = processMapper.selectProcessCollect(param);
        result.setCompleteNum(collect.getProcessTotal());
        result.setActualPriceCompleteNum(collect.getActualPriceCompleteNum());
        result.setActualPriceUnit(collect.getActualPriceUnit());
        result.setEstimatedPriceCompleteNum(collect.getEstimatedPriceCompleteNum());
        result.setEstimatedPriceUnit(collect.getEstimatedPriceUnit());
        //获取未完成数量以及未完成预计与实际费用
        param.setStatus("UNCOMPLETE");
        collect = processMapper.selectProcessCollect(param);
        result.setUncompleteNum(collect.getProcessTotal());
        result.setActualPriceUncompleteNum(collect.getActualPriceCompleteNum());
        result.setActualPriceUnit(collect.getActualPriceUnit());
        result.setEstimatedPriceUncompleteNum(collect.getEstimatedPriceCompleteNum());
        result.setEstimatedPriceUnit(collect.getEstimatedPriceUnit());
        //获取取消数量
        param.setStatus("CANCEL");
        collect = processMapper.selectProcessCollect(param);
        result.setCancelNum(collect.getProcessTotal());
        List<GetFdpProcessCollectList> list = new ArrayList<GetFdpProcessCollectList>();
        //费用验证
        if (result.getActualPriceCompleteNum() == null) {
            result.setActualPriceCompleteNum("0");
            result.setActualPriceUnit("人民币");
        }
        if (result.getActualPriceUncompleteNum() == null) {
            result.setActualPriceUncompleteNum("0");
            result.setActualPriceUnit("人民币");
        }
        if (result.getEstimatedPriceCompleteNum() == null) {
            result.setEstimatedPriceCompleteNum("0");
            result.setEstimatedPriceUnit("人民币");
        }
        if (result.getEstimatedPriceUncompleteNum() == null) {
            result.setEstimatedPriceUncompleteNum("0");
            result.setEstimatedPriceUnit("人民币");
        }
        list.add(result);
        return ResultUtil.success(result);
    }

    public Result getProcessDealPersoncollectByObject(ParamFdpProcessDetailed param) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        param.setUserId(user.getId());
        List<GetBelongPersonCollerctList> dealPersonCollectLists = new ArrayList<GetBelongPersonCollerctList>();
        Integer number;
        List<GetBelongPersonCollerctList> result = new ArrayList<GetBelongPersonCollerctList>();
        param.setStatus(null);
        dealPersonCollectLists = processMapper.selectDealPersonList(param);
        for (GetBelongPersonCollerctList item : dealPersonCollectLists) {
            item.setBelongPersonTotal(item.getBelongPersonTotal());
            result.add(item);
            param.setStatus("COMPLETE");
            dealPersonCollectLists = processMapper.selectDealPersonList(param);
            for (GetBelongPersonCollerctList comlist : dealPersonCollectLists) {
                if(item.getBelongPersonId()==comlist.getBelongPersonId()){
                    number = comlist.getBelongPersonTotal();
                    item.setBelCompleteNum(number);
                }

            }
            param.setStatus("UNCOMPLETE");
            dealPersonCollectLists = processMapper.selectDealPersonList(param);
            for (GetBelongPersonCollerctList uncomlist : dealPersonCollectLists) {
                if(item.getBelongPersonId() == uncomlist.getBelongPersonId()){
                    number = uncomlist.getBelongPersonTotal();
                    item.setBelUncompleteNum(number);
                }

            }

        }
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<GetBelongPersonCollerctList> pageInfo = new PageInfo<>(result);
        return ResultUtil.success(pageInfo);
    }

    public Result getDemandcollectByObject(ParamFdpProcessDetailed param) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        param.setUserId(user.getId());
        List<GetDemandCollectList> demandCollectLists = new ArrayList<GetDemandCollectList>();
        Integer number;
        List<GetDemandCollectList> result = new ArrayList<GetDemandCollectList>();
        param.setStatus(null);
        demandCollectLists = processMapper.selectDemandList(param);
        for (GetDemandCollectList item : demandCollectLists) {
            item.setDemandTotal(item.getDemandTotal());
            result.add(item);
            param.setStatus("COMPLETE");
            demandCollectLists = processMapper.selectDemandList(param);
            for (GetDemandCollectList comlist : demandCollectLists) {
                if(item.getCompanyId()==comlist.getCompanyId()){
                    number = comlist.getDemandTotal();
                    item.setDemCompleteNum(number);
                }

            }
            param.setStatus("UNCOMPLETE");
            demandCollectLists = processMapper.selectDemandList(param);
            for (GetDemandCollectList uncomlist : demandCollectLists) {
                if(item.getCompanyId() == uncomlist.getCompanyId()){
                    number = uncomlist.getDemandTotal();
                    item.setDemUncompleteNum(number);
                }

            }

        }
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<GetDemandCollectList> pageInfo = new PageInfo<>(result);
        return ResultUtil.success(pageInfo);
    }

    public Result processCollectDown(ParamFdpProcessDetailed param) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String currTime = sdf.format(date);
        //查询客服工单汇总
        List<GetFdpProcessCollectList> collectLists = getProcesscollectByObjectByDown(param,user.getId());
        //查询客服工单雇主汇总
        List<GetDemandCollectList> demandCollectLists = getDemandcollectByObjectByDown(param,user.getId());
        //查询客服工单处理人汇总
        List<GetBelongPersonCollerctList> belongPersonCollerctLists =  getProcessDealPersoncollectByObjectByDown (param,user.getId());
        File file = null;
        OutputStream os;
        try {
            file = new File("/usr/local/tempFile_xls");
            if (!file.exists()) {
                file.mkdirs();
                System.out.println("临时文件夹创建成功");
            }
            if (collectLists.size() > 0 && demandCollectLists.size() >0 && belongPersonCollerctLists.size()>0) {
                //生成派工xls表
                String sCurrPath = file.getPath() + ExcelUtil.FILE_SEPARATOR + "ProcessColl_" + currTime + ".xls";
                os = new FileOutputStream(sCurrPath);
                ExcelUtil.exportProcessCollectExcel(collectLists,demandCollectLists,belongPersonCollerctLists, os);
            }

        } catch (FileNotFoundException e) {
            return ResultUtil.validateError("找不到默认保存文件的目录，请联系管理员！");
        }
        File uploadFile = new File(file.getPath()+ ExcelUtil.FILE_SEPARATOR + "ProcessColl_" + currTime + ".xls");
        try {
            return fileService.upload(uploadFile.getName() , new FileInputStream(uploadFile), "excel");

        } catch (FileNotFoundException e) {
            return ResultUtil.validateError("文件没有找到，请联系管理员！");
        }
    }

    public List<GetFdpProcessCollectList> getProcesscollectByObjectByDown (ParamFdpProcessDetailed param,int userId){
        GetFdpProcessCollectList result = new GetFdpProcessCollectList();
        param.setUserId(userId);
        GetFdpProcessCollectList collect;
        //获取本系统数量
        param.setSource("SYS");
        collect = processMapper.selectProcessCollect(param);
        result.setSysNum(collect.getProcessTotal());
        result.setProcessTotal(collect.getProcessTotal());
        //获取微信数量
        param.setSource("WECHAT");
        collect = processMapper.selectProcessCollect(param);
        result.setWechatNum(collect.getProcessTotal());
        //获取伯俊数量
        param.setSource("POS");
        collect = processMapper.selectProcessCollect(param);
        result.setPosNum(collect.getProcessTotal());
        //获取故障单总数量
        //param.setSource("process");
        //collect = processMapper.selectProcessCollect(param);
        //result.setProcessTotal(collect.getProcessTotal());
        //获取报账单总数量
        param.setSource("report");
        collect = processMapper.selectProcessCollect(param);
        result.setReportTotal(collect.getProcessTotal());
        //获取已完成数量以及完成预计与实际费用
        param.setStatus("COMPLETE");
        param.setSource(null);
        collect = processMapper.selectProcessCollect(param);
        result.setCompleteNum(collect.getProcessTotal());
        result.setActualPriceCompleteNum(collect.getActualPriceCompleteNum());
        result.setActualPriceUnit(collect.getActualPriceUnit());
        result.setEstimatedPriceCompleteNum(collect.getEstimatedPriceCompleteNum());
        result.setEstimatedPriceUnit(collect.getEstimatedPriceUnit());
        //获取未完成数量以及未完成预计与实际费用
        param.setStatus("UNCOMPLETE");
        collect = processMapper.selectProcessCollect(param);
        result.setUncompleteNum(collect.getProcessTotal());
        result.setActualPriceUncompleteNum(collect.getActualPriceCompleteNum());
        result.setActualPriceUnit(collect.getActualPriceUnit());
        result.setEstimatedPriceUncompleteNum(collect.getEstimatedPriceCompleteNum());
        result.setEstimatedPriceUnit(collect.getEstimatedPriceUnit());
        //获取取消数量
        param.setStatus("CANCEL");
        collect = processMapper.selectProcessCollect(param);
        result.setCancelNum(collect.getProcessTotal());
        List<GetFdpProcessCollectList> list = new ArrayList<GetFdpProcessCollectList>();
        //费用验证
        if (result.getActualPriceCompleteNum() == null) {
            result.setActualPriceCompleteNum("0");
            result.setActualPriceUnit("人民币");
        }
        if (result.getActualPriceUncompleteNum() == null) {
            result.setActualPriceUncompleteNum("0");
            result.setActualPriceUnit("人民币");
        }
        if (result.getEstimatedPriceCompleteNum() == null) {
            result.setEstimatedPriceCompleteNum("0");
            result.setEstimatedPriceUnit("人民币");
        }
        if (result.getEstimatedPriceUncompleteNum() == null) {
            result.setEstimatedPriceUncompleteNum("0");
            result.setEstimatedPriceUnit("人民币");
        }
        list.add(result);
        return list;
    }

    public List<GetDemandCollectList> getDemandcollectByObjectByDown (ParamFdpProcessDetailed param,int userId){
        param.setUserId(userId);
        List<GetDemandCollectList> demandCollectLists = new ArrayList<GetDemandCollectList>();
        Integer number;
        List<GetDemandCollectList> result = new ArrayList<GetDemandCollectList>();
        param.setStatus(null);
        demandCollectLists = processMapper.selectDemandList(param);
        for (GetDemandCollectList item : demandCollectLists) {
            item.setDemandTotal(item.getDemandTotal());
            result.add(item);
            param.setStatus("COMPLETE");
            demandCollectLists = processMapper.selectDemandList(param);
            for (GetDemandCollectList comlist : demandCollectLists) {
                if(item.getCompanyId()==comlist.getCompanyId()){
                    number = comlist.getDemandTotal();
                    item.setDemCompleteNum(number);
                }

            }
            param.setStatus("UNCOMPLETE");
            demandCollectLists = processMapper.selectDemandList(param);
            for (GetDemandCollectList uncomlist : demandCollectLists) {
                if(item.getCompanyId() == uncomlist.getCompanyId()){
                    number = uncomlist.getDemandTotal();
                    item.setDemUncompleteNum(number);
                }

            }

        }
        return result;
    }

    public List<GetBelongPersonCollerctList> getProcessDealPersoncollectByObjectByDown(ParamFdpProcessDetailed param, int userId) {
        param.setUserId(userId);
        List<GetBelongPersonCollerctList> dealPersonCollectLists = new ArrayList<GetBelongPersonCollerctList>();
        Integer number;
        List<GetBelongPersonCollerctList> result = new ArrayList<GetBelongPersonCollerctList>();
        param.setStatus(null);
        dealPersonCollectLists = processMapper.selectDealPersonList(param);
        for (GetBelongPersonCollerctList item : dealPersonCollectLists) {
            item.setBelongPersonTotal(item.getBelongPersonTotal());
            result.add(item);
            param.setStatus("COMPLETE");
            dealPersonCollectLists = processMapper.selectDealPersonList(param);
            for (GetBelongPersonCollerctList comlist : dealPersonCollectLists) {
                if(item.getBelongPersonId()==comlist.getBelongPersonId()){
                    number = comlist.getBelongPersonTotal();
                    item.setBelCompleteNum(number);
                }

            }
            param.setStatus("UNCOMPLETE");
            dealPersonCollectLists = processMapper.selectDealPersonList(param);
            for (GetBelongPersonCollerctList uncomlist : dealPersonCollectLists) {
                if(item.getBelongPersonId() == uncomlist.getBelongPersonId()){
                    number = uncomlist.getBelongPersonTotal();
                    item.setBelUncompleteNum(number);
                }

            }

        }
        return result;
    }

    public Result getFaultDispatchOrderRequestList(GetFaultDispatchRequestList getFaultDispatchRequestList) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        //查询派工清单
        List<FdpFaultdispatchRequestList> list = requestList(getFaultDispatchRequestList,user.getId());
        PageHelper.startPage(getFaultDispatchRequestList.getPageNum(), getFaultDispatchRequestList.getPageSize());
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<FdpFaultdispatchRequestList> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(pageInfo);

    }

    private List<FdpFaultdispatchRequestList> requestList(GetFaultDispatchRequestList getFaultDispatchRequestList, int userId) {

        SysCompanyUsers users = sysCompanyUsersMapper.selectByPrimaryKey(userId);
        if(users.getActType().equals("VENDOR")){
            getFaultDispatchRequestList.setVendorId(users.getActObjectId());
            List<FdpFaultdispatchRequestList> list = orderMapper.selectOrderList(getFaultDispatchRequestList);
            for (FdpFaultdispatchRequestList ll: list
            ) {
                JSONObject jsStr = JSONObject.fromObject(ll.getDispatchModelRequest());
                JSONArray device = JSONArray.fromObject(ll.getDeviceRequest());
                String dev ="";
                String devdev="";
                String devAll ="";

                for(int i = 0;i<device.size();i++){
                    jsStr = device.getJSONObject(i);
                    for(int j =0 ;j<jsStr.size();j++){
                        devdev = jsStr.getString(String.valueOf(j));
                        if(devdev==null||devdev.equals("")){
                            continue;
                        }
                        if(j==jsStr.size()-1){
                            dev = devdev;
                            devAll=devAll+dev;
                        }else {
                            dev = devdev + ",";
                            devAll = devAll + dev;
                        }
                    }

                    int indx = devAll.lastIndexOf(",");
                    if(indx!=-1){
                        devAll = devAll.substring(0,indx)+devAll.substring(indx+1,devAll.length());
                    }
                    devAll =devAll+";";
                    int indAll = devAll.lastIndexOf(";");
                    if(indAll!=-1){
                        devAll = devAll.substring(0,indAll)+devAll.substring(indAll+1,devAll.length());
                    }
                }

                ll.setDeviceRequest(devAll);
                if(ll.isFlagFinish()==true){
                    ll.setFinishTime(ll.getLastDealTime());

                }

            }

            return list;

        }
        if(users.getActType().equals("DEMAND")){
            getFaultDispatchRequestList.setVendorId(users.getActObjectId());
            List<FdpFaultdispatchRequestList> list = orderMapper.selectOrderListDemand(getFaultDispatchRequestList);
            return list;
        }
        else {  return new ArrayList<FdpFaultdispatchRequestList>();}
    }

    public Result exportFaultOrderRequestList(GetFaultDispatchRequestList getFaultDispatchRequestList) {

        SysCompanyUsers user = CurrentUtil.getCurrent();

        List<FdpFaultdispatchRequestList> list = requestList(getFaultDispatchRequestList,user.getId());

        // 下载
        long fileName = System.currentTimeMillis();
        OutputStream out;
        try {
            File filepath = new File("/usr/local/tempFile_xls/");
            if (!filepath.exists()) {
                filepath.mkdir();
            }
            String sCurrPath = filepath + ExcelUtil.FILE_SEPARATOR + "REQUESTLIST_" + fileName + ".xls";
            out = new FileOutputStream(sCurrPath);
        } catch (FileNotFoundException e) {
            return ResultUtil.validateError("找不到默认保存文件的目录，请联系管理员!");
        }

        ExcelUtil.exportRequestList(list, out);
        File uploadFile = new File("/usr/local/tempFile_xls/" + ExcelUtil.FILE_SEPARATOR + "REQUESTLIST_" + fileName + ".xls");
        try {
            return fileService.upload(fileName + ".xls", new FileInputStream(uploadFile), "excel");
        } catch (FileNotFoundException e) {
            return ResultUtil.validateError("文件没有找到，请联系管理员！");
        }

    }

    public Result getFaultOrderRequestCount(GetFaultDispatchRequestList getFaultDispatchRequestList) {

        SysCompanyUsers user = CurrentUtil.getCurrent();

        List<FaultOrderRequestCount> requestList = requestCountList(getFaultDispatchRequestList,user.getId());
        PageHelper.startPage(getFaultDispatchRequestList.getPageNum(), getFaultDispatchRequestList.getPageSize());
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<FaultOrderRequestCount> pageInfo = new PageInfo<>(requestList);
        return ResultUtil.success(pageInfo);
    }

    /**
     * （方法）查询派工汇总
     * @param getFaultDispatchRequestList
     * @param userId
     * @return
     * @Author Liukan
     * @Date 2018/06/24
     */
    private List<FaultOrderRequestCount> requestCountList(GetFaultDispatchRequestList getFaultDispatchRequestList, int userId) {

        SysCompanyUsers users = sysCompanyUsersMapper.selectByPrimaryKey(userId);

        getFaultDispatchRequestList.setVendorId(users.getActObjectId());
        getFaultDispatchRequestList.setActType(users.getActType());
        int count = orderMapper.selectRequestCount(getFaultDispatchRequestList);
        List<FaultOrderRequestCount> requestList = new ArrayList<FaultOrderRequestCount>();
        FaultOrderRequestCount requestCount = new FaultOrderRequestCount();
        requestCount.setRequestCountAll(count);
        getFaultDispatchRequestList.setDispatchStatus("COMPLETE");
        BigDecimal actual = BigDecimal.ZERO;
        BigDecimal estimate = BigDecimal.ZERO;
        BigDecimal actualUN = BigDecimal.ZERO;
        BigDecimal estimateUN = BigDecimal.ZERO;
        String actualUnit ="人民币";
        String estimateUnit ="人民币";
        FaultOrderRequestCount request = orderMapper.selectRequestCompletePrice(getFaultDispatchRequestList);

        if (request == null) {
            actual = BigDecimal.ZERO;
            estimate = BigDecimal.ZERO;
            actualUnit ="人民币";
            estimateUnit ="人民币";

        } else {
            if (request.getActualPriceComplete() == null) {
                actual = BigDecimal.ZERO;
            }else{
                actual = request.getActualPriceComplete();
            }
            if (request.getActualPriceUnit() == null) {
                actualUnit = "人民币";
            }else{
                actualUnit = request.getActualPriceUnit();
            }
            if (request.getEstimatedPriceComplete() == null) {
                estimate = BigDecimal.ZERO;
            }else {
                estimate =request.getEstimatedPriceComplete();
            }
            if (request.getEstimatedPriceUnit() == null) {
                estimateUnit ="人民币";
            }else {
                estimateUnit =request.getEstimatedPriceUnit();
            }
        }

        requestCount.setActualPriceUnit(actualUnit);
        requestCount.setEstimatedPriceUnit(estimateUnit);
        requestCount.setActualPriceComplete(actual);
        requestCount.setEstimatedPriceComplete(estimate);
        int countComplete = orderMapper.selectRequestCount(getFaultDispatchRequestList);
        requestCount.setRequestCountComplete(countComplete);

        getFaultDispatchRequestList.setDispatchStatus("UNCOMPLETE");
        int countUnComplete = orderMapper.selectRequestCount(getFaultDispatchRequestList);
        requestCount.setReqeustCountUncomplete(countUnComplete);
        FaultOrderRequestCount requestUn = orderMapper.selectRequestCompletePrice(getFaultDispatchRequestList);
        if (requestUn == null) {
            actualUN = BigDecimal.ZERO;
            estimateUN = BigDecimal.ZERO;

        }else {
            if (requestUn.getActualPriceComplete() == null) {
                actualUN = BigDecimal.ZERO;
            }else {
                actualUN =requestUn.getActualPriceComplete();
            }
            if (requestUn.getEstimatedPriceComplete() == null) {
                estimateUN = BigDecimal.ZERO;
            }else
            {
                estimateUN =requestUn.getEstimatedPriceComplete();
            }
        }
        requestCount.setActualPriceUncomplete(actualUN);
        requestCount.setEstimatedPriceUncomplete(estimateUN);

        getFaultDispatchRequestList.setDispatchStatus("CANCEL");
        int countRequestCancel = orderMapper.selectRequestCount(getFaultDispatchRequestList);
        requestCount.setRequestCountCancel(countRequestCancel);

        requestList.add(requestCount);
        return requestList;
    }

    public Result getFaultOrderRequestCountByDemand(GetFaultDispatchRequestList getFaultDispatchRequestList) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        List<FaultOrderRequestCountByCompany> listCompany =requestListCompany(getFaultDispatchRequestList,user.getId());
        PageHelper.startPage(getFaultDispatchRequestList.getPageNum(), getFaultDispatchRequestList.getPageSize());
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<FaultOrderRequestCountByCompany> pageInfo = new PageInfo<>(listCompany);
        return ResultUtil.success(pageInfo);
    }

    /**
     /**
     * （方法）派工雇主统计
     * @param getFaultDispatchRequestList
     * @param userId
     * @return
     */
    private List<FaultOrderRequestCountByCompany> requestListCompany(GetFaultDispatchRequestList getFaultDispatchRequestList, int userId) {
        SysCompanyUsers users = sysCompanyUsersMapper.selectByPrimaryKey(userId);

        getFaultDispatchRequestList.setVendorId(users.getActObjectId());
        getFaultDispatchRequestList.setActType(users.getActType());
        List<FaultOrderRequestCount> listAll = orderMapper.selectRequestByCompanyAll(getFaultDispatchRequestList);

        List<FaultOrderRequestCount> listComplete = orderMapper.selectRequestByCompanyComplete(getFaultDispatchRequestList);

        List<FaultOrderRequestCount> listUnComplete = orderMapper.selectRequestByCompanyUnComplete(getFaultDispatchRequestList);

        List<FaultOrderRequestCountByCompany> listCompany = new ArrayList<FaultOrderRequestCountByCompany>();


        for (FaultOrderRequestCount cc: listAll
        ) {
            FaultOrderRequestCountByCompany list = new FaultOrderRequestCountByCompany();
            list.setCompanyName(cc.getCompanyName());
            list.setAllCount(cc.getRequestCountAll());
            for ( FaultOrderRequestCount complete: listComplete
            ) {
                if(cc.getCompanyName().equals(complete.getCompanyName())){
                    list.setCompleteCount(complete.getRequestCountComplete());

                }
            }
            for(FaultOrderRequestCount unComplete :listUnComplete){

                if(cc.getCompanyName().equals(unComplete.getCompanyName())){
                    list.setUnCompleteCount(unComplete.getReqeustCountUncomplete());
                }
            }
            listCompany.add(list);
        }

        return listCompany;

    }

    public Result requestCountByCreatePerson(GetFaultDispatchRequestList getFaultDispatchRequestList) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        List<FaultOrderRequestCountByCompany> listCreatePerson = requestCountByPerson(getFaultDispatchRequestList,user.getId());
        PageHelper.startPage(getFaultDispatchRequestList.getPageNum(), getFaultDispatchRequestList.getPageSize());
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<FaultOrderRequestCountByCompany> pageInfo = new PageInfo<>(listCreatePerson);
        return ResultUtil.success(pageInfo);
    }

    /**
     * (方法)查询派工工单创建人统计
     * @param getFaultDispatchRequestList
     * @param userId
     * @return
     * @Author Liukan
     * @Date 2018/06/19
     */
    private List<FaultOrderRequestCountByCompany> requestCountByPerson(GetFaultDispatchRequestList getFaultDispatchRequestList, int userId) {

        SysCompanyUsers users = sysCompanyUsersMapper.selectByPrimaryKey(userId);

        getFaultDispatchRequestList.setVendorId(users.getActObjectId());
        getFaultDispatchRequestList.setActType(users.getActType());
        List<FaultOrderRequestCount> listAll = orderMapper.selectRequestByCreatePersonyAll(getFaultDispatchRequestList);

        List<FaultOrderRequestCount> listComplete = orderMapper.selectRequestByCreatePersonyComplete(getFaultDispatchRequestList);

        List<FaultOrderRequestCount> listUnComplete = orderMapper.selectRequestByCreatePersonyUnComplete(getFaultDispatchRequestList);

        List<FaultOrderRequestCountByCompany> listCreatePerson = new ArrayList<FaultOrderRequestCountByCompany>();


        for (FaultOrderRequestCount cc: listAll
        ) {
            FaultOrderRequestCountByCompany list = new FaultOrderRequestCountByCompany();
            list.setCompanyName(cc.getUsername());
            list.setAllCount(cc.getRequestCountAll());
            for ( FaultOrderRequestCount complete: listComplete
            ) {
                if(cc.getUsername().equals(complete.getUsername())){
                    list.setCompleteCount(complete.getRequestCountComplete());

                }
            }
            for(FaultOrderRequestCount unComplete :listUnComplete){

                if(cc.getUsername().equals(unComplete.getUsername())){
                    list.setUnCompleteCount(unComplete.getReqeustCountUncomplete());
                }
            }
            listCreatePerson.add(list);
        }

        return listCreatePerson;
    }

    public Result exportFaultOrderRequestCount(GetFaultDispatchRequestList getFaultDispatchRequestList) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        List<FaultOrderRequestCount> requestCountList = requestCountList(getFaultDispatchRequestList,user.getId());
        List<FaultOrderRequestCountByCompany> requestListCompany =requestListCompany(getFaultDispatchRequestList,user.getId());
        List<FaultOrderRequestCountByCompany> requestCountByPerson = requestCountByPerson(getFaultDispatchRequestList,user.getId());
        // 下载
        long fileName = System.currentTimeMillis();
        OutputStream out;
        try {
            File filepath = new File("/usr/local/tempFile_xls/");
            if (!filepath.exists()) {
                filepath.mkdir();
            }
            String sCurrPath = filepath + ExcelUtil.FILE_SEPARATOR + "REQUESTCOUNTLIST_" + fileName + ".xls";
            out = new FileOutputStream(sCurrPath);
        } catch (FileNotFoundException e) {
            return ResultUtil.validateError("找不到默认保存文件的目录，请联系管理员!");
        }

        ExcelUtil.exportRequestCountList(requestCountList,requestListCompany, requestCountByPerson,out);
        File uploadFile = new File("/usr/local/tempFile_xls/" + ExcelUtil.FILE_SEPARATOR + "REQUESTCOUNTLIST_" + fileName + ".xls");
        try {
            return fileService.upload(fileName + ".xls", new FileInputStream(uploadFile), "excel");
        } catch (FileNotFoundException e) {
            return ResultUtil.validateError("文件没有找到，请联系管理员！");
        }
    }
}
