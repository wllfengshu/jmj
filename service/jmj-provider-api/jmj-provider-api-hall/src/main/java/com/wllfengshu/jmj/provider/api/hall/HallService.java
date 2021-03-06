package com.wllfengshu.jmj.provider.api.hall;

import com.wllfengshu.jmj.provider.api.hall.model.givehall.GiveHallRequest;
import com.wllfengshu.jmj.provider.api.hall.model.givehall.GiveHallResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
@FeignClient(name = "jmj-provider-hall")
public interface HallService {

    @ApiOperation("获取大厅")
    @PostMapping(value = "/giveHall")
    GiveHallResponse giveHall(@RequestBody GiveHallRequest request);


}
