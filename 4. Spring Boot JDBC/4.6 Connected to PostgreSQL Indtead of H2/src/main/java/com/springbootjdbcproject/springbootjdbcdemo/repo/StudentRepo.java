package com.springbootjdbcproject.springbootjdbcdemo.repo;

import com.springbootjdbcproject.springbootjdbcdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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

//    public void save(Student s) {
////        System.out.println("Student added successfully in to database...");
//        // Using the template we are going to save the data.
//
//        // Creating a query and since we don't have values at this point I will put question marks there.
//        String sqlQuery = "insert into student (rollNo, name, marks) values(?, ?, ?)";
//        int rows = jdbcTemplate.update(sqlQuery, s.getRollNo(), s.getName(), s.getMarks()); // So this question marks will be replaced by the actual values.
//        // we have to make sure that the sequence are matching.if we click on update we can see update returns an integer value.That means the number of rows affected.
//        System.out.println(rows + " effected" );
//
//        // if we know JDBC, the actual concept of Java database connectivity and if we want to execute a query we have three options.
//        // we have execute, update and execute query.Now when we want to update data like inserting,updating, deleting that's what we use execute update.
//        // and then we want to fire a Select query we use executeQuery.So instead of using executeUpdate we are going to use only update which is actually executeUpdate behind the scene.
//        // In this we have to pass the parameters.Firstly we are going to pass a query and the remaining parameter will be our values.
//
//        // When we run this we got an error saying - Table "STUDENT" not found. Actually we do have a h2 database, but we don't have a table.
//        // We have not asked our H2 to create a table for us that's something we are missing. Also, we need to populate the data and create the schema
//    }



    // Logic to Check for Existence Before Inserting (Recommended for Production-Like Behavior)
    public void save(Student s) {
        // First, check if rollNo already exists
        String checkQuery = "SELECT COUNT(*) FROM student WHERE rollNo = ?";
        int count = jdbcTemplate.queryForObject(checkQuery, Integer.class, s.getRollNo());

        if (count > 0) {
            // Update instead of insert
            String updateQuery = "UPDATE student SET name = ?, marks = ? WHERE rollNo = ?";
            int rows = jdbcTemplate.update(updateQuery, s.getName(), s.getMarks(), s.getRollNo());
            System.out.println(rows + " row(s) updated");
        } else {
            // Insert new row
            String insertQuery = "INSERT INTO student (rollNo, name, marks) VALUES (?, ?, ?)";
            int rows = jdbcTemplate.update(insertQuery, s.getRollNo(), s.getName(), s.getMarks());
            System.out.println(rows + " row(s) inserted");
        }
    }
//    public List<Student> findAll() {
//        List<Student> students = new ArrayList<>();
//        return students;
///        Row Mapper -         // fetching the data that we are storing
//        // Fetching all the data from database.I want to execute this query. So whenever we use a select query in JDBC we have to execute a method called executeQuery.
//        // we don't have executeQuery, but we have a method called query which takes 2 parameters 1st one ia the actual query and 2nd one is the object of row mapper
//        // Using RowMapper we can actually fetch the data from the ResultSet. If we remember in JDBC, whenever we fire a Select query, we get a ResultSet.
//        // Now from this ResultSet, we get one by one data and row mapper will help us to fetch that data from the result set.
//        // Let's use this RowMapper which is an interface accepting the type we can pass Student. The thing is this is a functional interface that means we can use lambda expression as well.
//        // We can start by typing RowMapper where we have to implement the method which takes two parameters. First is result set.(That's what you get from executing the query and then the row number.)
//        // So what it simply says is I have a method called mapRow which is to take one row at a time from the result set and give it to you
//        // So basically map row will give us one row at a time or one particular data or object at a time.Now this row number is something which your map row uses behind the scene.
//
//        RowMapper<Student> mapper = new RowMapper<Student>() {
//            @Override
//            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//                //So I want to fetch data from result set.So if you want to use it and store it somewhere, first of all let me create a student object
//                Student student = new Student();
//                // Setting the value for student. But this setRollNo will be coming from the resultSet. So we can say rs.getInt because it's of type integer.
//                // And you can specify the column number, or column name.
//                student.setRollNo(rs.getInt("rollNo"));
//                student.setName(rs.getString("name"));
//                student.setMarks(rs.getInt("marks"));
//                return student;  //  you can see map row return type is Student so we can return student
//            }
//        };
//        String sql = "select * from student";
//        return jdbcTemplate.query(sql, mapper);
//        // So what map row will do is it will fetch data from result set and What we are doing is taking the data, adding it to the student object and returning it.
//        // So this is the object(mapper) we have to pass in the query. Also, this query returns you the list of values. So if we click on query we can see it returns the list of the type.
//        // So here the type is student which returns the list of students.
//        // we can say return jdbcTemplate.query(sql, mapper);
//        // [Student{rollNo=101, name='Sai', marks=96}, Student{rollNo=102, name='Mahi', marks=92}, Student{rollNo=103, name='Gopi', marks=84}, Student{rollNo=104, name='Vijay', marks=73}, Student{rollNo=105, name='Prudhvi', marks=66}]
//    }


    // Doing it in Lambda style
    public List<Student> findAll() {
    //    RowMapper<Student> mapper = ( rs,  rowNum) -> {
    //            //So I want to fetch data from result set.So if you want to use it and store it somewhere, first of all let me create a student object
    //            Student student = new Student();
    //            // Setting the value for student. But this setRollNo will be coming from the resultSet. So we can say rs.getInt because it's of type integer.
    //            // And you can specify the column number, or column name.
    //            student.setRollNo(rs.getInt("rollNo"));
    //            student.setName(rs.getString("name"));
    //            student.setMarks(rs.getInt("marks"));
    //            return student;  //  you can see map row return type is Student so we can return student
    //    };
        String sql = "select * from student";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            //So I want to fetch data from result set.So if you want to use it and store it somewhere, first of all let me create a student object
            Student student = new Student();
            // Setting the value for student. But this setRollNo will be coming from the resultSet. So we can say rs.getInt because it's of type integer.
            // And you can specify the column number, or column name.
            student.setRollNo(rs.getInt("rollNo"));
            student.setName(rs.getString("name"));
            student.setMarks(rs.getInt("marks"));
            return student;  //  you can see map row return type is Student so we can return student
        });
    }
}