package org.academiadecodigo.asynctomatics.interviewmaster.converter;

import org.academiadecodigo.asynctomatics.interviewmaster.persistence.model.Question;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionToQuestionDto extends AbstractConverter<Question, QuestionDto> {

    @Override
    public QuestionDto convert(Question question) {

        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
        questionDto.setQuestion(question.getQuestion());
        return questionDto;
    }
}
