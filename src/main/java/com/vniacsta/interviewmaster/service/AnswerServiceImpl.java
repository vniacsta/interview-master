package com.vniacsta.interviewmaster.service;

import com.vniacsta.interviewmaster.persistence.dao.AnswerDao;
import com.vniacsta.interviewmaster.persistence.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    private AnswerDao answerDao;

    @Autowired
    public void setAnswerDao(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    @Override
    public Answer get(Integer id) {
        return answerDao.findById(id);
    }
}
