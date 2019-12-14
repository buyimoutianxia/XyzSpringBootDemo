package com.xyz.Controller;

import com.xyz.Entity.User;
import com.xyz.Mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class UserController {

    @RequestMapping("/add")
    public int add() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = new User();
        user.setUserName("mybatis-username");
        user.setAddress("mybatis-address");

        int ret = 0;
        try {
            ret = userMapper.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return ret;
        }

    }
}
