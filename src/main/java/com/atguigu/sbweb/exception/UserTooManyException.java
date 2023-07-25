package com.atguigu.sbweb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/7/24 16:11
 **/
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量太多")
public class UserTooManyException extends RuntimeException {

    public UserTooManyException() {
    }

    public UserTooManyException(String message) {
        super(message);
    }
}
