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
        // Reference Attribute
        // As of now we know how to inject a property. But then the property which we are working with is a normal variable,which is a primitive variable.
        // But what if the property is not a primitive variable? What if it's a reference?
        // public void code() {
            // System.out.println("Started Coding.. ");
            // Of course, after coding I want to call the compile method which is in Laptop class
            // Now, if you want to call method compile, we have to basically create object of laptop is because we can't call compile directly.
            // So we need laptop reference here.(Laptop laptop;). Now we can say laptop.compile();
            // If we only do like this - private  Laptop laptop; - We get the error Cannot invoke "org.springframeworkxmlbasedconfig.Laptop.compile()" because "this.laptop" is null
            // We cannot also do like this - private  Laptop laptop =new Laptop(); . It will work because we are using spring we want to inject the object.
            // As laptop is private variable firstly we need to get getters and setters. Now we need to go for config.xml, and we need to specify the same way that
            // we did for primitive variable by adding property name and ref. For the primitive variable we have to use value and for the object or reference variable we have to use ref.

            // But the question arises how will you do that? See, the thing is we got two classes right? And if you remember at the start itself we created two objects,
            // one for laptop and one for alien. The only thing we have to do is we have to connect this two. So basically we have to create that wire between the alien and the laptop.
            // Here in the reference property of Alien bean ( <property name="laptop" ref="lap"></property>) we need to mention the id of the Laptop bean which is lap
            // laptop.compile();
        // }


    }
}