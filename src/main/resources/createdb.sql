CREATE SCHEMA `assessment_system` DEFAULT CHARACTER SET utf8;

SET FOREIGN_KEY_CHECKS=0;

-- drop tables
DROP TABLE IF EXISTS `link`			CASCADE;
DROP TABLE IF EXISTS `literature`	CASCADE;
DROP TABLE IF EXISTS `statistic` 	CASCADE;
DROP TABLE IF EXISTS `user` 		CASCADE;
DROP TABLE IF EXISTS `answer` 		CASCADE;
DROP TABLE IF EXISTS `question` 	CASCADE;
DROP TABLE IF EXISTS `test` 		CASCADE;
DROP TABLE IF EXISTS `topic` 		CASCADE;

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
	`id`			BIGINT				NOT NULL	AUTO_INCREMENT,
	`description`	VARCHAR(150)		NOT NULL,
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
	`roleName`		ENUM ('ROLE_USER'
						, 'ROLE_ADMIN'
						, 'ROLE_TUTOR')	NOT NULL,

	CONSTRAINT	`pk_userId`					PRIMARY KEY	(`id`)
)ENGINE = InnoDB;

-- statistic table
CREATE TABLE `statistic`(
	`id`			BIGINT				NOT NULL	AUTO_INCREMENT,
	`date`			DATE 			    NOT NULL,
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