package com.example.messenger.service.template;

import com.baojufeng.commoncomponets.entity.message.trc.TrcEmailLog;
import org.springframework.stereotype.Service;

/**
 * @description: 邮件模板
 * @author: zhangshuai
 * @create: 2018-11-26 12:02
 */
@Service
public class EmailTemplateService {

    public TrcEmailLog emailTemplate(TrcEmailLog trcEmailLog){

        //客服
        if("KEFU".equals(trcEmailLog.getBusinessType())){
            trcEmailLog.setNickName("保聚风");
            trcEmailLog.setSubject("十一活动");
            trcEmailLog.setContext("客服你好:\n" +
                    "我是巴拉巴拉，\n" +
                    "谢谢");
        }else

        //用户
        if("CJPG".equals(trcEmailLog.getBusinessType())){
            trcEmailLog.setNickName("保聚风");
            trcEmailLog.setSubject("创建派工");
            trcEmailLog.setContext("用户你好:\n" +
                    "创建派工成功，请处理，\n" +
                    "谢谢");
        }else
        {
            trcEmailLog.setNickName("保聚风");
            trcEmailLog.setSubject("十一活动");
            trcEmailLog.setContext("默认邮箱模板:\n" +
                    "我是巴拉巴拉，\n" +
                    "谢谢");
        }

        return trcEmailLog;
    }
}
