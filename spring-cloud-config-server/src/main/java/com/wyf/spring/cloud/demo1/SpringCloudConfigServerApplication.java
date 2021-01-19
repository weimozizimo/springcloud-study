package com.wyf.spring.cloud.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

//开启配置服务支持模块
@EnableConfigServer
@SpringBootApplication
//开启服务发现
@EnableDiscoveryClient
public class SpringCloudConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServerApplication.class,args);
    }
}
