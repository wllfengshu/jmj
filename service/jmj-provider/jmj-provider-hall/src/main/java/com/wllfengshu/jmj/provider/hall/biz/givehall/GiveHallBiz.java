package com.wllfengshu.jmj.provider.hall.biz.givehall;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.common.entity.provider.enumeration.CommonEnum;
import com.wllfengshu.jmj.provider.api.hall.model.HallPO;
import com.wllfengshu.jmj.provider.api.hall.model.givehall.GiveHallRequest;
import com.wllfengshu.jmj.provider.api.hall.model.givehall.GiveHallResponse;
import com.wllfengshu.jmj.provider.hall.dao.HallDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2022-05-09 21:32
 */
@Service
public class GiveHallBiz extends AbstractInterfaceBase<GiveHallRequest, GiveHallResponse> {

    @Autowired
    private HallDAO hallDAO;

    @Override
    protected String giveActionName() {
        return "giveHall";
    }

    @Override
    protected GiveHallResponse doProcess(GiveHallRequest request) {
        GiveHallResponse response = new GiveHallResponse();
        response.setBizResponseCode(CommonEnum.SUCCESS.getCode());

        LambdaQueryWrapper<HallPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(HallPO::getUsername, request.getGatewayLoginInfo().getUsername());
        HallPO hall = hallDAO.selectOne(wrapper);
        response.setHallPO(hall);
        return response;
    }
}
