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
        // Setter Injection

//        Alien alien1= (Alien) context.getBean("alien1");
//        System.out.println(alien1.getAge()); //28
//        alien1.code();
        // Started Coding...
        //Compiling the code...


//         we are neither going to set the value by doing alien1.setAge(28); nor by setting the value directly at the variable level age = 26
//         What we are doing something called Injection. Now spring framework believes in something called injection. As We have talked about dependency injection.
//         So how do you inject a value with the help of Spring Framework.So the way we can do that is by going to config.XML, and we can inject the value.
//             <bean id="alien1" class="org.springframeworkxmlbasedconfig.Alien">
//                <property name="age" value="28"></property>
//         Now whenever you work with the primitive values you use value. But what if you want to work with some objects? Let's say alien is dependent upon some other class
//         Let's say laptop object. In that case, you have to use something else.Now what we'll do is it will assign the value.
//         So when it creates the object alien, it will assign the value which is 28 to the variable age.
//
//         But Is it directly assigning this age to a variable or through a setter.So basically it will first create the object. and then it will call the setter method.
//         And then only it will execute the other parts. So basically the spring will create the object, put that into container, but it will also assign the value which
//         is 28, to a variable age.And it's not just for one variable. Even if you have multiple variables, we can set the property for another variable and another value.
//         So that's how you can basically set the values with the help of property. And this is called a setter injection.

    }
}