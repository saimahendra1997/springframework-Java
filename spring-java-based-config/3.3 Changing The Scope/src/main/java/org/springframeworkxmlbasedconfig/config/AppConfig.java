package org.springframeworkxmlbasedconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframeworkxmlbasedconfig.Desktop;

public class AppConfig {

    // This is going to replace xml config. So if we want to make this work, the first thing you will do is you will use an annotation which is called @Configuration.
    // if we want to change the name of the bean we have to mention after @Bean (name = "com2"); we have to use name attribute
    // We can also use multiple words if we want
//    @Bean(name = "com2")
//    @Bean(name = {"com2" ,"mac" , "dell"})
    @Bean
    @Scope(value = "prototype")
    public Desktop desktop() {
        return new Desktop();
        // The moment when we use new keyword, we are getting the object. Yes, we are writing this code here, but we are not injecting the object right.
        //Spring is injecting it. So who will call this particular method spring. Who will manage the object spring? We are not doing it. We are just writing a code by saying new desktop.
        // But all this thing will be created, injected and managed by Spring Framework.once we have done this, the only thing we have to do here is we have to add an annotation called bean.

        // So if you want spring framework to create the object, you have to use @Bean. Now this is similar to what we have done in the XML.
        // In the XML earlier we are writing bean tag right? The same thing we have done here.
    }
}
