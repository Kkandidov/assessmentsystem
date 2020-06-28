package org.astashonok.assessmentsystem.service.impl;

import org.astashonok.assessmentsystem.model.User;
import org.astashonok.assessmentsystem.model.enums.RoleName;
import org.astashonok.assessmentsystem.service.api.UserService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.astashonok.assessmentsystem.service.impl.util.StaticService.resetDb;
import static org.astashonok.assessmentsystem.service.impl.util.StaticService.resetUser;
import static org.junit.Assert.*;

public class UserServiceImplTest {

    private static UserService userService;

    @BeforeClass
    public static void init() throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.astashonok.assessmentsystem");
        context.refresh();
        userService = (UserService) context.getBean("userService");
        resetDb();
    }

    @Test
    public void add() {
        User expected = new User("Sam", "Samoilov", "Samson", "samSamsam"
                , RoleName.ROLE_USER);
        User actual = userService.add(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void getById() {
        User expected = new User("User", "Userovic", "user", "userPassword"
                , RoleName.ROLE_USER);
        User actual = userService.getById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        User expected = new User("Ментор", "Менторович", "ментор", "менторПароль"
                , RoleName.ROLE_TUTOR);
        expected.setId(2);
        User actual = userService.update(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        User user = new User("User", "Userovic", "user", "userPassword"
                , RoleName.ROLE_USER);
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
}