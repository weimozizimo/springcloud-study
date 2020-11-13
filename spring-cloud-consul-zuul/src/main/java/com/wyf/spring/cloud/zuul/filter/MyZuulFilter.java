package com.wyf.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre"; //定义filter的类型，有pre,post,route,error四种
    }

    @Override
    public int filterOrder() {
        return 5; //定义filter的顺序，数字越小说明优先级越高
    }

    @Override
    public boolean shouldFilter() {
        return true; //标识是否需要执行该filter
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
