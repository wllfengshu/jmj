package com.wllfengshu.jmj.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangll
 * @date 2022-05-05 20:39
 */
@Configuration
public class AuthFilter extends ZuulFilter {

    @Value("${pageNoPermissionMsg:No Permission, <a href='http://localhost:8080'>Please click</a>}")
    private String pageNoPermissionMsg;

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
//        RequestContext rc = RequestContext.getCurrentContext();
//        String b1 = rc.getResponseBody();
//        rc.setResponseBody("111111111111111111111111111111111111");
////        rc.set
//        String b2 = rc.getResponseBody();
//
//        String token = TokenUtil.giveToken();
//        if (StringUtils.isEmpty(token)) {
//            RequestContext rc = RequestContext.getCurrentContext();
//            rc.setSendZuulResponse(false);
//            rc.setResponseStatusCode(401);
//            rc.addZuulResponseHeader("Content-Type","text/html;charset=utf-8");
//            rc.setResponseBody("No Permission");
//
//            return null;
//        }

        return null;
    }
}
