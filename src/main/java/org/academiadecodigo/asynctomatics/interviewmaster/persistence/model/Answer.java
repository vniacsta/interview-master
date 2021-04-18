package org.academiadecodigo.asynctomatics.interviewmaster.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "answer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Answer extends AbstractModel {

    private String answer;
    private boolean correct = false;

    @ManyToOne
    private Question question;


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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}
