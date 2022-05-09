package com.wllfengshu.jmj.provider.api.player.model.giveplayerbytoken;

import lombok.Data;

/**
 * @author wangll
 * @date 2022-05-07 9:58
 */
@Data
public class GivePlayerByTokenRequest {

    /**
     * 登陆的唯一标识
     */
    private String token;
}
