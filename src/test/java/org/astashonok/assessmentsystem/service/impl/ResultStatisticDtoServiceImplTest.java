package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.service.api.ResultStatisticDtoService;
import org.astashonok.assessmentsystem.service.impl.util.TestHibernateConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;
import static org.astashonok.assessmentsystem.service.impl.util.StaticService.resetDb;

@ContextConfiguration(classes = {TestHibernateConfig.class})
public class ResultStatisticDtoServiceImplTest extends AbstractTestNGSpringContextTests {

    private static ResultStatisticDtoService resultStatisticDtoService;

    @BeforeClass
    public static void init() throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.astashonok.assessmentsystem.service");
        context.refresh();
        resultStatisticDtoService = (ResultStatisticDtoService) context.getBean("resultStatisticDtoService");
        resetDb();
    }

    @Test
    public void getByUserId() {
        int expected = 5;
        int actual = resultStatisticDtoService.getByUserId(3).size();
        assertEquals(expected, actual);
    }
}