package com.springbootjdbcproject.springbootjdbcdemo;

import com.springbootjdbcproject.springbootjdbcdemo.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootjdbcdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootjdbcdemoApplication.class, args);

        // What we are going to do is we are going to build application for student management. Let's say adding student retrieving student deleting student if we want.
        // Can we connect the table with the class with the class or object? Basically we can say that our class is similar to your table because class will have a class name,
        // and class will have certain variables. Now in our table, if you we three columns, our class will have three properties(roll number, name, and marks.)
        // And every object of this class will be one row in your table.So if we create ten objects for student, imagine we have ten rows. So that's how basically we can relate our class and our tables.

        Student student = context.getBean(Student.class);
        student.setRollNo(101);;
        student.setName("Sai");
        student.setMarks(96);

        // Basically want to add this student. So whatever student object I'm creating I want to add it.So how exactly this is going to interact with which class.
        // Of Course, it will not be directly interacting with the uh repository layer. We need a layer in between which is service.


	}

}
