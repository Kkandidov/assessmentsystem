package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Answer;
import org.astashonok.assessmentsystem.service.api.AnswerService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("answerService")
public class AnswerServiceImpl implements AnswerService {

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
    public Answer getById(long id) {
        return getById(Answer.class, id);
    }

    @Override
    @Transactional
    public List<Answer> getAll() {
        return getAll(Answer.class);
    }

    @Override
    @Transactional
    public List<Answer> getByQuestionId(long id) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM Answer WHERE question.id = :id", Answer.class)
                .setParameter("id", id)
                .getResultList();
    }
}