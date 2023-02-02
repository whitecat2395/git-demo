package com.wuaishop.user.enums;

import lombok.Getter;

@Getter
public enum AuthStatusEnum {
    /**
     * 认证通过
     */
    AUTH_SUCCESS("0","认证通过"),
    /**
     * 认证过期
     */
    AUTH_EXPIRE("1","认证过期"),
    /**
     * 系统被禁用
     */
    AUTH_DISABLE("2","当前系统被禁用"),
    /**
     * 系统未注册
     */
    AUTH_MISS("3","系统未注册"),
    /**
     * 认证失败
     */
    AUTH_ERROR("4","认证失败");

    String value;
    String msg;

    AuthStatusEnum(String value , String msg){
        this.value=value;
        this.msg=msg;
    }
}
