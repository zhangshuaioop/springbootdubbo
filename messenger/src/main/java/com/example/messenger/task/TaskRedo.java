//package com.example.messenger.task;
//
//import com.baojufeng.commoncomponets.entity.message.message.Sms;
//import com.baojufeng.commoncomponets.entity.message.redo.TrcRedoLog;
//import com.baojufeng.commoncomponets.entity.message.trc.TrcEmailLog;
//import com.baojufeng.commoncomponets.utils.Result;
//import com.example.messenger.service.email.EmailService;
//import com.example.messenger.service.redo.TrcRedoLogService;
//import com.example.messenger.service.rocketmq.ProducerService;
//import com.example.messenger.service.sms.SmsService;
//import net.sf.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//@EnableScheduling
//@Component
//public class TaskRedo {
//    private final Logger logger = LoggerFactory.getLogger(TaskRedo.class);
//
//
//    @Autowired
//    private TrcRedoLogService trcRedoLogService;
//
//    @Autowired
//    private ProducerService producerService;
//
//    @Autowired
//    private EmailService emailService;
//
//    @Autowired
//    private SmsService smsService;
//
//    /**
//     * 处理redo异常请求
//     */
//    /*[秒] [分] [小时] [日] [月] [周] [年]*/
//    @Scheduled(cron = "0/60 * * * * ?")
////    @Scheduled(cron = "0/30 * * * * ?")
////    @Scheduled(cron = "0 0 0/2 * * *")
////    @Scheduled(cron = "0 0/30 * * * ?")  //半小时
//    public void redoHandleJob() {
//        logger.info("开始执行任务redoHandleJob，时间:" + new Date() + ",redo异常处理定时任务");
//
//       TrcRedoLog trcRedoLogOld = new TrcRedoLog();
//       List<TrcRedoLog> list = trcRedoLogService.findAll(trcRedoLogOld);
//       logger.info("处理条数:"+list.size());
//
//       String ids = "";
//
//       //成功条数
//       Integer successCount = 0;
//       for (TrcRedoLog trcRedoLog:list) {
//           JSONObject json = JSONObject.fromObject(trcRedoLog.getRequestBody());
//           if(trcRedoLog.getRequestUrl().equals("producerService/producer")){
//               logger.info("执行发送MQ消息redo处理; producerService/producer");
//               //json字符串转map
//               Map<String, Object> map = (Map) json;
//               Result result = producerService.producer(map);
//               if(result.getCode()==200){
//                   logger.info("redo异常处理成功，messageId"+trcRedoLog.getMessageId());
//                   ids += trcRedoLog.getId()+",";
//                   successCount++;
//               }
//           }else
//           if(trcRedoLog.getRequestUrl().equals("emailService/send")){
//               logger.info("执行发送邮箱redo处理; emailService/send");
//               TrcEmailLog trcEmailLog = (TrcEmailLog)JSONObject.toBean(json,TrcEmailLog.class);
//               if(emailService.send(trcEmailLog)){
//                   logger.info("redo异常处理成功，messageId"+trcRedoLog.getMessageId());
//                   ids += trcRedoLog.getId()+",";
//                   successCount++;
//               }
//           }else
//           if(trcRedoLog.getRequestUrl().equals("smsService/send")){
//               logger.info("执行发送短信redo处理; smsService/send");
//               Sms sms = (Sms)JSONObject.toBean(json,Sms.class);
//               if(smsService.send(sms)){
//                   logger.info("redo异常处理成功，messageId"+trcRedoLog.getMessageId());
//                   ids += trcRedoLog.getId()+",";
//                   successCount++;
//               }
//           }
//       }
//
//       //删除已处理成功的redo
//       if(ids.length() > 0){
//           trcRedoLogService.deletes(ids.substring(0, ids.length() -1));
//       }
//
//        logger.info("结束执行任务redoHandleJob,成功处理条数:"+successCount);
//
//    }
//
//
//}
