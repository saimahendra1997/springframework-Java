package com.springbootjdbcproject.springbootjdbcdemo.repo;

import com.springbootjdbcproject.springbootjdbcdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    // Creating reference for JDBC Template
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    // Also we want this to be auto wired. Now who is responsible to create the instance for this spring will do it. we don't have to worry about it.
    // So behind the scene it will use data source to add data. And it will also instantiate the database variable or the object,
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student s) {
//        System.out.println("Student added successfully in to database...");
        // Using the template we are going to save the data.

        // Creating a query and since we don't have values at this point I will put question marks there.
        String sqlQuery = "insert into student (rollNo, name, marks) values(?, ?, ?)";
        int rows = jdbcTemplate.update(sqlQuery, s.getRollNo(), s.getName(), s.getMarks()); // So this question marks will be replaced by the actual values.
        // we have to make sure that the sequence are matching.if we click on update we can see update returns an integer value.That means the number of rows affected.
        System.out.println(rows + " effected" );

        // if we know JDBC, the actual concept of Java database connectivity and if we want to execute a query we have three options.
        // we have execute, update and execute query.Now when we want to update data like inserting,updating, deleting that's what we use execute update.
        // and then we want to fire a Select query we use executeQuery.So instead of using executeUpdate we are going to use only update which is actually executeUpdate behind the scene.
        // In this we have to pass the parameters.Firstly we are going to pass a query and the remaining parameter will be our values.

        // When we run this we got an error saying - Table "STUDENT" not found. Actually we do have a h2 database, but we don't have a table.
        // We have not asked our H2 to create a table for us that's something we are missing. Also, we need to populate the data and create the schema
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        return students;
    }
}