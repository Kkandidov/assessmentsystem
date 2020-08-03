package org.astashonok.assessmentsystem.service.impl.admin;

import org.astashonok.assessmentsystem.model.Question;
import org.astashonok.assessmentsystem.model.Test;
import org.astashonok.assessmentsystem.model.Topic;
import org.astashonok.assessmentsystem.service.api.QuestionService;
import org.astashonok.assessmentsystem.service.api.TestService;
import org.astashonok.assessmentsystem.service.api.TopicService;
import org.astashonok.assessmentsystem.service.api.TtqService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QQTService implements TtqService {

    private TopicService topicService;
    private TestService testService;
    private QuestionService questionService;

    @Autowired
    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Transactional
    public Question createNewQuestion(String nameTopic, String nameTest, String nameQuestion) {
        Topic topic = topicService.createTopicByName(nameTopic);
        Test test = testService.createTestByName(nameTest,topic);
        Question question = questionService.getQuestionByDescription(nameQuestion,test);
        return question ;
    }

  /*  @Transactional
    public Topic createNewTopic(String nameTopic){
        return topicService.createTopicByName(nameTopic);
    }

    @Transactional
    public Test createNewTest(String nameTopic,String nameTest){
        Topic topic = topicService.createTopicByName(nameTopic);
        Test test = testService.createTestByName(nameTest,topic);
        return test;
    }*/

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SessionFactory getBeanToBeAutowired() {
        return sessionFactory;
    }

}
