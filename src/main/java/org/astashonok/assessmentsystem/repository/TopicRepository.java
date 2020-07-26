package org.astashonok.assessmentsystem.repository;

import org.astashonok.assessmentsystem.model.Topic;
import org.astashonok.assessmentsystem.repository.abstracts.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface TopicRepository extends CrudRepository<Topic> {
    default List<String> getNamesTopics(){
        List<String> namesTopicsL = new ArrayList<>();
        for (Topic t:getAll(Topic.class)
        ) {
            namesTopicsL.add(t.getName());
        }
        return namesTopicsL;
    }
}
