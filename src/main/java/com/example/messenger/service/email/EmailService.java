package com.example.messenger.service.email;

import com.example.messenger.entity.redo.TrcRedoLog;
import com.example.messenger.entity.trc.TrcEmailLog;
import com.example.messenger.service.redo.TrcRedoLogService;
import com.example.messenger.service.template.EmailTemplateService;
import com.example.messenger.service.trc.TrcEmailLogService;
import com.example.messenger.utils.Result;
import com.example.messenger.utils.ResultUtil;
import net.sf.json.JSONObject;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @description: 邮箱服务
 * @author: zhangshuai
 * @create: 2018-11-12 16:34
 */
@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private TrcRedoLogService trcRedoLogService;

    @Autowired
    private EmailTemplateService emailTemplateService;

    @Autowired
    private TrcEmailLogService trcEmailLogService;

    //发送邮件的邮箱
    @Value("${email.userName}")
    private String userName;

    //发送邮件的邮箱授权码
    @Value("${email.password}")
    private String password;

    //邮件发送服务器
    @Value("${email.host}")
    private String host;

    //服务器端口
    @Value("${email.port}")
    private int port;


    /**
     * 发送邮件
     * @param trcEmailLog
     * @return
     */
    public Result sendEmail(TrcEmailLog trcEmailLog){

        //设置模板
        trcEmailLog = emailTemplateService.emailTemplate(trcEmailLog);

        String[] tos = new String[0];
        Integer successCount = 0;
        Integer failCount = 0;
        String failEmail = "";
        if(trcEmailLog != null && trcEmailLog.getEmails() != null && trcEmailLog.getEmails().length() > 0){
            tos = trcEmailLog.getEmails().split(",");
            for (String to: tos) {
                trcEmailLog.setEmails(to);
                if(send(trcEmailLog)){
                    successCount++;
                }else {
                    failCount++;
                    failEmail += to+",";
                }
            }

        }
        return ResultUtil.success("发送条数:"+tos.length+",成功条数:"+successCount+",失败条数:"+failCount+",失败邮箱:"+failEmail);
//        return ResultUtil.error(ResultEnum.SEND_EMAIL_ERROR.getCode(),ResultEnum.SEND_EMAIL_ERROR.getMsg());


    }

    /**
     * 发送
     * @param trcEmailLog
     * @return
     */
    public boolean send(TrcEmailLog trcEmailLog){
        boolean status = false;
        SimpleEmail mail = new SimpleEmail();
        mail=(SimpleEmail) mail.setSSLOnConnect(true);
        // 设置邮箱服务器信息
        mail.setSmtpPort(port);
        mail.setHostName(host);
        // 设置密码验证器
        mail.setAuthentication(userName, password);
        try {
            // 设置邮件发送者
            //            mail.setFrom(userName);
            mail.setFrom(userName,trcEmailLog.getNickName());
            // 设置邮件接收者
            mail.addTo(trcEmailLog.getEmails());
            // 设置邮件编码
            mail.setCharset("UTF-8");

            // 设置邮件主题
            mail.setSubject(trcEmailLog.getSubject());

            // 设置邮件内容
            mail.setMsg(trcEmailLog.getContext());

            // 设置邮件发送时间
            mail.setSentDate(new Date());

            mail.setSocketTimeout(100*1000);

            mail.setSocketConnectionTimeout(100*1000);
            // 发送邮件
            mail.send();

            //修改邮箱记录处理状态为成功
            trcEmailLog.setStatus(2);   //状态0开始，1处理中，2成功

            trcEmailLogService.update(trcEmailLog);

            logger.info("发送成功!");

            status = true;
        } catch (EmailException e) {
            logger.info("发送失败!");
            logger.info(new Date() + " 发送邮件失败. 失败邮箱:" + trcEmailLog.getEmails());
            logger.info("邮件发送失败，进入redo日志表，待处理状态进行补发");
            TrcRedoLog trcRedoLog = new TrcRedoLog();
            trcRedoLog.setMessageId(trcEmailLog.getMessageId());
            trcRedoLog.setRequestBody(JSONObject.fromObject(trcEmailLog).toString());
            trcRedoLog.setRequestUrl("emailService/send");
            List<TrcRedoLog> list = trcRedoLogService.findAll(trcRedoLog);
            if(list.size()==0){
                trcRedoLogService.save(trcRedoLog);
            }
            e.printStackTrace();
            logger.info(e.toString());
            return status;
        }
        return status;
    }
}
