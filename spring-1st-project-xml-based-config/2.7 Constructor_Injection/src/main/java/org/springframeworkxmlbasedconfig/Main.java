package org.springframeworkxmlbasedconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // if you want to create a container, we have to use something called an ApplicationContext.Now ApplicationContext is
        // responsible to work with the IOC container. Actually we do have two options to interact with the container
        // One is BeanFactory which is an old one, the application context, a new one. Both does the same thing, almost the same thing.
        // Basically, it will help you to create the container, and it will help you to get the objects from the container


        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        // Constructor Injection
        // In Java we know that if you want to create the object or if you want to initialize the values, we can do that in constructor as well.
        // And that's most of the time we do. So if you want to assign the value initially when the object is created we prefer to use constructor
        // setters are good. But then if you want to assign the values later setter makes sense.
        // Firstly we already have the default constructor now creating the parameterized constructor which takes age as variable
        // I don't want to use the property tag now. So when I use property tag basically it uses the setter. I don't want to do that I want to use the constructor.
        // Now how will you assign a value with the help of constructor? The way we have property here we also have something called a constructor arg.
        Alien alien1= (Alien) context.getBean("alien1");
        System.out.println(alien1.getAge()); //28
        alien1.code();
        // Parameterized Constructor called...
        //Laptop Object Created..
        //28
        //Started Coding..
        //Compiling the code...

        // The concern is what if you have a constructor which takes two parameters. As of now We are passing only one.//
        //         <constructor-arg value="28"></constructor-arg>
        //        <constructor-arg ref="lap"></constructor-arg>
        // We can also mention the type explicitly because it was even not checking the type, it was checking the sequence.
        // Now which one to prefer. So if you want to have values which are compulsory you have to use constructor.
        // But if you have optional values optional properties you can use setter injections.
        // So that depends upon the project requirement.
    }
}