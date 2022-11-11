package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	Connection connection;
	
	public Connection getConnection() {
		String dbName= "Client_ejercicios";
		String userName= "root";
		String password= "5dejuliO";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/"+ dbName,
					userName,
					password);
		} catch (ClassNotFoundException | SQLException e) {//Podriamos poner en vez de esas dos, poner solo exception 3 pero es mas burdo
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
		
	}

}
