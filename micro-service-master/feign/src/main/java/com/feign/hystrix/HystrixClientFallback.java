package com.feign.hystrix;

import com.feign.client.RocketMqMicroService;
import com.feign.client.UserMicroService;
import com.lovnx.commoncomponets.enums.ResultEnum;
import com.lovnx.commoncomponets.utils.Result;
import com.lovnx.commoncomponets.utils.ResultUtil;
import org.springframework.stereotype.Component;

/**
 * @description: 熔断器回调
 * @author: zhangshuai
 * @create: 2018-10-26 10:12
 */
@Component
public class HystrixClientFallback implements RocketMqMicroService,UserMicroService {

    @Override
    public Result producer() {

        return ResultUtil.error(ResultEnum.MICRO_SERVICE_ERROR.getCode(),"RocketMq"+ResultEnum.MICRO_SERVICE_ERROR.getMsg());
    }

    @Override
    public Result findById(Integer id) {

        return ResultUtil.error(ResultEnum.MICRO_SERVICE_ERROR.getCode(),"User"+ResultEnum.MICRO_SERVICE_ERROR.getMsg());
    }
}
