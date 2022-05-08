package com.wllfengshu.jmj.provider.player.biz.giveplayerbytoken;

import com.wllfengshu.jmj.common.entity.player.PlayerEntity;
import com.wllfengshu.jmj.provider.api.player.model.GivePlayerByTokenRequest;
import com.wllfengshu.jmj.provider.api.player.model.GivePlayerByTokenResponse;
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
        playerEntity.setId(1L);
        playerEntity.setUsername("zhangSan");
        response.setPlayerEntity(playerEntity);

        return response;
    }
}
