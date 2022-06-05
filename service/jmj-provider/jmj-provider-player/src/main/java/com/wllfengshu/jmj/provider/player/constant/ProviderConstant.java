package com.wllfengshu.jmj.provider.player.constant;

/**
 * @author wangll
 * @date 2022-05-22 13:50
 */
public class ProviderConstant {

    private ProviderConstant() {}

    /**
     * 注册-默认值-玩家头像
     */
    public static final String REGISTER_HEAD_PORTRAIT_URL = "https://gitee.com/tiandixuanwuliang/jmj/raw/master/center-img/player/default/headPortraitUrl.png";

    /**
     * 注册-token超时时间（单位天）
     */
    public static final int REGISTER_TOKEN_TIMEOUT = 30;

    /**
     * redis前缀
     */
    public static final String REDIS_PREFIX = "player:";

    /**
     * redis中存放的前缀（token为key，用户信息为value）
     */
    public static final String REDIS_PREFIX_TOKEN_TO_PLAYER = REDIS_PREFIX + "tokenToPlayer:";

    /**
     * redis中存放的前缀（username为key，token为value）
     */
    public static final String REDIS_PREFIX_USERNAME_TO_TOKEN = REDIS_PREFIX + "usernameToToken:";
}
