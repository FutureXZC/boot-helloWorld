package com.my.boot.controller;

import com.my.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j  // 日志，log.xxx
@RestController  // 由下面2个注解合成
//@Controller
//@ResponseBody
public class HelloController {

//    @Autowired
    private final Car car;

    public HelloController(Car car) {
        this.car = car;
    }

    @RequestMapping("/car")
    public Car car() {
        log.info("car request...");
        return car;
    }

    @RequestMapping("/hello")
    public String handle01() {
        log.info("Hello world request...");
        return "Hello World! ";
    }
}
