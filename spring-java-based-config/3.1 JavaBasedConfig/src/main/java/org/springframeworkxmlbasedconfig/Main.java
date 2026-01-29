package org.springframeworkxmlbasedconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframeworkxmlbasedconfig.config.AppConfig;

public class Main {
    public static void main(String[] args) {

        // if you want to create a container, we have to use something called an ApplicationContext.Now ApplicationContext is
        // responsible to work with the IOC container. Actually we do have two options to interact with the container
        // One is BeanFactory which is an old one, the application context, a new one. Both does the same thing, almost the same thing.
        // Basically, it will help you to create the container, and it will help you to get the objects from the container

        // ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        // Now instead of using the XML approach, we are going for a Java based approach. For that we have to use a class which is called annotation config application context.
        // And in this particular constructor you have to pass a name of our config file, which is AppConfig.class
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Now the question is how do we do the configuration
        // We can also do like
        Desktop desk = context.getBean(Desktop.class);
        desk.compile();
        // If we want to make this work we need to use the annotation @Configuration in AppConfig.class
        // Next we need to use bean annotation as we need Desktop object
    }
}