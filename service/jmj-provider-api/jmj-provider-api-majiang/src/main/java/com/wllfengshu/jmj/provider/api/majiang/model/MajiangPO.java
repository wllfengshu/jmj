package com.wllfengshu.jmj.provider.api.majiang.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wllfengshu.jmj.provider.api.majiang.model.enumerate.MajiangTypeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wangll
 * @date 2022-02-13 23:09
 */
@Data
@TableName("tb_majiang")
public class MajiangPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 材质
     */
    private String textureUrl;

    /**
     * 用户名
     */
    private String username;

    /**
     * 麻将的类型
     */
    private MajiangTypeEnum type;
}
