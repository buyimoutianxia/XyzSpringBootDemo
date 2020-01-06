package com.xyz.lombokdemo;

import com.xyz.lombokdemo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.security.RunAs;

@RunWith(JUnit4.class)
@Slf4j
//@SpringBootTest
class LombokdemoApplicationTests {

    @Test
    public void contextLoads() {
        User user = new User();
        user.setName("100");
        System.out.println(user.getName());
        log.info("name:" + user.getName());
//
//        user.setAge( 1);
//        System.out.println(user.getAge());
//
//        System.out.println(user.toString());

//        User user = new User((long)1,"name", "age", 100);
//        System.out.println(user);
    }

}
