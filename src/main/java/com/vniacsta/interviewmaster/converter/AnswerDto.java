package com.vniacsta.interviewmaster.converter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AnswerDto {

    private Integer id;

    @NotNull(message = "Answer description is mandatory")
    @NotBlank(message = "Answer description is mandatory")
    private String answer;

    @NotNull(message = "Inform if the provided answer is correct or not")
    @NotBlank(message = "Inform if the provided answer is correct or not")
    private boolean correct;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
