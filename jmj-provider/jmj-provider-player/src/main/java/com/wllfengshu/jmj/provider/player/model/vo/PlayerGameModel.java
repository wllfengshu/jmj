package com.wllfengshu.jmj.provider.player.model.vo;

import com.wllfengshu.jmj.common.entity.player.PlayerEntity;

import java.util.List;

/**
 * 一局游戏
 *
 * @author wangll
 * @date 2022-02-13 23:40
 */
public class PlayerGameModel {

    /**
     * 一局游戏的人集合
     */
    private List<PlayerEntity> playerEntities;

    /**
     * 玩家数量
     */
    private Integer playerNum;
}
