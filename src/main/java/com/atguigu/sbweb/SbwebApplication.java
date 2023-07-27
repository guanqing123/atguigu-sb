package com.atguigu.sbweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.atguigu.sbweb.mapper")
@ServletComponentScan
@SpringBootApplication
public class SbwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbwebApplication.class, args);
    }

}
