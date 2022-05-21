package com.wllfengshu.jmj.provider.api.player.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 玩家
 *
 * @author wangll
 * @date 2022-02-13 23:36
 */
@Data
@TableName("tb_player")
public class PlayerPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
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

    /**
     * 密码
     */
    private String password;
}
