package org.springframeworkxmlbasedconfig.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframeworkxmlbasedconfig.Alien;
import org.springframeworkxmlbasedconfig.Computer;
import org.springframeworkxmlbasedconfig.Desktop;
import org.springframeworkxmlbasedconfig.Laptop;

public class AppConfig {

    // This is going to replace xml config
    // if we want to change the name of the bean we have to mention after @Bean (name = "com2"); we have to use name attribute
    // We can also use multiple words if we want
//    @Bean(name = "com2")
//    @Bean(name = {"com2" ,"mac" , "dell"})
    @Bean
    // @Scope(value = "prototype")
    public Desktop desktop() {
        return new Desktop();
        // The moment when we use new keyword, we are getting the object. Yes, we are writing this code here, but we are not injecting the object right.
        //Spring is injecting it. So who will call this particular method spring. Who will manage the object spring? We are not doing it. We are just writing a code by saying new desktop.
        // But all this thing will be created, injected and managed by Spring Framework.once we have done this, the only thing we have to do here is we have to add an annotation called bean.

        // So if you want spring framework to create the object, you have to use @Bean. Now this is similar to what we have done in the XML.
        // In the XML earlier we are writing bean tag right? The same thing we have done here.
    }

    // As of now we worked with Desktop creating the beans for Alien and Laptop - For that we have to create the beans

//     @Bean
//    public Alien alien()
//     {
//         // Need to assign the age value here
//         Alien obj = new Alien();
//         obj.setAge(28);
//         obj.setComp(desktop());
//         return obj;
//     }

    // The above scenario works, but the problem is when you assign desktop here we are making tightly coupled. What if we have laptop.
    // So we don't want this desktop to be there.What we can do is in the constructor we can pass Computer comp and no need to mention desktop here instead Just say com.
    // What happens is Spring will say okay this alien is dependent. So if we want to call alien it is dependent on a computer object.
    // So what it will do is it will look at the containers and say hey container, I want a computer object.
    // Container will say, hey, you know, I do have a desktop object which is a computer.You don't have to mention auto wired there,
    // but in the earlier versions we have to use auto wired. So even if you use auto wired or not use it will work.So basically
    // what we're doing is that we're creating a wire between alien and a desktop.

    // Now we got the question saying what if we got the two beans of computer then which one the spring will choose?
    @Bean
    public Alien alien(Computer com) // @Qualifier("laptop")
     {
         // Need to assign the age value here
         Alien obj = new Alien();
         obj.setAge(28);
         obj.setComp(com);
         return obj;
     }

     // Adding the Laptop Bean as well then we came to know which object spring will prefer
    // After running this we got the error saying that expected single matching bean but found 2: desktop,laptop
    // To solve this As we know that so when it comes to XML configuration we have two ways. One way is tha we can explicitly mention which comp you want.
    // How do I do that in the AppConfig.The way you can do that is by using an annotation called qualifier by mentioning the name of the bean.(@Qualifier("desktop")).This is same as what you do in ref.
    // If we don't want to use Qualifier there is something called primary which you can mention. that we have used in XML. But we have to use it at the specific bean level either at Laptop Or Desktop
    // So either you can use qualifier or you can use primary. In fact, we'll see qualifier mode once we move to the spring boot.
    @Bean
    @Primary
    public Laptop laptop()
    {
        return new Laptop();
    }
}
