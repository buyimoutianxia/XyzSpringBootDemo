package com.xyz.interceptordemo.mapper;

import com.xyz.interceptordemo.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public interface LoginMapper {

    UserEntity login(UserEntity user);

}
