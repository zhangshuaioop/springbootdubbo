package com.example.messenger.Task;

import com.example.messenger.entity.message.Email;
import com.example.messenger.entity.redo.ExceptionRedoLogs;
import com.example.messenger.service.email.EmailService;
import com.example.messenger.service.redo.ExceptionRedoLogsService;
import com.example.messenger.service.rocketmq.ProducerService;
import com.example.messenger.utils.Result;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@EnableScheduling
@Component
public class TaskRedo {
    private final Logger logger = LoggerFactory.getLogger(TaskRedo.class);


    @Autowired
    private ExceptionRedoLogsService exceptionRedoLogsService;

    @Autowired
    private ProducerService producerService;

    @Autowired
    private EmailService emailService;

    /**
     * 处理redo异常请求
     */
    /*[秒] [分] [小时] [日] [月] [周] [年]*/
   @Scheduled(cron = "0/30 * * * * *")
//    @Scheduled(cron = "0/30 * * * * ?")
//    @Scheduled(cron = "0 0 0/2 * * *")
//    @Scheduled(cron = "0 0/30 * * * ?")  //半小时
    public void redoHandleJob() {
        logger.info("开始执行任务redoHandleJob，时间:" + new Date() + ",redo异常处理定时任务");

       ExceptionRedoLogs exceptionRedoLog = new ExceptionRedoLogs();
       List<ExceptionRedoLogs> list = exceptionRedoLogsService.findAll(exceptionRedoLog);
       logger.info("处理条数:"+list.size());

       String ids = "";
       for (ExceptionRedoLogs exceptionRedoLogs:list) {
           JSONObject json = JSONObject.fromObject(exceptionRedoLogs.getRequestBody());
           if(exceptionRedoLogs.getRequestUrl().equals("producerService/producer")){
               //json字符串转map
               Map<String, Object> map = (Map) json;
               Result result = producerService.producer(map);
               if(result.getCode()==200){
                   logger.info("redo异常处理成功，messageId"+exceptionRedoLogs.getMessageId());
                   ids += exceptionRedoLogs.getId()+",";
               }
           }else
           if(exceptionRedoLogs.getRequestUrl().equals("emailService/send")){
               Email email = (Email)JSONObject.toBean(json,Email.class);
               if(emailService.send(email)){
                   logger.info("redo异常处理成功，messageId"+exceptionRedoLogs.getMessageId());
                   ids += exceptionRedoLogs.getId()+",";
               }
           }
       }

       //删除已处理成功的redo
       if(ids.length() > 0){
           exceptionRedoLogsService.deletes(ids.substring(0, ids.length() -1));
       }

        logger.info("结束执行任务redoHandleJob,成功处理条数:"+ids.length());

    }


}
