package com.xyz.mystarterdemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "xyz")
@Data
public class MyStarterProperties {
    private String name;
    private int age;
}
