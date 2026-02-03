package com.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	// So we have created this project of spring MVC which is a maven project when we were trying to run the project is not working.
	// Here we do have a controller and then we do have a mapping for the home page which returns index.jsp
	// But what we got here is not found since it is not a spring boot project as it is a normal maven project.
	// even if we added your spring dependencies, maven has no idea that it has to call particular controller
	// It's because in this Maven project, which we are running on Tomcat which acts as a servlet container,
	// it is responsible to run the servlets. But then there has to be mapping, right. So there has to be a mapping for a request and a servlet.
	// Of course we have controller but then your Tomcat has no idea.The thing is in spring framework we can have multiple controllers
	// for different requests will be having different controllers and to navigate to different controllers we have a front controller.
	// Assume we have a client and then we have lot of controllers on the other side.But when a client sends a request, the request
	// will not directly go to a controller it will go to something called a front controller which sits in between client and our controllers
	// Front controller is responsible to send a particular request to a particular controller.The front controller in Spring framework 
	// is called a dispatcher servlet which is the first servlet which we have to go to and then this will navigate to different controllers.
	
	// we no need to create the DispatcherServlet we just have to configure it.So we have to tell Tomcat, by saying every time we send a request,
	// send the request to the dispatcher servlet which will take care of the remaining operations.
	// Now how will we configure that? Now we have to understand every time we run this project our Tomcat goes to one
	// file, which is the web.xml. This is where we have to mention, when we send a request, send request to this particular servlet.
	// We have to create the tags 1st one is <servlet> and 2nd one is <servlet-mapping> tag
	
	// In web.xml
	/* Now in this <servlet-mapping> tag basically this is where we mention the URL pattern. we can say
	   for all the request, doesn't matter what request we are getting for all the requests, 
	   send a request to this particular servlet.It means we're talking about the dispatcher servlet.
	   To get the dispatcher servlet. Just to remember navigate to maven dependencies there is something 
	   called spring-web-mvc expand we have org.springframework.web.servlet and if we expand we can find
	   DispatcherServlet.class this is what we have to use. I can simply copy the qualified name for it and
	    paste it here without the .class extension.(<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		) what we are saying is every time someone sends a request for the URL mapping 
		which is the home page, or any other page or request we are saying spring to call the dispatcher servlet.
		But then to map servlet and servlet-mapping tags which are different tags. If we want to connect these two, we have to add one more tag
		here which is our servlet name. I am mentioning servlet name as springmvcdemo.
		we have to make sure these two are same because we can have multiple servlet tags in this particular file for different URL mapping.
		So for all the request call the dispatcher servlet and then to map this to we have to use springmvcdemo in both places.
		Now we have done the mapping.
		
		  <servlet>
		  	<servlet-name>springmvcdemo</servlet-name>
		  	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		  </servlet>
		                       
		  	<servlet-name>springmvcdemo</servlet-name>
			  <url-pattern>/</url-pattern>
		  </servlet-mapping>
  
		Right click on project - Build Path -> Configure Build Path -> Libraries -> change JRE System library to 21 if it is using 1.8
		and add library -> add server/runtime -> add Apache -> Apply and close
		
		when I run this now we got a different error which is  500.If we look at the error it says there is a problem with IOException with the XML file.
		It's because it actually says we don't have this file.Why would why do we need this file?
		 java.io.FileNotFoundException: Could not open ServletContext resource [/WEB-INF/springmvcdemo-servlet.xml]
		 It is actually sending the request to the dispatcher servlet which has its own problem. So it says if you want me to work and if you want me to understand
		  different controllers and mapping, you have to configure me.We were expecting that the dispatcher server to the magician to know all the controllers,
		  but not we have to configure that as well.How do we configure how do we talk to dispatch servlet and that's where we have to create this file(springmvcdemo-servlet.xml)
	*/
	
	
	@RequestMapping("/")
    public String homePage() {
//        return "index.jsp";
        return "index"; // removing .jsp extension and moving the view pages to views directory
    }

    @RequestMapping("add")
    public ModelAndView resultPage(@RequestParam("num1") long val1, @RequestParam("num2") long val2, ModelAndView modelAndView) {;
        try {
            modelAndView.addObject("num1", val1);
            modelAndView.addObject("num2", val2);
            long result = val1 + val2;
            modelAndView.addObject("result", result);
            modelAndView.addObject("operation", "Addition");
            modelAndView.addObject("error", null);  // Clear any previous error
            modelAndView.setViewName("result");
        } catch (Exception e) {
        modelAndView.addObject("error", "Invalid input: " + e.getMessage());
        }
        return modelAndView;
    }

    // Subtraction mapping
    @RequestMapping("subtract")
    public ModelAndView subtract(@RequestParam("num1") long val1, @RequestParam("num2") long val2, ModelAndView modelAndView) {
        try {
            modelAndView.addObject("num1", val1);
            modelAndView.addObject("num2", val2);
            long result = val1 - val2;
            modelAndView.addObject("result", result);
            modelAndView.addObject("operation", "Subtraction");
            modelAndView.addObject("error", null);  // Clear any previous error
            modelAndView.setViewName("result");
        } catch (Exception e) {
            modelAndView.addObject("error", "Invalid input: " + e.getMessage());
        }
        return modelAndView;
    }

    // Multiplication mapping
    @RequestMapping("multiply")
    public ModelAndView multiply(@RequestParam("num1") long val1, @RequestParam("num2") long val2, ModelAndView modelAndView) {
        try {
            modelAndView.addObject("num1", val1);
            modelAndView.addObject("num2", val2);
            long result = val1 * val2;
            modelAndView.addObject("result", result);
            modelAndView.addObject("operation", "Multiplication");
            modelAndView.addObject("error", null);  // Clear any previous error
            modelAndView.setViewName("result");
        } catch (Exception e) {
            modelAndView.addObject("error", "Invalid input: " + e.getMessage());
        }
        return modelAndView;
    }

    // Division mapping (with error handling)
    @RequestMapping("divide")
    public ModelAndView divide(@RequestParam("num1") long val1, @RequestParam("num2") long val2, ModelAndView modelAndView) {
        try {
            modelAndView.addObject("num1", val1);
            modelAndView.addObject("num2", val2);
            if (val2 == 0) {
                modelAndView.addObject("error", "Division by zero is not allowed.");
                modelAndView.addObject("result", null);
            } else {
                double result = (double) val1 / val2;
                modelAndView.addObject("result", result);
                modelAndView.addObject("operation", "Division");
                modelAndView.addObject("error", null);  // Clear any previous error
            }
            modelAndView.setViewName("result");
        } catch (Exception e) {
            modelAndView.addObject("error", "Invalid input: " + e.getMessage());
        }
        return modelAndView;
    }

    // New mapping for alien form
    @RequestMapping("/alien")
    public String alienHomePage() {
        return "alienindex";  // Alien form
    }

    @RequestMapping("addAlien")
    public String addAlien(@ModelAttribute Alien alien) {
        return "alienresult";
        // For viewing JSP Calculator - http://localhost:8080/
        // For viewing Alien Homepage - Navigate to - http://localhost:8080/alien
    }

    @ModelAttribute("course")
    public String courseName()
    {
        return "Java...";
    }
}
