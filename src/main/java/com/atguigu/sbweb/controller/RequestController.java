package com.atguigu.sbweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/4/9 16:25
 **/
@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg", "成功了...");
        request.setAttribute("code", 200);
        return "forward:/success";  // 转发到 /success请求
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("code") Integer code,
                       HttpServletRequest request){
        Object msg1 = request.getAttribute("msg");
        Object code1 = request.getAttribute("code");

        Map<String, Object> map = new HashMap<>();
        map.put("ann_msg", msg);
        map.put("ann_code", code);

        map.put("req_msg1", msg1);
        map.put("req_code1", code1);
        return map;
    }

    @GetMapping("/params")
    public String param(Map<String,Object> map,
                        Model model,
                        HttpServletRequest request,
                        HttpServletResponse response){
        map.put("hello", "world666");
        model.addAttribute("world", "hello666");
        request.setAttribute("message", "HelloWorld");

        Cookie cookie = new Cookie("c1", "v1");
        response.addCookie(cookie);
        return "forward:/toParam";
    }

    @ResponseBody
    @GetMapping("/toParam")
    public Map toParam(HttpServletRequest request){

        final Object hello = request.getAttribute("hello");
        final Object world = request.getAttribute("world");
        final Object message = request.getAttribute("message");
        final Cookie[] cookies = request.getCookies();


        Map<String, Object> map = new HashMap<>();
        map.put("hello", hello);
        map.put("world", world);
        map.put("message", message);
        map.put("cookie", Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("c1")).map(cookie -> cookie.getValue()).collect(Collectors.joining("")));

        return map;
    }

}
