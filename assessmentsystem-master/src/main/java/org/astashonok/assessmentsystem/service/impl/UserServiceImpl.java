package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.User;
import org.astashonok.assessmentsystem.service.api.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

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
    public User getById(long id) {
        return getById(User.class, id);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return getAll(User.class);
    }

    @Override
    @Transactional
    public User getByLogin(String login) {
        String query = "FROM User WHERE login = :login";
        return sessionFactory
                .getCurrentSession()
                .createQuery(query, User.class)
                .setParameter("login", login)
                .getSingleResult();
    }


}
