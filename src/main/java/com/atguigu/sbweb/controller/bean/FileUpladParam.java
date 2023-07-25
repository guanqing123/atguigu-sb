package com.atguigu.sbweb.controller.bean;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/7/21 16:12
 **/
@Data
public class FileUpladParam {

    private String name;
    private MultipartFile headImg;
    private MultipartFile[] interest;
}
