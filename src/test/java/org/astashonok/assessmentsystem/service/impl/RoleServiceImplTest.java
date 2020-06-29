package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Role;
import org.astashonok.assessmentsystem.model.enums.RoleName;
import org.astashonok.assessmentsystem.service.api.RoleService;
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
public class RoleServiceImplTest extends AbstractTestNGSpringContextTests{

    private static RoleService roleService;

    @BeforeClass
    public static void init() throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.astashonok.assessmentsystem.service");
        context.refresh();
        roleService = (RoleService) context.getBean("roleService");
        resetDb();
    }

    @Test
    public void getById() {
        Role expected = new Role(RoleName.ROLE_USER);
        Role actual = roleService.getById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void getAll() {
        int expected = 3;
        int actual = roleService.getAll().size();
        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void add() {
        roleService.add(new Role(RoleName.ROLE_ADMIN));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void update() {
        roleService.update(new Role(RoleName.ROLE_USER));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void delete() {
        roleService.delete(new Role(RoleName.ROLE_TUTOR));
    }
}