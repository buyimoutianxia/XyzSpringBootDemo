package com.xyz.service;

import com.xyz.entity.User;
import com.xyz.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 * @author 寒星月冷
 */
public class UserService {

    @Autowired
    UserMapper userMapper;

    public int add(User user) {
        int ret = 0;
        try {
            ret = userMapper.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return ret;
    }

}
