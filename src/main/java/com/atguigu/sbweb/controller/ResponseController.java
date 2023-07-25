package com.atguigu.sbweb.controller;

import com.atguigu.sbweb.controller.bean.Person;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/4/15 21:12
 **/
@Controller
@RequestMapping("rep")
public class ResponseController {

    @ResponseBody
    @GetMapping("/person")
    public Person getPerson(){
        Person person = new Person();
        person.setAge(28);
        person.setBirth(new Date());
        person.setUserName("zhangsan");
        return person;
    }

    @ResponseBody
    @GetMapping("/resource")
    public FileSystemResource resource(){
        return null;
    }
}
