package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Literature;
import org.astashonok.assessmentsystem.service.api.LiteratureService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("literatureService")
public class LiteratureServiceImpl implements LiteratureService {
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
    public Literature getById(long id) {
        return getById(Literature.class, id);
    }

    @Override
    public List<Literature> getAll() {
        return getAll(Literature.class);
    }
}
