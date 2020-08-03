package org.astashonok.assessmentsystem.repository;

import org.astashonok.assessmentsystem.model.Role;
import org.astashonok.assessmentsystem.repository.abstracts.CrudRepository;

public interface RoleRepository extends CrudRepository<Role> {

    @Override
    default Role add(Role entity) {
        // ignore
        throw new UnsupportedOperationException();
    }

    @Override
    default Role update(Role entity) {
        // ignore
        throw new UnsupportedOperationException();
    }

    @Override
    default void delete(Role entity) {
        // ignore
        throw new UnsupportedOperationException();
    }
}
