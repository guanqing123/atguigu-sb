package com.atguigu.sbweb;

import com.alibaba.druid.support.http.StatViewServlet;
import com.atguigu.sbweb.mapper.AnswerMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class SbwebApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    AnswerMapper answerMapper;

    @Test
    void contextLoads() {
        Long count = jdbcTemplate.queryForObject("select count(*) from answer", Long.class);
        log.info("记录条数:{}", count);

        log.info("datasource {}", dataSource.getClass());

        System.out.println(answerMapper.selectList(null));
    }
}
