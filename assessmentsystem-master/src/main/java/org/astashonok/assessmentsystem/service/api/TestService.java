package org.astashonok.assessmentsystem.service.api;

import org.astashonok.assessmentsystem.model.Test;
import org.astashonok.assessmentsystem.model.Topic;
import org.astashonok.assessmentsystem.repository.TestRepository;

import java.util.List;

public interface TestService extends TestRepository {

    Test getById(long id);
    List<Test> getAll();
    List<Test> getByTopicId(long id);
    Test createTestByName(String nameTest, Topic topic);
}
