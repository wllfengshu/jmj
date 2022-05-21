package com.wllfengshu.jmj.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.wllfengshu.jmj.common.entity.gateway.GatewayRequest;
import com.wllfengshu.jmj.common.entity.gateway.GatewayLoginInfo;
import com.wllfengshu.jmj.common.entity.gateway.constant.GatewayConstant;
import com.wllfengshu.jmj.provider.api.player.PlayerService;
import com.wllfengshu.jmj.provider.api.player.model.PlayerPO;
import com.wllfengshu.jmj.provider.api.player.model.giveplayerbytoken.GivePlayerByTokenRequest;
import com.wllfengshu.jmj.provider.api.player.model.giveplayerbytoken.GivePlayerByTokenResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wangll
 * @date 2022-05-05 20:39
 */
@Slf4j
@Configuration
public class AuthFilter extends ZuulFilter {

    @Value("${page.msg.NoPermission:No Permission, <a href='http://jmj:8080'>Please click</a>}")
    private String pageNoPermissionMsg;
    @Value("${tokenWhiteList:[]}")
    private List<String> tokenWhiteList;
    @Autowired
    private PlayerService playerService;

    @Override
    public String filterType() {
        // pre在路由之前过滤
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 过滤器的执行顺序
        return FilterConstants.SEND_ERROR_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        // 返回true表示要执行这个过滤器
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest hsr = rc.getRequest();
        if (null == hsr) {
            log.error("[request-httpServletRequestIsNull]");
            return this.routingFailed(rc);
        }

        // 1白名单接口不拦截
        String requestPath = hsr.getServletPath();
        if (tokenWhiteList.contains(requestPath)) {
            log.info("[request-tokenWhiteList] = {}", requestPath);
            return null;
        }
        // 2必须是post请求
        String method = hsr.getMethod();
        if (RequestMethod.POST.toString().equals(method)) {
            log.warn("[request-mastPost] = {}", method);
            return this.routingFailed(rc);
        }
        // 3获取token
        String token = hsr.getHeader(GatewayConstant.TOKEN);
        if (StringUtils.isEmpty(token)) {
            log.warn("[request-needToken]");
            return this.routingFailed(rc);
        }

        // 4设置用户信息
        GivePlayerByTokenRequest request = new GivePlayerByTokenRequest();
        request.setToken(token);
        GivePlayerByTokenResponse response = playerService.givePlayerByToken(request);
        if (null == response
            || null == response.getPlayerPO()) {
            log.warn("[request-notFoundUser] = {}", request);
            return this.routingFailed(rc);
        }
        return this.routingSucceeded(rc, token, response.getPlayerPO());
    }

    /**
     * 路由成功
     *
     * @param rc
     * @param token
     * @param playerPO
     * @return
     */
    private Object routingSucceeded(RequestContext rc, String token, PlayerPO playerPO) {
        rc.addZuulRequestHeader(GatewayConstant.TOKEN, token);

        // 构建登陆信息
        GatewayLoginInfo gatewayLoginInfo = new GatewayLoginInfo();
        BeanCopier beanCopier = BeanCopier.create(PlayerPO.class, GatewayLoginInfo.class, false);
        beanCopier.copy(playerPO, gatewayLoginInfo, null);
        // set
        GatewayRequest gatewayRequest = new GatewayRequest();
        gatewayRequest.setToken(token);
        gatewayRequest.setLoginTime(System.currentTimeMillis());
        gatewayRequest.setGatewayLoginInfo(gatewayLoginInfo);
        String loginInfo = JSON.toJSONString(gatewayRequest);
        log.info("[request-routingSucceeded] token = {} loginInfo = {}", token, loginInfo);
        rc.addZuulRequestHeader(GatewayConstant.LOGIN_INFO, loginInfo);
        return null;
    }

    /**
     * 路由失败
     *
     * @param rc
     * @return
     */
    private Object routingFailed(RequestContext rc) {
        rc.setSendZuulResponse(false);
        rc.setResponseStatusCode(401);
        rc.addZuulResponseHeader("Content-Type","text/html;charset=utf-8");
        rc.setResponseBody(pageNoPermissionMsg);
        log.warn("[request-routingFailed]");
        return null;
    }
}
