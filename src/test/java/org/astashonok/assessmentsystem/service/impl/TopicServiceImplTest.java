package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Topic;
import org.astashonok.assessmentsystem.service.api.TopicService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.astashonok.assessmentsystem.service.impl.util.StaticService.resetDb;
import static org.astashonok.assessmentsystem.service.impl.util.StaticService.resetTopic;
import static org.junit.Assert.*;

public class TopicServiceImplTest {

    private static TopicService topicService;

    @BeforeClass
    public static void init() throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.astashonok.assessmentsystem");
        context.refresh();
        topicService = (TopicService) context.getBean("topicService");
        resetDb();
    }

    @Test
    public void add() {
        Topic expected = new Topic("Тема 6", "Описание Тема 6");
        Topic actual = topicService.add(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void getById() {
        Topic expected = new Topic("Topic 2", "Description Topic 2");
        expected.setId(2);
        Topic actual = topicService.getById(2);
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        Topic expected = new Topic("Тема 1", "Описание Тема 1");
        expected.setId(1);
        Topic actual = topicService.update(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        Topic topic = new Topic("Topic 5", "Description Topic 5");
        topic.setId(5);
        topicService.delete(topic);
        Topic actual = topicService.getById(5);
        assertNull(actual);
    }

    @Test
    public void getAll() throws SQLException {
        resetTopic();
        int expected = 5;
        int actual = topicService.getAll().size();
        assertEquals(expected, actual);
    }
}