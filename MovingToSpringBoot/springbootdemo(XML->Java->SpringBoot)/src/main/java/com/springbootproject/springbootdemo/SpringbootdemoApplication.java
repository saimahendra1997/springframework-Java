package com.springbootproject.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootdemoApplication.class, args);
        Alien obj = context.getBean(Alien.class);
        System.out.println(obj.getAge());
        obj.code();
        // 28
        //Compiling in Laptop...
        // So all the annotations which we used in a spring project also applicable in spring Boot.
        // the biggest advantage we get here is you don't have to do a lot of configuration.
        // But when we talk about using the features of spring, let's focus on Spring Boot now because it does the same thing which spring does.
        // But we have to do less configuration. What if I want to configure something? Yes,we do have an option, and we have a lot of annotations available,
        // so we can use certain annotations to change it. Also, we get a property files we can use either YAML file or property files where we can specify some external values if you want.
	}

}
