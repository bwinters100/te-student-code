package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final String PROJECT_SELECT = "SELECT p.project_id, p.name, p.from_date, p.to_date FROM project p";

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProjectById(int projectId) {
		Project project = null;
		String sql = PROJECT_SELECT +
				" WHERE p.project_id=?";

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
			if (results.next()) {
				project = mapRowToProject(results);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException(e.getMessage());
		}

		return project;
	}

	@Override
	public List<Project> getProjects() {
		List<Project> allProjects = new ArrayList<>();
		String sql = PROJECT_SELECT;

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				Project projectResult = mapRowToProject(results);
				allProjects.add(projectResult);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException(e.getMessage());
		}

		return allProjects;
	}

	@Override
	public Project createProject(Project newProject) {
		try {
			Integer project_id = jdbcTemplate.queryForObject("Insert into project (name, from_date, to_date) Values (?,?,?) RETURNING project_id;", int.class, newProject.getName(), newProject.getFromDate(), newProject.getToDate());
			newProject.setId(project_id);
		} catch (DataAccessException e) {
			throw new DaoException(e.getMessage());
		}
		return newProject;
	}
	
	@Override
	public void linkProjectEmployee(int projectId, int employeeId) {

		String sql = "INSERT INTO project_employee (project_id, employee_id) VALUES (?, ?);";
		try {
			jdbcTemplate.update(sql, projectId, employeeId);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Unable to connect to server or database", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation", e);
		}
	}

	@Override
	public void unlinkProjectEmployee(int projectId, int employeeId) {
		String sql = "Delete from project_employee where project_id = ? and employee_id = ?";
		try {
			jdbcTemplate.update(sql, projectId, employeeId);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Unable to connect to server or database", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation", e);
		}
	}

	@Override
	public Project updateProject(Project project) {
		Project updatedProject = null;
		try{
			int numOfRows = jdbcTemplate.update("Update project set name = ?, from_date = ?, to_date = ? where project_id = ?;", project.getName(), project.getFromDate(), project.getToDate(), project.getId());
			if (numOfRows == 0) {
				throw new DaoException("No Rows Changed");
			}
			else{
				updatedProject = getProjectById(project.getId());
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Unable to connect to server or database", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation", e);
		}
		return updatedProject;
	}
	@Override
	public int deleteProjectById(int projectId) {
		{
			int numOfRows = 0;
			String empSQL = "Delete from project_employee where project_id = ?;";
			String depSQL = "Delete from project where project_id = ?;";
			try{
				jdbcTemplate.update(empSQL, projectId);
				numOfRows = jdbcTemplate.update(depSQL, projectId);
			} catch (CannotGetJdbcConnectionException e) {
				throw new DaoException("Unable to connect to server or database", e);
			} catch (DataIntegrityViolationException e) {
				throw new DaoException("Data integrity violation", e);
			}
			return numOfRows;
		}
	}
	
	private Project mapRowToProject(SqlRowSet results) {
		Project project = new Project();
		project.setId(results.getInt("project_id"));
		project.setName(results.getString("name"));
		if (results.getDate("from_date") != null) {
			project.setFromDate(results.getDate("from_date").toLocalDate());
		}
		if (results.getDate("to_date") != null) {
			project.setToDate(results.getDate("to_date").toLocalDate());
		}
		return project;
	}

}
