INSERT INTO categories (NAME) VALUES ('Technical Skills');
INSERT INTO categories (NAME) VALUES ('Certifications');
INSERT INTO categories (NAME) VALUES ('Soft Skills');
INSERT INTO categories (NAME) VALUES ('SDP and Tools');
INSERT INTO categories (NAME) VALUES ('Business Domain');
INSERT INTO categories (NAME) VALUES ('English');

INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('OOP/OOD', 1);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('App design/patterns', 1);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Java core', 1);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Testing', 1);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Hibernate/JPA/JDBC', 1);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Spring', 1);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Servlets/REST', 1);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Frontend', 1);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Database', 1);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Enviroment (infrastructure)', 1);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Other frameworks', 1);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Additional topics', 1);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Perfomance', 1);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Networking & Security', 1);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('UML', 1);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Relese and Deployment Management', 4);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Quolity Management', 4);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Risk Management', 4);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Agile', 4);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Jira', 4);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Sonar', 4);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Forex', 5);
INSERT INTO topics (NAME, CATEGORY_ID) VALUES ('Investment Banking', 5);

INSERT INTO positions (NAME) VALUES ('Intern Java Dev');
INSERT INTO positions (NAME) VALUES ('Junior Java Dev');
INSERT INTO positions (NAME) VALUES ('Regular Java Dev');
INSERT INTO positions (NAME) VALUES ('Senior Java Dev');

INSERT INTO skills (NAME, TOPIC_ID, POSITION_ID) VALUES ('Principles of OOP', 1, 1);
INSERT INTO skills (NAME, TOPIC_ID, POSITION_ID) VALUES ('Design patterns (list groups and give some examples), GOF', 1, 2);
INSERT INTO skills (NAME, TOPIC_ID, POSITION_ID) VALUES ('OOD Principles (SOLID, GRASP)', 1, 3);
INSERT INTO skills (NAME, TOPIC_ID, POSITION_ID) VALUES ('Design patterns (GOF)', 1, 3);
INSERT INTO skills (NAME, TOPIC_ID, POSITION_ID) VALUES ('TDD, BDD', 1, 3);

INSERT INTO skills (NAME, TOPIC_ID, POSITION_ID) VALUES ('Clean Code', 2, 2);
INSERT INTO skills (NAME, TOPIC_ID, POSITION_ID) VALUES ('Microservices architecture', 2, 4);
INSERT INTO skills (NAME, TOPIC_ID, POSITION_ID) VALUES ('Enterprise architecture patterns', 2, 4);
INSERT INTO skills (NAME, TOPIC_ID, POSITION_ID) VALUES ('API design', 2, 4);
INSERT INTO skills (NAME, TOPIC_ID, POSITION_ID) VALUES ('Integration patterns', 2, 4);
INSERT INTO skills (NAME, TOPIC_ID, POSITION_ID) VALUES ('Domain Driven Design (Optional)', 2, 4);

INSERT INTO skills (NAME, TOPIC_ID, POSITION_ID) VALUES ('Class Object (abstract classes and OOP in Java)', 3, 1);
INSERT INTO skills (NAME, TOPIC_ID, POSITION_ID) VALUES ('Collections (basic level)', 3, 1);
INSERT INTO skills (NAME, TOPIC_ID, POSITION_ID) VALUES ('Exceptions', 3, 1);
INSERT INTO skills (NAME, TOPIC_ID, POSITION_ID) VALUES ('Enums, Jenerics (basics-usage)', 3, 1);
INSERT INTO skills (NAME, TOPIC_ID, POSITION_ID) VALUES ('Rules about equels, hashcode (full understanding)', 3, 1);