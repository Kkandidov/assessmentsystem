package org.astashonok.assessmentsystem.service.impl.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticService {

    private static Connection connection;

    static {
        try {
            connection = SimpleSingleConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void resetTopic() throws SQLException {
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.addBatch("SET FOREIGN_KEY_CHECKS=0");
        statement.addBatch("TRUNCATE TABLE `topic`");
        statement.addBatch("SET FOREIGN_KEY_CHECKS=1");
        statement.addBatch("INSERT INTO `topic`(`name`, `description`) VALUES('Topic 1', 'Description Topic 1')");
        statement.addBatch("INSERT INTO `topic`(`name`, `description`) VALUES('Topic 2', 'Description Topic 2')");
        statement.addBatch("INSERT INTO `topic`(`name`, `description`) VALUES('Topic 3', 'Description Topic 3')");
        statement.addBatch("INSERT INTO `topic`(`name`, `description`) VALUES('Topic 4', 'Description Topic 4')");
        statement.addBatch("INSERT INTO `topic`(`name`, `description`) VALUES('Topic 5', 'Description Topic 5')");
        statement.executeBatch();
        connection.commit();
    }

    public static void resetTest() throws SQLException {
        Connection connection = SimpleSingleConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.addBatch("SET FOREIGN_KEY_CHECKS=0");
        statement.addBatch("TRUNCATE TABLE  `test`");
        statement.addBatch("SET FOREIGN_KEY_CHECKS=1");
        statement.addBatch("INSERT INTO `test`(`name`, `description`, `topicId`) VALUES('Test 1', 'Description Test 1', 1)");
        statement.addBatch("INSERT INTO `test`(`name`, `description`, `topicId`) VALUES('Test 2', 'Description Test 2', 2)");
        statement.addBatch("INSERT INTO `test`(`name`, `description`, `topicId`) VALUES('Test 3', 'Description Test 3', 3)");
        statement.addBatch("INSERT INTO `test`(`name`, `description`, `topicId`) VALUES('Test 4', 'Description Test 4', 4)");
        statement.addBatch("INSERT INTO `test`(`name`, `description`, `topicId`) VALUES('Test 5', 'Description Test 5', 5)");
        statement.executeBatch();
        connection.commit();
    }

    public static void resetQuestion() throws SQLException {
        Connection connection = SimpleSingleConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.addBatch("SET FOREIGN_KEY_CHECKS=0");
        statement.addBatch("TRUNCATE TABLE  `question`");
        statement.addBatch("SET FOREIGN_KEY_CHECKS=1");
        statement.addBatch("INSERT INTO `question`(`description`, `testId`) VALUES('Question 1', 1)");
        statement.addBatch("INSERT INTO `question`(`description`, `testId`) VALUES('Question 2', 2)");
        statement.addBatch("INSERT INTO `question`(`description`, `testId`) VALUES('Question 3', 3)");
        statement.addBatch("INSERT INTO `question`(`description`, `testId`) VALUES('Question 4', 4)");
        statement.addBatch("INSERT INTO `question`(`description`, `testId`) VALUES('Question 5', 5)");
        statement.executeBatch();
        connection.commit();
    }

    public static void resetAnswer() throws SQLException {
        Connection connection = SimpleSingleConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.addBatch("SET FOREIGN_KEY_CHECKS=0");
        statement.addBatch("TRUNCATE TABLE  `answer`");
        statement.addBatch("SET FOREIGN_KEY_CHECKS=1");
        statement.addBatch("INSERT INTO `answer`(`description`, `correct`, `questionId`) VALUES('Answer 1', false, 1)");
        statement.addBatch("INSERT INTO `answer`(`description`, `correct`, `questionId`) VALUES('Answer 2', true, 2)");
        statement.addBatch("INSERT INTO `answer`(`description`, `correct`, `questionId`) VALUES('Answer 3', true, 3)");
        statement.addBatch("INSERT INTO `answer`(`description`, `correct`, `questionId`) VALUES('Answer 4', true, 4)");
        statement.addBatch("INSERT INTO `answer`(`description`, `correct`, `questionId`) VALUES('Answer 5', false, 5)");
        statement.executeBatch();
        connection.commit();
    }

    public static void resetUser() throws SQLException {
        Connection connection = SimpleSingleConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.addBatch("SET FOREIGN_KEY_CHECKS=0");
        statement.addBatch("TRUNCATE TABLE  `user`");
        statement.addBatch("SET FOREIGN_KEY_CHECKS=1");
        statement.addBatch("INSERT INTO `user`(`firstName`, `lastName`, `login`, `password`)"
                + "VALUES('Admin', 'Adminovic', 'admin', 'adminPassword')");
        statement.addBatch("INSERT INTO `user`(`firstName`, `lastName`, `login`, `password`)"
                + "VALUES('Tutor', 'Tutorovic', 'tutor', 'tutorPassword')");
        statement.addBatch("INSERT INTO `user`(`firstName`, `lastName`, `login`, `password`)"
                + "VALUES('User', 'Userovic', 'user', 'userPassword')");
        statement.executeBatch();
        connection.commit();
    }

    public static void resetStatistic() throws SQLException {
        Connection connection = SimpleSingleConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.addBatch("SET FOREIGN_KEY_CHECKS=0");
        statement.addBatch("TRUNCATE TABLE  `statistic`");
        statement.addBatch("SET FOREIGN_KEY_CHECKS=1");
        statement.addBatch("INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)"
                + "VALUES('2020-01-12 10:37:22', false, 1, 3)");
        statement.addBatch("INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)"
                + "VALUES('2020-01-12 10:38:22', true, 2, 3)");
        statement.addBatch("INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)"
                + "VALUES('2020-01-12 10:39:22', false, 3, 3)");
        statement.addBatch("INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)"
                + "VALUES('2020-01-12 10:40:22', true, 4, 3)");
        statement.addBatch("INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)"
                + "VALUES('2020-01-12 10:41:22', false, 5, 3)");
        statement.executeBatch();
        connection.commit();
    }

    public static void resetLiterature() throws SQLException {
        Connection connection = SimpleSingleConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.addBatch("SET FOREIGN_KEY_CHECKS=0");
        statement.addBatch("TRUNCATE TABLE  `literature`");
        statement.addBatch("SET FOREIGN_KEY_CHECKS=1");
        statement.addBatch("INSERT INTO `literature`(`description`, `questionId`) VALUES('Literature 1', 1)");
        statement.addBatch("INSERT INTO `literature`(`description`, `questionId`) VALUES('Literature 2', 2)");
        statement.addBatch("INSERT INTO `literature`(`description`, `questionId`) VALUES('Literature 3', 3)");
        statement.addBatch("INSERT INTO `literature`(`description`, `questionId`) VALUES('Literature 4', 4)");
        statement.addBatch("INSERT INTO `literature`(`description`, `questionId`) VALUES('Literature 4', 5)");
        statement.executeBatch();
        connection.commit();
    }

    public static void resetLink() throws SQLException {
        Connection connection = SimpleSingleConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.addBatch("SET FOREIGN_KEY_CHECKS=0");
        statement.addBatch("TRUNCATE TABLE  `link`");
        statement.addBatch("SET FOREIGN_KEY_CHECKS=1");
        statement.addBatch("INSERT INTO `link`(`link`, `literatureId`) VALUES('Link 1', 1)");
        statement.addBatch("INSERT INTO `link`(`link`, `literatureId`) VALUES('Link 2', 2)");
        statement.addBatch("INSERT INTO `link`(`link`, `literatureId`) VALUES('Link 3', 3)");
        statement.addBatch("INSERT INTO `link`(`link`, `literatureId`) VALUES('Link 4', 4)");
        statement.addBatch("INSERT INTO `link`(`link`, `literatureId`) VALUES('Link 5', 5)");
        statement.executeBatch();
        connection.commit();
    }

    public static void resetDb() throws SQLException {
        Connection connection = SimpleSingleConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.addBatch("SET FOREIGN_KEY_CHECKS=0");
        statement.addBatch("TRUNCATE TABLE  `link`");
        statement.addBatch("TRUNCATE TABLE  `literature`");
        statement.addBatch("TRUNCATE TABLE  `statistic`");
        statement.addBatch("TRUNCATE TABLE  `userRole`");
        statement.addBatch("TRUNCATE TABLE  `role`");
        statement.addBatch("TRUNCATE TABLE  `user`");
        statement.addBatch("TRUNCATE TABLE  `answer`");
        statement.addBatch("TRUNCATE TABLE  `question`");
        statement.addBatch("TRUNCATE TABLE  `test`");
        statement.addBatch("TRUNCATE TABLE `topic`");
        statement.addBatch("SET FOREIGN_KEY_CHECKS=1");
        statement.addBatch("INSERT INTO `topic`(`name`, `description`) VALUES('Topic 1', 'Description Topic 1')");
        statement.addBatch("INSERT INTO `topic`(`name`, `description`) VALUES('Topic 2', 'Description Topic 2')");
        statement.addBatch("INSERT INTO `topic`(`name`, `description`) VALUES('Topic 3', 'Description Topic 3')");
        statement.addBatch("INSERT INTO `topic`(`name`, `description`) VALUES('Topic 4', 'Description Topic 4')");
        statement.addBatch("INSERT INTO `topic`(`name`, `description`) VALUES('Topic 5', 'Description Topic 5')");
        statement.addBatch("INSERT INTO `test`(`name`, `description`, `topicId`) VALUES('Test 1', 'Description Test 1', 1)");
        statement.addBatch("INSERT INTO `test`(`name`, `description`, `topicId`) VALUES('Test 2', 'Description Test 2', 2)");
        statement.addBatch("INSERT INTO `test`(`name`, `description`, `topicId`) VALUES('Test 3', 'Description Test 3', 3)");
        statement.addBatch("INSERT INTO `test`(`name`, `description`, `topicId`) VALUES('Test 4', 'Description Test 4', 4)");
        statement.addBatch("INSERT INTO `test`(`name`, `description`, `topicId`) VALUES('Test 5', 'Description Test 5', 5)");
        statement.addBatch("INSERT INTO `question`(`description`, `testId`) VALUES('Question 1', 1)");
        statement.addBatch("INSERT INTO `question`(`description`, `testId`) VALUES('Question 2', 2)");
        statement.addBatch("INSERT INTO `question`(`description`, `testId`) VALUES('Question 3', 3)");
        statement.addBatch("INSERT INTO `question`(`description`, `testId`) VALUES('Question 4', 4)");
        statement.addBatch("INSERT INTO `question`(`description`, `testId`) VALUES('Question 5', 5)");
        statement.addBatch("INSERT INTO `answer`(`description`, `correct`, `questionId`) VALUES('Answer 1', false, 1)");
        statement.addBatch("INSERT INTO `answer`(`description`, `correct`, `questionId`) VALUES('Answer 2', true, 2)");
        statement.addBatch("INSERT INTO `answer`(`description`, `correct`, `questionId`) VALUES('Answer 3', true, 3)");
        statement.addBatch("INSERT INTO `answer`(`description`, `correct`, `questionId`) VALUES('Answer 4', true, 4)");
        statement.addBatch("INSERT INTO `answer`(`description`, `correct`, `questionId`) VALUES('Answer 5', false, 5)");
        statement.addBatch("INSERT INTO `user`(`firstName`, `lastName`, `login`, `password`)"
                + "VALUES('Admin', 'Adminovic', 'admin', 'adminPassword')");
        statement.addBatch("INSERT INTO `user`(`firstName`, `lastName`, `login`, `password`)"
                + "VALUES('Tutor', 'Tutorovic', 'tutor', 'tutorPassword')");
        statement.addBatch("INSERT INTO `user`(`firstName`, `lastName`, `login`, `password`)"
                + "VALUES('User', 'Userovic', 'user', 'userPassword')");
        statement.addBatch("INSERT INTO `role`(`name`) VALUES('ROLE_ADMIN')");
        statement.addBatch("INSERT INTO `role`(`name`) VALUES('ROLE_TUTOR')");
        statement.addBatch("INSERT INTO `role`(`name`) VALUES('ROLE_USER')");
        statement.addBatch("INSERT INTO `userRole`(`userId`, `roleId`) VALUES(1, 1)");
        statement.addBatch("INSERT INTO `userRole`(`userId`, `roleId`) VALUES(2, 2)");
        statement.addBatch("INSERT INTO `userRole`(`userId`, `roleId`) VALUES(3, 3)");
        statement.addBatch("INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)"
                + "VALUES('2020-01-12 10:37:22', false, 1, 3)");
        statement.addBatch("INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)"
                + "VALUES('2020-01-12 10:38:22', true, 2, 3)");
        statement.addBatch("INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)"
                + "VALUES('2020-01-12 10:39:22', false, 3, 3)");
        statement.addBatch("INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)"
                + "VALUES('2020-01-12 10:40:22', true, 4, 3)");
        statement.addBatch("INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)"
                + "VALUES('2020-01-12 10:41:22', false, 5, 3)");
        statement.addBatch("INSERT INTO `literature`(`description`, `questionId`) VALUES('Literature 1', 1)");
        statement.addBatch("INSERT INTO `literature`(`description`, `questionId`) VALUES('Literature 2', 2)");
        statement.addBatch("INSERT INTO `literature`(`description`, `questionId`) VALUES('Literature 3', 3)");
        statement.addBatch("INSERT INTO `literature`(`description`, `questionId`) VALUES('Literature 4', 4)");
        statement.addBatch("INSERT INTO `literature`(`description`, `questionId`) VALUES('Literature 4', 5)");
        statement.addBatch("INSERT INTO `link`(`link`, `literatureId`) VALUES('Link 1', 1)");
        statement.addBatch("INSERT INTO `link`(`link`, `literatureId`) VALUES('Link 2', 2)");
        statement.addBatch("INSERT INTO `link`(`link`, `literatureId`) VALUES('Link 3', 3)");
        statement.addBatch("INSERT INTO `link`(`link`, `literatureId`) VALUES('Link 4', 4)");
        statement.addBatch("INSERT INTO `link`(`link`, `literatureId`) VALUES('Link 5', 5)");
        statement.executeBatch();
        connection.commit();
    }
}
