package org.academiadecodigo.asynctomatics.interviewmaster.persistence.dao.jpa;

import org.academiadecodigo.asynctomatics.interviewmaster.persistence.dao.AnswerDao;
import org.academiadecodigo.asynctomatics.interviewmaster.persistence.model.Answer;
import org.springframework.stereotype.Repository;

@Repository
public class JpaAnswerDao extends GenericJpaDao<Answer> implements AnswerDao {

    public JpaAnswerDao() {
        super(Answer.class);
    }

}
