package com.springbootwebapp.springbootwebapp_1;

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

}
