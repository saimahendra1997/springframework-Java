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

        // Now the question is how do we do the configuration. We can also do like
        // Desktop desk = context.getBean(Desktop.class);
        // Because what we have done is when we are asking for the desktop class object, we are specifying a type, but not the name. What if Iwe specify a name here
        // If we're trying to set the desk
//        Desktop desktop = context.getBean("desk", Desktop.class);
         // Desktop dt = context.getBean("desktop", Desktop.class); // to get the default name adding the bean name as method name that we mentioned in App.config
        // Desktop dt = context.getBean("com2", Desktop.class); // the custom name that we mentioned in App.config
        // dt.compile();
        // If we run this No bean named 'desk' available. Earlier in xml we have used bean name as desk. Even we don't mention as of now it should have to
        // provide some default name which is method name desktop() -  public Desktop desktop(). For that we have to use desktop instead of desk

        // Scopes
        // So we know by default every bean will be singleton. That means the moment you load your application, it will create the container.
        // And in that container the object will be available.At this point we are working with only one particular bean which is desktop.
        // We are not even working for alien or laptop.So those objects are not getting created. And that's why if you see in the output nowhere,
        // it says laptop object created or object created for alien As of now the output is. But in total we got only one object created.
        // Desktop Objected Created...
        //Compiling in Desktop....
        //Now what if I don't want to use Singleton for Desktop? What if I want to use a prototype here

        // 1st Scenario - We are not specifying the name of bean this time. Now let's say I just want object of desktop class two times.
        Desktop dt1 = context.getBean(Desktop.class);
        dt1.compile();

        Desktop dt2 = context.getBean(Desktop.class);
        dt2.compile();
        // If we run this output shows that only one desktop object created
//        Desktop Objected Created...
//        Compiling in Desktop....
//        Compiling in Desktop....
        // what if we want 2 different objects. In that case, in  App config.
        //
        //And here you have to do something for the prototype. we have to use some annotation. ( @Scope(value = "prototype"))
        // Desktop Objected Created...
        //Compiling in Desktop....
        //Desktop Objected Created...
        //Compiling in Desktop....
    }
}