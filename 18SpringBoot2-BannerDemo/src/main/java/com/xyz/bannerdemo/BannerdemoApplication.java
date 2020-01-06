package com.xyz.bannerdemo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BannerdemoApplication {

    public static void main(String[] args) {
        //原启动方式
        SpringApplication.run(BannerdemoApplication.class, args);
        /**
         * 隐藏Banner的启动方式
         */
//        SpringApplication springApplication = new SpringApplication(BannerdemoApplication.class);
        //设置Banner的方式为隐藏
//        springApplication.setBannerMode(Banner.Mode.OFF);
        //启动SpringApplication
//        springApplication.run(args);
    }

}
