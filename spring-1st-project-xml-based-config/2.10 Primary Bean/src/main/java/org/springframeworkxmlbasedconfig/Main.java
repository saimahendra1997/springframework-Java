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
        Alien alien1= (Alien) context.getBean("alien1");
        System.out.println(alien1.getAge()); //28
        alien1.code();

        // Primary bean
        // As we discussed in Autowiring byType cannot work with both checks. It throws error which says expected single matching bean.
        //    But found two because both the beans are have the same type. They have laptop and desktop which are both of type of computer.that's the confusion
        // TO solve this we can mention primary="true" . Now when you make this as a primary, what it says is in case of confusion between laptop and desktop,
        // if spring is not able to decide which one to select, this primary will say select laptop first.
        // But what if you are explicitly mentioning that I'm going to access desk obj. Even if you have by type which says primary is laptop, since you
        // are mentioning explicitly it will go for desktop.So primary works only when you have a confusion.

    }
}