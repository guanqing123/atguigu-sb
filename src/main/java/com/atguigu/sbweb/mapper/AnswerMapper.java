package com.atguigu.sbweb.mapper;

import com.atguigu.sbweb.model.Answer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// @Mapper
public interface AnswerMapper {

    Answer getAnswer(Long id);

    @Select("select * from answer")
    List<Answer> getAnswerList();

    void save(Answer answer);

    @Insert("insert into answer(text, `desc`) values(#{text}, #{desc})")
    @Options(useGeneratedKeys = true, keyProperty = "answerId")
    void insert(Answer answer);
}
