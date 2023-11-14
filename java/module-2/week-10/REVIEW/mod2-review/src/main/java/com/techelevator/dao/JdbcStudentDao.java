package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcStudentDao implements StudentDao {

    private static final RowMapper<Student> MAPPER = new RowMapper<Student>() {

        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String deptCode = rs.getString("dept_code");
            int credits = rs.getInt("credits");
            return new Student(id, name, deptCode, credits);
        }
    };

    private final JdbcTemplate template;

    public JdbcStudentDao(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Student> getStudentByName(String name) {
        try {
            // what about this? ...
            // Janelle';delete from student;select * from student where name = 'Tom
            return template.query("select * from student where name = '" + name + "'", MAPPER);
            //  return template.query("select * from student where name = ?", MAPPER, name);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
