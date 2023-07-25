package com.atguigu.sbweb.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/5/5 20:27
 **/
@Slf4j
// @WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("容器初始化完成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("容器销毁");
    }
}
