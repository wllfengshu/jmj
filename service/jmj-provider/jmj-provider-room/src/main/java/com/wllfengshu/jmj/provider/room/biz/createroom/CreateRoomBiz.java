package com.wllfengshu.jmj.provider.room.biz.createroom;

import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.common.entity.provider.enumeration.CommonEnum;
import com.wllfengshu.jmj.provider.api.room.model.RunRoomPO;
import com.wllfengshu.jmj.provider.api.room.model.createroom.CreateRoomRequest;
import com.wllfengshu.jmj.provider.api.room.model.createroom.CreateRoomResponse;
import com.wllfengshu.jmj.provider.api.room.model.createroom.RunRoomBO;
import com.wllfengshu.jmj.provider.api.room.model.createroom.RunRoomStatusEnum;
import com.wllfengshu.jmj.provider.room.constant.ProviderConstant;
import com.wllfengshu.jmj.provider.room.dao.RunRoomDAO;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
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
        final String username = request.getGatewayLoginInfo().getUsername();
        // 0检查是否已经在房间
        String oldRoomId = (String) redisTemplate.opsForValue().get(REDIS_PREFIX_USERNAME_TO_ROOM_ID + username);
        if (StringUtils.isNotEmpty(oldRoomId)) {
            redisTemplate.expire(REDIS_PREFIX_ROOM_ID_TO_ROOM + oldRoomId, ProviderConstant.CREATE_ROOM_TIMEOUT, TimeUnit.DAYS);
            redisTemplate.expire(REDIS_PREFIX_USERNAME_TO_ROOM_ID + username, ProviderConstant.CREATE_ROOM_TIMEOUT, TimeUnit.DAYS);
            RunRoomBO bo = (RunRoomBO) redisTemplate.opsForValue().get(REDIS_PREFIX_ROOM_ID_TO_ROOM + oldRoomId);
            return this.giveSuccessResponse(bo);
        }

        // 1insert db
        RunRoomPO po = new RunRoomPO();
        po.setCreatorUsername(username);
        runRoomDAO.insert(po);
        // 2save redis
        RunRoomBO bo = new RunRoomBO();
        bo.setRoomId(po.getRoomId());
        bo.setCreatorUsername(username);
        bo.setRoomPassword(request.getRoomPassword());
        bo.setAllowMaxPlayerNum(4);
        bo.setCurrentPlayerNum(NumberUtils.INTEGER_ONE);
        bo.setRunRoomStatusEnum(RunRoomStatusEnum.NORMAL);
        bo.setTokens(List.of(request.getToken()));
        redisTemplate.opsForValue().set(REDIS_PREFIX_ROOM_ID_TO_ROOM + po.getRoomId(), bo);
        redisTemplate.opsForValue().set(REDIS_PREFIX_USERNAME_TO_ROOM_ID + username, po.getRoomId());
        // 3return
        return this.giveSuccessResponse(bo);
    }

    private CreateRoomResponse giveSuccessResponse(RunRoomBO bo) {
        CreateRoomResponse response = new CreateRoomResponse();
        response.setBizResponseCode(CommonEnum.SUCCESS.getCode());
        response.setRunRoomBO(bo);
        return response;
    }
}
