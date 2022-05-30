package com.wllfengshu.jmj.provider.player.enumeration;

/**
 * @author wangll
 * @date 2022-05-22 10:42
 */
public enum ProviderEnum {

    /**
     * 注册
     */
    THE_TWO_PASSWORDS_ARE_INCONSISTENT(-1000, "两次密码不一致"),
    USER_EXISTS(-1001, "用户已存在"),
    SAVE_USER_FAILED(-1002, "保存用户失败"),

    /**
     * 登陆
     */
    USER_NAME_AND_PASSWORD_NOT_MATCH(-2000, "用户名和密码不匹配"),

    /**
     * 根据token获取数据时，获取失败
     */
    NO_LOGIN(-3000, "未登录")

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
