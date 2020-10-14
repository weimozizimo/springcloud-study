package com.wyf.spring.cloud.concumer1.controller;


import com.wyf.spring.cloud.concumer1.service.FeignHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignHelloController {

    @Autowired
    private FeignHelloService feignHelloService;

    @RequestMapping("/feign/call")
    public String call(){
        //像调用本地服务一样
        String hello = feignHelloService.hello();
        return hello;
    }
}
