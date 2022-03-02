package com.wllfengshu.jmj.common.entity.majiang;

import com.wllfengshu.jmj.common.entity.majiang.entity.MajiangEntity;
import lombok.Data;

import java.util.List;

/**
 * 一副牌
 *
 * @author wangll
 * @date 2022-02-13 23:27
 */
@Data
public class MajiangPairModel {

    /**
     * 麻将
     */
    private List<MajiangEntity> majiangEntities;

    /**
     * 总张数
     */
    private Integer totalNum;

    /**
     * 剩余张数
     */
    private Integer surplusNum;
}
