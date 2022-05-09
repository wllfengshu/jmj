package com.wllfengshu.jmj.provider.api.hall.model.givehall;

import com.wllfengshu.jmj.provider.api.hall.model.HallEntity;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-05-08 23:38
 */
@Data
public class GiveHallResponse {

    /**
     * 大厅信息
     */
    private HallEntity hallEntity;
}
