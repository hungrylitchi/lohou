package com.litchi.cool.lohou.common.exception;

import com.litchi.cool.lohou.common.enums.RetCodeEnum;
import lombok.Data;

@Data
public class LohouException extends RuntimeException {
    private String code;
    private String msg;

    public LohouException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public LohouException(String code, String msg, String detailMessage) {
        super(detailMessage);
        this.code = code;
        this.msg = msg;
    }

    public LohouException(RetCodeEnum retCodeEnum) {
        super(retCodeEnum.getMsg());
        this.code = retCodeEnum.getCode();
        this.msg = retCodeEnum.getMsg();
    }
}
