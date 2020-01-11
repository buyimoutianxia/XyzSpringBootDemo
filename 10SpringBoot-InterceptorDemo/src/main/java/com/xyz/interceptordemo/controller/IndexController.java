package com.xyz.interceptordemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user1")
public class IndexController {

    @RequestMapping("/login_view")
    public String login_View() {
        return "login";
    }

    @RequestMapping(name = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

}
