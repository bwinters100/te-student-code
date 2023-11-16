select dept_code from student order by credits limit 1;

SELECT s.dept_code
FROM student s
WHERE s.credits = (SELECT MIN(credits) FROM student);

SELECT department.code, count(*) as student_count FROM department
JOIN student on student.dept_code = department.code
GROUP BY (department.code);

SELECT dept_code, count(*) as student_count FROM student
GROUP BY (dept_code);