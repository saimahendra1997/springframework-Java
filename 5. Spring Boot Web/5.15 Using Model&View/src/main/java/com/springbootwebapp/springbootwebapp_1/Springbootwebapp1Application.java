package com.springbootwebapp.springbootwebapp_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springbootwebapp1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootwebapp1Application.class, args);

		// Added only one dependency:Spring Web (spring-boot-starter-web) - Starting with new Spring Boot Web MVC project
		// Creating JSP Page - Making Homepage ready
		// To create your index.jsp basically you have to create a new folder/directory called web app because spring will look for this particular folder for our home page.
		// when we use a JSP page we have to mention certain things to say that it is a JSP page.We can do that is by using a page attribute, and then you mention the language as java.
		// %@ page language="java". When we run this It says 404 is not able to find the index page. The reason is in MVC there index.jsp which is a view technology.
		// The request 1st goes to the controller. We have nowhere created the controller. JSP will be called by the controller, not by the client

		// Creating Controller
	}

}
