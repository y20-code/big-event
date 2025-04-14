package com.yls.exception;

import com.yls.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理器
@RestControllerAdvice
public class GlobalExceptionHander {

    //jakarta.validation.ConstraintViolationException: register.username: 需要匹配正则表达式"^\S{5,16}$"
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error(StringUtils.hasLength(e.getMessage())? e.getMessage() : "操作失败");
    }
}
