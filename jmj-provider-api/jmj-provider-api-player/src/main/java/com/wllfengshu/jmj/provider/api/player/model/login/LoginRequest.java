package com.wllfengshu.jmj.provider.api.player.model.login;

import lombok.Data;

/**
 * @author wangll
 * @date 2022-02-14 23:07
 */
@Data
public class LoginRequest {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
