package com.springbootproject.springbootdemo;

import com.springbootproject.springbootdemo.model.Laptop;
import com.springbootproject.springbootdemo.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootdemoApplication.class, args);
//        Alien obj = context.getBean(Alien.class);
//        System.out.println(obj.getAge());
//        obj.code();
        // 28
        //Compiling in Laptop...
        // So all the annotations which we used in a spring project also applicable in spring Boot.
        // the biggest advantage we get here is you don't have to do a lot of configuration.
        // But when we talk about using the features of spring, let's focus on Spring Boot now because it does the same thing which spring does.
        // But we have to do less configuration. What if I want to configure something? Yes,we do have an option, and we have a lot of annotations available,
        // so we can use certain annotations to change it. Also, we get a property files we can use either YAML file or property files where we can specify some external values if you want.


        // Different Layers
        // Now till this point, we have talked about one of the stereotype annotation, which is @Component. So if we want spring to manage your class or the object,
        // we have to write @Component on top of it.This is not the only stereotype annotation available. So if we talk about any application you'll be having multiple layers there.
        // Controller, Service and Repository layers. The first thing is we have to make sure that we use different packages for different layers
        // in these layers is we have one more object which we pass between different layers and that object we can say model at this point.
        // So example alien laptop desktop The actual represents some model, the actual entity which we're going to store in database.So all these things will be part of a model package.

        // Creating Service and Repo Layers for Laptop
        LaptopService lapService = context.getBean(LaptopService.class);

        Laptop lap = context.getBean(Laptop.class);
        lapService.addLaptop(lap); // Here it is acting as processing layer with Laptop
	}

}
