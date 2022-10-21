package prZoologicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class AnimalDAO {
	
	//no hace falta inicializar la clase con abstract. ya que solo vamos a usar sus metodos.
	
	private static Connection connection;
	
	//buscar todos los animales
	public static ArrayList<Animal> findAllAnimales(){
		
		connection = openConnection();
		
		String query = "Select * from animales";
		Animal animal=null;
		ArrayList<Animal> listaAnimal=new ArrayList<Animal>();
		 
		try {
			Statement statement = connection.createStatement();
			ResultSet rs =  statement.executeQuery(query);
			while (rs.next()) {
				animal = new Animal(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getString("habitad"),
					rs.getDouble("peso_aproximado"));
				listaAnimal.add(animal);
		}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listaAnimal;
		
	}
	
	// Buscar un animal por id
	public static Animal findById(int id) {
		
		connection = openConnection();
		String query = "Select * from animales where id= ?";
		Animal animal = null;
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs =  ps.executeQuery();
				while (rs.next()) {
					animal = new Animal(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("habitad"),
						rs.getDouble("peso_aproximado"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return animal;
	}
	
	
	public static void deleteAnimalByNombre(String nombre) {
		connection = openConnection();
		//String query = "delete from animales where nombre = ?";
		
		String query = "delete from animales where nombre ='"+nombre+"'";
//		PreparedStatement ps = connection.prepareStatement(query);
//		ps.setString(1,nombre);
//		ps.executeUpdate();
		
		
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
	}
	
	//Borrar todos los animales
	public static void deleteAllAnimal() {
		connection = openConnection();
		
		String query = "delete from animales";
		
		try {
			/*Statement statement = connection.createStatement();
			statement.executeUpdate(query);*/
			PreparedStatement preparedStatement =
					connection.prepareStatement(query);
			preparedStatement.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		closeConnection();
		
	}
	
	public static void insertAnimal(Animal animal) {
		connection = openConnection();
		
		String query= "insert into animales (nombre, habitad, "
				+ "peso_aproximado) values (?, ?, ?)";
		try {
			PreparedStatement preparedStatement= 
					connection.prepareStatement(query);
			preparedStatement.setString(1, animal.getNombre());
			preparedStatement.setString(2, animal.getHabitad());
			preparedStatement.setDouble(3, animal.getPeso_aproximado());
			
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	
	private static Connection openConnection() {
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}
	
	private static void closeConnection() {
		
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
