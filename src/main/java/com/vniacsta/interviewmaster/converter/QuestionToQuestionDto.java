package com.vniacsta.interviewmaster.converter;

import com.vniacsta.interviewmaster.persistence.model.Question;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionToQuestionDto implements Converter<Question, QuestionDto> {

    @Override
    public QuestionDto convert(Question question) {

        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
        questionDto.setQuestion(question.getQuestion());
        return questionDto;
    }
}
