package com.wllfengshu.jmj.common.entity.player;

import lombok.Data;

/**
 * 玩家
 *
 * @author wangll
 * @date 2022-02-13 23:36
 */
@Data
public class PlayerEntity {

    /**
     * ID
     */
    private Long id;

    /**
     * 登陆名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String headPortraitUrl;

    /**
     * 金币
     */
    private Long goldCoins;
}
