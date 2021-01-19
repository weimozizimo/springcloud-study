package com.wyf.spring.cloud.demo1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope //被该注解注释的类，再客户端执行/refresh操作时会刷新此配置类下的配置属性
@RestController
public class HelloController {

    @Value("${spring.config.hello}")
    private String hello;

    @GetMapping
    public String from(){
        return this.hello;
    }
}
