package org.academiadecodigo.asynctomatics.interviewmaster.persistence.dao.jpa;

import org.academiadecodigo.asynctomatics.interviewmaster.persistence.dao.QuestionDao;
import org.academiadecodigo.asynctomatics.interviewmaster.persistence.model.Question;
import org.springframework.stereotype.Repository;

@Repository
public class JpaQuestionDao extends GenericJpaDao<Question> implements QuestionDao {

    public JpaQuestionDao() {
        super(Question.class);
    }
}
