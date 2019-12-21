package com.xyz.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedulerTask2 {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerTask2.class);

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 6000)
    private void printCurrentTiem() {
//        System.out.println("now is :" + SIMPLE_DATE_FORMAT.format(new Date()));
        logger.info("now is :" + SIMPLE_DATE_FORMAT.format(new Date()));
    }

}
