package com.baojufeng.commoncomponets.hystrix;

import com.baojufeng.commoncomponets.client.UserMicroService;
import com.baojufeng.commoncomponets.client.messenger.MessengerMicroService;
import com.baojufeng.commoncomponets.entity.message.message.Sms;
import com.baojufeng.commoncomponets.entity.message.trc.TrcEmailLog;
import com.baojufeng.commoncomponets.entity.user.User;
import com.baojufeng.commoncomponets.enums.ResultEnum;
import com.baojufeng.commoncomponets.utils.Result;
import com.baojufeng.commoncomponets.utils.ResultUtil;
import org.springframework.stereotype.Component;

/**
 * @description: 熔断器回调
 * @author: zhangshuai
 * @create: 2018-10-26 10:12
 */
@Component
public class HystrixClientFallback implements UserMicroService,MessengerMicroService {


    /**
     * 用户基本服务
     * @param user
     * @return
     */
    @Override
    public Result findPage(User user) {
        return ResultUtil.error(ResultEnum.MICRO_SERVICE_ERROR.getCode(),"User"+ResultEnum.MICRO_SERVICE_ERROR.getMsg());
    }

    /**
     * 发送邮件服务
     * @param trcEmailLog
     * @return
     */
    @Override
    public Result sendEmail(TrcEmailLog trcEmailLog) {
        return ResultUtil.error(ResultEnum.MICRO_SERVICE_ERROR.getCode(),"发送邮件"+ResultEnum.MICRO_SERVICE_ERROR.getMsg());
    }

    /**
     * 发送短信服务
     * @param sms
     * @return
     */
    @Override
    public Result sendSms(Sms sms) {
        return ResultUtil.error(ResultEnum.MICRO_SERVICE_ERROR.getCode(),"发送短信"+ResultEnum.MICRO_SERVICE_ERROR.getMsg());
    }
}
