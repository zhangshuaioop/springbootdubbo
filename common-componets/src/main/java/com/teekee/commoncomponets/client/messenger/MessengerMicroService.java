package com.teekee.commoncomponets.client.messenger;

import com.teekee.commoncomponets.entity.message.message.Sms;
import com.teekee.commoncomponets.entity.message.trc.TrcEmailLog;
import com.teekee.commoncomponets.hystrix.HystrixClientFallback;
import com.teekee.commoncomponets.utils.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 消息服务
 */
@FeignClient(name="messenger",fallback = HystrixClientFallback.class)
public interface MessengerMicroService {

    /**
     * 邮件发送服务
     * @param trcEmailLog
     * @return
     */
    @RequestMapping(value = "/email/sendEmail",method=RequestMethod.POST)
    Result sendEmail(@RequestBody TrcEmailLog trcEmailLog);


    /**
     * 短信发送服务
     * @param sms
     * @return
     */
    @RequestMapping(value = "/sms/sendSms",method=RequestMethod.POST)
    Result sendSms(@RequestBody Sms sms);

}
