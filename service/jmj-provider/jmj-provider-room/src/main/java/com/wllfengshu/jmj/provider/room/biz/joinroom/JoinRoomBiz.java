package com.wllfengshu.jmj.provider.room.biz.joinroom;

import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.provider.api.room.model.joinroom.JoinRoomRequest;
import com.wllfengshu.jmj.provider.api.room.model.joinroom.JoinRoomResponse;
import com.wllfengshu.jmj.provider.api.room.model.joinroom.JoinRoomStatusEnum;
import com.wllfengshu.jmj.provider.room.dao.RunRoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2022-06-05 17:34
 */
@Service
public class JoinRoomBiz extends AbstractInterfaceBase<JoinRoomRequest, JoinRoomResponse> {

    @Autowired
    private RunRoomDAO runRoomDAO;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    protected String giveActionName() {
        return "createRoom";
    }

    @Override
    protected JoinRoomResponse doProcess(JoinRoomRequest request) {
        JoinRoomResponse response = new JoinRoomResponse();
        response.setJoinRoomStatusEnum(JoinRoomStatusEnum.NORMAL);
        response.setRunRoomPO(null);
        return null;
    }
}
