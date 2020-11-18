package com.wyf.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Log4j2
@Component
public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre"; //定义filter的类型，有pre,post,route,error四种
    }

    @Override
    public int filterOrder() {
        return 0; //定义filter的顺序，数字越小说明优先级越高
    }

    @Override
    public boolean shouldFilter() {
        return true; //标识是否需要执行该filter
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        log.info(token);
        if(token==null){
            try {
                log.warn("there is no request token");
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                ctx.getResponse().getWriter().write("this request not have token");
                return  null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  null;
    }
}
