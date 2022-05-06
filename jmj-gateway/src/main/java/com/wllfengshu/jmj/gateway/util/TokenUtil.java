package com.wllfengshu.jmj.gateway.util;

import com.netflix.zuul.context.RequestContext;
import com.wllfengshu.jmj.gateway.common.Constant;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangll
 * @date 2022-05-07 0:24
 */
public class TokenUtil {

    /**
     * 获取token
     *
     * @return
     */
    public static String giveToken() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        return request.getHeader(Constant.TOKEN);
    }
}
