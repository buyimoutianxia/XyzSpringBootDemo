package com.xyz.logbackdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogBackController2 {

   private  static  final Logger logger = LoggerFactory.getLogger(LogBackController2.class);

   @GetMapping("/log2")
   public String logBack() {
      logger.info("+++++info++2222++++");
      logger.error("++++error+2222+++++");
      return "index";
   }

}
