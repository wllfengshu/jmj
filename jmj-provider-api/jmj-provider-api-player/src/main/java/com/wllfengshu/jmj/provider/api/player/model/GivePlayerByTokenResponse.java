package com.wllfengshu.jmj.provider.api.player.model;

import com.wllfengshu.jmj.common.entity.player.PlayerEntity;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-05-07 9:58
 */
@Data
public class GivePlayerByTokenResponse {

    private PlayerEntity playerEntity;
}
