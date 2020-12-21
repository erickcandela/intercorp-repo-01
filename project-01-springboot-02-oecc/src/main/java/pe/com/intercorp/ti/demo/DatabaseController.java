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
public class DatabaseController {

	@RequestMapping("/dbconnect")
	public String ejecutarIndex() throws SQLException, IOException {
		String texto01 = "0";
		String texto02 = "0";
		String texto03 = "0";
		String texto04 = "0";
		String texto = "0";

		texto01 = "Loading application properties" + "<br/>";
		Properties properties = new Properties();
		properties.load(DatabaseController.class.getClassLoader().getResourceAsStream("application.properties"));
		
		texto02 = "Connecting to the database" + "<br/>";
		Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
		texto03 = "Database connection test: " + connection.getCatalog() + "<br/>";
		
		texto04 = "Closing database connection" + "<br/>";
		connection.close();		
		
		texto = texto01 + texto02 + texto03 + texto04;
		
		return texto;
	}
}