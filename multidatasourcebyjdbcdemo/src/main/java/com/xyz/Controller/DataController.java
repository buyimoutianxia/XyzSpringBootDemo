package com.xyz.Controller;

import com.xyz.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @Autowired
    DataService dataService;


    @RequestMapping("/add1")
    public String addUser1() {
       return  "成功插入" + dataService.add1() + "笔";
    }

    @RequestMapping("/add2")
    public String addUser2() {
        return "成功插入" + dataService.add2()  + "笔";
    }
}
