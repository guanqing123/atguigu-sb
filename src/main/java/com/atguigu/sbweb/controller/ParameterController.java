package com.atguigu.sbweb.controller;

import com.atguigu.sbweb.controller.bean.Person;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/4/9 9:01
 **/
@RestController
public class ParameterController {

    /**
     * 数据绑定：页面提交的请求数据（GET、POST）都可以和对象属性进行绑定
     * @Author guanqing
     * @Date 2023/4/9 22:06
     **/
    @PostMapping("/saveuser")
    public Person saveuser(Person person){
        return person;
    }

    @PostMapping("/he")
    public HttpEntity he(){
        final Person person = new Person();
        person.setUserName("zhangsan");
        int i= 1/0;
        return new HttpEntity(person);
    }

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") String id,
                                     @PathVariable("username") String username,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> headers,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @CookieValue("Webstorm-4041027b") Cookie cookie){
        Map<String, Object> map = new HashMap<>();

        map.put("id", id);
        map.put("username", username);
        map.put("pv", pv);
        map.put("userAgent", userAgent);
        map.put("headers", headers);
        map.put("age", age);
        map.put("inters", inters);
        System.out.println(cookie.getName() + "\t" + cookie.getValue());
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }

    //1、语法： 请求路径：/cars/sell;low=34;brand=byd,audi,yd
    //2、SpringBoot默认是禁用了矩阵变量的功能
    //      手动开启：原理。对于路径的处理。UrlPathHelper进行解析。
    //              removeSemicolonContent（移除分号内容）支持矩阵变量的
    //3、矩阵变量必须有url路径变量才能被解析
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();

        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    // /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        Map<String,Object> map = new HashMap<>();

        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }
}
