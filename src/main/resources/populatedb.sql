SET FOREIGN_KEY_CHECKS=0;
TRUNCATE TABLE  `link`;
TRUNCATE TABLE  `literature`;
TRUNCATE TABLE  `statistic`;
TRUNCATE TABLE  `userRole`;
TRUNCATE TABLE  `role`;
TRUNCATE TABLE  `user`;
TRUNCATE TABLE  `answer`;
TRUNCATE TABLE  `question`;
TRUNCATE TABLE  `test`;
TRUNCATE TABLE  `topic`;
SET FOREIGN_KEY_CHECKS=1;

-- populate topic table
INSERT INTO `topic`(`name`, `description`)
VALUES('Математика', 'Математика');
INSERT INTO `topic`(`name`, `description`)
VALUES('Программирование', 'Программирование');

-- populate test table
INSERT INTO `test`(`name`, `description`, `topicId`)
VALUES('Уравнения', 'Алгебраические уравнения', 1);
INSERT INTO `test`(`name`, `description`, `topicId`)
VALUES('Комбинаторика', 'Комбинаторика', 1);
INSERT INTO `test`(`name`, `description`, `topicId`)
VALUES('Многопоточность', 'Многопоточность', 2);
INSERT INTO `test`(`name`, `description`, `topicId`)
VALUES('Коллекции', 'Коллекции', 2);

-- -- populate question table
INSERT INTO `question`(`description`, `testId`)
VALUES('Какое из приведенных равенств является уравнением?', 1);
INSERT INTO `question`(`description`, `testId`)
VALUES('Какое из чисел является корнем уравнения y+322=351?', 1);
INSERT INTO `question`(`description`, `testId`)
VALUES('Решите уравнение   x−137=215?', 1);
INSERT INTO `question`(`description`, `testId`)
VALUES('Решите уравнение 400−y=275?', 1);

INSERT INTO `question`(`description`, `testId`)
VALUES('Сколькими способами могут разместиться 7 человек в салоне автобуса на семи свободных местах?', 2);
INSERT INTO `question`(`description`, `testId`)
VALUES('В пассажирском поезде 8 вагонов. Сколькими способами можно рассадить в поезде 3 человека, при условии, что все они должны ехать в различных вагонах?', 2);
INSERT INTO `question`(`description`, `testId`)
VALUES('Сколько существует вариантов выбора двух чисел из восьми?', 2);
INSERT INTO `question`(`description`, `testId`)
VALUES('Сколькими способами можно переставить буквы в слове \"луна\"?', 2);

INSERT INTO `question`(`description`, `testId`)
VALUES('В какое состояние переходит поток после вызова метода start()?', 3);
INSERT INTO `question`(`description`, `testId`)
VALUES('В каком состоянии находится поток, если он создан и не запущен?', 3);
INSERT INTO `question`(`description`, `testId`)
VALUES('Какой метод интерфейса Runnable должен быть реализован всеми потоками?', 3);
INSERT INTO `question`(`description`, `testId`)
VALUES('Какой метод надо вызвать, чтобы запустить поток?', 3);

INSERT INTO `question`(`description`, `testId`)
VALUES('Может ли класс из Collection Framework быть неотсортированным и упорядоченным?', 4);
INSERT INTO `question`(`description`, `testId`)
VALUES('Что должно вернуть выражение x.equals(null) в соответствии с контрактом по написанию этого метода?', 4);
INSERT INTO `question`(`description`, `testId`)
VALUES('Какой из следующих методов используется для получения набора, содержащего все ключи, используемые в карте?', 4);
INSERT INTO `question`(`description`, `testId`)
VALUES('Какой интерфейс предоставляет возможность хранить объекты в виде пар ключ-значение?', 4);

-- populate answer table
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('22+5=27', false, 1);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('27-x=5', true, 1);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('27-5=22', false, 1);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('5=27-22', false, 1);

INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('683', false, 2);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('19', false, 2);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('9', false, 2);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('29', true, 2);

INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('352', true, 3);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('362', false, 3);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('267', false, 3);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('458', false, 3);

INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('655', false, 4);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('46', false, 4);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('125', true, 4);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('245', false, 4);

INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('720', true, 5);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('3600', false, 5);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('36', false, 5);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('18', false, 5);

INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('1024', false, 6);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('3096', false, 6);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('9', false, 6);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('36', true, 6);

INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('28', true, 7);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('56', false, 7);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('73', false, 7);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('23', false, 7);

INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('12', true, 8);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('14', false, 8);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('6', false, 8);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('4', false, 8);

INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('Runnable', true, 9);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('New', false, 9);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('Dead', false, 9);

INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('Runnable', false, 10);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('New', true, 10);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('Dead', false, 10);

INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('start()', false, 11);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('run()', true, 11);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('throw()', false, 11);

INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('start()', true, 12);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('run()', false, 12);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('throw()', false, 12);

INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('да', true, 13);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('нет', false, 13);

INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('null', false, 14);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('NullPointerException', false, 14);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('не скомпилируется', false, 14);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('false', true, 14);

INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('getAll()', false, 15);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('getKeys()', true, 15);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('setKeys()', false, 15);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('getMap()', false, 15);

INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('Map', true, 16);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('Set', false, 16);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES ('List', false, 16);

-- populate user table (https://bcrypt-generator.com/)
INSERT INTO `user`(`firstName`, `lastName`, `login`, `password`)
-- password = adminPassword
VALUES('Admin', 'Adminovic', 'admin', '$2y$12$FxWZFvC8gEEvZQhHgg.YSO6ZqCjbU1x5cHtjWI8XxivApqG17JUUS');
INSERT INTO `user`(`firstName`, `lastName`, `login`, `password`)
-- password = tutorPassword
VALUES('Tutor', 'Tutorovic', 'tutor', '$2y$12$kpa.v1Lq76nAVtDLwYls/Oya6wFzTvU9Vnqcwpj2kmPQlMnV0Z/Ea');
INSERT INTO `user`(`firstName`, `lastName`, `login`, `password`)
-- password = userPassword
VALUES('Константин', 'Асташонок', 'user', '$2y$12$WAeUHsiu26Hu1Yi35JuN.e4JKc6wOrtA//cqKn/kB/lzDz5uDx6Xe');

-- populate role table
INSERT INTO `role`(`name`)
VALUES('ROLE_ADMIN');
INSERT INTO `role`(`name`)
VALUES('ROLE_TUTOR');
INSERT INTO `role`(`name`)
VALUES('ROLE_USER');

-- populate userRole table
INSERT INTO `userRole`(`userId`, `roleId`)
VALUES(1, 1);
INSERT INTO `userRole`(`userId`, `roleId`)
VALUES(2, 2);
INSERT INTO `userRole`(`userId`, `roleId`)
VALUES(3, 3);
INSERT INTO `userRole`(`userId`, `roleId`)
VALUES(3, 1);


-- populate statistic table


-- populate literature table
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 1', 1);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 2', 2);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 3', 3);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 4', 4);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 5', 5);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 6', 6);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 7', 7);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 8', 8);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 9', 9);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 10', 10);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 11', 11);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 12', 12);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 13', 13);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 14', 14);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 15', 15);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 16', 16);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Литература 17', 9);


-- populate link table
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 1', 1);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 2', 2);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 3', 3);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 4', 4);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 5', 5);

INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 6', 6);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 7', 7);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 8', 8);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 9', 9);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 10', 10);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 11', 11);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 12', 12);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 13', 13);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 14', 14);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 15', 15);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 16', 16);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Cсылка 17', 9);