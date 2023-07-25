package com.atguigu.sbweb.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/5/5 20:24
 **/
@Slf4j
// @WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("MyFilter工作");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("MyFilter销毁");
    }
}
