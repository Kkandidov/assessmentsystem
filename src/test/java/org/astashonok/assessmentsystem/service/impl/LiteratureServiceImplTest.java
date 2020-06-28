package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Literature;
import org.astashonok.assessmentsystem.model.Question;
import org.astashonok.assessmentsystem.model.Topic;
import org.astashonok.assessmentsystem.service.api.LiteratureService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.astashonok.assessmentsystem.service.impl.util.StaticService.resetDb;
import static org.astashonok.assessmentsystem.service.impl.util.StaticService.resetLiterature;
import static org.junit.Assert.*;

public class LiteratureServiceImplTest {

    private static LiteratureService literatureService;

    @BeforeClass
    public static void init() throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.astashonok.assessmentsystem");
        context.refresh();
        literatureService = (LiteratureService) context.getBean("literatureService");
        resetDb();
    }

    @Test
    public void add() {
        Topic topic3 = new Topic("Topic 3", "Description Topic 3");
        topic3.setId(3);
        org.astashonok.assessmentsystem.model.Test test3 = new org.astashonok.assessmentsystem.model.Test(
                "Test 3", "Description Test 3", topic3
        );
        test3.setId(3);
        Question question3 = new Question("Question 3", test3);
        question3.setId(3);
        Literature expected = new Literature("Литература 6", question3);
        Literature actual = literatureService.add(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void getById() {
        Topic topic3 = new Topic();
        topic3.setId(3);
        org.astashonok.assessmentsystem.model.Test test3 = new org.astashonok.assessmentsystem.model.Test();
        test3.setId(3);
        Question question3 = new Question();
        question3.setId(3);
        Literature expected = new Literature("Literature 3", question3);
        Literature actual = literatureService.getById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        Topic topic2 = new Topic("Topic 2", "Description Topic 2");
        topic2.setId(2);
        org.astashonok.assessmentsystem.model.Test test2 = new org.astashonok.assessmentsystem.model.Test(
                "Test 2", "Description Test 2", topic2
        );
        test2.setId(2);
        Question question2 = new Question("Question 2", test2);
        question2.setId(2);
        Literature expected = new Literature("Литература 2", question2);
        expected.setId(2);
        Literature actual = literatureService.update(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        Topic topic1 = new Topic("Topic 1", "Description Topic 1");
        topic1.setId(1);
        org.astashonok.assessmentsystem.model.Test test1 = new org.astashonok.assessmentsystem.model.Test(
                "Test 1", "Description Test 1", topic1
        );
        test1.setId(1);
        Question question1 = new Question("Question 1", test1);
        question1.setId(1);
        Literature literature = new Literature("Literature 1", question1);
        literature.setId(1);
        literatureService.delete(literature);
        Literature actual = literatureService.getById(1);
        assertNull(actual);
    }

    @Test
    public void getAll() throws SQLException {
        resetLiterature();
        int expected = 5;
        int actual = literatureService.getAll().size();
        assertEquals(expected, actual);
    }
}