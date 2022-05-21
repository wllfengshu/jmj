package com.wllfengshu.jmj.provider.api.hall.model.givehall;

import com.wllfengshu.jmj.common.entity.gateway.GatewayResponse;
import com.wllfengshu.jmj.provider.api.hall.model.HallPO;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-05-08 23:38
 */
@Data
public class GiveHallResponse extends GatewayResponse {

    /**
     * 大厅信息
     */
    private HallPO hallPO;
}
