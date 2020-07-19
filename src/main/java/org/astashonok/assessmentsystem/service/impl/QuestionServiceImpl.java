package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Question;
import org.astashonok.assessmentsystem.service.api.QuestionService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SessionFactory getBeanToBeAutowired() {
        return sessionFactory;
    }

    @Override
    @Transactional
    public Question getById(long id) {
        return getById(Question.class, id);
    }

    @Override
    @Transactional
    public List<Question> getAll() {
        return getAll(Question.class);
    }

    @Override
    @Transactional
    public List<Question> getByTestId(long id) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM Question WHERE test.id = :id", Question.class)
                .setParameter("id", id)
                .getResultList();
    }
}
