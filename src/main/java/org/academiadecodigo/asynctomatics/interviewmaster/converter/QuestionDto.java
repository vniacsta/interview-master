package org.academiadecodigo.asynctomatics.interviewmaster.converter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QuestionDto {

    private Integer id;

    @NotNull(message = "Question description is mandatory")
    @NotBlank(message = "Question description is mandatory")
    private String question;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
