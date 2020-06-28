SET FOREIGN_KEY_CHECKS=0;
TRUNCATE TABLE  `link`;
TRUNCATE TABLE  `literature`;
TRUNCATE TABLE  `statistic`;
TRUNCATE TABLE  `user`;
TRUNCATE TABLE  `answer`;
TRUNCATE TABLE  `question`;
TRUNCATE TABLE  `test`;
TRUNCATE TABLE  `topic`;
SET FOREIGN_KEY_CHECKS=1;

-- populate topic table
INSERT INTO `topic`(`name`, `description`)
VALUES('Topic 1', 'Description Topic 1');
INSERT INTO `topic`(`name`, `description`)
VALUES('Topic 2', 'Description Topic 2');
INSERT INTO `topic`(`name`, `description`)
VALUES('Topic 3', 'Description Topic 3');
INSERT INTO `topic`(`name`, `description`)
VALUES('Topic 4', 'Description Topic 4');
INSERT INTO `topic`(`name`, `description`)
VALUES('Topic 5', 'Description Topic 5');

-- populate test table
INSERT INTO `test`(`name`, `description`, `topicId`)
VALUES('Test 1', 'Description Test 1', 1);
INSERT INTO `test`(`name`, `description`, `topicId`)
VALUES('Test 2', 'Description Test 2', 2);
INSERT INTO `test`(`name`, `description`, `topicId`)
VALUES('Test 3', 'Description Test 3', 3);
INSERT INTO `test`(`name`, `description`, `topicId`)
VALUES('Test 4', 'Description Test 4', 4);
INSERT INTO `test`(`name`, `description`, `topicId`)
VALUES('Test 5', 'Description Test 5', 5);

-- -- populate question table
INSERT INTO `question`(`description`, `testId`)
VALUES('Question 1', 1);
INSERT INTO `question`(`description`, `testId`)
VALUES('Question 2', 2);
INSERT INTO `question`(`description`, `testId`)
VALUES('Question 3', 3);
INSERT INTO `question`(`description`, `testId`)
VALUES('Question 4', 4);
INSERT INTO `question`(`description`, `testId`)
VALUES('Question 5', 5);

-- populate answer table
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('Answer 1', false, 1);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('Answer 2', true, 2);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('Answer 3', true, 3);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('Answer 4', true, 4);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('Answer 5', false, 5);

-- populate user table
INSERT INTO `user`(`firstName`, `lastName`, `login`, `password`, `roleName`)
VALUES('Admin', 'Adminovic', 'admin', 'adminPassword', 'ROLE_ADMIN');
INSERT INTO `user`(`firstName`, `lastName`, `login`, `password`, `roleName`)
VALUES('Tutor', 'Tutorovic', 'tutor', 'tutorPassword', 'ROLE_TUTOR');
INSERT INTO `user`(`firstName`, `lastName`, `login`, `password`, `roleName`)
VALUES('User', 'Userovic', 'user', 'userPassword', 'ROLE_USER');

-- populate statistic table
INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)
VALUES('2020-01-12', false, 1, 3);
INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)
VALUES('2020-01-12', true, 2, 3);
INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)
VALUES('2020-01-12', false, 3, 3);
INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)
VALUES('2020-01-12', true, 4, 3);
INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)
VALUES('2020-01-12', false, 5, 3);

-- populate literature table
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Literature 1', 1);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Literature 2', 2);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Literature 3', 3);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Literature 4', 4);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Literature 4', 5);

-- populate link table
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Link 1', 1);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Link 2', 2);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Link 3', 3);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Link 4', 4);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Link 5', 5);