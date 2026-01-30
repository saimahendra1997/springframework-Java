package com.springbootjdbcproject.springbootjdbcdemo.service;

import com.springbootjdbcproject.springbootjdbcdemo.model.Student;
import com.springbootjdbcproject.springbootjdbcdemo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo studentRepo;

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    @Autowired // Setter Injection
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    // See, in the service class we can have multiple methods, not just for storing data in database, because the actual code for storing data in database will be done in repository.
    // Apart from those methods for the CRUD operations, we can have some more methods as well. If we want to say find a student who got a marks more than this or that.
    public void addStudent(Student s) {
//        System.out.println("Student Added...");
        // Instead of saying added here, what we want to do to use repo because repo is responsible to store data in database, we can use a method like save.
        // Of Course, we can use any method name. But slowly we are moving towards Spring Data JPA where you will be using some methods of JPA. So save is one of the method.
        // So we can start following the same convention
        studentRepo.save(s);
        //  service has no idea what is happening right. So it says my job is to send data or call the method of repo.
    }

    public List<Student> getStudents() {
        return  studentRepo.findAll();
        // We can use certain methods in repo. We can also say getStudents.But the better way is to use findAll().
        // We're trying to use the methods of JPA so that when we go towards JPA, we will find the same method name which make much more sense
    }
}
