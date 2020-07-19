CREATE SCHEMA `test_assessment_system` DEFAULT CHARACTER SET utf8;

USE `test_assessment_system`;

SET FOREIGN_KEY_CHECKS=0;

-- drop tables
DROP TABLE IF EXISTS `link`			CASCADE;
DROP TABLE IF EXISTS `literature`	CASCADE;
DROP TABLE IF EXISTS `statistic` 	CASCADE;
DROP TABLE IF EXISTS `userRole` 	CASCADE;
DROP TABLE IF EXISTS `role` 		CASCADE;
DROP TABLE IF EXISTS `user` 		CASCADE;
DROP TABLE IF EXISTS `answer` 		CASCADE;
DROP TABLE IF EXISTS `question` 	CASCADE;
DROP TABLE IF EXISTS `test` 		CASCADE;
DROP TABLE IF EXISTS `topic` 		CASCADE;
DROP PROCEDURE IF EXISTS getUserStatistic;
DROP PROCEDURE IF EXISTS getUserFullStatistic;

-- topic table
CREATE TABLE `topic`(
    `id`			BIGINT				NOT NULL	AUTO_INCREMENT,
    `name`			VARCHAR(100)		NOT NULL,
    `description`	VARCHAR(150),

    CONSTRAINT	`pk_topicId`				PRIMARY KEY	(`id`)
)ENGINE = InnoDB;

-- test table
CREATE TABLE `test`(
    `id`			BIGINT				NOT NULL	AUTO_INCREMENT,
    `name`			VARCHAR(100)		NOT NULL,
    `description`	VARCHAR(150),
    `topicId`		BIGINT				NOT NULL,

    CONSTRAINT	`pk_testId`					PRIMARY KEY	(`id`),
    CONSTRAINT	`fk_test_topicId`			FOREIGN KEY (`topicId`)			REFERENCES	`topic`			(`id`)	ON DELETE CASCADE
)ENGINE = InnoDB;

-- question table
CREATE TABLE `question`(
    `id`		    BIGINT				NOT NULL	AUTO_INCREMENT,
    `description`   VARCHAR(150)		NOT NULL,
    `testId`		BIGINT				NOT NULL,

    CONSTRAINT	`pk_questionId`				PRIMARY KEY	(`id`),
    CONSTRAINT	`fk_question_testId`		FOREIGN KEY (`testId`)			REFERENCES	`test`			(`id`)	ON DELETE CASCADE
)ENGINE = InnoDB;

-- answer table
CREATE TABLE `answer`(
    `id`			BIGINT				NOT NULL	AUTO_INCREMENT,
    `description`	VARCHAR(150)		NOT NULL,
    `correct`		BOOLEAN,
    `questionId`	BIGINT				NOT NULL,

    CONSTRAINT	`pk_answerId`				PRIMARY KEY	(`id`),
    CONSTRAINT	`fk_answer_questionId`		FOREIGN KEY (`questionId`)		REFERENCES	`question`		(`id`)	ON DELETE CASCADE
)ENGINE = InnoDB;

-- user table
CREATE TABLE `user`(
    `id`			BIGINT				NOT NULL	AUTO_INCREMENT,
    `firstName`		VARCHAR(50)			NOT NULL,
    `lastName`		VARCHAR(50),
    `login`			VARCHAR(50)			NOT NULL,
    `password`		VARCHAR(255)		NOT NULL,

    CONSTRAINT	`pk_userId`					PRIMARY KEY	(`id`),
    UNIQUE (`login`)
)ENGINE = InnoDB;

-- role table
CREATE TABLE `role`(
   `id`				BIGINT				NOT NULL	AUTO_INCREMENT,
    `name`			ENUM ('ROLE_USER'
					, 'ROLE_ADMIN'
					, 'ROLE_TUTOR')	NOT NULL,

    CONSTRAINT	`pk_roleId`					PRIMARY KEY	(`id`),
	UNIQUE (name)
)ENGINE = InnoDB;

-- userRole table
CREATE TABLE `userRole`(
    `userId`			BIGINT				NOT NULL,
    `roleId`			BIGINT				NOT NULL,

    CONSTRAINT	`fk_userRole_userId`		FOREIGN KEY (`userId`)			REFERENCES	`user`			(`id`)	ON DELETE CASCADE,
    CONSTRAINT	`fk_userRole_roleId`		FOREIGN KEY (`roleId`)			REFERENCES	`role`			(`id`)	ON DELETE CASCADE
)ENGINE = InnoDB;

-- statistic table
CREATE TABLE `statistic`(
    `id`			BIGINT				NOT NULL	AUTO_INCREMENT,
    `date`			DATETIME 			NOT NULL,
    `correct`		BOOLEAN,
    `questionId`	BIGINT				NOT NULL,
    `userId`		BIGINT				NOT NULL,

    CONSTRAINT	`pk_statisticId`			PRIMARY KEY	(`id`),
    CONSTRAINT	`fk_statistic_questionId`	FOREIGN KEY (`questionId`)		REFERENCES	`question`		(`id`)	ON DELETE CASCADE,
    CONSTRAINT	`fk_statistic_userId`		FOREIGN KEY (`userId`)			REFERENCES	`user`			(`id`)	ON DELETE CASCADE
)ENGINE = InnoDB;

-- literature table
CREATE TABLE `literature`(
    `id`			BIGINT				NOT NULL	AUTO_INCREMENT,
    `description`	VARCHAR(100)		NOT NULL,
    `questionId`	BIGINT				NOT NULL,

    CONSTRAINT	`pk_literatureId`			PRIMARY KEY	(`id`),
    CONSTRAINT	`fk_literature_questionId`	FOREIGN KEY (`questionId`)		REFERENCES	`question`		(`id`)	ON DELETE CASCADE
)ENGINE = InnoDB;

-- link table
CREATE TABLE `link`(
    `id`			BIGINT				NOT NULL	AUTO_INCREMENT,
    `link`			VARCHAR(150)		NOT NULL,
    `literatureId`	BIGINT				NOT NULL,

    CONSTRAINT	`pk_linkId`					PRIMARY KEY	(`id`),
    CONSTRAINT	`fk_link_literatureId`		FOREIGN KEY (`literatureId`)	REFERENCES	`literature`	(`id`)	ON DELETE CASCADE
)ENGINE = InnoDB;

SET FOREIGN_KEY_CHECKS=1;

-- create a stored procedures
DELIMITER //
CREATE PROCEDURE getUserStatistic (IN user_id BIGINT, IN startDate DATETIME, IN endDate DATETIME)
BEGIN
    SELECT  id,
            date,
            correct,
            questionId,
            userId
    FROM statistic
    WHERE userId = user_id
      AND date between startDate AND endDate;
END//

CREATE PROCEDURE getUserFullStatistic (IN user_id BIGINT)
BEGIN
    SELECT 	id AS userId,
              testName,
              CONCAT (firstName, ' ', lastName) AS fullName,
              questionDescription,
              passedTimes,
              (correctCount / passedTimes) * 100 AS correctAnswersPercentage
    FROM user
    JOIN (	SELECT 	questionId,
                    userId,
                    COUNT(questionId) AS passedTimes,
                    COUNT(IF(correct = 0, NULL, 1)) AS correctCount,
                    question.description AS questionDescription,
                    test.description AS testName
            FROM statistic
            JOIN question ON questionId = question.id
            JOIN test ON test.id = question.testId
            GROUP BY userId, questionId) AS prepared
    ON user.id = userId
    WHERE userId = user_id
    ORDER BY testName;
END//
DELIMITER ;