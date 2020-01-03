package com.xyz.interceptorlogdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.xyz.interceptorlogdemo.util.LoggerUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/index")
public class IndexController {

   @RequestMapping("/login")
   public JSONObject login(HttpServletRequest request, String name) {
      JSONObject obj = new JSONObject();
      obj.put("msg" ,"用户" + name + ",登陆成功");
      request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
      return obj;
   }

}
