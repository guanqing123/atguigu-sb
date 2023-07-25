package com.atguigu.sbweb.controller;

import com.atguigu.sbweb.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/4/8 21:35
 **/
@RestController
@RequestMapping("/prop")
public class PropController {

    @Autowired
    Person person;

    @PostMapping("/person")
    public ResponseEntity person(HttpServletRequest request){
        return ResponseEntity.ok(person);
    }
}
