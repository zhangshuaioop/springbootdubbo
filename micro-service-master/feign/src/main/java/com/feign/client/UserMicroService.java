package com.feign.client;

import com.feign.hystrix.HystrixClientFallback;
import com.lovnx.commoncomponets.entity.user.User;
import com.lovnx.commoncomponets.utils.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户基本服务
 */
@FeignClient(name="service-user",fallback = HystrixClientFallback.class)
public interface UserMicroService {

    /**
     * 用户分页查询
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/findPage",method=RequestMethod.POST)
    Result findPage(@RequestBody User user);
}
