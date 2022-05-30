package com.wllfengshu.jmj.provider.api.hall.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wangll
 * @date 2022-02-13 23:47
 */
@Data
@TableName("tb_hall")
public class HallPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    private Integer id;

    /**
     * 背景图
     */
    private String bgImgUrl;

    /**
     * 用户名
     */
    private String username;
}
