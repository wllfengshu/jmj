package com.wllfengshu.jmj.provider.player.biz.giveplayerbytoken;

import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.provider.api.player.model.PlayerPO;
import com.wllfengshu.jmj.provider.api.player.model.giveplayerbytoken.GivePlayerByTokenRequest;
import com.wllfengshu.jmj.provider.api.player.model.giveplayerbytoken.GivePlayerByTokenResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2022-05-08 19:12
 */
@Service
public class GivePlayerByTokenBiz extends AbstractInterfaceBase<GivePlayerByTokenRequest, GivePlayerByTokenResponse> {

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
        GivePlayerByTokenResponse response = new GivePlayerByTokenResponse();
        PlayerPO playerPO = new PlayerPO();
        playerPO.setUsername("zhangSan");
        response.setPlayerPO(playerPO);

        return response;
    }
}
