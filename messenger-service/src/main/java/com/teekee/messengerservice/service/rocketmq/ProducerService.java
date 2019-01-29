package com.teekee.messengerservice.service.rocketmq;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyun.openservices.ons.api.SendResult;
import com.aliyun.openservices.ons.api.order.OrderProducer;
import com.teekee.messengerservice.entity.redo.TrcRedoLog;
import com.teekee.messengerservice.enums.ResultEnum;
import com.teekee.messengerservice.service.redo.TrcRedoLogService;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @description: MQ发送者
 * @author: zhangshuai
 * @create: 2018-10-24 17:19
 */
@Service
public class ProducerService {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private TrcRedoLogService trcRedoLogService;

    //阿里云配置的topic
    @Value("${alibaba.topic}")
    private String topic;

    //AccessKey 阿里云身份验证
    @Value("${alibaba.accessKey}")
    private String accessKey;

    //SecretKey 阿里云身份验证
    @Value("${alibaba.secretKey}")
    private String secretKey;

    //设置 TCP 接入域名（此处以公共云生产环境为例）
    @Value("${alibaba.ONSAddr}")
    private String ONSAddr;

    /**
     * 发送者
     * @return
     */
    public Result producer(Map map){
        Properties properties = new Properties();
        // AccessKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.AccessKey, accessKey);
        // SecretKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, secretKey);
        // 设置 TCP 接入域名（此处以公共云生产环境为例）
        properties.put(PropertyKeyConst.ONSAddr,ONSAddr);

        //map转json字符串
        String jsonObjectStr = JSONObject.fromObject(map).toString();
        OrderProducer producer = null;
        try {
         producer = ONSFactory.createOrderProducer(properties);
        // 在发送消息前，必须调用 start 方法来启动 Producer，只需调用一次即可。
        producer.start();



        for (int i = 0; i < 1; i++) {
            String orderId = UUID.randomUUID().toString();
            Message msg = new Message(//
                    // Message 所属的 Topic
                    topic,
                    // Message Tag, 可理解为 Gmail 中的标签，对消息进行再归类，方便 Consumer 指定过滤条件在 MQ 服务器过滤
                    "TagA",
                    // Message Body 可以是任何二进制形式的数据， MQ 不做任何干预，需要 Producer 与 Consumer 协商好一致的序列化和反序列化方式
                    jsonObjectStr.getBytes()
            );
            // 设置代表消息的业务关键属性，请尽可能全局唯一。
            // 以方便您在无法正常收到消息情况下，可通过 MQ 控制台查询消息并补发。
            // 注意：不设置也不会影响消息正常收发
            msg.setKey(orderId);
            // 分区顺序消息中区分不同分区的关键字段，sharding key 于普通消息的 key 是完全不同的概念。
            // 全局顺序消息，该字段可以设置为任意非空字符串。
            String shardingKey = String.valueOf(orderId);

                SendResult sendResult = producer.send(msg, shardingKey);
                // 发送消息，只要不抛异常就是成功
                if (sendResult != null) {
                    logger.info(new Date() + " 发送mq消息成功. Topic为:" + msg.getTopic() + " msgId is: " + sendResult.getMessageId());
                    return  ResultUtil.success();
                }

            }

        }
            catch (Exception e) {
            // 消息发送失败，需要进行重试处理，可重新发送这条消息或持久化这条数据进行补偿处理
            logger.info("发送mq消息失败，进入redo日志表，待处理状态");
            TrcRedoLog trcRedoLog = new TrcRedoLog();
            trcRedoLog.setMessageId(map.get("messageId").toString());
            trcRedoLog.setRequestBody(jsonObjectStr);
            trcRedoLog.setRequestUrl("producerService/producer");
            List<TrcRedoLog> list = trcRedoLogService.findAll(trcRedoLog);
            if(list.size()==0){
                trcRedoLogService.save(trcRedoLog);
            }
            e.printStackTrace();
            return  ResultUtil.error(ResultEnum.SEND_MQ_ERROR.getCode(),ResultEnum.SEND_MQ_ERROR.getMsg());
        }
            producer.shutdown();

        return  ResultUtil.success();
    }





}
