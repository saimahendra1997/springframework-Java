package org.springbootweb;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet("/demo") // We have to add it if we are using external tomcat
public class DemoServlet extends HttpServlet {

    // Creating a servlet. By writing this Servlet at the end of the class namer makes it a Servlet? No
    // One of thw way to give the Servlet feature to this class is by extending HttpServlet.If we talk about servlet, it has multiple features like accepting the request
    // from the user and responding to the user. So basically for request and response we need special objects.
    // And the way we can get that is if we extend a class via HTTPServlet okay.So basically we need two things the request and the response.

    // However we need a method which will execute whenever we get a request.service is one of the important method in Servlet which gets executed whenever you send a request.
    // Now question arises how will we accept the data from the client and how will we respond to the client.
    // in this example, we don't want to send any data from client to server.we just want to send a request. But what if we want to send the data back to the client.
    // Let's say if we are working on a scenario where we want to send some data from the client to the server, we need an object from where we can do that.
    // We can do that in the service method, you have to pass two parameters, one for the request and one for the response and these we will get from HttpServletRequest & HttpServletResponse.

    //
    // To run this Servlet or If we want to execute this servlet, we have to send a request from our browser and send a request.
    // Now where do we send a request. So basically we have to send a request to the localhost, and then you have to mention the port number
    // and by default if we talk about Tomcat it goes with the port number 8080.To call this servlet firstly we need to run the tomcat
    // Create the object of tomcat in Mian.java and call start() where the tomcat has started
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // We are not mentioning any type of request here as we are saying service.So the ideal way is to use specific methods like doGet which is a method.
        // It's a part of servlet which works with the Get request.If we want to submit data, we use doPost. Now since we're not submitting data, I'll stick to doGet
        System.out.println("Service Method called");

        // Sending response from the servlet. As we do have response object. So we can simply use this object and we can send the response.
        // when we run the servlet the client will receive the data from response, but by default is empty.
        response.setContentType("text/html"); // what it will do is it will understand that we are also sending HTML, not just a plain text.
        // So it will try to convert our HTML into a design.
        response.getWriter().println("<h1>Hello from DemoServlet!</h1>");

        // This is one way of sending data.But we also have a concept of MVC where we keep our logic and view separate.
        // What we are doing here is in the same servlet. We are doing three things. We are accepting request and processing the data if we want.
        // And when we return the data, we're not just returning a plain data, we are returning the HTML page. So let's say if we're building a complex design,
        // in this case we have to write thousands of HTML tags and imagine writing everything in the servlet or in this particular service will not look good
        // If someone wants to debug it, it will be a nightmare. So that's why we use something called MVC.When you send a request this is by default a Get request.
        // There is something called methods in HTTP. We have GET, POST, PUT, and  DELETE and multiple but then these four are famous.
        // So let's say if you want to get data from a server you use a Get request. When we want to send data to the server we use Post request
        // when you want to delete something from the server, we send delete request, and if we want to update something, we use a put request.
        // But what if we want to send data by creating a form in which we are submitting some data. In that case you will be using a Post request.
    }


    // Introduction to MVC
    // What if we want to return a data.We can say hey servlet I need to get some data from the database then servlet will talk to database and get our data back
    // if we just want to return data it's very simple. But then we know that if we want our client to see some data on a browser, we cannot simply send a data, right?
    // that's why we will use a front end.Now the question arise if we want to return a front end from your servlet, basically we have to write HTML tags inside Java which we're done earlier
    // If you start adding HTML content inside the Java code, what if it becomes bulky, and that's where we have to find a solution which is JSP.
    // Now again that in Java we have multiple view technologies.That's why we call them as view technologies because we create them to show to the client.
    // So in servlet basically we write HTML inside Java we can also write Java code in between them and that's where we have something called a JSP (Java Server Pages.)
    // So we can use JSP to create the view technology. Firstly servlet is responsible to accept the request from the client and JSP is responsible to create that beautiful page which we want.
    // That means we can do accepting the request and do our  processing and then once we get our data, just send that data to JSP page. JSP will send that to the client with the HTML.
    // Then, when we talk about Java,which is object-oriented. So whatever data we want to represent, it should be representing that with the help of object format.
    // That means if we want a student data in the table which is in the database, when we get that data in our application, not just keeping that data in simple variables.
    // That means basically we have to use these three technologies now servlets to accept the request from the client, JSP to show it to the client and the data, which is our object.
    // Now this is where we get a term called MVC.

    // Assume, that we have an ID which is 101. and to get the details of this  person with an ID 101. Firstly client sends a request, the request goes to the controller
    // which is responsible to accept the request which depends upon what type of request we get then it will talk to database to get the data, and that data we will be saving
    // in an object which we call them as model.Then controller will send this data to a view technology. So when we talked about data which is the model object goes from the
    // controller to the view technology(JSP, Thymeleaf) and then in that view, technology, it will fetch the data, fill up the entire page and give it back to the client. That's how MVC works.

    // So just to reiterate, servlets are controllers, view technologies can be implemented with help of JSP, and models are basically normal classes or POJO classes.
    // If we observe when I say we can write Java code inside JSP, so we have an HTML page, and we have a Java code there. How exactly it works.
    // Because if we talk about Tomcat, which is a Web server, also a servlet container, which means we can only run servlets inside Tomcat.
    // How can we run JSP? What happens is behind the scene is this JSP page gets converted into servlet.So every time we use JSP it's getting converted into servlet.
}
