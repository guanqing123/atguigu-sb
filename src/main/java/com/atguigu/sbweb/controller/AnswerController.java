package com.atguigu.sbweb.controller;

import com.atguigu.sbweb.model.Answer;
import com.atguigu.sbweb.service.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/7/27 11:30
 **/
@Slf4j
@RestController
@RequestMapping("/answer")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping("/byId")
    public Answer getAnswerById(@RequestParam("id") Long id){
        return answerService.getAnswerById(id);
    }

    @GetMapping("/getAnswerList")
    public List<Answer> getAnswerList(){
        return answerService.getAnswerList();
    }

    @PostMapping("/save")
    public Answer save(Answer answer){
        int random = new Random().nextInt(10);
        if (random %2==0) {
            log.info("save --> random:{}", random);
            answerService.save(answer);
        } else {
            log.info("insert --> random:{}", random);
            answerService.insert(answer);
        }
        return answer;
    }
}
