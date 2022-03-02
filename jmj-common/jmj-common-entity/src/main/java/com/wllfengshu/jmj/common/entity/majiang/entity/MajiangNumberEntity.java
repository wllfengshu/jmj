package com.wllfengshu.jmj.common.entity.majiang.entity;

import lombok.Data;

/**
 * 子牌
 *
 * @author wangll
 * @date 2022-02-13 23:20
 */
@Data
public class MajiangNumberEntity extends MajiangEntity{

    /**
     * 数字：1~9
     */
    private Integer number;
}
