package com.wyf.spring.cloud.consumer2.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//通过新增接口，并通过注解的方式绑定服务即可轻松的完成远程调用,fallback绑定失败回调处理类
@FeignClient(value = "service-producer",fallback = FeignHelloHystrix.class)
public interface FeignHelloService {

    @RequestMapping("/hello")
    public String hello();

}
