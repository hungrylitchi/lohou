package com.litchi.cool.lohou.common.config;

import com.litchi.cool.lohou.common.base.BaseResponse;
import com.litchi.cool.lohou.common.enums.RetCodeEnum;
import com.litchi.cool.lohou.common.exception.LohouException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(Throwable.class)
    BaseResponse<Object> handleException(Throwable throwable , HttpServletRequest request, HttpServletResponse response) {
        if(throwable instanceof LohouException){
            LohouException lohouException = (LohouException) throwable;
            log.warn("errcode:{},errMsg:{},{}", lohouException.getCode(), lohouException.getMsg(),lohouException.getStackTrace()[0]);
            return BaseResponse.fail(lohouException.getCode(), lohouException.getMsg());
        }else{
            log.error("", throwable);
            return BaseResponse.fail(RetCodeEnum.SYSTEM_ERROR);
        }
    }

}
