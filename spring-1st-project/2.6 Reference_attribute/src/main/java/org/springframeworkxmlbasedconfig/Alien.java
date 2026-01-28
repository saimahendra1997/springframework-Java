package org.springframeworkxmlbasedconfig;

import java.beans.ConstructorProperties;

public class Alien {

    private int age;
//    private  Laptop laptop =new Laptop(); // It will work
    // We don't want to do this we want spring to inject this reference variable
    private Laptop laptop;

    public Alien() {
        System.out.println("Alien Object Created...");
    }

        public int getAge() {
            return age;
        }

    public void setAge(int age) {    // Setter Injection
        System.out.println("Setter called");
        this.age = age;
    }

    public Laptop getLap() {
        return laptop;
    }

    public void setLap(Laptop lap) {
        this.laptop = lap;
    }

    public void code() {
        System.out.println("Coding");
        laptop.compile();
    }
}
