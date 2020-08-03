package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Topic;
import org.astashonok.assessmentsystem.service.api.TestService;
import org.astashonok.assessmentsystem.service.impl.util.TestHibernateConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.astashonok.assessmentsystem.service.impl.util.StaticService.resetDb;
import static org.astashonok.assessmentsystem.service.impl.util.StaticService.resetTest;

@ContextConfiguration(classes = {TestHibernateConfig.class})
public class TestServiceImplTest extends AbstractTestNGSpringContextTests{

    private static TestService testService;

    @BeforeClass
    public static void init() throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.astashonok.assessmentsystem.service");
        context.refresh();
        testService = (TestService) context.getBean("testService");
        resetDb();
    }

    @Test
    public void add() {
        Topic topic2 = new Topic("Topic 2", "Description Topic 2");
        topic2.setId(2);
        org.astashonok.assessmentsystem.model.Test expected = new org.astashonok.assessmentsystem.model.Test(
                "Тест 6", "Описание Тест 6", topic2
        );
        org.astashonok.assessmentsystem.model.Test actual = testService.add(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void getById() {
        Topic topic1 = new Topic();
        topic1.setId(1);
        org.astashonok.assessmentsystem.model.Test expected = new org.astashonok.assessmentsystem.model.Test(
                "Test 1", "Description Test 1", topic1
        );
        org.astashonok.assessmentsystem.model.Test actual = testService.getById(1);
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        Topic topic3 = new Topic("Topic 3", "Description Topic 3");
        topic3.setId(3);
        org.astashonok.assessmentsystem.model.Test expected = new org.astashonok.assessmentsystem.model.Test(
                "Тест 3", "Описание Тест 3", topic3
        );
        expected.setId(3);
        org.astashonok.assessmentsystem.model.Test actual = testService.update(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        Topic topic2 = new Topic("Topic 2", "Description Topic 2");
        topic2.setId(2);
        org.astashonok.assessmentsystem.model.Test test = new org.astashonok.assessmentsystem.model.Test(
                "Test 2", "Description Test 2", topic2
        );
        test.setId(2);
        testService.delete(test);
        org.astashonok.assessmentsystem.model.Test actual = testService.getById(2);
        assertNull(actual);
    }

    @Test
    public void getAll() throws SQLException {
        resetTest();
        int expected = 5;
        int actual = testService.getAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void getByTopicId(){
        int expected = 1;
        int actual = testService.getByTopicId(1).size();
        assertEquals(expected, actual);
    }
}