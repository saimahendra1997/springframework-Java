package org.springframeworkxmlbasedconfig;

import java.beans.ConstructorProperties;

public class Alien {

    private int age;
//    private  Laptop laptop =new Laptop();
    private Laptop laptop;

    public Alien() {
        System.out.println("Alien Object Created...");
    }

//    public Alien(int age) {
//        System.out.println("Parameterized Constructor called...");
//        this.age=age;
//    }

    @ConstructorProperties({"age", "laptop"})
    public Alien(int age, Laptop laptop) {
        this.age = age;
        this.laptop = laptop;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Setter Called...");
        this.age = age;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public void code() {
        System.out.println("Started Coding.. ");
        laptop.compile();
    }
}
