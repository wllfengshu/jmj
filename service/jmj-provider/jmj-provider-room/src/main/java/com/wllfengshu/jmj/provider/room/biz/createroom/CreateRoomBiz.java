package com.wllfengshu.jmj.provider.room.biz.createroom;

import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.common.entity.provider.enumeration.CommonEnum;
import com.wllfengshu.jmj.provider.api.room.model.RunRoomPO;
import com.wllfengshu.jmj.provider.api.room.model.createroom.CreateRoomRequest;
import com.wllfengshu.jmj.provider.api.room.model.createroom.CreateRoomResponse;
import com.wllfengshu.jmj.provider.room.constant.ProviderConstant;
import com.wllfengshu.jmj.provider.room.dao.RunRoomDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.wllfengshu.jmj.provider.room.constant.ProviderConstant.REDIS_PREFIX_ROOM_ID_TO_ROOM;
import static com.wllfengshu.jmj.provider.room.constant.ProviderConstant.REDIS_PREFIX_USERNAME_TO_ROOM_ID;

/**
 * @author wangll
 * @date 2022-06-05 17:34
 */
@Service
public class CreateRoomBiz extends AbstractInterfaceBase<CreateRoomRequest, CreateRoomResponse> {

    @Autowired
    private RunRoomDAO runRoomDAO;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    protected String giveActionName() {
        return "createRoom";
    }

    @Override
    protected CreateRoomResponse doProcess(CreateRoomRequest request) {
        // 0检查是否已经在房间
        String oldRoomId = (String) redisTemplate.opsForValue().get(REDIS_PREFIX_USERNAME_TO_ROOM_ID + request.getGatewayLoginInfo().getUsername());
        if (StringUtils.isNotEmpty(oldRoomId)) {
            RunRoomPO po = (RunRoomPO) redisTemplate.opsForValue().get(REDIS_PREFIX_ROOM_ID_TO_ROOM + oldRoomId);
            CreateRoomResponse response = new CreateRoomResponse();
            response.setBizResponseCode(CommonEnum.SUCCESS.getCode());
            response.setRunRoomPO(po);
            redisTemplate.expire(REDIS_PREFIX_ROOM_ID_TO_ROOM + oldRoomId, ProviderConstant.CREATE_ROOM_TIMEOUT, TimeUnit.DAYS);
            redisTemplate.expire(REDIS_PREFIX_USERNAME_TO_ROOM_ID + request.getGatewayLoginInfo().getUsername(), ProviderConstant.CREATE_ROOM_TIMEOUT, TimeUnit.DAYS);
            return response;
        }

        // 1insert db
        RunRoomPO po = new RunRoomPO();
        po.setRoomPassword(request.getRoomPassword());
        runRoomDAO.insert(po);
        // 2save redis
        redisTemplate.opsForValue().set(REDIS_PREFIX_ROOM_ID_TO_ROOM + po.getRoomId(), po);
        redisTemplate.opsForValue().set(REDIS_PREFIX_USERNAME_TO_ROOM_ID + request.getGatewayLoginInfo().getUsername(), po.getRoomId());
        // 3return
        CreateRoomResponse response = new CreateRoomResponse();
        response.setRunRoomPO(po);
        return response;
    }
}
