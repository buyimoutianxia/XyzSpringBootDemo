package com.xyz.Service;

import com.xyz.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int insert(Map map) {
        return  userDao.insert(map);
    }

    public int delete(Map map) {
        return userDao.delete(map);
    }
}
