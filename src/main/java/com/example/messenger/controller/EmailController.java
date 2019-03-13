package com.example.messenger.controller;

import com.example.messenger.entity.trc.TrcEmailLog;
import com.example.messenger.enums.BusinessEnum;
import com.example.messenger.enums.ResultEnum;
import com.example.messenger.service.rocketmq.ProducerService;
import com.example.messenger.utils.RedisLockUp;
import com.example.messenger.utils.RedisUnLock;
import com.example.messenger.utils.Result;
import com.example.messenger.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 邮件
 * @author: zhangshuai
 * @create: 2018-11-12 16:30
 */
@Api(value = "EmailController", tags = "email-controller")
@RestController
@RequestMapping(value = "/email")
public class EmailController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private ProducerService producerService;

    @ApiOperation(
            value = "邮箱发送服务",
            notes = "邮箱发送服务",
            consumes = "application/json",
            responseReference = "com.example.messenger.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @PostMapping(value = "/sendEmail")
    public Result sendEmail(@RequestBody TrcEmailLog trcEmailLog) {

        // 从连接池中获取连接
        Jedis jedis = jedisPool.getResource();

        if(trcEmailLog == null || trcEmailLog.getBusinessType() == null || trcEmailLog.getBusinessType().length()<1 ||
                trcEmailLog.getMessageId() == null || trcEmailLog.getMessageId().length()<1 ||
                trcEmailLog.getEmails() == null || trcEmailLog.getEmails().length()<1 ){
            //关闭客户端
            jedis.close();
            logger.info("关闭客户端");
            return ResultUtil.error(ResultEnum.PARAMTER_ERROR.getCode(),ResultEnum.PARAMTER_ERROR.getMsg());
        }

        //请求标识
        String requestId = trcEmailLog.getMessageId();

        //key
        String lockKey = "sendEmail";

        try {
            //加锁
            Boolean lock = RedisLockUp.tryGetDistributedLock(jedis, lockKey,requestId , 10);

            if(lock){
                //加锁成功
                logger.info("加锁成功开始处理业务,key="+lockKey+",requestId="+requestId);


                //业务处理
                Map<String,Object> map = new HashMap<>();
                map.put("type",BusinessEnum.EMAIL.getType());
                map.put("object",trcEmailLog);
                map.put("messageId",trcEmailLog.getMessageId());
                logger.info("邮箱发送服务开始,入参:"+map.toString());
                Result result = producerService.producer(map);
                logger.info("邮箱发送服务结束,出参:"+result.toString());

            }else {
                //关闭客户端
                jedis.close();
                logger.info("关闭客户端");
                return ResultUtil.error(ResultEnum.JEDIS_LOCK_UP.getCode(),ResultEnum.JEDIS_LOCK_UP.getMsg());
            }

            logger.info("业务处理完成开始解锁");
            //解锁
            RedisUnLock.releaseDistributedLock(jedis, lockKey, requestId);

        } catch (JedisConnectionException e) {

            //关闭客户端
            jedis.close();
            logger.info("关闭客户端");
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.MICRO_SERVICE_ERROR.getCode(),ResultEnum.MICRO_SERVICE_ERROR.getMsg());
        }
        //关闭客户端
        jedis.close();
        logger.info("关闭客户端");
        return ResultUtil.success();
    }

}
