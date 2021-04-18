package com.vniacsta.interviewmaster.persistence.dao.jpa;

import com.vniacsta.interviewmaster.persistence.dao.QuestionDao;
import com.vniacsta.interviewmaster.persistence.model.Question;
import org.springframework.stereotype.Repository;

@Repository
public class JpaQuestionDao extends GenericJpaDao<Question> implements QuestionDao {

    public JpaQuestionDao() {
        super(Question.class);
    }
}
