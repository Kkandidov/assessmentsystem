package org.astashonok.assessmentsystem.service.api;

import org.astashonok.assessmentsystem.model.Test;
import org.astashonok.assessmentsystem.repository.TestRepository;

import java.util.List;

public interface TestService extends TestRepository {

    Test getById(long id);
    List<Test> getAll();
}
