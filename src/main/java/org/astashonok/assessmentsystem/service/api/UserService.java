package org.astashonok.assessmentsystem.service.api;

import org.astashonok.assessmentsystem.model.User;
import org.astashonok.assessmentsystem.repository.UserRepository;

import java.util.List;

public interface UserService extends UserRepository {

    User getById(long id);
    List<User> getAll();
}
