package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Answer;
import org.astashonok.assessmentsystem.model.Question;
import org.astashonok.assessmentsystem.model.Topic;
import org.astashonok.assessmentsystem.service.api.AnswerService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.astashonok.assessmentsystem.service.impl.util.StaticService.resetAnswer;
import static org.astashonok.assessmentsystem.service.impl.util.StaticService.resetDb;
import static org.junit.Assert.*;

public class AnswerServiceImplTest {

    private static AnswerService answerService;

    @BeforeClass
    public static void init() throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.astashonok.assessmentsystem");
        context.refresh();
        answerService = (AnswerService) context.getBean("answerService");
        resetDb();
    }

    @Test
    public void add() {
        Topic topic1 = new Topic("Topic 1", "Description Topic 1");
        topic1.setId(1);
        org.astashonok.assessmentsystem.model.Test test1 = new org.astashonok.assessmentsystem.model.Test(
                "Test 1", "Description Test 1", topic1
        );
        test1.setId(1);
        Question question1 = new Question("Question 1", test1);
        question1.setId(1);
        Answer expected = new Answer("Ответ 6", true, question1);
        Answer actual = answerService.add(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        Topic topic3 = new Topic("Topic 3", "Description Topic 3");
        topic3.setId(3);
        org.astashonok.assessmentsystem.model.Test test3 = new org.astashonok.assessmentsystem.model.Test(
                "Test 3", "Description Test 3", topic3
        );
        test3.setId(3);
        Question question3 = new Question("Question 3", test3);
        question3.setId(3);
        Answer expected = new Answer("Ответ 3", true, question3);
        expected.setId(3);
        Answer actual = answerService.update(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        Topic topic4 = new Topic("Topic 4", "Description Topic 4");
        topic4.setId(4);
        org.astashonok.assessmentsystem.model.Test test4 = new org.astashonok.assessmentsystem.model.Test(
                "Test 4", "Description Test 4", topic4
        );
        test4.setId(4);
        Question question4 = new Question("Question 4", test4);
        question4.setId(4);
        Answer answer = new Answer("Answer 4", true, question4);
        answer.setId(4);
        answerService.delete(answer);
        Answer actual = answerService.getById(4);
        assertNull(actual);
    }

    @Test
    public void getById() {
        Topic topic1 = new Topic();
        topic1.setId(1);
        org.astashonok.assessmentsystem.model.Test test1 = new org.astashonok.assessmentsystem.model.Test();
        test1.setId(1);
        Question question1 = new Question("Question 1", test1);
        question1.setId(1);
        Answer expected = new Answer("Answer 1", false, question1);
        Answer actual = answerService.getById(1);
        assertEquals(expected, actual);
    }

    @Test
    public void getAll() throws SQLException {
        resetAnswer();
        int expected = 5;
        int actual = answerService.getAll().size();
        assertEquals(expected, actual);
    }
}