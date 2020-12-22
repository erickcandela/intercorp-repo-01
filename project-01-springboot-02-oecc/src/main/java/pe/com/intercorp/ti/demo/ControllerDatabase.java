package pe.com.intercorp.ti.demo;

/*
Desarrollador: Oscar Erick Candela Carbajal  
*/

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ControllerDatabase {

	@RequestMapping("/dbconnect")
	public String ejecutarDatabase() throws SQLException, IOException {
		System.out.println("ejecutarDatabase INICIO");
		String texto0201 = "0";
		String texto0202 = "0";
		String texto0203 = "0";
		String texto0204 = "0";
		String texto0200 = "0";

		texto0201 = "Loading application properties" + "<br/>";
		Properties properties = new Properties();
		properties.load(ControllerDatabase.class.getClassLoader().getResourceAsStream("application.properties"));
		
		texto0202 = "Connecting to the database" + "<br/>";
		Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
		texto0203 = "Database connection test: " + connection.getCatalog() + "<br/>";
		
		texto0204 = "Closing database connection" + "<br/>";
		connection.close();		
		
		texto0200 = texto0201 + texto0202 + texto0203 + texto0204;	
		System.out.println("ejecutarDatabase FIN");
		return texto0200;
	}
}