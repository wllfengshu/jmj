package com.wllfengshu.jmj.provider.room.constant;

/**
 * @author wangll
 * @date 2022-05-22 13:50
 */
public class ProviderConstant {

    private ProviderConstant() {}

    /**
     * 房间redis存储超时时间
     */
    public static final int CREATE_ROOM_TIMEOUT = 1;

    /**
     * redis前缀
     */
    public static final String REDIS_PREFIX = "room:";

    /**
     * redis中存放的前缀（roomId为key，房间信息为value）
     */
    public static final String REDIS_PREFIX_ROOM_ID_TO_ROOM = REDIS_PREFIX + "roomIdToRoom:";

    /**
     * redis中存放的前缀（username为key，roomId为value）
     */
    public static final String REDIS_PREFIX_USERNAME_TO_ROOM_ID = REDIS_PREFIX + "usernameToRoomId:";


}
