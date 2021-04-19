package org.academiadecodigo.asynctomatics.interviewmaster.service;

import org.academiadecodigo.asynctomatics.interviewmaster.persistence.dao.AnswerDao;
import org.academiadecodigo.asynctomatics.interviewmaster.persistence.dao.QuestionDao;
import org.academiadecodigo.asynctomatics.interviewmaster.persistence.model.Answer;
import org.academiadecodigo.asynctomatics.interviewmaster.persistence.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;
    private AnswerDao answerDao;

    @Autowired
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Autowired
    public void setAnswerDao(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    @Override
    public Question get(Integer id) {
        return questionDao.findById(id);
    }

    @Transactional
    @Override
    public Question save(Question question) {
        return questionDao.saveOrUpdate(question);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        questionDao.delete(id);
    }

    @Override
    public List<Question> list() {
        return questionDao.findAll();
    }

    @Transactional
    @Override
    public Answer addAnswer(Integer id, Answer answer) {

        Question question = questionDao.findById(id);
        question.addAnswer(answer);
        questionDao.saveOrUpdate(question);

        return null;
    }

    @Transactional
    @Override
    public void deleteAnswer(Integer questionId, Integer answerId) {

        Question question = questionDao.findById(questionId);
        Answer answer = answerDao.findById(answerId);

        if (!answer.getQuestion().getId().equals(questionId)) {
            try {
                throw new Exception("Answer not found with the provided question id");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        question.removeAnswer(answer);
        questionDao.saveOrUpdate(question);
    }
}
