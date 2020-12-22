package pe.com.intercorp.ti.demo;

/*
Desarrollador: Oscar Erick Candela Carbajal  
*/

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@ComponentScan(basePackages={"pe.com.intercorp.ti.demo"})
public class ControllerIndex {

	@RequestMapping("/")
	public String ejecutarIndex() throws IOException, SQLException {
		System.out.println("ejecutarIndex INICIO");
		String texto0101 = "0";
		String texto0102 = "0";
		String texto0103 = "0";
		String texto0104 = "0";
		String texto0100 = "0";
		
		texto0101 = "Greetings from Spring Boot!" + "<br/>";
		texto0102 = "Greetings from Microservicio!" + "<br/>";
		texto0103 = "[Intercorp - Experis]" + "<br/>";
		texto0104 = "[Desarrollador: Oscar Erick Candela Carbajal (OECC)]";
		texto0100 = texto0101 + texto0102 + texto0103 + texto0104;
		System.out.println("ejecutarIndex FIN");
		return texto0100;
	}
}