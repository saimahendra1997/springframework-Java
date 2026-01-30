package com.springbootproject.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Value("28")
    private int age;

    @Autowired
    private Computer com;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    @Autowired // Doing setter injection
    @Qualifier("laptop")
    // So even if we're making desktop as Primary I will say in the qualifier as Laptop. We know that Qualifier overrides the Primary
    public void setCom(Computer com) {
        this.com = com;
    }

    public void code()
    {
        com.compile();
    }
}
