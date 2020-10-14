package com.wyf.spring.cloud.concumer1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    
    @Autowired
    private DiscoveryClient discoveryClient;
    
    /** 
    * @Description: 获取所有服务 
    * @Param: [] 
    * @return: java.lang.Object 
    * @Author: weiyifei
    * @Date: 2020/10/10 14:35
    */
    @RequestMapping("/services")
    public Object services(){
        return discoveryClient.getInstances("service-producer");
    }
    
    /** 
    * @Description: 从所有服务中选择一个服务(轮询)
    * @Param: [] 
    * @return: java.lang.Object 
    * @Author: weiyifei
    * @Date: 2020/10/10 14:47
    */
    
    @RequestMapping("/discover")
    public Object discover(){
        return loadBalancerClient.choose("service-producer").getUri().toString();
    }
    
    
}
