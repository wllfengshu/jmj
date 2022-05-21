package com.wllfengshu.jmj.provider.api.player.model.register;

import lombok.Data;
import org.springframework.lang.NonNull;

/**
 * @author wangll
 * @date 2022-05-21 16:45
 */
@Data
public class RegisterRequest {

    /**
     * 用户名
     */
    @NonNull
    private String username;

    /**
     * 密码
     */
    @NonNull
    private String password;

    /**
     * 确认密码
     */
    @NonNull
    private String confirmPassword;
}
