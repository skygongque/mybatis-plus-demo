package com.example.mybatisdemo.exception;

import com.example.mybatisdemo.util.CommonResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//全局异常处理
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({Exception.class})
    public <T> CommonResult<T> handleException(final Exception exception) {
        exception.printStackTrace();
        return CommonResult.error(StringUtils.hasLength(exception.getMessage()) ? exception.getMessage() : "操作失败");
    }
}
