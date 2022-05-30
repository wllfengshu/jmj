package com.wllfengshu.jmj.provider.api.dice.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 骰子
 *
 * @author wangll
 * @date 2022-02-13 20:26
 */
@Data
@TableName("tb_dice")
public class DicePO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    private Integer id;

    /**
     * 1点的材质地址
     */
    private String texturePoint1Url;

    /**
     * 掷骰子动态图的材质地址
     */
    private String textureGifUrl;

    /**
     * 用户名
     */
    private String username;
}
