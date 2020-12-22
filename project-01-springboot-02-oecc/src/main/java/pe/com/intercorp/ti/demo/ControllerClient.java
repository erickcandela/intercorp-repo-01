package pe.com.intercorp.ti.demo;

/*
Desarrollador: Oscar Erick Candela Carbajal  
*/

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@ComponentScan(basePackages={"pe.com.intercorp.ti.demo"})
public class ControllerClient {

	@RequestMapping("/listClient")
	public String listClient() {
		System.out.println("listClient INICIO");
		String texto0201 = "0";
		String texto0202 = "0";
		String texto0203 = "0";
		String texto0204 = "0";
		String texto0200 = "0";
		
		String error01 = "0";
		String error02 = "0";
		String error03 = "0";
		
		String propertyUrl = "0";
		String propertyUser = "0";
		String propertyPassword = "0";
		
		String listContent = "0";
		
		try {
			
			texto0201 = "Loading application properties - List" + "<br/>";
			Properties properties = new Properties();
			properties.load(ControllerClient.class.getClassLoader().getResourceAsStream("application.properties"));
			
			propertyUrl = properties.getProperty("url");
			System.out.println(propertyUrl);
			
			propertyUser = properties.getProperty("user");
			System.out.println(propertyUser);
			
			propertyPassword = properties.getProperty("password");
			System.out.println(propertyPassword);
			
			texto0202 = "Connecting to the database - List" + "<br/>";
			
			Connection connection = DriverManager.getConnection(propertyUrl, propertyUser, propertyPassword);
			texto0203 = "Database connection test - List: " + connection.getCatalog() + "<br/>";
	
			Long id = 0L;
			String nombre = "0";
			String apellidoPaterno = "0";
			String apellidoMaterno = "0";
			String edad = "0";
			String fechaNacimiento = "0";
			
			PreparedStatement readStatement = connection.prepareStatement("SELECT * FROM client;");
		    ResultSet resultSet = readStatement.executeQuery();
		    ResultSetMetaData md = resultSet.getMetaData();
		    
		    List<BClient> objetList = new ArrayList<BClient>();
		    
		    if (!resultSet.next()) {
		    	error03 = "There is no data in the database!";
		    	texto0200 += error03;
		        return null;
		    }
		    
			while (resultSet.next()) {
			 
				id = resultSet.getLong("id");
				nombre = resultSet.getString("username");
				apellidoPaterno = resultSet.getString("apellidopaterno");
				apellidoMaterno = resultSet.getString("apellidomaterno");
				edad = resultSet.getString("edad");
				fechaNacimiento = resultSet.getString("fechanacimiento");
			  
				BClient objetBean = new BClient();
				objetBean.setId(id);
			
			  objetList.add(objetBean);
			}
		    
		    for (int i = 0; i<objetList.size(); i++) {
		    	listContent = objetList.get(i).getId() + "; " + objetList.get(i).getApellidoPaterno() + "; " + objetList.get(i).getApellidoMaterno() + "; " + objetList.get(i).getEdad() + "; " + objetList.get(i).getFechaNacimiento() + "<br/>";  
		    }
		     
			texto0204 = "Closing database connection - List" + "<br/>";
			connection.close();	
			
			
		} catch (IOException ioe) {
			error01 = ioe.getMessage() + "<br/>";
			texto0200 += error01;
		} catch (SQLException sqle) {
			error02 = sqle.getMessage() + "<br/>";
			texto0200 += error02;
		}
		
		texto0200 += texto0201 + texto0202 + texto0203 + texto0204 + listContent;	
		System.out.println("listClient FIN");
				
		return texto0200;
	}	
	
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
			
			texto0201 = "Loading application properties - Insert" + "<br/>";
			Properties properties = new Properties();
			properties.load(ControllerClient.class.getClassLoader().getResourceAsStream("application.properties"));
			
			propertyUrl = properties.getProperty("url");
			System.out.println(propertyUrl);
			
			propertyUser = properties.getProperty("user");
			System.out.println(propertyUser);
			
			propertyPassword = properties.getProperty("password");
			System.out.println(propertyPassword);
			
			texto0202 = "Connecting to the database - Insert" + "<br/>";
			
			Connection connection = DriverManager.getConnection(propertyUrl, propertyUser, propertyPassword);
			texto0203 = "Database connection test - Insert: " + connection.getCatalog() + "<br/>";
	
			Long id = 0L;
			String nombre = "0";
			String apellidoPaterno = "0";
			String apellidoMaterno = "0";
			String edad = "0";
			String fechaNacimiento = "0";
			
			PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO client (id, nombre, apellidopaterno, apellidomaterno, edad, fechanacimiento) VALUES (?, ?, ?, ?, ?, ?);");
			
			id = 3L;
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
			
		    insertStatement.setLong(1, objetBean.getId());
		    insertStatement.setString(2, objetBean.getNombre());
		    insertStatement.setString(3, objetBean.getApellidoPaterno());
		    insertStatement.setString(4, objetBean.getApellidoMaterno());		    
		    insertStatement.setString(5, objetBean.getEdad());
		    insertStatement.setString(6, objetBean.getFechaNacimiento());
		    insertStatement.executeUpdate();			
			
			texto0204 = "Closing database connection - Insert" + "<br/>";
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

}