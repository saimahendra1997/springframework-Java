package org.springframeworkxmlbasedconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // if you want to create a container, we have to use something called an ApplicationContext.Now ApplicationContext is
        // responsible to work with the IOC container. Actually we do have two options to interact with the container
        // One is BeanFactory which is an old one, the application context, a new one. Both does the same thing, almost the same thing.
        // Basically, it will help you to create the container, and it will help you to get the objects from the container

        ApplicationContext context = new ClassPathXmlApplicationContext();
        // Now if you go to application context it's an it's basically an interface.It extends a lot of different or interfaces.
        // and then if I click on this particular ListableBeanFactory it extends Bean Factory. So by default, or we can say this
        // application context is a superset of Bean Factory.So whatever we want to do with Bean Factory can be done with application context.
        // But the question arises how will you create the object.What are the classes which implements this.Actually there are a lot of classes which implements this.
        // We are going to use the ClassPathXmlApplicationContext.
        // See, the thing is there are different ways of configuring your spring project and one of them is XML. So in this particular section we are going to talk about XML.
        // Then we'll move towards Java based and then we'll move towards the annotations.
        // ApplicationContext context = new ClassPathXmlApplicationContext("alien"); - which actually creates the container and then with that container
        // we can specify what class object we want

//        Alien alien = (Alien) context.getBean("alien1");
//        alien.code();
        // But the thing is by default, getBean will give you the type of object as object. If you can see it says it is providing object.
        // Object getBean(String name) throws BeansException; But what we want is alien object. So what you have to do is we have to just do typecasting.

        // If we try to run this we will get the error - BeanFactory not initialized or already closed - call 'refresh' before accessing beans via the ApplicationContext
        // There is no issue with the container. It is unable to find alien class in container. To fix this we need to create an XML as we are using XML based config.
        // since we are using a ClassPathXmlApplicationContext, it will look for the XML file in the classpath in main. Created config.xml

    }
}