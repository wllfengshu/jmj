package com.wllfengshu.jmj.provider.api.player.model.giveplayerbytoken;

import com.wllfengshu.jmj.common.entity.gateway.GatewayResponse;
import com.wllfengshu.jmj.provider.api.player.model.PlayerPO;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-05-07 9:58
 */
@Data
public class GivePlayerByTokenResponse extends GatewayResponse {

    /**
     * 玩家信息
     */
    private PlayerPO playerPO;
}
