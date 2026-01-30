package com.springbootjdbcproject.springbootjdbcdemo;

import com.springbootjdbcproject.springbootjdbcdemo.model.Student;
import com.springbootjdbcproject.springbootjdbcdemo.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringbootjdbcdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootjdbcdemoApplication.class, args);

        // What we are going to do is we are going to build application for student management. Let's say adding student retrieving student deleting student if we want.
        // Can we connect the table with the class with the class or object? Basically we can say that our class is similar to your table because class will have a class name,
        // and class will have certain variables. Now in our table, if you we three columns, our class will have three properties(roll number, name, and marks.)
        // And every object of this class will be one row in your table.So if we create ten objects for student, imagine we have ten rows. So that's how basically we can relate our class and our tables.

        Student student = context.getBean(Student.class);
        student.setRollNo(105);;
        student.setName("Prudhvi");
        student.setMarks(66);

        // Basically want to add this student. So whatever student object I'm creating I want to add it.So how exactly this is going to interact with which class.
        // Of Course, it will not be directly interacting with the uh repository layer. We need a layer in between which is service.

        StudentService studentService = context.getBean(StudentService.class);
        studentService.addStudent(student);

        // If I want to print all the students
        List<Student> students = studentService.getStudents();
        System.out.println(students); // After adding the student we are just listing all the students in the repo

        // And things are working out. we got the output as
        // Student Added Successfully in to db
        //[]
        // But not exactly the way we wanted. We want to get this data from database. As we have H2 which is default database available for us.
        // It's time to work with the db. Let's actually store this data in db and fetch this from db.To achieve this we have to use something called a JDBC template.


        // JDBC Template
        // The moment we add our H2 in your dependency, basically we get the extra db and also the driver for it.we just have to use it.
        // And by default it will have some default values and no need to actually configure anything. By Default, we will get the configuration.
        // we just have to use a template to save data.If we want to customize it, that's a different thing. But by default we will get the values.


        // Creating Schema and data
        // So normally when we have a DBMS let's say a Postgres or MySQL, basically we can open that software and write the query to create the schema.
        // But since we are using H2, and not using a web application to get the H2 console, what we can do is if we want to create a schema in the resource folder, and name it as schema.sql
        // So basically we can create two files, one for the schema and one for the data. In the schema we will only specify what exact table we want and for data as well which is data.sql.

        // -- we say create table and we mention the table name which is student in our case and then in the round brackets we mention our columns.
        //--   The first column I need is row number which is of type int and I want this to be primary key.
        //--   Next is name which is varchar the size I want to have is 50, and I will say marks int

        // --In data.sql we don't have to mention the JSON file. we basically have to mention our Insert statement.
        //-- So I will say insert into student for three values rollNo, name, marks and I will say values where I can specify some numbers.


        //  PostgresSQL
        // If we want to connect with external db we need to make changes in pom.xml where we need to add postgresSQL dependency
        // If we run after adding the dependency it will throw the error because we didn't specify any data source
        // To specify we have to add some properties in resources -> application.properties file
        // firstly we need to change the url data source by default it is h2 we need to change it to PostgresSQL
        // Now when you work with Postgres in fact any JDBC it starts with JDBC colo followed by dbms name, and then we have to specify the IP address which is the localhost, and then the port number.
        // For Postgres the port number is 5432. For My SQL you can use 3306 and depend upon your DBMS, and then you have to mention our database name

    }

}
