package com.wllfengshu.jmj.provider.api.majiang;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
@FeignClient(name = "jmj-provider-majiang")
public interface MajiangService {

}
