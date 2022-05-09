package com.wllfengshu.jmj.provider.api.player.model.login;

import com.wllfengshu.jmj.provider.api.player.model.PlayerEntity;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-02-14 23:10
 */
@Data
public class LoginResponse {

    /**
     * 登陆的唯一标识
     */
    private String token;

    /**
     * 玩家信息
     */
    private PlayerEntity playerEntity;
}
