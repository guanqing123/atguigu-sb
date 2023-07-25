package com.atguigu.sbweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SbwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbwebApplication.class, args);
    }

}
