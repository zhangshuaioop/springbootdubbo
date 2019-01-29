package com.teekee.blueoceanservice.service.bif;

import com.teekee.blueoceanservice.entity.bif.BifDispatchHrNegativeLog;
import com.teekee.blueoceanservice.entity.bif.BifDispatchHumanResource;
import com.teekee.blueoceanservice.entity.sysconsole.SysConsoleUsers;
import com.teekee.blueoceanservice.mapper.bif.BifDispatchHrNegativeLogMapper;
import com.teekee.blueoceanservice.mapper.bif.BifDispatchHumanResourceMapper;
import com.teekee.blueoceanservice.utils.CurrentUtil;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author Chenliwen
 * @Date 2019/1/3 14:08
 **/
@Service
public class BifDispatchHrNegativeLogService {

    @Resource
    private BifDispatchHrNegativeLogMapper mapper;
    @Resource
    private BifDispatchHumanResourceMapper humanResourceMapper;

    public Result handle(BifDispatchHrNegativeLog request) {

        SysConsoleUsers user = CurrentUtil.getCurrent();

        Date now = new Date();

        //新增负面评价
        request.setNegativeType("COMMUNICATION");
        request.setFlagDeleted(false);
        request.setCreateTime(now);
        request.setUpdateTime(now);
        request.setCreatePerson(user.getId());
        request.setUpdatePerson(user.getId());
        mapper.insertSelective(request);

        //查询该人员信息
        BifDispatchHumanResource hr = humanResourceMapper.selectByPrimaryKey(request.getHrId());
        if(hr != null){
            //修改人员信息
            BifDispatchHumanResource resource = new BifDispatchHumanResource();
            resource.setId(request.getHrId());
            resource.setContactAssessmentCount(hr.getContactAssessmentCount()+1);
            BigDecimal contactPoint =  hr.getContactAssmTotalPoint().multiply(new BigDecimal(0.9));
            resource.setContactAssmTotalPoint(contactPoint);
            //未派工不推荐人员
            if(hr.getDispatchSuccessfulCount()==0){
                resource.setUserEvaluatePoint(contactPoint.add(new BigDecimal(13)));
            }else{
                BigDecimal userPoint = hr.getUserAssmTimelyAvgPoint().add(hr.getUserAssmAchieveAvgPoint().add(hr.getUserAssmCommunicationAvgPoint()));
                resource.setUserEvaluatePoint(userPoint.add(contactPoint));
            } 
            humanResourceMapper.updateByPrimaryKeySelective(resource);
        }

        return ResultUtil.successMsg("负面评价信息已提交！");
    }
}
