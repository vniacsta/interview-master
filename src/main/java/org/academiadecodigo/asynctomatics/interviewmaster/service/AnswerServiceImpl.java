package org.academiadecodigo.asynctomatics.interviewmaster.service;

import org.academiadecodigo.asynctomatics.interviewmaster.persistence.dao.AnswerDao;
import org.academiadecodigo.asynctomatics.interviewmaster.persistence.dao.QuestionDao;
import org.academiadecodigo.asynctomatics.interviewmaster.persistence.model.Answer;
import org.academiadecodigo.asynctomatics.interviewmaster.persistence.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private AnswerDao answerDao;
    private QuestionDao questionDao;

    @Autowired
    public void setAnswerDao(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    @Autowired
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }


    @Override
    public Answer get(Integer id) {
        return answerDao.findById(id);
    }

    @Override
    public boolean isCorrect(Integer id) {
        Answer answer = answerDao.findById(id);
        return answer.isCorrect();
    }

    @Override
    public List<Answer> list(Integer questionId) {
        Question question = questionDao.findById(questionId);
        return question.getAnswerList();
    }
}
