package com.atguigu.sbweb.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/4/19 8:46
 **/
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行之前
     * @Author guanqing
     * @Date 2023/7/21 11:08
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String requestURI = request.getRequestURI();
        log.info("preHandle requestURI {}", requestURI);
        return true;
    }

    /**
     * 目标方法执行完成以后
     * @Author guanqing
     * @Date 2023/7/21 11:08
     **/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle handler {}", handler);
    }

    /**
     * 页面渲染以后
     * @Author guanqing
     * @Date 2023/7/21 11:10
     **/
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion {}", handler);
    }
}
