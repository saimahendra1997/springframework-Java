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
        // Scopes - So we got two references and both the time I'm calling the same alien1.
//        Alien alien1= (Alien) context.getBean("alien1");
//        Alien alien2= (Alien) context.getBean("alien1");
        // The question is Will it be creating one object or two object?even if you say get beans two times in total, we are getting only one object.
        // To prove that we are creating the variable age in Alien class. We are printing the age. By default, the age will be 0.
        // Here we're explicitly defining age for alien1 where we will be thinking that age for alien1 is 28 and age for alien2 is 0
        // But if we run the application o/.p for both the ages are 28 even if we have 2 different references they both are the same object.
        // The reason being in this config.xml. We created this only once.so it doesn't matter how many times you say get bean, it will go for the same object reference.
//        alien1.age = 28;
//        System.out.println(alien1.age); // 28
//        System.out.println(alien2.age); // 28

        // why it is happening is because when you talk about any bean in the spring, it has different scope. we have different scope options.
        // We got Singleton, we got prototype, we got request, we got the multiple like session as wellBut then in spring core we use only two which is Singleton and prototype.
        // The others like Request and session. It works for uh web or web sockets.

        // So by default it follows singleton which means in your application for this alien there will be only one object created.
        // So it doesn't matter how many times you call them. So even if you say getBean thousands of times, it will refer to the same object is because
        // we get it Only one object here which is alien1, and we are calling it here.

    }
}