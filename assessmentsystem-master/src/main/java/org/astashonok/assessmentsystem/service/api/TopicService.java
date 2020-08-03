package org.astashonok.assessmentsystem.service.api;

import org.astashonok.assessmentsystem.model.Topic;
import org.astashonok.assessmentsystem.repository.TopicRepository;

import java.util.List;

public interface TopicService extends TopicRepository {

    Topic getById(long id);
    List<Topic> getAll();
    Topic createTopicByName(String nameTopic);
}
