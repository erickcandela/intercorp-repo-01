package pe.com.intercorp.ti.demo;

/*
Desarrollador: Oscar Erick Candela Carbajal  
*/

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@ComponentScan(basePackages={"pe.com.intercorp.ti.demo"})
public class ControllerClient {

	@RequestMapping("/insertClient")
	public String insertClient() {
		System.out.println("insertClient INICIO");
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
			properties.load(ControllerClient.class.getClassLoader().getResourceAsStream("application.properties"));
			
			propertyUrl = properties.getProperty("url");
			System.out.println(propertyUrl);
			
			propertyUser = properties.getProperty("user");
			System.out.println(propertyUser);
			
			propertyPassword = properties.getProperty("password");
			System.out.println(propertyPassword);
			
			texto0202 = "Connecting to the database" + "<br/>";
			
			Connection connection = DriverManager.getConnection(propertyUrl, propertyUser, propertyPassword);
			texto0203 = "Database connection test: " + connection.getCatalog() + "<br/>";
	
			Long id = parseLong(0);
			String nombre = "0";
			String apellidoPaterno = "0";
			String apellidoMaterno = "0";
			String edad = "0";
			String fechaNacimiento = "0";
			
			id = parseLong(3);
			nombre = "Franklin";
			apellidoPaterno = "Gómez";
			apellidoMaterno = "Condori";
			edad = "40";
			fechaNacimiento = "15/03/1978";
			
			BClient objetBean = new BClient();
			objetBean.setId(id);
			objetBean.setNombre(nombre);
			objetBean.setApellidoPaterno(apellidoPaterno);
			objetBean.setApellidoMaterno(apellidoMaterno);
			objetBean.setEdad(edad);
			objetBean.setFechaNacimiento(fechaNacimiento);
			
			PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO client (id, nombre, apellidopaterno, apellidomaterno, edad, fechanacimiento) VALUES (?, ?, ?, ?, ?, ?);");

		    insertStatement.setLong(1, objetBean.getId());
		    insertStatement.setString(2, objetBean.getApellidoPaterno());
		    insertStatement.setString(3, objetBean.getApellidoMaterno());
		    insertStatement.setString(4, objetBean.getNombre());
		    insertStatement.setString(5, objetBean.getEdad());
		    insertStatement.setString(6, objetBean.getFechaNacimiento());
		    insertStatement.executeUpdate();			
			
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
		System.out.println("insertClient FIN");
				
		return texto0200;
	}

	private Long parseLong(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}