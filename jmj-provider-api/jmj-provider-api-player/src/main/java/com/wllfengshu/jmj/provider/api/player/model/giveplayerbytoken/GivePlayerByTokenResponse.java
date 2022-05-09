package com.wllfengshu.jmj.provider.api.player.model.giveplayerbytoken;

import com.wllfengshu.jmj.provider.api.player.model.PlayerEntity;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-05-07 9:58
 */
@Data
public class GivePlayerByTokenResponse {

    /**
     * 玩家信息
     */
    private PlayerEntity playerEntity;
}
