package org.springframeworkxmlbasedconfig;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Component("computer2")
@Primary
@Scope("prototype")
public class Desktop implements Computer{

    public Desktop() {
        System.out.println("Desktop Objected Created...");
    }

    @Override
    public void compile() {
        System.out.println("Compiling in Desktop....");
    }
}
