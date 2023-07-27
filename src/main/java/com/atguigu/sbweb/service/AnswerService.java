package com.atguigu.sbweb.service;

import com.atguigu.sbweb.mapper.AnswerMapper;
import com.atguigu.sbweb.model.Answer;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/7/27 11:29
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AnswerService extends ServiceImpl<AnswerMapper, Answer> {

    private final AnswerMapper answerMapper;

    public Answer getAnswerById(Long id){
        final Answer answer = answerMapper.getAnswer(id);
        return answer;
    }

    public List<Answer> getAnswerList() {
        List<Answer> answers = answerMapper.getAnswerList();
        return answers;
    }

    public void save2(Answer answer) {
        answerMapper.save2(answer);
    }

    public void insert2(Answer answer) {
        answerMapper.insert(answer);
    }
}
