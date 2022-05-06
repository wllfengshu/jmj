package com.wllfengshu.jmj.provider.majiang.web;

import com.wllfengshu.jmj.provider.majiang.service.MajiangService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 麻将
 *
 * @author wangll
 * @date 2022-02-13 20:03
 */
@Slf4j
@RestController
@RequestMapping("/majaing/")
@RequiredArgsConstructor
public class MajiangController {

    @NonNull
    private MajiangService majiangService;


}
