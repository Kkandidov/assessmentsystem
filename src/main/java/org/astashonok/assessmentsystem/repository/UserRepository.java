package org.astashonok.assessmentsystem.repository;

import org.astashonok.assessmentsystem.model.User;
import org.astashonok.assessmentsystem.repository.abstracts.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserRepository extends CrudRepository<User> {
    default User update(User entity, PasswordEncoder passwordEncoder){
        entity.setRoles(entity.setRoleByNameRole(entity.getNameRole()));
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return (User) getBeanToBeAutowired().getCurrentSession().merge(entity);
    }

    default User add(User entity,PasswordEncoder passwordEncoder) {
        entity.setRoles(entity.setRoleByNameRole(entity.getNameRole()));
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return (User) getBeanToBeAutowired().getCurrentSession().merge(entity);
    }
}
