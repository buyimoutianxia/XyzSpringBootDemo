package com.xyz.thymeleafdemo.controller;

import com.sun.xml.internal.ws.api.server.Module;
import com.xyz.thymeleafdemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.security.pkcs11.Secmod;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model) {
        List<User> list = new ArrayList<>();
        for(int i=0; i<=10; i++) {
            User user = new User();
            user.setId((long)i);
            user.setName("xyz" + i);
            user.setAddress("address" + i);
            list.add(user);
        }
        model.addAttribute("userlist", list);
        return "index";
    }

}
