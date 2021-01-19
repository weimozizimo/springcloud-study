package com.wyf.spring.cloud.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//开启配置服务支持模块
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class,args);
    }
}
