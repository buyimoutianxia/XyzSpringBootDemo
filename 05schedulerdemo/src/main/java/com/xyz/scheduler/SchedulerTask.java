package com.xyz.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class SchedulerTask {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerTask.class);

    private int i = 0;

    @Scheduled(cron = "*/6 * * * * ?")
    private void process() {
//        System.out.println("task id :" + (i++));
        logger.info("task id :" + (i++));
    }

}
