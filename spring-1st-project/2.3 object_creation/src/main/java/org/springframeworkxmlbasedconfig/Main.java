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
        // The object of Alien is getting created at this line itself - ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        // So what's happening is, we're not just creating a container, but we're also specifying, hey, there's a file called config.xml.
        // Go to that file and create all the objects which are mentioned with the bean tag and that's what it's doing.So it depends upon how many beans
        // that we mention in config.xml in bean tags. Those many objects will create.

        //    	Alien obj = (Alien) context.getBean("alien");
//        Alien obj1 = (Alien) context.getBean("alien1");
//        // Here we are just using that object
//        obj1.code();
//
//        Alien obj2 = (Alien) context.getBean("alien2");
//        obj2.code();

        // So we got two references and both the time I'm calling the same alien one.
        Alien obj1 = (Alien) context.getBean("alien1");
        obj1.code();

        Alien obj2 = (Alien) context.getBean("alien1");
        obj2.code();
        // Will it be creating one object or two object?
    }
}