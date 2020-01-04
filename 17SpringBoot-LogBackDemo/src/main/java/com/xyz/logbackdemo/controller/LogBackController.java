package com.xyz.logbackdemo.controller;

import com.xyz.logbackdemo.LogbackdemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogBackController {

   private  static  final Logger logger = LoggerFactory.getLogger(LogBackController.class);

   @GetMapping("/log1")
   public String logBack() {
      logger.info("+++++info++1111++++");
      return "index";
   }

}
