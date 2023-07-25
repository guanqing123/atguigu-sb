package com.atguigu.sbweb.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @description: TODO 处理整个web controller的异常
 * @Author guanqing
 * @Date 2023/7/24 11:43
 **/
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class,NullPointerException.class}) //处理异常
    public String handlerArithException(Exception e){

        log.error("异常是：{}", e);
        return "login"; //视图地址
    }
}
