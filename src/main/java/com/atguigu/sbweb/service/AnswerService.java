package com.atguigu.sbweb.service;

import com.atguigu.sbweb.mapper.AnswerMapper;
import com.atguigu.sbweb.model.Answer;
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
public class AnswerService {

    private final AnswerMapper answerMapper;

    public Answer getAnswerById(Long id){
        final Answer answer = answerMapper.getAnswer(id);
        return answer;
    }

    public List<Answer> getAnswerList() {
        List<Answer> answers = answerMapper.getAnswerList();
        return answers;
    }

    public void save(Answer answer) {
        answerMapper.save(answer);
    }

    public void insert(Answer answer) {
        answerMapper.insert(answer);
    }
}
