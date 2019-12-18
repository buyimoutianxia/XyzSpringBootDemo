package com.xyz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "com.xyz.mapper1")
public class MultidatasourcebymybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultidatasourcebymybatisApplication.class, args);
    }

}
