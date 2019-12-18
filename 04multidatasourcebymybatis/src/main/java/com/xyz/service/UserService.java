package com.xyz.service;

import com.xyz.entity.User;
import com.xyz.mapper1.UserMapper1;
import com.xyz.mapper2.UserMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

   @Autowired
   UserMapper1 userMapper1;

   @Autowired
   UserMapper2 userMapper2;

   public int add1(User user) {
      return userMapper1.addUser1(user);
   }

   public int add2(User user) {
      return userMapper2.addUser2(user);
   }

}
