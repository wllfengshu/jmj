package com.wllfengshu.jmj.provider.hall.biz.givehall;

import com.wllfengshu.jmj.provider.api.hall.model.HallEntity;
import com.wllfengshu.jmj.provider.api.hall.model.givehall.GiveHallRequest;
import com.wllfengshu.jmj.provider.api.hall.model.givehall.GiveHallResponse;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2022-05-09 21:32
 */
@Service
public class GiveHallBiz {

    public GiveHallResponse login(GiveHallRequest request) {
        GiveHallResponse response = new GiveHallResponse();

        HallEntity hallEntity = new HallEntity();
        hallEntity.setBgImgUrl("https://gitee.com/tiandixuanwuliang/test/blob/master/img-center/hall/default/hall-bg.png");
        response.setHallEntity(hallEntity);

        return response;
    }
}
