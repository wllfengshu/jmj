package com.wllfengshu.jmj.provider.majiang.web;

import com.wllfengshu.jmj.common.entity.majiang.MajiangPairModel;
import com.wllfengshu.jmj.provider.majiang.service.MajiangService;
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
@Api(value = "Majiang", tags = "麻将")
@RestController
@RequestMapping("/majaing/")
@RequiredArgsConstructor
public class MajiangController {

    @NonNull
    private MajiangService majiangService;

    @ApiOperation(value = "获取麻将", httpMethod = "GET")
    @GetMapping(value = "/giveMajiang")
    public ResponseEntity<MajiangPairModel> giveMajiang(@RequestParam(value = "username") String username) {
        return new ResponseEntity<>(majiangService.giveMajiang(username), HttpStatus.OK);
    }
}
