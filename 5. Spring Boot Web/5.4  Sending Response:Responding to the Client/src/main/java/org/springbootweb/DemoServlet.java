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
}
