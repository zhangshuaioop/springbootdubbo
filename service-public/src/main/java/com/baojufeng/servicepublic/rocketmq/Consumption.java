package com.baojufeng.servicepublic.rocketmq;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyun.openservices.ons.api.order.ConsumeOrderContext;
import com.aliyun.openservices.ons.api.order.MessageOrderListener;
import com.aliyun.openservices.ons.api.order.OrderAction;
import com.aliyun.openservices.ons.api.order.OrderConsumer;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * @description: alibaba RocketMq消费者
 * @author: zhangshuai
 * @create: 2018-10-24 16:51
 */
//@Component
public class Consumption {

    //Consumer ID
    @Value("${alibaba.consumerId}")
    private String consumerId;

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
     * 消费者服务
     */
    @PostConstruct
    public void defaultMQPushConsumer() {
        Properties properties = new Properties();
        // 您在控制台创建的 Consumer ID
        properties.put(PropertyKeyConst.ConsumerId, consumerId);
        // AccessKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.AccessKey, accessKey);
        // SecretKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, secretKey);
        // 设置 TCP 接入域名（此处以公共云生产环境为例）
        properties.put(PropertyKeyConst.ONSAddr,ONSAddr);
        // 顺序消息消费失败进行重试前的等待时间，单位(毫秒)
        properties.put(PropertyKeyConst.SuspendTimeMillis, "100");
        // 消息消费失败时的最大重试次数
        properties.put(PropertyKeyConst.MaxReconsumeTimes, "20");
        // 在订阅消息前，必须调用 start 方法来启动 Consumer，只需调用一次即可。
        OrderConsumer consumer = ONSFactory.createOrderedConsumer(properties);
        consumer.start();

        consumer.subscribe(
                // Message 所属的 Topic
                "test-topics",
                // 订阅指定 Topic 下的 Tags：
                // 1. * 表示订阅所有消息
                // 2. TagA || TagB || TagC 表示订阅 TagA 或 TagB 或 TagC 的消息
                "TagA",
                new MessageOrderListener() {
                    /**
                     * 1. 消息消费处理失败或者处理出现异常，返回 OrderAction.Suspend<br>
                     * 2. 消息处理成功，返回 OrderAction.Success
                     */
                    @Override
                    public OrderAction consume(Message message, ConsumeOrderContext context) {
                        System.out.println("消费成功");
                        System.out.println(message);
                        return OrderAction.Success;
                    }
                });

        System.out.print("等待消息...");
    }


}
