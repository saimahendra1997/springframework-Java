package com.springdemostarter.firstproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// Now making this class as a component, you are making sure that your spring knows that spring has to manage this particular object.
// So create the object, assemble the object and manage it. Everything will be done by spring, just by this annotation.
public class Alien {

    @Autowired
    // If we mentioned Autowired so now your spring framework knows that it is their responsibility to search for this laptop object inside the container
    Laptop laptop;

    public void testingBeans()
    {
        System.out.println("Object got successfully created with the help of spring -- Application context");
    }

    public void code()
    {
        laptop.code();
    }
}
