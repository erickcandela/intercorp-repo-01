package pe.com.intercorp.ti.demo;

/*
Desarrollador: Oscar Erick Candela Carbajal  
*/

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class IndexController {

	@RequestMapping("/")
	public String ejecutarIndex() {
		String texto01 = "0";
		String texto02 = "0";
		String texto03 = "0";
		String texto = "0";
		
		texto01 = "Greetings from Spring Boot!" + "<br/>";
		texto02 = "Greetings from Microservicio!" + "<br/>";
		texto03 = "[Intercorp - Experis]";
		texto03 = "[Desarrollador: Oscar Erick Candela Carbajal (OECC)]";
		texto = texto01 + texto02 + texto03;
		
		return texto;
	}
}