package org.springbootweb;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet("/hello") // We have to add it if we are using external tomcat
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
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Service Method called");
    }
}
