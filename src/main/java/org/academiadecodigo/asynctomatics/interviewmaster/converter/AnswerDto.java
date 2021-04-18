package org.academiadecodigo.asynctomatics.interviewmaster.converter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AnswerDto {

    private Integer id;

    @NotNull(message = "Answer description is mandatory")
    @NotBlank(message = "Answer description is mandatory")
    @Size(min = 10, max = 100)
    private String answer;

    @NotNull(message = "Inform if the provided answer is correct or not")
    @NotBlank(message = "Inform if the provided answer is correct or not")
    @Pattern(regexp = "^([Tt][Rr][Uu][Ee]|[Ff][Aa][Ll][Ss][Ee])$", message = "Please choose between true or false")
    @Size(min = 4, max = 5)
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
