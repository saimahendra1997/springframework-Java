package com.springbootjdbcproject.springbootjdbcdemo.repo;

import com.springbootjdbcproject.springbootjdbcdemo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    public void save(Student s) {
        System.out.println("Student added successfully in to database...");
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        return students;
    }
}