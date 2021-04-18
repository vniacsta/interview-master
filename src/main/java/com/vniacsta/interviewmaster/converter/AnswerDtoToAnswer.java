package com.vniacsta.interviewmaster.converter;

import com.vniacsta.interviewmaster.persistence.model.Answer;
import com.vniacsta.interviewmaster.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class AnswerDtoToAnswer implements Converter<AnswerDto, Answer> {

    private AnswerService answerService;

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Override
    public Answer convert(AnswerDto answerDto) {

        Answer answer = (answerDto.getId() != null ? answerService.get(answerDto.getId()) : new Answer());
        answer.setAnswer(answerDto.getAnswer());
        answer.setCorrect(answerDto.isCorrect());
        return answer;
    }
}
