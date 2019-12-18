package com.xyz.controller;

import com.xyz.entity.User;
import com.xyz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/add1")
    public String add1() {
        User user = new User();
        user.setAddress("multimybatis-address1");
        user.setUserName("multimybatis-username1");
        return  "insert " + userService.add1(user) + " times";
    }

    @RequestMapping("/add2")
    public String add2() {
        User user = new User();
        user.setUserName("multimybatis-username2");
        user.setAddress("multimybatis-address2");
        return "insert " + userService.add2(user) + " times";
    }

}
