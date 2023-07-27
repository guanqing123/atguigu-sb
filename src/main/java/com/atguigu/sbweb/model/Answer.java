package com.atguigu.sbweb.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/7/27 10:57
 **/
@Data
public class Answer {

    private Long answerId;
    private String text;
    @TableField(value = "`desc`")
    private String desc;
}
