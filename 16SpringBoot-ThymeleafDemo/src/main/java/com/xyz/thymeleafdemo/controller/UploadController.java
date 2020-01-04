package com.xyz.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UploadController {

    @RequestMapping("/")
    public String upload() {
        return "upload";
    }
}
