package com.xyz.datajpademo.controller;

import com.xyz.datajpademo.entity.UserEntity;
import com.xyz.datajpademo.jpa.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserJpa userJpa;

    @RequestMapping("/list")
    public List<UserEntity> list() {
        return userJpa.findAll();
    }

    @RequestMapping("/save")
    public UserEntity save(UserEntity userEntity) {
        return userJpa.save(userEntity);
    }

    @RequestMapping("/delete")
    public List<UserEntity> delete(@RequestParam("id")  long id  ) {
        userJpa.deleteById(id);
        return userJpa.findAll();
    }

}
