package com.techelevator.dao;

import com.techelevator.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getStudentByName(String name);
}
