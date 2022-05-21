package com.wllfengshu.jmj.provider.hall.biz.givehall;

import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.provider.api.hall.model.HallPO;
import com.wllfengshu.jmj.provider.api.hall.model.givehall.GiveHallRequest;
import com.wllfengshu.jmj.provider.api.hall.model.givehall.GiveHallResponse;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2022-05-09 21:32
 */
@Service
public class GiveHallBiz extends AbstractInterfaceBase<GiveHallRequest, GiveHallResponse> {

    @Override
    protected String giveActionName() {
        return "giveHall";
    }

    @Override
    protected GiveHallResponse doProcess(GiveHallRequest request) {
        GiveHallResponse response = new GiveHallResponse();

        HallPO hallPO = new HallPO();
        hallPO.setBgImgUrl("https://gitee.com/tiandixuanwuliang/jmj/raw/master/center-img/hall/default/hall-bg.png");
        response.setHallPO(hallPO);

        return response;
    }
}
