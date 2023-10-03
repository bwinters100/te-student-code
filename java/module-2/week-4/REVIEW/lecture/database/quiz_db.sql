BEGIN TRANSACTION;

DROP TABLE IF EXISTS quiz, question, quiz_question, answer CASCADE;

CREATE TABLE quiz (
    quiz_id int GENERATED ALWAYS AS IDENTITY,
    quiz_name varchar(20) NOT NULL,
    CONSTRAINT PK_quiz PRIMARY KEY(quiz_id)
);

CREATE TABLE question (
    question_id int GENERATED ALWAYS AS IDENTITY,
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

INSERT INTO quiz (quiz_name) VALUES ('test_quiz');
--Question 1
INSERT INTO question (question_text, correct_answer) VALUES ('What color is the sky?', 2);
INSERT INTO answer (question_id, answer_number, answer_text)
VALUES (lastval(), 1, 'yellow'), (lastval(), 2, 'blue'), (lastval(), 3, 'green'), (lastval(), 4, 'red');
INSERT INTO quiz_question (quiz_id, question_id, question_number)
VALUES ((SELECT quiz_id FROM quiz WHERE quiz_name = 'test_quiz'), lastval(), 1);
--Question 2
INSERT INTO question (question_text, correct_answer) VALUES ('A skeleton walks into a bar, and says to the bartender, "Give me a beer and a ..."', 3);
INSERT INTO answer (question_id, answer_number, answer_text)
VALUES (lastval(), 1, 'hair brush'), (lastval(), 2, 'dry erase marker'), (lastval(), 3, 'mop'), (lastval(), 4, 'yo-yo');
INSERT INTO quiz_question (quiz_id, question_id, question_number)
VALUES ((SELECT quiz_id FROM quiz WHERE quiz_name = 'test_quiz'), lastval(), 2);

COMMIT;
