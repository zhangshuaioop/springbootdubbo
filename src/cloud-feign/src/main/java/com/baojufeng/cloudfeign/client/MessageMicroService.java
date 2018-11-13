package com.baojufeng.cloudfeign.client;

import com.baojufeng.cloudfeign.hystrix.HystrixClientFallback;
import com.baojufeng.commoncomponets.entity.message.Email;
import com.baojufeng.commoncomponets.utils.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 消息服务
 */
@FeignClient(name = "service-message",fallback = HystrixClientFallback.class)
public interface MessageMicroService {

    /**
     * 发送邮箱
     * @param email
     * @return
     */
    @RequestMapping(value = "/email/sendEmail",method=RequestMethod.POST)
    Result sendEmail(@RequestBody Email email);

}
