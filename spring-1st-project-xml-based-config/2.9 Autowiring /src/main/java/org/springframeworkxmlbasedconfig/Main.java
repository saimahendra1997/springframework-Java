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
        // Created the interface
        // What we are doing as of now is we are saying that alien is dependent on a laptop. We don't want to do that.
        // What if you can create a layer on top of it, something like, let's say a computer. So everyone has a computer, but we don't have computers as object, right?
        // Computer is just a concept. The implementation for that is desktop, laptop, mobile phone, everything.

        // Autowiring
        // Now in the config for this interface and Autowiring we are in thought of using the property based
        // Look in to config.xml for further explanation....

    }
}