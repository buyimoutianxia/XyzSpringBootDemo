package com.xyz.mystarterdemo.service;

import lombok.Data;

@Data
public class MyStarterService {
    private String name;
    private int age;

    public  String sayInfo() {
        return "name:" + name + ",age:" + age;
    }
}
