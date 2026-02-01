package org.springbootweb;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Main {
    public static void main(String[] args) throws LifecycleException {

        // If we want to build the dynamic web application, that's where we need a back end programming and one of it is Java.
        // Every time we get a request from the client, and it goes to the server, which will accept the request, process the request and gives back to the client.
        // Now when you say give back something to the client. Nowadays, we are talking about only the data.
        // Maybe it is possible that the front end which we are building for a web, it is done with the help of React, Angular or a Vanilla.JS.
        // Important is the back end will send the JSON data to the client And what if client wants to send some data? Of course client can send data in the JSON format.
        // Basically What we get from the server is the data that means we have to generate that data from the server.
        // Maybe this data is coming from the database or this data is coming from some other server right. Basically all this data passing and happening with the help of JSON data.

        // Now question arises how do we build this server in Java and for that we have to use something called Servlets.
        // As the name suggests we have serve and let.So basically these are the components the server components which will process and in fact it will accept the request
        // and process the request. It will send data back to the client.Now basically to run these servlets we can't simply run our servlets on JVM
        // now to run these servlets. since it has some extra features that getting the request from the internet and then responding back, we have to use a special container called a Servlet Container.
        // Or you can say a Web Container.So one of the best option or the lightweight option we got is Tomcat. Now Tomcat is a server in which we can run your servlets.
        // So ultimately, if we want to build the back end where we're accepting requests from the client, that's where we need a Servlet. But then if we want to use spring there,
        // spring will make sure that we are doing it in an easy format. Ultimately, spring will also work with servlet behind the scene.

        // Working with servlets
        //  As we discussed, if we want to run our servlet, we need a container, which is our Tomcat server.
        // Now there are two options here. So what we can do is we can build our application in Java and wanted to run that on a server,
        // what we do is you create a package of it.with the extension .WAR which is the web archive.If we're building a console application, we can use .jar.
        // But if we want to make a web application, you use .war because it runs on Tomcat.we can also create jar which you can directly run.
        // But the important thing is we have to create a package of our project and put that on a Tomcat server so that we can run it.
        // webapps is a folder where you put your project.(So if we create a project, and created a package of it, put that into webapps).
        // And if we want to start our Tomcat, we can see in the bin folder,files called startup.sh and shutdown.sh.
        // If we don't want this extra configuration we can use Embedded Tomcat.So the advantage is you don't have to do all this configuration.


        // To Start the Servlet we need to create the tomcat object first
        System.out.println("Initializing Tomcat...");
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);  // Explicitly set port
        // Tomcat's job is to keep running, and we're not keeping it running. To keep it running.We have to say tomcat.getServer().await();
        // So basically we get the hold on the server and say await which means we are asking Tomcat to wait and keep it running. So at least this time the server will not stop.
        // When we run this time tomcat is running. The only problem is it is not able to handle the request.
        // The reason is So if we talk about any website we have multiple pages there. So when we access a particular page we provide a URL, and mention the website name slash something right.
        // We have to tell servlet by saying So here also we want to make sure that whenever I run localhost:8080/hello this time you want to call that servlet.
        // That means we have to do the mapping for this hello and with our servlet there should be mapping between the hello URL and our servlet.


        // Servlet Mapping
        // First way of doing is if we are using an external Tomcat, we have to do more configuration. In this application we are using an embedded Tomcat.
        // In the earlier days, if we want to do the configuration, we used to use XML so the file name is web.xml where we specify the URL and we specify the servlet.
        // So we say hey Tomcat. Whenever someone requests for this URL, execute this servlet. This was one approach.
        // Second way of doing Bwe move to the annotation way where we have to specify the annotation on top of our servlet we use @WebServlet and by specify the request
        // that we wanted to work (Ex. when someone specified /hello we have to say tomcat to call that particular servlet. This is how basically we used to do in the annotation way.
        // But it works when you are using external Tomcat. When you're using embedded Tomcat we have to do the configuration by ourselves here.
        // Now to do the mapping we need to get the hold on the context object. Adding the context from tomcat. We have to pass 2 parameters
        // The first one is the application name or the context for the application.Now since we are working with the same application, we want to go for default app which is double quotes.
        // And then we have to mention the directory structure. Here we are not creating so mentioning null.Uh so we are keeping it empty for the default.
        // And we don't want to create a new directory structure. we'll keep it null.

        tomcat.getConnector(); // In embedded Tomcat 10+, the HTTP connector is not initialized implicitly.
        // We must explicitly create it using tomcat.getConnector(), otherwise the server starts without binding to a port.
        Context context = tomcat.addContext("", null);
        // Now once we got the hold on the context object, now we can use a method called addServlet which is a static method belongs to Tomcat class.
        // We have to pass 3 parameters 1st is context object, 2nd one is servlet name and 3rd one is object for the servlet
        Tomcat.addServlet(context, "DemoServlet", new DemoServlet());
        // once we have added a servlet now let's do the actual mapping.The way you can do the mapping is with help of context.addServletMappingDecoded()
        // We have to pass 2 parameters 1st one is url which is /hello and the 2nd one is name of the servlet which is DemoServlet.
        // Now don't get confused with the name of a servlet with the actual servlet. The actual servlet is Demo servlet. The name is something which we can set anything we want.
        // So whatever your servlet name you have mentioned above the same name you have to mention here as well
        context.addServletMappingDecoded("/demo", "DemoServlet");

        // Actually we have to start the server after all the mappings
        // tomcat.setPort(8081);  // Or any free port, e.g., 9090
        System.out.println("Starting Tomcat...");
        tomcat.start();
        tomcat.getServer().await();
    }
}