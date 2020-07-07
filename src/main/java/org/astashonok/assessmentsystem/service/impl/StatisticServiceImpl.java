package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Statistic;
import org.astashonok.assessmentsystem.service.api.StatisticService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("statisticService")
public class StatisticServiceImpl implements StatisticService {

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
    public Statistic getById(long id) {
        return getById(Statistic.class, id);
    }

    @Override
    public List<Statistic> getAll() {
        return getAll(Statistic.class);
    }
}
