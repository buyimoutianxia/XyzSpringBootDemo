package com.xyz.fasjsondemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xyz.fasjsondemo.mapper")
@SpringBootApplication
public class FasjsondemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FasjsondemoApplication.class, args);
    }

}
