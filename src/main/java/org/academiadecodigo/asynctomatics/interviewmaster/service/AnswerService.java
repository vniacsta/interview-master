package org.academiadecodigo.asynctomatics.interviewmaster.service;

import org.academiadecodigo.asynctomatics.interviewmaster.persistence.model.Answer;

import java.util.List;

public interface AnswerService {

    Answer get(Integer id);

    boolean isCorrect(Integer id);

    List<Answer> list(Integer questionId);
}
