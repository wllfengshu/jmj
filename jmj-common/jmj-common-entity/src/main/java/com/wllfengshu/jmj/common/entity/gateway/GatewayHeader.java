package com.wllfengshu.jmj.common.entity.gateway;

import com.wllfengshu.jmj.common.entity.player.PlayerEntity;
import lombok.Data;

/**
 * 网关请求头
 *
 * @author wangll
 * @date 2022-05-06 9:23
 */
@Data
public class GatewayHeader {

    /**
     * 请求唯一标识
     */
    private String requestId;

    /**
     * 登陆时间
     */
    private String loginTime;

    /**
     * 用户信息
     */
    private PlayerEntity playerEntity;
}
