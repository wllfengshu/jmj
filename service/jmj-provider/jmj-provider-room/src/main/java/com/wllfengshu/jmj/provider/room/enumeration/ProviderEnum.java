package com.wllfengshu.jmj.provider.room.enumeration;

/**
 * @author wangll
 * @date 2022-05-22 10:42
 */
public enum ProviderEnum {

    ;

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ProviderEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
