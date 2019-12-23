package com.xyz.redisdemo;

import com.xyz.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class RedisdemoApplicationTests {

    @Resource
    RedisService redisService;

    @Test
    void contextLoads() {
        redisService.set("redis_key", "redis_value");

        String value = redisService.get("redis_key");
        System.out.println("value:" + value);
    }

}
