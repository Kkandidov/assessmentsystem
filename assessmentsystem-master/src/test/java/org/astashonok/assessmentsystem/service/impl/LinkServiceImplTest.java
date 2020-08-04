package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Link;
import org.astashonok.assessmentsystem.model.Literature;
import org.astashonok.assessmentsystem.model.Question;
import org.astashonok.assessmentsystem.model.Topic;
import org.astashonok.assessmentsystem.service.api.LinkService;
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
import static org.astashonok.assessmentsystem.service.impl.util.StaticService.resetLink;

@ContextConfiguration(classes = {TestHibernateConfig.class})
public class LinkServiceImplTest extends AbstractTestNGSpringContextTests{

    private static LinkService linkService;

    @BeforeClass
    public static void init() throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.astashonok.assessmentsystem.service");
        context.refresh();
        linkService = (LinkService) context.getBean("linkService");
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
        Literature literature3 = new Literature("Literature 3", question3);
        literature3.setId(3);
        Link expected = new Link("Ссылка 6", literature3);
        Link actual = linkService.add(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void getById() {
        Topic topic1 = new Topic();
        topic1.setId(1);
        org.astashonok.assessmentsystem.model.Test test1 = new org.astashonok.assessmentsystem.model.Test();
        test1.setId(1);
        Question question1 = new Question();
        question1.setId(1);
        Literature literature1 = new Literature();
        literature1.setId(1);
        Link expected = new Link("Link 1", literature1);
        expected.setId(1);
        Link actual = linkService.getById(1);
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
        Literature literature3 = new Literature("Literature 3", question3);
        literature3.setId(3);
        Link expected = new Link("Ссылка 3", literature3);
        expected.setId(3);
        Link actual = linkService.update(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        Topic topic2 = new Topic("Topic 2", "Description Topic 2");
        topic2.setId(2);
        org.astashonok.assessmentsystem.model.Test test2 = new org.astashonok.assessmentsystem.model.Test(
                "Test 2", "Description Test 2", topic2
        );
        test2.setId(2);
        Question question2 = new Question("Question 2", test2);
        question2.setId(2);
        Literature literature2 = new Literature("Literature 2", question2);
        literature2.setId(2);
        Link link = new Link("Link 2", literature2);
        link.setId(2);
        linkService.delete(link);
        Link actual = linkService.getById(2);
        assertNull(actual);
    }

    @Test
    public void getAll() throws SQLException {
        resetLink();
        int expected = 5;
        int actual = linkService.getAll().size();
        assertEquals(expected, actual);
    }
}