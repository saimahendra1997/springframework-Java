package com.springbootproject.springbootdemo;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{

    @Override
    public void compile() {
        System.out.println("Compiling in Laptop...");
    }
}
