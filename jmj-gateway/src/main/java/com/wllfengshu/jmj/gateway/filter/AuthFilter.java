package com.wllfengshu.jmj.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangll
 * @date 2022-05-05 20:39
 */
@Configuration
public class AuthFilter extends ZuulFilter {

    @Override
    public String filterType() {
        // pre在路由之前过滤
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 过滤器的执行顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 返回true表示要执行这个过滤器
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if (token == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.addZuulResponseHeader("content-type","text/html;charset=utf-8");
            ctx.setResponseBody("非法访问");
        }
        return null;
    }
}
