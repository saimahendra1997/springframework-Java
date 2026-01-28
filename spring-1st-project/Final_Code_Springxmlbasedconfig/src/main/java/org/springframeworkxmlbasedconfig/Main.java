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

        // The configuration for that container is mentioned in the config.XML. Now our spring framework knows what are the classes objects
        // the spring has to create for you in the container.And then when you say get bean, it will give you the object. It's as simple as that.
        // Alien alien = new Alien();

        // The object of Alien is getting created at this line itself - ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        // So what's happening is, we're not just creating a container, but we're also specifying, hey, there's a file called config.xml.
        // Go to that file and create all the objects which are mentioned with the bean tag and that's what it's doing.So it depends upon how many beans
        // that we mention in config.xml in bean tags. Those many objects will create.


        // Scopes

        // So we got two references and both the time I'm calling the same alien1.
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


        // Reference Attribute
        // As of now we know how to inject a property. But then the property which we are working with is a normal variable,which is a primitive variable.
        // But what if the property is not a primitive variable? What if it's a reference?
        // public void code() {
            // System.out.println("Started Coding.. ");
            // Of course, after coding I want to call the compile method which is in Laptop class
            // Now, if you want to call method compile, we have to basically create object of laptop is because we can't call compile directly.
            // So we need laptop reference here.(Laptop laptop;). Now we can say laptop.compile();
            // If we only do like this - private  Laptop laptop; - We get the error Cannot invoke "org.springframeworkxmlbasedconfig.Laptop.compile()" because "this.laptop" is null
            // We cannot also do like this - private  Laptop laptop =new Laptop(); . It will work because we are using spring we want to inject the object.
            // As laptop is private variable firstly we need to get getters and setters. Now we need to go for config.xml, and we need to specify the same way that
            // we did for primitive variable by adding property name and ref. For the primitive variable we have to use value and for the object or reference variable we have to use ref.

            // But the question arises how will you do that? See, the thing is we got two classes right? And if you remember at the start itself we created two objects,
            // one for laptop and one for alien. The only thing we have to do is we have to connect this two. So basically we have to create that wire between the alien and the laptop.
            // Here in the reference property of Alien bean ( <property name="laptop" ref="lap"></property>) we need to mention the id of the Laptop bean which is lap
            // laptop.compile();
        // }

        // Constructor Injection
        // In Java we know that if you want to create the object or if you want to initialize the values, we can do that in constructor as well.
        // And that's most of the time we do. So if you want to assign the value initially when the object is created we prefer to use constructor
        // setters are good. But then if you want to assign the values later setter makes sense.
        // Firstly we already have the default constructor now creating the parameterized constructor which takes age as variable
        // I don't want to use the property tag now. So when I use property tag basically it uses the setter. I don't want to do that I want to use the constructor.
        // Now how will you assign a value with the help of constructor? The way we have property here we also have something called a constructor arg.
        Alien alien1= (Alien) context.getBean("alien1");
        System.out.println(alien1.getAge()); //28
        alien1.code();
        // Parameterized Constructor called...
        //Laptop Object Created..
        //28
        //Started Coding..
        //Compiling the code...

        // The concern is what if you have a constructor which takes two parameters. As of now We are passing only one.//
        //         <constructor-arg value="28"></constructor-arg>
        //        <constructor-arg ref="lap"></constructor-arg>
        // We can also mention the type explicitly because it was even not checking the type, it was checking the sequence.


        // Creating the interface
        // What we are doing as of now is we are saying that alien is dependent on a laptop. We don't want to do that.
        // What if you can create a layer on top of it, something like, let's say a computer. So everyone has a computer, but we don't have computers as object, right?
        // Computer is just a concept. The implementation for that is desktop, laptop, mobile phone, everything.


        // Autowiring
        // Now in the config for this interface and Autowiring we are in thought of using the property based
        // Look in to config.xml for further explanation....


        // Primary bean
        // As we discussed in Autowiring byType cannot work with both checks. It throws error which says expected single matching bean.
        //    But found two because both the beans are have the same type. They have laptop and desktop which are both of type of computer.that's the confusion
        // TO solve this we can mention primary="true" . Now when you make this as a primary, what it says is in case of confusion between laptop and desktop,
        // if spring is not able to decide which one to select, this primary will say select laptop first.
        // But what if you are explicitly mentioning that I'm going to access desk obj. Even if you have by type which says primary is laptop, since you
        // are mentioning explicitly it will go for desktop.So primary works only when you have a confusion.

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