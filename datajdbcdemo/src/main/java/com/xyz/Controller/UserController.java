package com.xyz.controller;

import com.xyz.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private  UserService userService;

    @RequestMapping("/add")
    public String  userAdd(@RequestParam(value="username") String username, @RequestParam(value="address") String address) {
        Map<String, String > map  = new HashMap<String ,String>();
        map.put("username", username);
        map.put("address", address);
        return  "插入" + userService.insert(map) + "笔";
//        return "username: " + username + " ,address : " + address;
    }

    @RequestMapping("/delete")
    public String userDelete(@RequestParam(value="username") String username) {
        Map<String, String> map  = new HashMap<String, String>();
        map.put("username", username);
        return "删除" + userService.delete(map) + "笔";
    }
}
