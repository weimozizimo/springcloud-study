package com.wyf.spring.cloud.monitor;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;


//启动熔断监控服务
//访问 http://localhost:8531/hystrix 查看页面
@EnableHystrixDashboard
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine
public class ConsulMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulMonitorApplication.class,args);
    }
}
