package com.atguigu.sbweb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/7/25 20:51
 **/
@RestController
@RequestMapping("/sql")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DruidController {

    private final JdbcTemplate jdbcTemplate;

    @GetMapping("/query")
    public ResponseEntity query(){
        Long count = jdbcTemplate.queryForObject("select count(*) from answer", Long.class);
        return ResponseEntity.ok(count);
    }
}
