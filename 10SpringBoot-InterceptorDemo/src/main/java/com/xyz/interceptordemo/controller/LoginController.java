package com.xyz.interceptordemo.controller;

import com.xyz.interceptordemo.entity.UserEntity;
import com.xyz.interceptordemo.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class LoginController {

   @Autowired
   LoginMapper loginMapper;

   @RequestMapping("/login")
   public String login(UserEntity user, HttpServletRequest request) {
      String result = "登陆成功";
      boolean flag = true;

      //根据登陆用户查询数据库用户信息
      UserEntity userEntity =  loginMapper.login(user);

      //查询用户名
      if(userEntity == null) {
         result = "用户不存在";
         flag = false;
         //查询密码
      }else if(!user.getPwd().equals(userEntity.getPwd())) {
         result = "密码错误";
         flag = false;
      }

      //登陆成功
      if(flag) {
         request.getSession().setAttribute("_session_user", userEntity);
      }

      return result;
   }

}
