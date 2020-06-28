package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Topic;
import org.astashonok.assessmentsystem.service.api.TopicService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("topicService")
public class TopicServiceImpl implements TopicService {

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
    public Topic getById(long id) {
        return getById(Topic.class, id);
    }

    @Override
    public List<Topic> getAll() {
        return getAll(Topic.class);
    }
}
