package com.xyz.fasjsondemo.mapper;

import com.xyz.fasjsondemo.entity.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface  UserMapper {

    List<UserEntity> listUser();

}
