package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.Role;
import org.astashonok.assessmentsystem.model.User;
import org.astashonok.assessmentsystem.model.enums.RoleName;
import org.astashonok.assessmentsystem.service.api.UserService;
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
import static org.astashonok.assessmentsystem.service.impl.util.StaticService.resetUser;

@ContextConfiguration(classes = {TestHibernateConfig.class})
public class UserServiceImplTest extends AbstractTestNGSpringContextTests{

    private static UserService userService;

    @BeforeClass
    public static void init() throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.astashonok.assessmentsystem.service");
        context.refresh();
        userService = (UserService) context.getBean("userService");
        resetDb();
    }

    @Test
    public void add() {
        Role role3 = new Role(RoleName.ROLE_USER);
        role3.setId(3);
        User expected = new User("Sam", "Samoilov", "Samson", "samSamsam"
                , role3);
        User actual = userService.add(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void getById() {
        Role role3 = new Role(RoleName.ROLE_USER);
        role3.setId(3);
        User expected = new User("User", "Userovic", "user", "userPassword"
                , role3);
        User actual = userService.getById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        Role role2 = new Role(RoleName.ROLE_TUTOR);
        role2.setId(2);
        User expected = new User("Ментор", "Менторович", "ментор", "менторПароль"
                , role2);
        expected.setId(2);
        User actual = userService.update(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        Role role3 = new Role(RoleName.ROLE_USER);
        role3.setId(3);
        User user = new User("User", "Userovic", "user", "userPassword"
                , role3);
        user.setId(3);
        userService.delete(user);
        User actual = userService.getById(3);
        assertNull(actual);
    }

    @Test
    public void getAll() throws SQLException {
        resetUser();
        int expected = 3;
        int actual = userService.getAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void getByLogin() {
        Role role3 = new Role(RoleName.ROLE_USER);
        role3.setId(3);
        User expected = new User("User", "Userovic", "user", "userPassword"
                , role3);
        User actual = userService.getByLogin("user");
        assertEquals(expected, actual);
    }
}