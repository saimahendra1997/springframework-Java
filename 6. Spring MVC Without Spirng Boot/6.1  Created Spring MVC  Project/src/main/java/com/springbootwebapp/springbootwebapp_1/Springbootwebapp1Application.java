package com.springbootwebapp.springbootwebapp_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springbootwebapp1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootwebapp1Application.class, args);

		// Now we are using the previous MVC project but without spring boot. As we using it w/o spring boot we need to set up lot of configuration.
		// basically earlier we have used an embedded Tomcat but then in spring framework we will be using an external Tomcat.
		// Also, we need to use STS/Eclipse for configuring the external by default IntelliJ Community doesn't support adding external tomcat. If our IntelliJ Ultimate we can use it directly.
	}

}
