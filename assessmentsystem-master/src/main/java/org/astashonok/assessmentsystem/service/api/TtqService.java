package org.astashonok.assessmentsystem.service.api;

import org.astashonok.assessmentsystem.model.Question;
import org.astashonok.assessmentsystem.repository.abstracts.CrudRepository;

public interface TtqService extends CrudRepository {
    public Question createNewQuestion(String nameTopic, String nameTest, String nameQuestion);
   /* public Topic createNewTopic(String nameTopic);
    public Test createNewTest(String nameTopic, String nameTest);*/
}
