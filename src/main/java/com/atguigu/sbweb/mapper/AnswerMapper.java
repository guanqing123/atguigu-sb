package com.atguigu.sbweb.mapper;

import com.atguigu.sbweb.model.Answer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// @Mapper
public interface AnswerMapper extends BaseMapper<Answer> {

    Answer getAnswer(Long id);

    @Select("select * from answer")
    List<Answer> getAnswerList();

    void save2(Answer answer);

    @Insert("insert into answer(text, `desc`) values(#{text}, #{desc})")
    @Options(useGeneratedKeys = true, keyProperty = "answerId")
    void insert2(Answer answer);
}
