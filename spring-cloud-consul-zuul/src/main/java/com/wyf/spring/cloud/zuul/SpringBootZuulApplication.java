package com.wyf.spring.cloud.zuul;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //开启网关支持
public class SpringBootZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootZuulApplication.class,args);
    }
}
