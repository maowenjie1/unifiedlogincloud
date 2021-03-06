package com.zuma.smssender.enums;

import lombok.Getter;
import org.omg.CORBA.UNKNOWN;

/**
 * author:Administrator
 * datetime:2017/11/8 0008 13:38
 * 手机运营商枚举
 */
@Getter
public enum PhoneOperatorEnum implements CodeEnum<Integer> {
    YIDONG(0,"移动"),
    DIANXIN(1,"电信"),
    LIANTONG(2,"联通"),

    ALL(4,"所有"),
    UNKNOWN(-1,"未知")
    ;
    private Integer code;
    private String message;

    PhoneOperatorEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
