package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class LoginController {

    @GetMapping("/login")
    public String EatApple() {
        System.out.println("登录中");
        return "登录成功!!";
    }
}
