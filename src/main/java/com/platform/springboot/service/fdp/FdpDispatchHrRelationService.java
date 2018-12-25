package com.platform.springboot.service.fdp;

import com.platform.springboot.entity.fdp.FdpDispatchJobPerformance;
import com.platform.springboot.entity.fdp.GetFdpFaultDispatchHrRelationShowRequest;
import com.platform.springboot.entity.fdp.GetFdpJobPerformanceVoice;
import com.platform.springboot.mapper.fdp.FdpDispatchJobPerformanceMapper;
import com.platform.springboot.mapper.fdp.FdpFaultDispatchHrRelationMapper;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import com.platform.springboot.mapper.fdp.FdpDispatchJobPerformanceMapper;
import com.platform.springboot.mapper.fdp.FdpFaultDispatchHrRelationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghao
 * @Title: FdpDispatchHrRelationService
 * @ProjectName WaterDrop
 * @Description: 派工流程
 * @date 2018/12/22上午11:27
 */
@Service
public class FdpDispatchHrRelationService {

    @Resource
    FdpFaultDispatchHrRelationMapper fdpFaultDispatchHrRelationMapper;

    @Resource
    private FdpDispatchJobPerformanceMapper jobPerformanceMapper;

    public Result profileLogShow(Integer dispatchOrderId) {
        //查询之前是否上传完工资料
        GetFdpFaultDispatchHrRelationShowRequest result = fdpFaultDispatchHrRelationMapper.selectConfirmFile(dispatchOrderId);

        List<FdpDispatchJobPerformance> logList = jobPerformanceMapper.selectFirstVersionByOrderId(dispatchOrderId);

        List<FdpDispatchJobPerformance> logNewList = jobPerformanceMapper.selectNewVersionByOrderId(dispatchOrderId);

        for (FdpDispatchJobPerformance str :logList) {
            for (FdpDispatchJobPerformance str2:logNewList) {
                if(str2.getJobStepDescription().equals(str.getJobStepDescription())){
                    str.setWorkConditionPhoto(str2.getWorkConditionPhoto());
                    str.setWorkConditionPhotoName(str2.getWorkConditionPhotoName());
                    str.setJobPerformanceDescription(str2.getJobPerformanceDescription());
                    str.setFlagUsed(true);
                    if(null != str2.getVoiceLogUrl() && !str2.getVoiceLogUrl().equals("")){
                        String[] voiceUrl = str2.getVoiceLogUrl().split(";");
                        String[] voiceLong = str2.getVoiceLogLength().split(";");
                        String[] voiceTime =  str2.getVoiceLogTime().split(";");
                        GetFdpJobPerformanceVoice voice;
                        List<GetFdpJobPerformanceVoice> voiceList = new ArrayList<GetFdpJobPerformanceVoice>();
                        if(voiceUrl.length > 0){
                            for(int i = 0 ; i < voiceUrl.length ; i++){
                                voice = new GetFdpJobPerformanceVoice();
                                voice.setVoiceLogUrl(voiceUrl[i]);
                                voice.setVoiceLogLength(voiceLong[i]);
                                voice.setVoiceLogTime(voiceTime[i]);
                                voiceList.add(voice);
                            }
                            str.setVoiceList(voiceList);
                        }
                    }else{
                        str.setVoiceList(new ArrayList<GetFdpJobPerformanceVoice>());
                    }
                }
            }
        }
        if(result!=null){
            result.setJobPerformances(logList);
            return ResultUtil.success(result);
        }
        return ResultUtil.success(null);
    }
}
