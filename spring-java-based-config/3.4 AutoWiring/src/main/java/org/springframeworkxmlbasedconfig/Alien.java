package org.springframeworkxmlbasedconfig;

import java.beans.ConstructorProperties;

public class Alien {
    private int age;
    private Computer comp;

    public Alien() {
        System.out.println("Alien Object Created...");
    }

//    public Alien(int age) {
//        System.out.println("Parameterized Constructor called...");
//        this.age=age;
//    }

//    @ConstructorProperties({"age", "computer"})
//    public Alien(int age, Computer comp) {
//        this.age = age;
//        this.comp = comp;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
//        System.out.println("Setter Called...");
        this.age = age;
    }

    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    public void code() {
        System.out.println("Started Coding.. ");
        comp.compile();
        // Now alien is not dependent on a laptop. It's dependent on a computer.Now this computer can be anything. It can be a laptop or desktop.
        // So in future if we want to pass a laptop you can do that.Or we can pass a desktop. Now based on which object you are passing.
        // When you call compile, it will call the method of that particular class. If you're passing the object of laptop, it will call the compile method of laptop.
        // If you pass a desktop object, it will call the compile method of desktop.
    }
}
