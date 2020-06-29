package org.astashonok.assessmentsystem.service.api;

import org.astashonok.assessmentsystem.model.Role;
import org.astashonok.assessmentsystem.repository.RoleRepository;

import java.util.List;

public interface RoleService extends RoleRepository {

    Role getById(long id);
    List<Role> getAll();
}
