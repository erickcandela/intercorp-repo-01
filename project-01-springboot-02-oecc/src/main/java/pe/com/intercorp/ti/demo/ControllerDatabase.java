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

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@ComponentScan(basePackages={"pe.com.intercorp.ti.demo"})
public class ControllerDatabase {

	@RequestMapping("/dbconnect")
	public String ejecutarDatabase() {
		System.out.println("ejecutarDatabase INICIO");
		String texto0201 = "0";
		String texto0202 = "0";
		String texto0203 = "0";
		String texto0204 = "0";
		String texto0200 = "0";
		
		String error01 = "0";
		String error02 = "0";
		
		String propertyUrl = "0";
		String propertyUser = "0";
		String propertyPassword = "0";
		
		try {
			
			texto0201 = "Loading application properties" + "<br/>";
			Properties properties = new Properties();
			properties.load(ControllerDatabase.class.getClassLoader().getResourceAsStream("application.properties"));
			
			propertyUrl = properties.getProperty("url");
			System.out.println(propertyUrl);
			
			propertyUser = properties.getProperty("user");
			System.out.println(propertyUser);
			
			propertyPassword = properties.getProperty("password");
			System.out.println(propertyPassword);
			
			texto0202 = "Connecting to the database" + "<br/>";
			
			Connection connection = DriverManager.getConnection(propertyUrl, propertyUser, propertyPassword);
			texto0203 = "Database connection test: " + connection.getCatalog() + "<br/>";
			
			texto0204 = "Closing database connection" + "<br/>";
			connection.close();	
			
			
		} catch (IOException ioe) {
			error01 = ioe.getMessage() + "<br/>";
			texto0200 += error01;
		} catch (SQLException sqle) {
			error02 = sqle.getMessage() + "<br/>";
			texto0200 += error02;
		}
		
		texto0200 += texto0201 + texto0202 + texto0203 + texto0204;	
		System.out.println("ejecutarDatabase FIN");
				
		return texto0200;
	}
}