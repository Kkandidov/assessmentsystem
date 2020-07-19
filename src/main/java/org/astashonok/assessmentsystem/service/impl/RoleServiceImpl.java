package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Role;
import org.astashonok.assessmentsystem.service.api.RoleService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

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
    public Role getById(long id) {
        return getById(Role.class, id);
    }

    @Override
    @Transactional
    public List<Role> getAll() {
        return getAll(Role.class);
    }
}
