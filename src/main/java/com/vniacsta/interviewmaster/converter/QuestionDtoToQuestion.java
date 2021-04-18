package com.vniacsta.interviewmaster.converter;

import com.vniacsta.interviewmaster.persistence.model.Question;
import com.vniacsta.interviewmaster.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class QuestionDtoToQuestion implements Converter<QuestionDto, Question> {

    private QuestionService questionService;

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Question convert(QuestionDto questionDto) {

        Question question = (questionDto.getId() != null ? questionService.get(questionDto.getId()) : new Question());
        question.setQuestion(questionDto.getQuestion());
        return question;
    }
}
