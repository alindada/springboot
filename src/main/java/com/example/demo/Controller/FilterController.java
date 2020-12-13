package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FilterController {

    @GetMapping("/checklogin")
    public String EatApple() {
        System.out.println("吃苹果");
        return "OK!!";
    }

}
