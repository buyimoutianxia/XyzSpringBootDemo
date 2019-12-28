package com.xyz.fasjsondemo.controller;

import com.xyz.fasjsondemo.entity.UserEntity;
import com.xyz.fasjsondemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/list")
    public List<UserEntity> list() {
        return userMapper.listUser();
    }

}
