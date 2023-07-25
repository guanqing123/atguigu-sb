package com.atguigu.sbweb.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/5/5 20:39
 **/
// (proxyBeanMethods = true): 保证依赖的组件始终是单实例的
@Configuration(proxyBeanMethods = true)
public class MyRegisterConfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean(myServlet, "/my","/my02");
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter myFilter = new MyFilter();
        // return new FilterRegistrationBean(myFilter, myServlet());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my", "/my02"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyListener myListener = new MyListener();
        return new ServletListenerRegistrationBean(myListener);
    }
}
