package com.wllfengshu.jmj.provider.api.player.model.giveplayerbytoken;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

/**
 * 根据token获取用户信息的实体类（这个类不要继承GatewayRequest）
 *
 * @author wangll
 * @date 2022-05-07 9:58
 */
@Data
@NoArgsConstructor
public class GivePlayerByTokenRequest {

    /**
     * 登陆的唯一凭证
     */
    @NonNull
    private String token;
}
