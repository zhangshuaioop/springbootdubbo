package com.teekee.blackrockservice.Task;

import com.teekee.blackrockservice.entity.BifDevice;
import com.teekee.blackrockservice.service.BifDeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.Date;

@EnableScheduling
@Component
public class TaskBifDevice {
    private final Logger logger = LoggerFactory.getLogger(TaskBifDevice.class);


    @Autowired
    private BifDeviceService bifDeviceService;

    /**
     * 更新设备基本信息
     */
    /*[秒] [分] [小时] [日] [月] [周] [年]*/
//   @Scheduled(cron = "0/5 * * * * *")  //5秒
//    @Scheduled(cron = "0/30 * * * * ?")
//    @Scheduled(cron = "0 0 0/2 * * *")
//    @Scheduled(cron = "0 0/30 * * * ?")  //半小时
    public void updateBifDeviceJob() {
        //当前日期
        Date currentDate = new Date();
        logger.info("开始执行任务updateBifDeviceJob，时间" + currentDate + "更新设备基本信息定时任务");

        BifDevice bifDevice = new BifDevice();
        bifDevice.setFlagUsable(false);
       bifDevice.setId(38);
        int i = bifDeviceService.update(bifDevice);

        logger.info("结束更新条数:" + i);

    }


}
