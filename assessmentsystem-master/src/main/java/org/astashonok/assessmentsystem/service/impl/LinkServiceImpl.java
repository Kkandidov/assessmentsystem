package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Link;
import org.astashonok.assessmentsystem.service.api.LinkService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("linkService")
public class LinkServiceImpl implements LinkService {

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
    public Link getById(long id) {
        return getById(Link.class, id);
    }

    @Override
    @Transactional
    public List<Link> getAll() {
        return getAll(Link.class);
    }

    @Override
    @Transactional
    public List<Link> getByLiteratureId(long id) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM Link WHERE literature.id = :id", Link.class)
                .setParameter("id", id)
                .getResultList();
    }
}
