package com.wllfengshu.jmj.provider.api.player.model;

import lombok.Data;

/**
 * @author wangll
 * @date 2022-02-14 23:07
 */
@Data
public class LoginRequest {

    private String username;
    private String password;
}
