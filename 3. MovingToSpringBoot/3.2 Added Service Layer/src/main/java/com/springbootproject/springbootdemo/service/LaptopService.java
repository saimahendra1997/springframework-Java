package com.springbootproject.springbootdemo.service;

import com.springbootproject.springbootdemo.model.Laptop;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
// If you want to get this class object, which annotation we are going to use here.
// As we know this will not work if we don't have @Component on top of it. As we know if we add @Component Spring will create and manage the objects for us
// but as we discussed before @Component is not the only option. If we want to work with service class. We can also use @Service Stereo type.
// Now Service and component does the same thing. They both say it becomes a managed bean because if we click on service we can see service itself is annotated with @Component.
// even if you write add component, you will not get the error. It will work. But using service makes much more sense.


    // Apart from this, If we want to store this data in database. In this case where we will write your database steps(JDBC)
    // So if you want to connect our Java application with database we need JDBC in between which is Java database connectivity where we will write your JDBC steps inside service class.
    // Of Course, we can write it in a service class, but it's not a good practice where we should write your JDBC code is a separate class called repository class,
    // where you will have all the database connections. The only job of that class is to work with database.The job of service is to process the data not connecting with database.

    
    public void addLaptop(Laptop lap) {
        // Here we are going to add laptop in database
    }

    public boolean isGoodForCoding()
    {
        // Based on the configuration we are returning whether it is good or bad
        return true;
    }
}
