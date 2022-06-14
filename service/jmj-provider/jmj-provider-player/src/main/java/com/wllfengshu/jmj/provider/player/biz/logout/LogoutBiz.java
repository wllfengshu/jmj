package com.wllfengshu.jmj.provider.player.biz.logout;

import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.common.entity.provider.enumeration.CommonEnum;
import com.wllfengshu.jmj.provider.api.player.model.logout.LogoutRequest;
import com.wllfengshu.jmj.provider.api.player.model.logout.LogoutResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.wllfengshu.jmj.provider.player.constant.ProviderConstant.REDIS_PREFIX_TOKEN_TO_PLAYER;
import static com.wllfengshu.jmj.provider.player.constant.ProviderConstant.REDIS_PREFIX_USERNAME_TO_TOKEN;

/**
 * @author wangll
 * @date 2022-05-21 16:55
 */
@Service
public class LogoutBiz extends AbstractInterfaceBase<LogoutRequest, LogoutResponse> {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    protected String giveActionName() {
        return "logout";
    }

    @Override
    protected boolean checkRequest(LogoutRequest request) {
        return StringUtils.isNoneEmpty(request.getToken())
                && null != request.getGatewayLoginInfo();
    }

    @Override
    public LogoutResponse doProcess(LogoutRequest request) {
        redisTemplate.expire(REDIS_PREFIX_TOKEN_TO_PLAYER + request.getToken(), NumberUtils.INTEGER_ZERO, TimeUnit.MILLISECONDS);
        redisTemplate.expire(REDIS_PREFIX_USERNAME_TO_TOKEN + request.getGatewayLoginInfo().getUsername(), NumberUtils.INTEGER_ZERO, TimeUnit.MILLISECONDS);
        LogoutResponse response = new LogoutResponse();
        response.setBizResponseCode(CommonEnum.SUCCESS.getCode());
        return response;
    }
}
