package com.wllfengshu.jmj.provider.majiang.web;

import com.wllfengshu.jmj.provider.majiang.service.MajiangService;
import io.swagger.annotations.Api;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
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


}
