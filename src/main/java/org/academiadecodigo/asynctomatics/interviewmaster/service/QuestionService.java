package org.academiadecodigo.asynctomatics.interviewmaster.service;

import org.academiadecodigo.asynctomatics.interviewmaster.persistence.model.Answer;
import org.academiadecodigo.asynctomatics.interviewmaster.persistence.model.Question;

import java.util.List;

public interface QuestionService {

    Question get(Integer id);

    Question save(Question question);

    void delete(Integer id);

    List<Question> list();

    Answer addAnswer(Integer id, Answer answer);

    void deleteAnswer(Integer questionId, Integer answerId);
}
