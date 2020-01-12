package com.xyz.mystarterdemo2;

import com.xyz.mystarterdemo.service.MyStarterService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class Mystarterdemo2ApplicationTests {

    @Autowired
    MyStarterService myStarterService;

    @Test
    void contextLoads() {
        System.out.println(myStarterService.sayInfo());
    }

}
