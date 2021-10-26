package com.ruangong.douban.result;

import lombok.Getter;
import org.apache.el.parser.AstFalse;

/**
 * @version v1.0
 * @ClassName ResultCodeEnum
 * @Description TODO
 * @Author bong
 * @Date 2021/10/26 10:52
 **/
@Getter
public enum ResultCodeEnum {
    REGISTER_SUCCESS(true,20000,"注册成功"),
    REGISTER_EMAIL_ERROR(false,21000,"邮箱已存在"),
    REGISTER_USERNAME_ERROR(false,210001,"用户名称已存在")
    ;

    private Boolean success;

    private Integer code;

    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
