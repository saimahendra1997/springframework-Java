package com.springbootproject.springbootdemo.repo;

import com.springbootproject.springbootdemo.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepo {
    // Only Specifying the database operations in this class and which is responsible to connect with database.
    // We can have all the CRUD operations here create read update delete.

    public void save(Laptop lap)
    {
        System.out.println("Laptop saved successfully...");
    }
}
