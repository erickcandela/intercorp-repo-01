package pe.com.intercorp.ti.demo;

/*
Desarrollador: Oscar Erick Candela Carbajal  
*/

import org.springframework.boot.SpringApplication ;
import org.springframework.boot.autoconfigure.SpringBootApplication ;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"pe.com.intercorp.ti.demo"})
public class DemoBackendApplication {
	
	public static void main (String [] args) {
		SpringApplication.run(DemoBackendApplication.class, args);
	}
}