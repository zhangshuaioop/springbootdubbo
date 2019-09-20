//package com.example.messenger.controller;
//
//import com.baojufeng.commoncomponets.entity.message.message.Sms;
//import com.baojufeng.commoncomponets.enums.ResultEnum;
//import com.baojufeng.commoncomponets.utils.RedisLockUp;
//import com.baojufeng.commoncomponets.utils.RedisUnLock;
//import com.baojufeng.commoncomponets.utils.Result;
//import com.baojufeng.commoncomponets.utils.ResultUtil;
//import com.example.messenger.enums.BusinessEnum;
//import com.example.messenger.service.rocketmq.ProducerService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.exceptions.JedisConnectionException;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @description: 短信服务
// * @author: zhangshuai
// * @create: 2018-11-23 23:51
// */
//@Api(value = "SmsController", tags = "sms-controller")
//@RestController
//@RequestMapping(value = "/sms")
//public class SmsController {
//
//    private final Logger logger = Logger.getLogger(getClass());
//
//    @Autowired
//    private JedisPool jedisPool;
//
//    @Autowired
//    private ProducerService producerService;
//
//    @ApiOperation(
//            value = "短信发送服务",
//            notes = "短信发送服务",
//            consumes = "application/json",
//            responseReference = "com.example.messenger.utils.Result"
//    )
//    @SuppressWarnings("unchecked")
//    @PostMapping(value = "/sendSms")
//    public Result sendSms(@RequestBody Sms sms) {
//
//        // 从连接池中获取连接
//        Jedis jedis = jedisPool.getResource();
//
//        if(sms == null || sms.getBusinessType() == null || sms.getBusinessType().length()<1 ||
//                sms.getMessageId() == null || sms.getMessageId().length()<1 ||
//                sms.getMobile() == null || sms.getMobile().length()<1 ||
//                sms.getTrcSmsLogId() == null || sms.getTrcSmsLogId() == 0){
//            //关闭客户端
//            jedis.close();
//            logger.info("关闭客户端");
//            return ResultUtil.error(ResultEnum.PARAMTER_ERROR.getCode(),ResultEnum.PARAMTER_ERROR.getMsg());
//        }
//
//        String requestId = sms.getMessageId();
//
//        String lockKey = "sendSms";
//
//        try {
//            //加锁
//            Boolean lock = RedisLockUp.tryGetDistributedLock(jedis, lockKey,requestId , 10);
//
//            if(lock){
//                //加锁成功
//                logger.info("加锁成功开始处理业务,key="+lockKey+",requestId="+requestId);
//
//
//                //业务处理
//                Map<String,Object> map = new HashMap<>();
//                map.put("type",BusinessEnum.SMS.getType());
//                map.put("object",sms);
//                map.put("messageId",sms.getMessageId());
//                logger.info("短信发送服务开始,入参:"+map.toString());
//                Result result = producerService.producer(map);
//                logger.info("短信发送服务结束,出参:"+result.toString());
//
//            }else {
//                //关闭客户端
//                jedis.close();
//                logger.info("关闭客户端");
//                return ResultUtil.error(ResultEnum.JEDIS_LOCK_UP.getCode(),ResultEnum.JEDIS_LOCK_UP.getMsg());
//            }
//
//            logger.info("业务处理完成开始解锁");
//            //解锁
//            RedisUnLock.releaseDistributedLock(jedis, lockKey, requestId);
//
//        } catch (JedisConnectionException e) {
//
//            //关闭客户端
//            jedis.close();
//            logger.info("关闭客户端");
//            e.printStackTrace();
//            return ResultUtil.error(ResultEnum.MICRO_SERVICE_ERROR.getCode(),ResultEnum.MICRO_SERVICE_ERROR.getMsg());
//        }
//        //关闭客户端
//        jedis.close();
//        logger.info("关闭客户端");
//        return ResultUtil.success();
//    }
//
//}
