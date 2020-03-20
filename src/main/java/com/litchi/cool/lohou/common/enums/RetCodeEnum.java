package com.litchi.cool.lohou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  RetCodeEnum {
    //common
    SUCCESS("0", "成功"),
    FAILED("1", "失败"),
    SYSTEM_ERROR("LH9000", "系统繁忙,请您稍后再试或联系客服！"),

    //链接
    LINK_PROTOCOL_CHECK_FAILED("LH5001","链接必须以 “http://” 或 “https://” 开头！"),
    LINK_BLINK_CHECK_FAILED("LH5002","链接中包含空格！"),
    LINK_INSERT_FAILED("LH5010","链接插入失败，请重试！"),

    ;

    private String code;
    private String msg;
}
