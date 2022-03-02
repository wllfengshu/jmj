package com.wllfengshu.jmj.provider.hall.web;

import com.wllfengshu.jmj.provider.hall.model.vo.HallModel;
import com.wllfengshu.jmj.provider.hall.service.HallService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangll
 * @date 2022-02-13 20:03
 */
@Slf4j
@Api(value = "Hall", tags = "大厅")
@RestController
@RequestMapping("/hall/")
@RequiredArgsConstructor
public class HallController {

    @NonNull
    private HallService hallService;

    @ApiOperation(value = "获取大厅", httpMethod = "GET")
    @GetMapping(value = "/giveHall")
    public ResponseEntity<HallModel> giveHall(@RequestParam(value = "username") String username) {
        return new ResponseEntity<>(hallService.giveHall(username), HttpStatus.OK);
    }
}
