package com.atguigu.sbweb.controller;

import com.atguigu.sbweb.controller.bean.FileUpladParam;
import com.atguigu.sbweb.controller.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/7/21 16:10
 **/
@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload")
    public String upload(FileUpladParam param, @RequestPart("avatar")MultipartFile avatar, @RequestBody FileUpladParam fileUpladParam){
        log.info("头像名：{}, 兴趣个数: {}, avatar: {}",
                param.getHeadImg().getOriginalFilename(), param.getInterest().length, avatar.getSize());
        return "上传成功";
    }

    @PostMapping("/bodyUpload")
    public String requestBodyUpload(@RequestBody FileUpladParam fileUpladParam){
        log.info("fileUploadParam: {}", fileUpladParam);
        return "上传测试";
    }

    @PostMapping("/body")
    public String body(@RequestBody FileUpladParam param, @RequestBody Person person){
        log.info("param:{}, person:{}", param, person);
        return "body";
    }

    @PostMapping("/body2")
    public String body(@RequestBody FileUpladParam param){
        log.info("param:{}", param);
        return "body";
    }
}
