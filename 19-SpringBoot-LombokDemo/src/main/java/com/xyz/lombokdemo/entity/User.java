package com.xyz.lombokdemo.entity;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
@Data
public class User {

    private Long id;
    private String name;
    private String addres;
    private int age;
}
