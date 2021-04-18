package org.academiadecodigo.asynctomatics.interviewmaster.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
public class Question extends AbstractModel {

    private String question;

    @OneToMany(
            // propagate changes on question to answers
            cascade = {CascadeType.ALL},

            // make sure to remove answers if unlinked from question
            orphanRemoval = true,

            // question foreign key on answer table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "question",

            // fetch answers from database together with question
            fetch = FetchType.EAGER
    )
    private List<Answer> answerList = new ArrayList<>();


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }


    public void addAnswer(Answer answer) {
        answerList.add(answer);
        answer.setQuestion(this);
    }

    public void removeAnswer(Answer answer) {
        answerList.remove(answer);
        answer.setQuestion(null);
    }
}
