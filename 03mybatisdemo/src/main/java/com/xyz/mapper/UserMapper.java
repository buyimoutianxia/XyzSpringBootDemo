package com.xyz.mapper;

import com.xyz.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    Integer addUser(User user);

}
