package com.wyh.demo.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author imai
 * @since 2021/3/20 11:26 下午
 */

//@Component
@EnableAsync
public class ScheduledTask {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class.getName());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /*
    fixedRate:固定速率执行 每5秒执行一次
     */
    @Async
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTimeWithFixedRate(){
        log.info("Current Thread : {}",Thread.currentThread().getName());
        log.info("Fixed Rate Task:The time is now {}",dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 2000)
    public void reporterCurrentTimeWithFixedDelay(){
        try{
            TimeUnit.SECONDS.sleep(3);
            log.info("Fixed Delay Task:Time time is now {}",dateFormat.format(new Date()));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Scheduled(initialDelay = 5000,fixedRate = 5000)
    public void reportCurrentTimeWithInitialDelay(){
        log.info("initialDelay Task with {}" + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "1-2 * * * * ?")
    public void reportCurrentTimeWithCron(){
        log.info("Cron {}", dateFormat.format(new Date()));
    }


}
