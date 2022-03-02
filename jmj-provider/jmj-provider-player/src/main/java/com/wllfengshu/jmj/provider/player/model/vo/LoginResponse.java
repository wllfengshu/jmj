package com.wllfengshu.jmj.provider.player.model.vo;

import com.wllfengshu.jmj.common.entity.player.PlayerEntity;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-02-14 23:10
 */
@Data
public class LoginResponse {

    private String sessionId;

    private PlayerEntity playerEntity;
}
