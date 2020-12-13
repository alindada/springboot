package com.example.demo;

import com.example.demo.domain.SpringMessage;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloSpringBoot {

    @RequestMapping("hello")
    public String Hello() {
        return "Hello Spring Boot!!";
    }

    @GetMapping("param")
    public SpringMessage param(@RequestParam(value = "key1", defaultValue = "xiaoming", required = true) String key1) {

        SpringMessage msg = new SpringMessage();
        msg.setUsername(key1);


        return msg;

    }

    @GetMapping("path/{key1}")
    public SpringMessage path(@PathVariable(value = "key1") String key1) {

        SpringMessage msg = new SpringMessage();
        msg.setUsername(key1);


        return msg;

    }

    @PostMapping("body")
    public SpringMessage body(@RequestBody SpringMessage msgObj) {
        SpringMessage msg = new SpringMessage();
        msg.setUsername("你提交的名称是：" + msgObj.getUsername());
        msg.setAge("你提交的年龄是：" + msgObj.getAge());

        return msg;

    }

}
