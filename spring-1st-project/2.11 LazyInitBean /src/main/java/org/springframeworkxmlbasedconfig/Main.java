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
        // Lazy initialization of the bean
        // In this project we are working with 3 beans(alien, laptop and desktop). As we know that scopes(Singleton, Prototype, Request, Session). We know that
        // Whenever we don't mention the scope by default the scope isd singleton which means in total you will get only one object. And that too when your container
        // loads at that point it will load all the singleton objects.The moment we run this application because of this line (ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");)
        // when we say cClassPathXmlApplicationContext, and specify config.XML in the application context, it will basically load all the beans. Even if you are not using it, it will have the object ready for you.
        // Go to the config.xml....
//        Desktop desktop = (Desktop) context.getBean("desk");

        // getBean byType
        // To specify the class type okay. Why do we need that.? So if you look at this alien object, when we want this object from the container, we are saying (Alien alien1= (Alien) context.getBean("alien1");)
        // in the getBean we specify the name of the bean which is alien1 here. Now a container says, okay, I will give you the bean. But the type of object I will give you is object type.
        // And that's why we specifically mention that to do typecasting as well because when we call getBean which return the object.(Object getBean(String name) throws BeansException;)
        // And this is not something we want, right.We don't want the type to be of object. What we want is the type should be of type of class.In this case we want the object of alien.
        // Can we directly get the alien object so that we don't have to do typecasting here and that's why if you go to the definition again, there is one more method called getBean, which
        // takes the name of the ID which you want, or the bean we want, but also we can specify the class of which you want the object, (	<T> T getBean(String name, Class<T> requiredType) throws BeansException;)
        // because when we specify the type of class, it also gives the type. we have to define it something like Desktop desktop = context.getBean("desk", Desktop.class);
        // One more case is if we don't want to specify the name of the bean, So in this case it will search byType.Let's rerun this and it works.
        // So basically you can specify the name of a bean. Or you can specify the type of class object you want.

        // The only problem is when we mention only the class is what if you want the object of a computer.

//        Desktop desktop = context.getBean("desk", Desktop.class);
        // Desktop desktop = context.getBean(Desktop.class); // Not specifying the name of the bean

        // Computer computer = context.getBean(Desktop.class);
        // Computer computer = context.getBean(Computer.class); // It works because we have specified primary = "true" <bean id="lap" class="org.springframeworkxmlbasedconfig.Laptop" primary="true"/>
        // Of course, it's an interface. But then every interface gets compiled to .class file, right? So if we run this code uh it works because in the XML file we are mentioning this as a primary.
        // If we don't specify primary and if you observe we got two classes laptop and desktop.
        // Both are implementing the same interface. And that's where it will create an issue.
        // So if you don't want to get into the scenario where you have two beans of the same type, it's good to go for the names, we know, because when you specify name, there's no confusion.

    }
}