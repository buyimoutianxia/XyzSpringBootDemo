package com.xyz.freemakerdemo.controller;

import com.xyz.freemakerdemo.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class UserController {

   @RequestMapping("/index")
   public String userInfo(Model model) {
      List<UserInfo> userInfoList = new ArrayList<>();
      for(int i=0; i<10; i++) {
         UserInfo userInfo = new UserInfo();
         userInfo.setId(i);
         userInfo.setName("name" + i);
         userInfo.setAddress("address" + i);
         log.info("id:" + userInfo.getId() +" ,name:" + userInfo.getName() + " ,address:" + userInfo.getAddress());
         userInfoList.add(userInfo);
      }
      log.info("listsize:" + userInfoList.size());
      model.addAttribute("userInfoList", userInfoList);
      return "index";
   };

}
