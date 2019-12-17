package com.xyz.mapper1;

import com.xyz.entity.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper1 {

    Integer addUser1(User user);

}
