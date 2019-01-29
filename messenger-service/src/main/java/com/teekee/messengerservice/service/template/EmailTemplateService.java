package com.teekee.messengerservice.service.template;

import com.teekee.messengerservice.entity.cfg.CfgMailTemplate;
import com.teekee.messengerservice.entity.trc.TrcEmailLog;
import com.teekee.messengerservice.mapper.cfg.CfgMailTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * @description: 邮件模板
 * @author: zhangshuai
 * @create: 2018-11-26 12:02
 */
@Service
public class EmailTemplateService {

    @Autowired
    private CfgMailTemplateMapper cfgMailTemplateMapper;

    public TrcEmailLog emailTemplate(TrcEmailLog trcEmailLog){


        CfgMailTemplate cfgMailTemplate = cfgMailTemplateMapper.selectByType(trcEmailLog.getBusinessType());
        trcEmailLog.setNickName("teekee系统");
        trcEmailLog.setSubject(cfgMailTemplate.getTitle());

        Map<String,Object> map = trcEmailLog.getParamMap();

        //map，value为null的值处理成空字符串
        Set<String> set = map.keySet();
        if(set != null && !set.isEmpty()) {
            for(String key : set) {
                if(map.get(key).equals("null")) { map.put(key, ""); }
            }
        }

        String content = "";
        String [] contentArr = cfgMailTemplate.getContent().split("&");
        for (int i=0;i<contentArr.length;i++){
            if(i==(contentArr.length-1)){
                content += contentArr[i];
            }else {
                content += contentArr[i]+map.get((i+1)+"");
            }
        }

        trcEmailLog.setContext(content);

        //客服
//        if("KEFU".equals(trcEmailLog.getBusinessType())){
//            trcEmailLog.setNickName("teekee系统");
//            trcEmailLog.setSubject("十一活动");
//            trcEmailLog.setContext("客服你好:\n" +
//                    "我是巴拉巴拉，\n" +
//                    "谢谢");
//        }else
//
//        //用户
//        if("CJPG".equals(trcEmailLog.getBusinessType())){
//            trcEmailLog.setNickName("保聚风");
//            trcEmailLog.setSubject("创建派工");
//            trcEmailLog.setContext("用户你好:\n" +
//                    "创建派工成功，请处理，\n" +
//                    "谢谢");
//        }else
//        {
//            trcEmailLog.setNickName("保聚风");
//            trcEmailLog.setSubject("十一活动");
//            trcEmailLog.setContext("默认邮箱模板:\n" +
//                    "我是巴拉巴拉，\n" +
//                    "谢谢");
//        }

        return trcEmailLog;
    }
}
