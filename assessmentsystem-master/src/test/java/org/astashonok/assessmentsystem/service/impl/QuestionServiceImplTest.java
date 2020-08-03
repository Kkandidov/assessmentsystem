package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Question;
import org.astashonok.assessmentsystem.model.Topic;
import org.astashonok.assessmentsystem.service.api.QuestionService;
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
import static org.astashonok.assessmentsystem.service.impl.util.StaticService.resetQuestion;

@ContextConfiguration(classes = {TestHibernateConfig.class})
public class QuestionServiceImplTest extends AbstractTestNGSpringContextTests{

    private static QuestionService questionService;

    @BeforeClass
    public static void init() throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.astashonok.assessmentsystem.service");
        context.refresh();
        questionService = (QuestionService) context.getBean("questionService");
        resetDb();
    }

    @Test
    public void add() {
        Topic topic2 = new Topic("Topic 2", "Description Topic 2");
        topic2.setId(2);
        org.astashonok.assessmentsystem.model.Test test = new org.astashonok.assessmentsystem.model.Test(
                "Test 2", "Description Test 2", topic2
        );
        test.setId(2);
        Question expected = new Question("Вопрос 6", test);
        Question actual = questionService.add(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void getById() {
        org.astashonok.assessmentsystem.model.Test test = new org.astashonok.assessmentsystem.model.Test();
        test.setId(1);
        Question expected = new Question("Question 1", test);
        Question actual = questionService.getById(1);
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        Topic topic3 = new Topic("Topic 3", "Description Topic 3");
        topic3.setId(3);
        org.astashonok.assessmentsystem.model.Test test = new org.astashonok.assessmentsystem.model.Test(
                "Test 3", "Description Test 3", topic3
        );
        test.setId(3);
        Question expected = new Question("Вопрос 3", test);
        expected.setId(3);
        Question actual = questionService.update(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        Topic topic4 = new Topic("Topic 4", "Description Topic 4");
        topic4.setId(4);
        org.astashonok.assessmentsystem.model.Test test = new org.astashonok.assessmentsystem.model.Test(
                "Test 4", "Description Test 4", topic4
        );
        test.setId(4);
        Question question = new Question("Question 4", test);
        question.setId(4);
        questionService.delete(question);
        Question actual = questionService.getById(4);
        assertNull(actual);
    }

    @Test
    public void getAll() throws SQLException {
        resetQuestion();
        int expected = 5;
        int actual = questionService.getAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void getByTestId(){
        int expected = 1;
        int actual = questionService.getByTestId(1).size();
        assertEquals(expected, actual);
    }
}