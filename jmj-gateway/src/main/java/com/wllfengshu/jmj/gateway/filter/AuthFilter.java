package com.wllfengshu.jmj.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.wllfengshu.jmj.common.entity.gateway.GatewayEntity;
import com.wllfengshu.jmj.common.entity.gateway.constant.GatewayConstant;
import com.wllfengshu.jmj.common.entity.player.PlayerEntity;
import com.wllfengshu.jmj.common.util.CustomStringUtils;
import com.wllfengshu.jmj.provider.api.player.PlayerService;
import com.wllfengshu.jmj.provider.api.player.model.GivePlayerByTokenRequest;
import com.wllfengshu.jmj.provider.api.player.model.GivePlayerByTokenResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangll
 * @date 2022-05-05 20:39
 */
@Slf4j
@Configuration
public class AuthFilter extends ZuulFilter {

    @Value("${pageNoPermissionMsg:No Permission, <a href='http://localhost:8080'>Please click</a>}")
    private String pageNoPermissionMsg;
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
            return this.routingFailed(rc);
        }
        String token = hsr.getHeader(GatewayConstant.TOKEN);
        if (StringUtils.isEmpty(token)) {
            return this.routingFailed(rc);
        }
        // 设置用户信息
        GivePlayerByTokenRequest request = new GivePlayerByTokenRequest();
        request.setToken(token);
        GivePlayerByTokenResponse response = playerService.givePlayerByToken(request);
        PlayerEntity playerEntity = response.getPlayerEntity();
        if (null == playerEntity) {
            return this.routingFailed(rc);
        }
        return this.routingSucceeded(rc, token, playerEntity);
    }

    /**
     * 路由成功
     *
     * @param rc
     * @param token
     * @param playerEntity
     * @return
     */
    private Object routingSucceeded(RequestContext rc, String token, PlayerEntity playerEntity) {
        rc.addZuulRequestHeader(GatewayConstant.TOKEN, token);

        GatewayEntity gatewayEntity = new GatewayEntity();
        gatewayEntity.setRequestId(CustomStringUtils.giveUuid());
        gatewayEntity.setLoginTime(System.currentTimeMillis());
        gatewayEntity.setPlayerEntity(playerEntity);
        String loginInfo = gatewayEntity.toString();
        log.info("[request-routingSucceeded] = {}", loginInfo);
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
        log.info("[request-routingFailed]");
        return null;
    }
}
