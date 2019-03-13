package com.example.messenger.service.template;

import com.example.messenger.entity.message.Sms;
import org.springframework.stereotype.Service;

/**
 * @description: 短信模板
 * @author: zhangshuai
 * @create: 2018-11-26 12:47
 */
@Service
public class SmsTemplateService {

    public Sms smsTemplate(Sms sms){

        //客服
        if("YZM".equals(sms.getBusinessType())){
            sms.setContent("验证码："+sms.getCode()+"，验证码5分钟内有效，如非本人操作请忽略，谢谢。");
        }else

        //用户
        if("YH".equals(sms.getBusinessType())){
            sms.setContent("用户你好:\n" +
                    "我是巴拉巴拉，\n" +
                    "谢谢");
        }else

            //默认
        {
            sms.setContent("默认短信模板:\n" +
                    "我是巴拉巴拉，\n" +
                    "谢谢");
        }

        return sms;
    }



}
