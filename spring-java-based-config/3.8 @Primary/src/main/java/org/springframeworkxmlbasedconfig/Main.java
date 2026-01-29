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

        // Scopes - We are not specifying the name of bean this time. Now let's say I just want object of desktop class two times.
//        Desktop dt1 = context.getBean(Desktop.class);
//        dt1.compile();
//
//        Desktop dt2 = context.getBean(Desktop.class);
//        dt2.compile();
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


        // Autowire
        // We are not working with Desktop anymore and created the bean for ALien in AppConfig. Trying to call the Alien object here.
        // We are not going to mention the name of the bean only specified the type
        Alien obj = context.getBean(Alien.class);
        // obj.setAge(28);
        System.out.println(obj.getAge());
        obj.code();

        // If we run this we got the error saying comp is null. And if you see the code() which is dependent on the object of a computer, right which is null by default.
        // So we have to make sure because see in the XML configuration we made sure that this comp has a reference to a bean. Here we are not doing it.
        // There is no linking between the alien and the desktop.
        // Adding XL for the reference that we did earlier
//        <bean id="alien1" class="org.springframeworkxmlbasedconfig.Alien" autowire="byType">-->
//                <!--        <property name="age" value="28"/>-->
//                <!--        But what if you are explicitly mentioning that I'm going to access desk obj. Even if you have by type which says primary is laptop, since you-->
//                <!--        are mentioning explicitly it will go for desktop.So primary works only when you have a confusion.-->
//                <!--        <property name="comp" ref="desk"/>-->
//                <!--    </bean>-->
//                <!--        <bean id="comp" class="org.springframeworkxmlbasedconfig.Laptop" primary="true"/>-->
//                <!--    <bean id="desk" class="org.springframeworkxmlbasedconfig.Desktop"/>-->

        // Desktop Objected Created...
        //Alien Object Created...
        //28
        //Started Coding..
        //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "org.springframeworkxmlbasedconfig.Computer.compile()" because "this.comp" is null

        // Also we are going to assign the age value from the AppConfig --> Go to AppConfig
        // Even after assign the value to the age by using obj.setAge() the comp is still null -So because alien has two variables age and comp.
        // So age we are assigning but comp is still null. We have to assign comp as well
        // To assign comp which is actually ready because we already created the bean for Desktop which is the implementation of Computer
        // For that we have to say obj.setComp(desktop()) which actually returns the object of desktop which actually works
        // Desktop Objected Created...
        //Alien Object Created...
        //Desktop Objected Created...
        //28
        //Started Coding..
        //Compiling in Desktop....


        // Component - Stereotype
        // Now we are going to add @component which is a stereotype annotation in spring, which helps your spring framework to understand that this alien is a class
        // where spring has to manage the objects for it.And the way you can do that is by using add component on all of your classes wherever you want the object
        // The advantage is we don't have to do any configuration in your Java based configuration(AppConfig.java). Just Comment it and run
        // If we run this it throws an error saying
        // The problem is if we see this line(ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);)
        // what you're saying is I'm using annotation configuration, and the class in which I'm doing all the configuration is AppConfig.Java.
        // So what spring will do is it will go to that particular class, and it will say, I got the configuration class, but I don't see any bean created there.
        // Even if we write add @Component on top of your classes, spring has no idea that we're doing this, or spring is responsible to check your classes.
        // We need to mention to spring saying that I am not creating beans here. I'm just writing @Component on top of classes, so please manage it.
        // In order spring to manage it we need to mention @ComponentScan. So when you say @ComponentScan we're saying hey spring, please scan this particular components and
        // see if you find this annotation @Component on top of it please manage them. In that we @ComponentScan we also have to mention the base package
        // The oupt prints but the error saying cannot invoke compile()
        // Alien Object Created...
        //Desktop Objected Created...
        //Laptop Object Created...
        //0
        //Started Coding..
        //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "org.springframeworkxmlbasedconfig.Computer.compile()" because "this.comp" is null
        // So in the code basically we are calling compile method of comp which is the object of computer. So that means there is something issue with the alien and the laptop or desktop.
        // There is no connection there. Earlier We did that connection in the AppConfig. We are not doing it now. We are just saying add component.
        // How do you connect them now?



        //  AutowireField, Constructor, Setter

        // So basically what is happening in the above is we are not able to find the values for age and comp.We are just getting this object.
        // So basically Spring Framework is creating our alien object with the default values for age and comp. The default value for age is zero and comp by default is null.
        // We have to say that comp object is created inside the container we have to do that by using @Autowired annotation on Computer in Alien class
        // After that when we run - we got different error saying that No qualifying bean of type 'org.springframeworkxmlbasedconfig.Computer' available: expected single matching bean but found 2: desktop,laptop
        // Which we solved it earlier. So we can just go back here and say qualifier, and you can specify the name of your bean which is class name, but we need to make sure the first letter is small
        // If we need different name we can mention that at class level after @Component("computer2") then we need to specify in the qualifier by matching that


        // So if we talk about auto wire this is basically injecting the object.So the injection can be done on three levels here.one is field injection.
        // Second is constructor injection and third one is setter injection.


        // Qualifier
        // Earlier we have solved the problem with the help of qualifier. And if we run this again we have commented the qualifier. It will give the same error.
        // It says expected single matching bean but found 2. So to solve this we have done this before as well. We can use something called primary.
        // But what exactly we are going to use primary. So on top of our classes you can mention one of the class as primary. I am making the Desktop as @Primary
        // But what happens when we use primary and the qualifier together.So let me say qualifier as laptop and saying desktop is primary.
        // If we run this is going to prefer the laptop. So qualifier gets ahead of primary.

    }
}