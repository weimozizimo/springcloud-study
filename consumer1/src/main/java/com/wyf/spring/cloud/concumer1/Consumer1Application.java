package com.wyf.spring.cloud.concumer1;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


//该注解用于开启扫描SpringCloudFeign客户端的功能
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class Consumer1Application {

    public static void main(String[] args) {

        SpringApplication.run(Consumer1Application.class,args);
    }


    /**
    * @Description:  注入restTemplate，并添加@LoadBanlanced用于拦截请求，以使用ribbon来进行负载均衡
    * @Param: []
    * @return: org.springframework.web.client.RestTemplate
    * @Author: weiyifei
    * @Date: 2020/10/10 15:20
    */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    // 此配置是为了服务监控而配置，与服务容错本身无关，
    // ServletRegistrationBean因为springboot的默认路径不是"/hystrix.stream"，
    // 只要在自己的项目里配置上下面的servlet就可以了
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
