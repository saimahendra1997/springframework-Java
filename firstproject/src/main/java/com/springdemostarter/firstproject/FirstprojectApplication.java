package com.springdemostarter.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstprojectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FirstprojectApplication.class, args);
        System.out.println("Hi Sai,Welcome to Java Spring Framework");

        // Alien alien = new Alien(); // YOU control creation -- ❌ Without Spring:
        // As we know that everytime whenever the spring creates the objects for us, it will be available in the container which is IOC
        // We have to find the way to get to the container, we have to do that is by using application context.
        // SpringApplication.run(FirstprojectApplication.class, args);
        // If we click on run it returns the object of ConfigurableApplicationContext which is extending the (ApplicationContext, Lifecycle, Closeable)
        // As it means if we simply use the ApplicationContext return value we get the ApplicationContext object which is context
        // what we did is run returns the context obj -- ApplicationContext context = SpringApplication.run(FirstprojectApplication.class, args);
        // Now we got the  way to communicate with the IOC container. We can simply say hey context that means hey container, give me the object
        // and remember the object is not object. In spring the object is called bean

        Alien obj1 = context.getBean(Alien.class); // // SPRING controls creation -- ✅ With Spring:
        // Here we need to mention which class object that we want. As we do have multiple classes we need to specify the class name saying that
        // I need the object of the alien class
        obj1.testingBeans();

        // Creating the object multiple times
        Alien obj2 = context.getBean(Alien.class);
        obj2.testingBeans();
        // Actually it will work. But the question is are we getting the same object or are we getting different object?
        System.out.println(obj1 == obj2);
        // ✅ Answer: SAME object (by default) -- true
        // Spring beans are singleton by default.
        // (We’ll change this later using @Scope("prototype")


        // Firstly we need to annotate our Laptop class with @Component to create the laptop object inside the container
        // If we do obj2.code which throws Cannot invoke "com.springdemostarter.firstproject.Laptop.code()" because "this.laptop" is null
        // Even though Laptop obj was created it is throwing null. To prove that Laptop object got created
        // Laptop lap= context.getBean(Laptop.class);
        // lap.code(); // which successfully got printed - Started coding...
        // That means the object got created, and we are able to use that in the main because we do have the container access
        // Then the question arrives why it is not working with obj.code(). The reason is it is not AutoWired
        obj2.code();


        // The flow of what happening here is we can have multiple layers, and we got alien, and then we got laptop.
        // So basically our main is dependent on the alien object. Alien is dependent on the laptop object.
        // But when you're using alien in the main you can use the context directly is because we have the access.
        // But apart from the main, whenever you want to use this object creation or object accessing, you have to use @Component and @Autowired
	}

}
