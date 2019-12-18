package com.xyz.controller;

import com.xyz.entity.User;
import com.xyz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/add")
    public int add() throws IOException {

        User user = new User();
        user.setUserName("mybatis-username");
        user.setAddress("mybatis-address");

        return userService.add(user);

    }
}
