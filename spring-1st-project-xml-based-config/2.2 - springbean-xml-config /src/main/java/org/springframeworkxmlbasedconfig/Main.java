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
        // Alien alien = new Alien();

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

//        The problem is in that the container is not able to find the alien obj. So how do we do that? We have to talk to Spring Framework by saying, we know, it is your responsibility spring to
//        manage this alien class here or to create the object of it. How will you do that?  There are multiple ways. As we know that you can use XML, Java based configuration or annotations.
//        Here we are going to use the XML. The first thing you do is you create a XML file. But where? since we are using a ClassPathXmlApplicationContext, it will look for the XML file
//        in the classpath which is main. I have to create a folder as resources. So it will basically look for the resource folder, and we can name our file as e.g. config.xml
        // In config.xml where we can mention our bean tags

        // Now what I'm going to use to create the bean we have to use a bean tag. Let's say when I say spring framework to manage the beans, which are basically objects that
        // are managed by Spring Framework. Firstly I have to mention two things. First, the name of the bean or the ID for the bean and the class. So we can mention ID which is alien in this case.
        // Now what is this alien?. As we know in main.Java, when I say getBean, I'm saying alien here.ext.getBean("alien"); So this is a name it will search for.
        // So in the spring we are saying or in the configuration we are saying whenever someone asked for the alien you have to provide the object of what.
        // So for that you have to say class and you have to mention the class name. But the fully qualified class name, which means with the help of package as well. So just alien will not work.
    //        even in XML we have to use those tags which springs understand and for that you have to define the definitions for this bean. for that we have to use syntax.
            // In google search for spring bean configuration xml file
    //        <?xml version="1.0" encoding="UTF-8"?>
    //                <beans xmlns="http://www.springframework.org/schema/beans"
    //        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    //        xsi:schemaLocation="
    //        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    //    <!-- bean definitions here -->
    //                </beans>
// So now Spring framework knows what are the project knows what this bean means.

//        If we specify another alien tag. Whether it will create the two objects? Answer is Yes. So it depends upon how many beans you mention here. Those many objects will create.
//        So if you mention two beans with two different IDs for the same class, it will create two objects

//        So even if we don't mention ID it still creates the object. But the question is if we don't have an ID here, how will you refer that here.
//        Alien alien = (Alien) context.getBean("alien"). Because when we say get bean you have to mention the ID.
//        The configuration for that container is mentioned in the config.XML. Now our spring framework knows what are the classes objects
//        the spring has to create for you in the container.And then when you say get bean, it will give you the object. It's as simple as that.

    }
}