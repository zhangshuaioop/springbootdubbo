package com.teekee.blackrockservice.service.fdp;

import com.teekee.commoncomponets.base.BaseService;
import com.teekee.blackrockservice.entity.fdp.*;
import com.teekee.blackrockservice.mapper.fdp.FdpDispatchCompleteProfileLogMapper;
import com.teekee.blackrockservice.mapper.fdp.FdpDispatchJobPerformanceMapper;
import com.teekee.blackrockservice.mapper.fdp.FdpFaultDispatchHrRelationMapper;
import com.teekee.blackrockservice.mapper.fdp.FdpFaultDispatchOrderMapper;
import com.teekee.blackrockservice.utils.ResponseMessage;
import com.teekee.blackrockservice.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Niting
 * @date 2018/11/3
 **/
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class FdpFaultDispatchOrderService extends BaseService<FdpFaultDispatchOrderMapper, FdpFaultDispatchOrder> {
    @Resource
    FdpFaultDispatchOrderMapper mapper;
    @Resource
    FdpFaultDispatchHrRelationMapper hrRelationMapper;
    @Resource
    FdpDispatchJobPerformanceMapper performanceMapper;
    @Resource
    private FdpDispatchCompleteProfileLogMapper profileLogMapper;
    /**
     * 接单状态数量统计
     * @return
     * @Author:Niting
     * @Date:2018/07/19
     */
    public List<GetDispatchOrderServiceStatusList> statusCollect(Integer id) {
        String[] status = {"NEEDHRCONFIRM","PENDING","PROCESSING","FINISH"};
        List<GetDispatchOrderServiceStatusList> result = new ArrayList<GetDispatchOrderServiceStatusList>();
        GetDispatchOrderServiceStatusList statusList ;
        FdpFaultDispatchOrder order = new FdpFaultDispatchOrder();
        for (String item : status){
            order.setId(id);
            order.setDispatchStatus(item);
            statusList = mapper.selectStatusCollect(order);
            if(statusList != null){
                if(statusList.getCount() == 0){
                    statusList.setStatus(item);
                }
                result.add(statusList);
            }
        }
        if(result.size() > 0){
            return result;
        }
        return new ArrayList<GetDispatchOrderServiceStatusList>();
    }



    /**
     * 工作内容显示
     * @Author:Niting
     * @Date:2018/11/07
     * @param orderId
     * @return
     */
    public FdpDispatchJobPerformanceList dispatchDescriptionList(Integer orderId) {

        FdpDispatchJobPerformanceList list = new FdpDispatchJobPerformanceList();

        //查询新增报账单时的工作内容
        List<FdpDispatchJobPerformance> logList = performanceMapper.selectFirstVersionByOrderId(orderId);
        //查询最新的工作内容
        List<FdpDispatchJobPerformance> logNewList = performanceMapper.selectNewVersionByOrderId(orderId);

        for (FdpDispatchJobPerformance str :logList
                ) {
            for (FdpDispatchJobPerformance str2:logNewList
                    ) {
                if(str2.getJobStepDescription().equals(str.getJobStepDescription())){
                    str.setWorkConditionPhoto(str2.getWorkConditionPhoto());
                    str.setWorkConditionPhotoName(str2.getWorkConditionPhotoName());
                    str.setJobPerformanceDescription(str2.getJobPerformanceDescription());
                    str.setVoiceLogUrl(str2.getVoiceLogUrl());
                    str.setVoiceLogLength(str2.getVoiceLogLength());
                    str.setVoiceLogTime(str2.getVoiceLogTime());
                    str.setFlagUsed(true);
                }
                if(str2.getJobPerformanceVersion()==str.getJobPerformanceVersion()){
                    str.setWorkConditionPhoto(str2.getWorkConditionPhoto());
                    str.setWorkConditionPhotoName(str2.getWorkConditionPhotoName());
                    str.setJobPerformanceDescription(str2.getJobPerformanceDescription());
                    str.setVoiceLogUrl(str2.getVoiceLogUrl());
                    str.setVoiceLogLength(str2.getVoiceLogLength());
                    str.setVoiceLogTime(str2.getVoiceLogTime());
                    str.setFlagUsed(false);
                }
            }
        }
        FdpFaultDispatchHrRelation hrRelation = hrRelationMapper.selectByOrderId(orderId);
        list.setJobPerformanceLists(logList);
        if(hrRelation != null){
            list.setMemo(hrRelation.getUserAssmMemo());
            list.setUserJobEndReason(hrRelation.getUserJobEndReason());
        }
        return list;
    }

    /**
     * 暂存工作内容
     * @param dispatchDescriptionList
     * @Author:Niting
     * @Date:2018/11/07
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage updateDispatchDescription(FdpDispatchJobPerformanceList dispatchDescriptionList) {
        int id = dispatchDescriptionList.getId();

        List<FdpDispatchJobPerformance> performanceList = performanceMapper.selectNewVersionByOrderId(id);

        //当需要修改的工作内容条数大于1 则 修改工作内容表
        if(dispatchDescriptionList.getJobPerformanceLists().size()>0){

            //先循环一次看照片数量是否大于9张
            for (FdpDispatchJobPerformance job: dispatchDescriptionList.getJobPerformanceLists()) {
                if(job.getWorkConditionPhoto() != null){
                    String[] sArray=job.getWorkConditionPhoto().split(";");
                    if(sArray.length>9){
                        return StringUtil.buildErrorRespMsg("照片数量大于9张！");
                    }
                }
            }
            //把之前的为最新的工作内容设为false
            performanceMapper.updateIsLastByOrderId(id);

            int i =1;
            FdpFaultDispatchOrder order = mapper.selectByPrimaryKey(id);

            for (FdpDispatchJobPerformance job: dispatchDescriptionList.getJobPerformanceLists()
                    ) {

                job.setDispatchOrderId(id);
                job.setDispatchRequestId(order.getFaultDispatchRequestId());
                job.setFlagIsLast(true);
                job.setJobStepIndex(i);
                job.setCreateTime(new Date());
                job.setJobPerformanceVersion(performanceList.get(0).getJobPerformanceVersion()+1);
                job.setId(0);
                performanceMapper.insertSelective(job);
                i++;
            }

            //修改备注
            FdpFaultDispatchHrRelation hrRelation = new FdpFaultDispatchHrRelation();
            hrRelation.setUserAssmMemo(dispatchDescriptionList.getMemo());
            hrRelation.setDispatchOrderId(id);
            hrRelationMapper.updateMemoById(hrRelation);

            return StringUtil.buildSuccessRespMsg("暂存成功！");
        }else {
            return StringUtil.buildErrorRespMsg("请选择工作内容后提交！");
        }


    }

    /**
     * 待完工资料查询
     * @return
     * @Author:Niting
     * @Date:2018/07/23
     */
    public GetFdpDispatchHrRelationFinishShow queryFinishShow(Integer orderId) {
        GetFdpDispatchHrRelationFinishShow result = mapper.queryFinishShow(orderId);
        if(result != null){
            return result;
        }
        return new GetFdpDispatchHrRelationFinishShow();
    }
    /**
     * 我已完成工作
     * @param dispatchDescriptionList
     * @Author:Liukan
     * @Date:2018/11/07
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage completeDescription(FdpDispatchJobPerformanceList dispatchDescriptionList, FdpFaultDispatchHrRelation hrRelation ) {

        int id = dispatchDescriptionList.getId();

        //调用暂存方法
        updateDispatchDescription(dispatchDescriptionList);

        //如果未完工原因不为空说明是已选择完成按钮
        if(hrRelation.getUserJobEndReason()!=null){
            //查询最终版本号
            int version = performanceMapper.selectVersionByOrderId(id);
            //更新完工时间
            hrRelation.setDispatchOrderId(id);
            hrRelation.setHrFinishServiceTime(new Date());
            hrRelation.setHrJobPerformanceVersion(version);
            hrRelation.setHrDispatchStatus("FINISH");
            hrRelationMapper.updateMemoById(hrRelation);
            //更新已完成
            updateFlagFinish(id);
            return  StringUtil.buildSuccessRespMsg("已提交完成工作");
        }

        //查询最新版本
        int version = performanceMapper.selectVersionByOrderId(id);
        //更新完工时间
        hrRelation.setDispatchOrderId(id);
        hrRelation.setHrFinishServiceTime(new Date());
        hrRelation.setId(id);
        hrRelation.setHrJobPerformanceVersion(version);
        hrRelation.setHrDispatchStatus("FINISH");
        hrRelationMapper.updateMemoById(hrRelation);
        //更新已完成
        updateFlagFinish(id);
        return StringUtil.buildSuccessRespMsg("已全部完成");
    }

    /**
     * 更新已完成
     * @Author:Niting
     * @Date:2018/11/07
     * @param id
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void updateFlagFinish(Integer id) {

        performanceMapper.updateFinishByOrderId(id);
    }
    /**
     * 提交完工资料
     * @return
     * @Author:Niting
     * @Date:2018/07/23
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage handleCompleteData(FdpFaultDispatchHrRelation param, Integer hrId) {
        Date now = new Date();
        if(param.getDispatchOrderId() != 0){
            param.setHrDispatchStatus("FILENEEDCONFIRM");
            int result = hrRelationMapper.updateByOrderId(param);

            //查询requestId
            FdpFaultDispatchOrder order = mapper.selectByPrimaryKey(param.getDispatchOrderId());

            //新增完工资料日志表
            FdpDispatchCompleteProfileLog log = new FdpDispatchCompleteProfileLog();
            log.setDispatchOrderId(param.getDispatchOrderId());
            log.setFaultDispatchRequestId(order.getFaultDispatchRequestId());
            log.setUserCompleteProfileFile(param.getUserCompleteProfileFile());
            log.setUserCompleteProfileFileName(param.getUserCompleteProfileFileName());
            if(param.getUserCompleteProfilePhoto() != null && param.getUserCompleteProfilePhoto().contains(";")){
                String[] photoList = param.getUserCompleteProfilePhoto().split(";");
                if(photoList.length > 9){
                    return StringUtil.buildErrorRespMsg("图片不能超过9张！");
                }
            }
            log.setUserCompleteProfilePhoto(param.getUserCompleteProfilePhoto());
            log.setUserCompleteProfilePhotoName(param.getUserCompleteProfilePhotoName());
            log.setCompleteProfileUserType("DISPATCH_HR");
            log.setCompleteProfileUserId(hrId);
            log.setCreateTime(now);
            profileLogMapper.insertSelective(log);
            if(result > 0){
                return StringUtil.buildSuccessRespMsg("提交完工资料成功！");
            }
            return StringUtil.buildErrorRespMsg("提交完工资料失败！");
        }
        return StringUtil.buildErrorRespMsg("提交完工资料失败！");
    }

    /**
     * 开始出发
     * @param id
     * @Author:Liukan
     * @Date:2018/07/24
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage orderStart(Integer id) {
        FdpFaultDispatchHrRelation hrRelation = new FdpFaultDispatchHrRelation();
        hrRelation.setHrStartOffTime(new Date());
        hrRelation.setDispatchOrderId(id);
        hrRelationMapper.updateMemoById(hrRelation);
        return StringUtil.buildSuccessRespMsg("开始出发");
    }

    /**
     * 工单详情
     * @param id
     * @return
     */
    public FdpFaultDispatchOrderList orderInfo(Integer id) {

        FdpFaultDispatchOrderList list = new FdpFaultDispatchOrderList();

        FdpFaultDispatchOrder order = mapper.selectByPrimaryKey(id);

        FdpFaultDispatchOrderInfo orderInfo = mapper.selectOrderById(id);
        list.setOrderInfo(orderInfo);

        if(order.getDispatchStatus().equals("COMPLETE")){
            //把已做完的工作内容设为ture
            list.setJobPerformanceList(dispatchDescriptionList(id));
            list.setHrRelation(hrRelationMapper.selectByOrderId(id));
            return list;
        }else{

            return list;
        }

    }

    /**
     * 开始处理
     * @Author:Liukan
     * @Date:2018/07/20
     * @param id
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage serviceStart(Integer id) {
        Date now = new Date();
        FdpFaultDispatchHrRelation hrRelation =new FdpFaultDispatchHrRelation();

        hrRelation.setDispatchOrderId(id);
        hrRelation.setHrDispatchStatus("PROCESSING");
        hrRelation.setHrStartServiceTime(now);
        hrRelationMapper.updateServiceStartByOrderId(hrRelation);

        ////修改order状态
        //FdpFaultDispatchOrder order = new FdpFaultDispatchOrder();
        //order.setDispatchStatus("PROCESSING");
        //order.setId(id);
        //order.setLastDealTime(now);
        //mapper.updateByPrimaryKeySelective(order);

        return StringUtil.buildSuccessRespMsg("已开始服务");
    }

    /**
     * 开始接单
     * @return
     * @Author:Niting
     * @Date:2018/11/11
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public ResponseMessage orderReceiving(Integer orderId) {
        Date now = new Date();

        if(orderId != 0){
            //更新接单时间
            FdpFaultDispatchHrRelation hrRelation = new FdpFaultDispatchHrRelation();
            hrRelation.setHrConfirmTime(now);
            hrRelation.setDispatchOrderId(orderId);
            hrRelation.setHrDispatchStatus("PENDING");
            hrRelationMapper.updateMemoById(hrRelation);

            return  StringUtil.buildSuccessRespMsg("您已确认接单！");
        }
        return StringUtil.buildErrorRespMsg("接单失败！");
    }

    /**
     * 查看流程历史记录
     * @return
     * @Author:Chenliwen
     * @Date:2018/12/24
     */
    public List<FdpDispatchJobPerformance> orderHistory(FdpDispatchJobPerformance jobPerformance) {
        List<FdpDispatchJobPerformance> list = new ArrayList<>();
        List<FdpDispatchJobPerformance> result = performanceMapper.selectHistory(jobPerformance);
        if(result != null){
            return result;
        }
        return list;
    }

    /**
     * 查看流程历史记录版本时间点
     * @return
     * @Author:Chenliwen
     * @Date:2018/12/24
     */
    public List<FdpDispatchJobPerformance> orderHistoryTime(int orderId) {
        List<FdpDispatchJobPerformance> list = new ArrayList<>();
        List<FdpDispatchJobPerformance> result = performanceMapper.selectHistoryTime(orderId);
        if(result != null){
            return result;
        }
        return list;
    }
}
