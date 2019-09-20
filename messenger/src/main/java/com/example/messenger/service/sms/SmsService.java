package com.example.messenger.service.sms;

import com.baojufeng.commoncomponets.entity.message.message.Sms;
import com.baojufeng.commoncomponets.entity.message.redo.TrcRedoLog;
import com.baojufeng.commoncomponets.entity.message.trc.TrcSmsLog;
import com.baojufeng.commoncomponets.utils.Result;
import com.baojufeng.commoncomponets.utils.ResultUtil;
import com.example.messenger.service.redo.TrcRedoLogService;
import com.example.messenger.service.template.SmsTemplateService;
import com.example.messenger.service.trc.TrcSmsLogService;
import com.example.messenger.utils.HttpUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 短信服务
 * @author: zhangshuai
 * @create: 2018-11-24 18:29
 */
@Service
public class SmsService {

    private static final Logger logger = LoggerFactory.getLogger(SmsService.class);

    @Value("${sms.singleSendUrl}")
    private String singleSendUrl;

    @Value("${sms.userid}")
    private String userid;

    @Value("${sms.password}")
    private String password;

    @Value("${sms.svrtype}")
    private String svrtype;

    @Value("${sms.exno}")
    private String exno;

    @Autowired
    private TrcRedoLogService trcRedoLogService;

    @Autowired
    private SmsTemplateService smsTemplateService;

    @Autowired
    private TrcSmsLogService trcSmsLogService;

    /**
     * 短信发送
     * @param sms
     * @return
     */
    public Result sendSms(Sms sms){

        sms.setCode(getRandom());

        //设置模板
        if(sms.getContent() == null || sms.getContent().length() < 1){
            sms = smsTemplateService.smsTemplate(sms);
        }

        String[] tos = new String[0];
        Integer successCount = 0;
        Integer failCount = 0;
        String failMobile = "";
        if(sms != null && sms.getMobile() != null && sms.getMobile().length() > 0){
            tos = sms.getMobile().split(",");
            for (String to: tos) {
                sms.setMobile(to);
                if(send(sms)){
                    successCount++;
                }else {
                    failCount++;
                    failMobile += to+",";
                }
            }

        }
        return ResultUtil.success("发送条数:"+tos.length+",成功条数:"+successCount+",失败条数:"+failCount+",失败号码:"+failMobile);

    }


    /**
     * 发送
     * @param sms
     * @return
     */
    public boolean send(Sms sms){

        boolean status = false;

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
        String currTime = sdf.format(date);
        String newPassword = "JE0223"+"00000000"+password+currTime;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String curr = dateFormat.format(date);

        try {
            Map<String,String> map = new HashMap<>();
            map.put("userid",userid);
            map.put("pwd",DigestUtils.md5DigestAsHex(newPassword.getBytes()));
            map.put("mobile",sms.getMobile());
            map.put("content",sms.getContent());
            map.put("timestamp",currTime);
            map.put("svrtype",svrtype);
            map.put("exno",exno);
            map.put("custid",curr+sms.getCode());
            map.put("exdata","");

            //发送短信
            logger.info("开始发送短信，入参：map="+map.toString());
            String response = HttpUtils.sendHttpPost(singleSendUrl, map);
            logger.info("开始发送短信，出参：responseEntity="+response);
            JSONObject jsonobject = JSONObject.fromObject(response);
            if (jsonobject.getString("result").equals("0")){
                logger.info("短信发送成功开始更新记录");

                //更新短信记录处理状态为成功
                TrcSmsLog log = new TrcSmsLog();
                log.setId(sms.getTrcSmsLogId());
                log.setFlagSendSuccessful(true);
                log.setKeyword(sms.getCode());
                log.setContent(URLDecoder.decode(sms.getContent(), "UTF-8"));
                log.setSerialNumber(curr+sms.getCode());
                log.setValidTime(new Date(new Date().getTime() + 300000));
                trcSmsLogService.update(log);

                status = true;

            }
        } catch (Exception e) {

            logger.info("发送失败!");
            logger.info(new Date() + " 发送短信败. 失败号码:" + sms.getMobile());
            logger.info("短信发送失败，进入redo日志表，待处理状态进行补发");
            TrcRedoLog trcRedoLog = new TrcRedoLog();
            trcRedoLog.setMessageId(sms.getMessageId());
            trcRedoLog.setRequestBody(JSONObject.fromObject(sms).toString());
            trcRedoLog.setRequestUrl("smsService/send");
            List<TrcRedoLog> list = trcRedoLogService.findAll(trcRedoLog);
            if(list.size()==0){
                trcRedoLogService.save(trcRedoLog);
            }

            e.printStackTrace();
            return status;
        }

        return status;

    }


    //6位随机数生成
    private String getRandom() {

        String result = "";

        while (result.length() < 6) {
            String str = String.valueOf((int)(Math.random()*10));
            if(result.indexOf(str) == -1){
                result += str;
            }
        }
        return result;
    }

}
