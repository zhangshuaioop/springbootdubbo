package com.baojufeng.cloudfeign.hystrix;

import com.baojufeng.cloudfeign.client.RocketMqMicroService;
import com.baojufeng.cloudfeign.client.UserMicroService;
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
public class HystrixClientFallback implements RocketMqMicroService,UserMicroService {

    @Override
    public Result producer() {

        return ResultUtil.error(ResultEnum.MICRO_SERVICE_ERROR.getCode(),"RocketMq"+ResultEnum.MICRO_SERVICE_ERROR.getMsg());
    }

    @Override
    public Result findPage(User user) {
        return ResultUtil.error(ResultEnum.MICRO_SERVICE_ERROR.getCode(),"User"+ResultEnum.MICRO_SERVICE_ERROR.getMsg());
    }
}