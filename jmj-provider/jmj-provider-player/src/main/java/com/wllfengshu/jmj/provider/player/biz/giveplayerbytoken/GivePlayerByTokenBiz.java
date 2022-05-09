package com.wllfengshu.jmj.provider.player.biz.giveplayerbytoken;

import com.wllfengshu.jmj.provider.api.player.model.PlayerEntity;
import com.wllfengshu.jmj.provider.api.player.model.giveplayerbytoken.GivePlayerByTokenRequest;
import com.wllfengshu.jmj.provider.api.player.model.giveplayerbytoken.GivePlayerByTokenResponse;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2022-05-08 19:12
 */
@Service
public class GivePlayerByTokenBiz {

    public GivePlayerByTokenResponse givePlayerByToken(GivePlayerByTokenRequest request) {
        GivePlayerByTokenResponse response = new GivePlayerByTokenResponse();
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setUsername("zhangSan");
        response.setPlayerEntity(playerEntity);

        return response;
    }
}
