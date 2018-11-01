package com.baojufeng.servicepublic.service;

import com.baojufeng.servicepublic.rocketmq.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 发送者
 * @author: zhangshuai
 * @create: 2018-10-24 17:19
 */
@Service
public class ProducerService {

    @Autowired
    private Producer producer;

    /**
     * 发送者
     * @return
     */
    public String producer(){
        return producer.producer();
    }

}
