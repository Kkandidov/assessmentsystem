package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Test;
import org.astashonok.assessmentsystem.service.api.TestService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("testService")
public class TestServiceImpl implements TestService {

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
    public Test getById(long id) {
        return getById(Test.class, id);
    }

    @Override
    public List<Test> getAll() {
        return getAll(Test.class);
    }

    @Override
    public List<Test> getByTopicId(long id) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM Test WHERE topic.id = :id",Test.class)
                .setParameter("id", id)
                .getResultList();
    }
}
