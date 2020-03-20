package com.litchi.cool.lohou.common.base;

import com.litchi.cool.lohou.common.enums.RetCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    String code;
    String msg;
    T data;

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(RetCodeEnum.SUCCESS.getCode(), RetCodeEnum.SUCCESS.getMsg(), data);
    }

    public static<T>  BaseResponse<T> fail() {
        return new BaseResponse<>(RetCodeEnum.FAILED.getCode(), RetCodeEnum.FAILED.getMsg(), null);
    }

    public static <T> BaseResponse<T> fail(String code, String msg) {
        return new BaseResponse<>(code, msg, null);
    }

    public static <T> BaseResponse<T> fail(RetCodeEnum retCodeEnum) {
        return new BaseResponse<>(retCodeEnum.getCode(), retCodeEnum.getMsg(), null);
    }

}
