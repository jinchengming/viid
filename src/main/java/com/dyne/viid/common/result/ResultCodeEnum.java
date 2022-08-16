package com.dyne.viid.common.result;

import lombok.Getter;

/**
 * 描述: 通用返回封装
 *
 * @author cm_fighting
 * @create 2021-11-24 下午1:36
 */
@Getter
public enum ResultCodeEnum {
    // 操作成功
    SUCCESS(true, 200, "操作成功"),
    // 操作失败
    UNKNOWN_REASON(false, 500, "操作失败"),
    // 重定向
    REDIRECT(true, 302, "重定向"),
    // 参数检验失败
    VALIDATE_FAILED(false, 402, "参数检验失败"),
    // 暂未登录或token已经过期
    UNAUTHORIZED(false, 401, "暂未登录或token已经过期"),
    // 没有相关权限
    FORBIDDEN(false, 403, "没有相关权限");

    private Boolean success;
    private Integer code;
    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
