BEGIN TRANSACTION;

DROP TABLE IF EXISTS quiz, question, quiz_question, answer CASCADE;

CREATE TABLE quiz (
    quiz_id int GENERATED ALWAYS AS IDENTITY,  -- same as serial in Postgres
    quiz_name varchar(20) NOT NULL,
    CONSTRAINT PK_quiz PRIMARY KEY(quiz_id)
);

CREATE TABLE question (
    question_id int GENERATED ALWAYS AS IDENTITY,  -- same as serial in Postgres
    question_text varchar(100) NOT NULL,
    correct_answer int NOT NULL,
    CONSTRAINT PK_question PRIMARY KEY(question_id)
);

CREATE TABLE quiz_question (
    quiz_id int REFERENCES quiz(quiz_id),
    question_id int REFERENCES question(question_id),
    question_number int NOT NULL,
    CONSTRAINT PK_quiz_question PRIMARY KEY(quiz_id, question_id)
);

CREATE TABLE answer (
    question_id int REFERENCES question(question_id),
    answer_number int,
    answer_text varchar(50) NOT NULL,
    CONSTRAINT PK_answer PRIMARY KEY(question_id, answer_number)
);

-- Test Data ---------------------------------------

-- Quiz 1 -- serial quiz_id = 1
INSERT INTO quiz (quiz_name) VALUES ('test_quiz');

-- Question 1 -- serial question_id = 1
INSERT INTO question (question_text, correct_answer)
    VALUES ('What color is the sky?', 2);
-- Answers for question_id = 1
INSERT INTO answer (question_id, answer_number, answer_text)
    VALUES (1, 1, 'yellow'), (1, 2, 'blue'), (1, 3, 'green'), (1, 4, 'red');

-- Add question (question_id = 1) to quiz (quiz_id = 1)
INSERT INTO quiz_question (quiz_id, question_id, question_number)
    VALUES ((SELECT quiz_id FROM quiz WHERE quiz_name = 'test_quiz'), 1, 1);

-- Question 2 -- serial question_id = 2
INSERT INTO question (question_text, correct_answer)
    VALUES ('A skeleton walks into a bar, and says to the bartender, "Give me a beer and a ..."', 3);
-- Answers for question_id 2
INSERT INTO answer (question_id, answer_number, answer_text)
    VALUES (2, 1, 'hair brush'), (2, 2, 'dry erase marker'), (2, 3, 'mop'), (2, 4, 'yo-yo');

-- Add question (question_id = 2) to quiz (quiz_id = 1)
INSERT INTO quiz_question (quiz_id, question_id, question_number)
    VALUES ((SELECT quiz_id FROM quiz WHERE quiz_name = 'test_quiz'), 2, 2);

COMMIT;
