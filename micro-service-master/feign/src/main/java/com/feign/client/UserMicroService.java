package com.feign.client;

import com.lovnx.commoncomponets.utils.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户基本服务
 */
@FeignClient(name="service-user")
public interface UserMicroService {

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    @RequestMapping("/user/findById")
    Result findById(@RequestParam("id") Integer id);
}
