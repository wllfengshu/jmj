package com.wllfengshu.jmj.provider.player.biz.giveplayerbytoken;

import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.common.entity.provider.enumeration.CommonEnum;
import com.wllfengshu.jmj.provider.player.enumeration.ProviderEnum;
import com.wllfengshu.jmj.provider.api.player.model.PlayerPO;
import com.wllfengshu.jmj.provider.api.player.model.giveplayerbytoken.GivePlayerByTokenRequest;
import com.wllfengshu.jmj.provider.api.player.model.giveplayerbytoken.GivePlayerByTokenResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import static com.wllfengshu.jmj.provider.player.constant.ProviderConstant.REDIS_PREFIX_TOKEN_TO_PLAYER;

/**
 * @author wangll
 * @date 2022-05-08 19:12
 */
@Service
public class GivePlayerByTokenBiz extends AbstractInterfaceBase<GivePlayerByTokenRequest, GivePlayerByTokenResponse> {

    @Autowired
    private RedisTemplate<String, PlayerPO> redisTemplate;

    @Override
    protected String giveActionName() {
        return "givePlayerByToken";
    }

    @Override
    protected boolean checkRequest(GivePlayerByTokenRequest request) {
        return StringUtils.isNoneEmpty(request.getToken());
    }

    @Override
    public GivePlayerByTokenResponse doProcess(GivePlayerByTokenRequest request) {
        PlayerPO player = redisTemplate.opsForValue().get(REDIS_PREFIX_TOKEN_TO_PLAYER + request.getToken());
        if (null == player) {
            GivePlayerByTokenResponse response = new GivePlayerByTokenResponse();
            response.setBizResponseCode(ProviderEnum.NO_LOGIN.getCode());
            response.setBizResponseDesc(ProviderEnum.NO_LOGIN.getDesc());
            return response;
        }

        GivePlayerByTokenResponse response = new GivePlayerByTokenResponse();
        response.setBizResponseCode(CommonEnum.SUCCESS.getCode());
        response.setPlayerPO(player);
        return response;
    }
}
