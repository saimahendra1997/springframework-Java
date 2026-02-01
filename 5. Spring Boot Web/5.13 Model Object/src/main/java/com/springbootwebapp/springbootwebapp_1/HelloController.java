package com.springbootwebapp.springbootwebapp_1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    // As we are using a Spring boot app, or spring framework for the web, we have to specify that it has a special meaning.
    // the way we do that with the help of annotations. If we want something to be a spring managed object, that's why you use @Component.
    // If we want to make this controller, we use something called @Controller, which is a stereotype annotation.
    // What happens behind the scene is it will get converted into servlet and that's what works in the Tomcat.
    // Important thing is as a developer we don't have to create servlets. we just have to create a controller and that's it.

    // This won't work.Earlier in servlets we have something called service method doGet doPost.
    // We need methods here as well because the actual work will be done by those method.It's our controller responsibility to call that index.jsp


    // We can create a method which is responsible to call the index.jsp. What happening here is when Spring framework calls the controller.
    // since we are saying this is a controller, whatever we return here should be the name of your view technology which return index dot JSP. since you are returning a string we will say string.
    // So what will happen here is this is a controller.when we run this project, when we send a request for the home page, this controller should be
    // getting called, and it should specify, hey,saying when you call a home page, I want you to call index.jsp.So search for index.jsp in the project and call this.
    // Now if we want this method to be called we need to specify that this particular home should be mapped with the home URL(/home).That's what you have to map.The mapping is important.

    // @RequestMapping
    // For Mapping we have to use annotation called @RequestMapping, and we have to specify path "/". At this point we are using RequestMapping to map the request and is able to call the index.jsp
    // By default Spring boot does not support JSP page. So we have to basically convert JSP into Servlet. We have to add one more dependency called Tomcat Jasper
    // We need to match it with embed tomcat version
    @RequestMapping("/")
    public String homePage() {
//        return "index.jsp";
        return "index"; // removing .jsp extension and moving the view pages to views directory
    }

    // Modified the index.jsp and added style.css where we are performing some additions - Initially we were sending the request for the home page,
    // but now we are sending the request for the add which means we need a controller who can accept this request.

    // if we want to have something which will accept the request, we have to create another method. At this point we want to return a page.
    // Of course when you add this two numbers we also want a page. that's what we're expecting in the browser that means we have to return another jsp page.
    // To get this method called we have to use @RequestMapping, and we have to specify the path which is calculate which is browser expecting
    // But the question arises who is doing this mapping? As we discussed for every servlet we have to do the mapping in the XML file.
    // We are not doing mapping here. So the thing is there is something called dispatcher Servlet  who is responsible to map all these requests.
    // The next step is basically we have to accept the values.One is a servlet way and second is the spring way.If we want to accept the data from a client,
    // we have to use something called HTTPServletRequest.when we specify the HTTPServletRequest, it is spring's responsibility to assign you the object.
    // once we have this object you can get the values. To get we have to specify request.getParameter.Any way when a client sends a request to the server,
    // the request object will have all the data. So we just have to fetch the data.

//    @RequestMapping("add")
//    public String resultPage(HttpServletRequest request, HttpSession session) {
//        int num1 = Integer.parseInt(request.getParameter("num1"));
//        int num2 = Integer.parseInt(request.getParameter("num2"));
//        int result = num1 + num2;

        // Displaying the data on the result page. First of all, we have to send this data to the result page. To do that there are multiple ways. We can use something called Session
        // So we have to put the data in a session object. Now what is Session. So basically when we have multiple pages and if a user is accessing multiple pages, we want to maintain
        // this data between the pages the way you can do that is with the help of session. To get the hold on a session we can just pass the session object
        // HttpSession which is an interface we are creating a reference for it. We know that Spring framework is responsible to inject the object.
        // with the object we are adding this data(result) data in the session by setAttribute() and in this we have to pass two things the name of a variable or name of the data
        // which is result and the actual data which is result.

        // Now to print the data in the result page(result.jsp) - we have to put that into JSP code. Whenever yoweu want to write a Java code inside JSP we have to open the angular bracket.
        // Then the question arise how will we get the session object in result.jsp. In JSP session objects get by default
        // There's another way where we can use the JSTL way which is basically a JS standard library or template library, which allows us to directly use some certain tags which we can get the value.
        // So we can specify it in curly brackets ${result}. it will directly use it will likely search the session object request to get data.we have to put the dollar symbol as well
//        session.setAttribute("operation", "Addition");
//        session.setAttribute("result", result);
//        session.setAttribute("error", null); // Clear any previous error
//        return "result.jsp";
//    }


    // Subtraction mapping
    @GetMapping("/subtract")
    public String subtract(HttpServletRequest request, HttpSession session) {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int result = num1 - num2;

        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);
        session.setAttribute("operation", "Subtraction");
        session.setAttribute("result", result);
        session.setAttribute("error", null);

        return "result"; // removing .jsp extension and moving the view pages to views directory
    }

    // Multiplication mapping
    @GetMapping("/multiply")
    public String multiply(HttpServletRequest request, HttpSession session) {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int result = num1 * num2;

        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);
        session.setAttribute("operation", "Multiplication");
        session.setAttribute("result", result);
        session.setAttribute("error", null);

        return "result"; // removing .jsp extension and moving the view pages to views directory
    }

    // Division mapping (with error handling)
    @GetMapping("/divide")
    public String divide(HttpServletRequest request, HttpSession session) {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));

        if (num2 == 0) {
            session.setAttribute("error", "Division by zero is not allowed.");
            session.setAttribute("result", null);
        } else {
            double result = (double) num1 / num2;
            session.setAttribute("num1", num1);
            session.setAttribute("num2", num2);
            session.setAttribute("operation", "Division");
            session.setAttribute("result", result);
            session.setAttribute("error", null);
        }

        return "result"; // removing .jsp extension and moving the view pages to views directory
    }


    //  Request Param
    // As of now we have discussed servlet way of doing .if we talk about this add path In the browser we can see its add request (http://localhost:8080/add?num1=86238&num2=83924789,
    // and then we are sending this to data in the URL itself.we're sending this data here as a query parameter, what we can also do is instead of using request object
    // we can just take those two values into variables by simply saying (int num1 and num2.) and what I'm expecting is it will directly give those values to these variables.
    // As we are giving values directly no need to use request objects.It is working what happens is when we send a request for the add method, when we're passing your those two query
    // parameters with the same name, that matches in result.jsp(num1 & num2) . That's why it's working. Try changing by mentioning the different names it won't work.
    // if we don't want to specify the matching values num one there. So in that case we can use an annotation called @RequestParam and in the bracket we can mention the actual variable
    // or actual name which is coming from the browser. So in the URL we are sending num1. So what we are saying is whatever data we are getting in num1, just assign to that variable called val1. That's it
//    @RequestMapping("add")
//    public String resultPage(@RequestParam("num1") int val1, @RequestParam("num2") int val2, HttpSession session) {;
//        int result = val1 + val2;
//        session.setAttribute("operation", "Addition");
//        session.setAttribute("result", result);
//        session.setAttribute("error", null); // Clear any previous error
//        return "result.jsp";
//    }

    // Removing the Session object - Instead of that we can use Model Object
    // As we talked about MVC we had a model view controller right where controller is responsible to accept the user request then we have a view which is going to the client.
    // What about that data.Remember we have talked about how do we transfer data between the controller and the view. So basically we have to use an object and that is your model object
    // So instead of setAttribute we have addAttribute because we can add multiple attributes not just one, and then we can give a name for that.Model is an interface which is used to transfer the data
    // So instead of using HttpSession we are using Model now.So we have get rid of the HttpServletRequest request object and HttpSession. Now this is how we basically build, an application using Spring MVC or SpringBoot.
    // Also, we can get rid of this .JSP wya of declaration. As we know that for the view we have multiple options.We got JSP, Freemarker, ThymeLeaf. So we have so many options.
    // Moving our view pages to views directory and removing .jsp extension
    @RequestMapping("add")
    public String resultPage(@RequestParam("num1") int val1, @RequestParam("num2") int val2, Model model) {;
        int result = val1 + val2;
        model.addAttribute("num1", val1);
        model.addAttribute("num2", val2);
        model.addAttribute("operation", "Addition");
        model.addAttribute("result", result);
        model.addAttribute("error", null); // Clear any previous error
        return "result"; // removing .jsp extension and moving the view pages to views directory
    }
}
