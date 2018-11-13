package com.baojufeng.servicemessage.service;

import com.baojufeng.commoncomponets.entity.message.Email;
import com.baojufeng.commoncomponets.enums.ResultEnum;
import com.baojufeng.commoncomponets.utils.Result;
import com.baojufeng.commoncomponets.utils.ResultUtil;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @description: 邮箱服务
 * @author: zhangshuai
 * @create: 2018-11-12 16:34
 */
@Service
public class EmailService{

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    //发送邮件的邮箱
    private static String userName = "1301505228@qq.com";  //qq发送邮箱
//    private static final String userName = "zhangshuaioop@163.com";  //网易发送邮箱
//    private static final String userName = "tech@99bicycle.com";  //阿里云发送邮箱

    //发送邮件的邮箱授权码
    private static String password = "otzrsjbldfegiiia";  //qq邮箱授权码
//    private static final String  password = "??hehedamemeda";   //网易邮箱授权码
//    private static final String  password = "Lin456789";   //阿里云邮箱授权码

    //邮件发送服务器
    private static String  host = "smtp.qq.com";   //qq个人邮件发送服务器
//    private static String  host = "smtp.exmail.qq.com";   //qq企业邮件发送服务器
//    private static final String  host = "smtp.163.com";   //163邮件发送服务器
//    private static final String  host = "smtp.99bicycle.com";   //阿里云邮件发送服务器(赳赳单车企业邮箱)


    //服务器端口
    private static int port = 587 ;    //qq
//    private static  final int port = 25;    //网易
//    private static final  int port = 465;    //阿里云企业邮箱

    /**
     * 发送邮件
     * @param email
     * @return
     */
    public Result sendEmail(Email email) {

        if(email != null && email.getEmails() != null && email.getEmails().length() > 0){
            String[] to = email.getEmails().split(",");
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
                mail.setFrom(userName,email.getNickName());
                // 设置邮件接收者
                mail.addTo(to);
                // 设置邮件编码
                mail.setCharset("UTF-8");

                // 设置邮件主题
                mail.setSubject(email.getSubject());

                // 设置邮件内容
                mail.setMsg(email.getContext());

                // 设置邮件发送时间
                mail.setSentDate(new Date());

                mail.setSocketTimeout(100*1000);

                mail.setSocketConnectionTimeout(100*1000);

                // 发送邮件
                mail.send();
                logger.info("发送成功!");
                return ResultUtil.success();
            } catch (EmailException e) {
                logger.info("发送失败!");
                e.printStackTrace();
                logger.info(e.toString());
            }
        }
        return ResultUtil.error(ResultEnum.SEND_EMAIL_ERROR.getCode(),ResultEnum.SEND_EMAIL_ERROR.getMsg());


    }
}
