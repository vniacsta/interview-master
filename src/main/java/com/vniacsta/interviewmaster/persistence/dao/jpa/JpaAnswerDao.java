package com.vniacsta.interviewmaster.persistence.dao.jpa;

import com.vniacsta.interviewmaster.persistence.dao.AnswerDao;
import com.vniacsta.interviewmaster.persistence.model.Answer;
import org.springframework.stereotype.Repository;

@Repository
public class JpaAnswerDao extends GenericJpaDao<Answer> implements AnswerDao {

    public JpaAnswerDao() {
        super(Answer.class);
    }

}
