drop table department, student;

CREATE TABLE department (
    code VARCHAR(4) PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    dept_code VARCHAR(4) REFERENCES department(code),
    credits INT NOT NULL
);

INSERT INTO department (code, name) VALUES
('MATH', 'Math'),
('CSCI', 'Computer Science'),
('PHIL', 'Philosophy'),
('ARTH', 'Art History');

INSERT INTO student (id, name, dept_code, credits) VALUES
(1001, 'Janelle', 'MATH', 104),
(1002, 'Júlio', 'CSCI', 68),
(1003, 'Chandra', 'PHIL', 32),
(1004, 'Jung', 'PHIL', 92),
(1005, 'Shakila', 'CSCI', 112),
(1006, 'Rajendra', 'ARTH', 18);
