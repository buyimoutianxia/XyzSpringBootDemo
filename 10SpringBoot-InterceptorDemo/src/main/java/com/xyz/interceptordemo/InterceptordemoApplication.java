package com.xyz.interceptordemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.xyz.interceptordemo.mapper")
public class InterceptordemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterceptordemoApplication.class, args);
    }

}
