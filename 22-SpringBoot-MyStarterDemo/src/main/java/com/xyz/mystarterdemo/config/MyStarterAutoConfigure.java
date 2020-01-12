package com.xyz.mystarterdemo.config;


import com.xyz.mystarterdemo.service.MyStarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyStarterProperties.class)
@ConditionalOnClass(MyStarterService.class)
public class MyStarterAutoConfigure {

   @Autowired
   MyStarterProperties myStarterProperties;

   @Bean
   public MyStarterService myStarterService() {
      MyStarterService myStarterService = new MyStarterService();
      myStarterService.setName(myStarterProperties.getName());
      myStarterService.setAge(myStarterProperties.getAge());
      return myStarterService;
   }

}
