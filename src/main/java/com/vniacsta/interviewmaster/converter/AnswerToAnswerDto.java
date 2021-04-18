package com.vniacsta.interviewmaster.converter;

import com.vniacsta.interviewmaster.persistence.model.Answer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AnswerToAnswerDto implements Converter<Answer, AnswerDto> {

    @Override
    public AnswerDto convert(Answer answer) {

        AnswerDto answerDto = new AnswerDto();
        answerDto.setId(answer.getId());
        answerDto.setAnswer(answer.getAnswer());
        answerDto.setCorrect(answer.isCorrect());
        return answerDto;
    }
}
