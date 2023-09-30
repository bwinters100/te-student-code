package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {

	private final String DEPARTMENT_SELECT = "SELECT d.department_id, d.name FROM department d ";

	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartmentById(int id) {
		Department department = null;
		String sql = DEPARTMENT_SELECT +
				" WHERE d.department_id=?";

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
			if (results.next()) {
				department = mapRowToDepartment(results);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Unable to connect to server or database", e);
		}

		return department;
	}

	@Override
	public List<Department> getDepartments() {
		List<Department> departments = new ArrayList<>();
		String sql = DEPARTMENT_SELECT;

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				departments.add(mapRowToDepartment(results));
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Unable to connect to server or database", e);
		}

		return departments;
	}

	@Override
	public Department createDepartment(Department department) {
		try {
			Integer department_id = jdbcTemplate.queryForObject("Insert into department (name) Values (?) RETURNING department_id;", int.class, department.getName());
			department.setId(department_id);
		} catch (DataAccessException e) {
			throw new DaoException(e.getMessage());
		}
		return department;
	}

	@Override
	public Department updateDepartment(Department department) {
		Department updatedDepartment = null;
		try{
		int numOfRows = jdbcTemplate.update("Update department set name = ? where department_id = ?;", department.getName(), department.getId());
		if (numOfRows == 0) {
			throw new DaoException("No Rows Changed");
		}
		else{
			updatedDepartment = getDepartmentById(department.getId());
		}
	} catch (CannotGetJdbcConnectionException e) {
		throw new DaoException("Unable to connect to server or database", e);
	} catch (DataIntegrityViolationException e) {
		throw new DaoException("Data integrity violation", e);
	}
	return updatedDepartment;
}

	@Override
	public int deleteDepartmentById(int id) {
		int numOfRows = 0;
		String empSQL = "Delete from employee where department_id = ?;";
		String depSQL = "Delete from department where department_id = ?;";
		try{
			jdbcTemplate.update(empSQL, id);
			numOfRows = jdbcTemplate.update(depSQL, id);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Unable to connect to server or database", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation", e);
		}
		return numOfRows;
	}

	private Department mapRowToDepartment(SqlRowSet results) {
		Department department = new Department();
		department.setId(results.getInt("department_id"));
		department.setName(results.getString("name"));
		return department;
	}

}
