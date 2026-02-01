package com.springbootwebapp.springbootwebapp_1;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "index.jsp";
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
    @RequestMapping()
    public String resultPage(HttpServletRequest request) {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int result = Integer.parseInt(request.getParameter("result"));
        return "result.jsp";
    }

}
