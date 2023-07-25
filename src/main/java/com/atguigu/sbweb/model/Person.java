package com.atguigu.sbweb.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/4/8 21:23
 **/
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String userName;
    private Boolean boss;
    private Date birth;
    private Pet pet;
    private Integer age;
    private String[] interests;
    private List<String> animal;
    private Map<String, Object> score;
    private Set<Double> salarys;
    private Map<String, List<Pet>> allPets;
}
