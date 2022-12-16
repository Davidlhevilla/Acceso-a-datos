package dao;

import java.sql.Connection;
import java.sql.SQLException;

import util.DatabaseConnection;

public class ObjetoDao {

	private static Connection connection;
	/**
	 * Método que abre la conexion de BD
	 * @return devuelve la conexion.s
	 */
	protected static Connection openConnection() {
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}
	/**
	 * Método que cierra una conexion
	 */
	protected static void closeConnection() {
		
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
