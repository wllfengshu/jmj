package com.wllfengshu.jmj.provider.room.biz.giveroom;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.common.entity.provider.enumeration.CommonEnum;
import com.wllfengshu.jmj.provider.api.room.model.RoomPO;
import com.wllfengshu.jmj.provider.api.room.model.giveroom.GiveRoomRequest;
import com.wllfengshu.jmj.provider.api.room.model.giveroom.GiveRoomResponse;
import com.wllfengshu.jmj.provider.room.dao.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2022-05-09 21:35
 */
@Service
public class GiveRoomBiz extends AbstractInterfaceBase<GiveRoomRequest, GiveRoomResponse> {

    @Autowired
    private RoomDAO roomDAO;

    @Override
    protected String giveActionName() {
        return "giveRoom";
    }

    @Override
    protected GiveRoomResponse doProcess(GiveRoomRequest request) {
        GiveRoomResponse response = new GiveRoomResponse();
        response.setBizResponseCode(CommonEnum.SUCCESS.getCode());

        LambdaQueryWrapper<RoomPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(RoomPO::getUsername, request.getGatewayLoginInfo().getUsername());
        RoomPO room = roomDAO.selectOne(wrapper);
        response.setRoomPO(room);
        return response;
    }
}
