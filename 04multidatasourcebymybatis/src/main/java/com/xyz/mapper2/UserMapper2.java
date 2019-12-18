package com.xyz.mapper2;

import com.xyz.entity.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper2 {

    Integer addUser2(User user);

}
