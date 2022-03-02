package com.wllfengshu.jmj.common.entity.majiang.enumerate;

/**
 * @author wangll
 * @date 2022-02-13 23:14
 */
public enum MajiangTypeEnum {

    WAN("万", 0),
    TIAO("条", 1),
    TONG("筒", 2),

    DONG("东", 3),
    NAN("南", 4),
    XI("西", 5),
    BEI("北", 6),
    ZHONG("中", 7),
    FA("发", 8),
    BAI("白", 9);

    private String name;
    private Integer code;

    MajiangTypeEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }
}
