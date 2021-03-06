package com.wllfengshu.jmj.provider.hall.service;

import com.wllfengshu.jmj.provider.api.hall.HallService;
import com.wllfengshu.jmj.provider.api.hall.model.givehall.GiveHallRequest;
import com.wllfengshu.jmj.provider.api.hall.model.givehall.GiveHallResponse;
import com.wllfengshu.jmj.provider.hall.biz.givehall.GiveHallBiz;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
@Api
@Slf4j
@RestController
public class HallServiceImpl implements HallService {

    @Autowired
    private GiveHallBiz giveHallBiz;

    @Override
    public GiveHallResponse giveHall(GiveHallRequest request) {
        return giveHallBiz.process(request);
    }
}
