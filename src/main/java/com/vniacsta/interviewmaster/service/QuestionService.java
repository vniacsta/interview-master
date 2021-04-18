package com.vniacsta.interviewmaster.service;

import com.vniacsta.interviewmaster.persistence.model.Answer;
import com.vniacsta.interviewmaster.persistence.model.Question;

import java.util.List;

public interface QuestionService {

    Question get(Integer id);

    boolean isCorrect(boolean correct);

    Question save(Question question);

    void delete(Integer id);

    List<Question> list();

    Answer addAnswer(Integer id, Answer answer);

    void deleteAnswer(Integer questionId, Integer answerId);
}
