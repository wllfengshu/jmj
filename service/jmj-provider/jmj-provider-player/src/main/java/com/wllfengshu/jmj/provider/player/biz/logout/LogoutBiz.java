package com.wllfengshu.jmj.provider.player.biz.logout;

import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.common.entity.provider.enumeration.CommonEnum;
import com.wllfengshu.jmj.provider.api.player.model.PlayerPO;
import com.wllfengshu.jmj.provider.api.player.model.logout.LogoutRequest;
import com.wllfengshu.jmj.provider.api.player.model.logout.LogoutResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author wangll
 * @date 2022-05-21 16:55
 */
@Service
public class LogoutBiz extends AbstractInterfaceBase<LogoutRequest, LogoutResponse> {

    @Autowired
    private RedisTemplate<String, PlayerPO> redisTemplate;

    @Override
    protected String giveActionName() {
        return "logout";
    }

    @Override
    protected boolean checkRequest(LogoutRequest request) {
        return StringUtils.isNoneEmpty(request.getToken());
    }

    @Override
    public LogoutResponse doProcess(LogoutRequest request) {
        redisTemplate.expire(request.getToken(), 0, TimeUnit.MILLISECONDS);
        LogoutResponse response = new LogoutResponse();
        response.setBizResponseCode(CommonEnum.SUCCESS.getCode());
        return response;
    }
}
