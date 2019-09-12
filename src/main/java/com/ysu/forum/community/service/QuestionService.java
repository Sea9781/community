package com.ysu.forum.community.service;

import com.ysu.forum.community.dto.QuestionDTO;
import com.ysu.forum.community.mapper.QuestionMapper;
import com.ysu.forum.community.mapper.UserMapper;
import com.ysu.forum.community.model.Question;
import com.ysu.forum.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: community
 * @description:
 * @author: Sea
 * @create: 2019-09-05 21:39
 **/
@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList =new ArrayList<>();
        for(Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO() ;
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO. setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
