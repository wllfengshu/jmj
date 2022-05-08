package com.wllfengshu.jmj.provider.api.majiang.model;

import com.wllfengshu.jmj.provider.api.majiang.model.enumerate.MajiangTypeEnum;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-02-13 23:09
 */
@Data
public class MajiangEntity {

    /**
     * 麻将的类型
     */
    private MajiangTypeEnum type;
}
