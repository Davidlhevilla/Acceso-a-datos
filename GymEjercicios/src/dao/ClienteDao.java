package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Cliente;
import pojo.Ejercicio;





public class ClienteDao extends ObjetoDao implements InterfazDao<Cliente>{
	
	
	private static Connection connection;
	
	public ClienteDao() {
		
	}

	@Override
	public ArrayList<Cliente> buscarTodos() {
		connection = openConnection();

		String query = "Select * from cliente";
		Cliente cliente = null;
		ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				ArrayList<Ejercicio>ejercicios = new ArrayList<Ejercicio>();
				cliente = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getInt("edad"),
						rs.getString("sexo"),null);
				
				
				String query_ejercicio = "select * from ejercicios where cliente_id = ?";
				PreparedStatement ps_ejercicios = connection.prepareStatement(query_ejercicio);
				ps_ejercicios.setInt(1, rs.getInt("id")); 
				ResultSet rs_ejercicios = ps_ejercicios.executeQuery();
				
				while(rs_ejercicios.next()) {
					Ejercicio ejercicio = new Ejercicio(
							rs_ejercicios.getInt("id"),
							rs_ejercicios.getString("nombre"),
							rs_ejercicios.getInt("repeticiones"),
							rs_ejercicios.getInt("series")
							);
					ejercicios.add(ejercicio);
					
				}
				cliente.setEjercicios(ejercicios);
				
				
				listaCliente.add(cliente);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

		return listaCliente;
	}

	@Override
	public Cliente buscarPorId(int i) {
		connection = openConnection();
		String query = "Select * from cliente where id= ?";
		Cliente cliente = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cliente = new Cliente(
						i, 
						rs.getString("nombre"),
						rs.getInt("edad"),
						rs.getString("sexo"),
						null);
				cliente.setEjercicios(obtenerEjercicios(cliente));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		closeConnection();
		return cliente;
	}

	@Override
	public void insertar(Cliente cliente) {
		connection = openConnection();

		String query = "insert into cliente (nombre, edad, sexo)" + " values(?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, cliente.getNombre());
			ps.setInt(2, cliente.getEdad());
			ps.setString(3, cliente.getSexo());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
		
	}

	@Override
	public void modificar(Cliente cliente) {
		connection = openConnection();

		String query = "UPDATE cliente SET nombre= ?, edad= ?, sexo= ? where id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, cliente.getNombre());
			ps.setInt(2, cliente.getEdad());
			ps.setString(3, cliente.getSexo());
			ps.setInt(4, cliente.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
	}
	
	
	public ArrayList<Ejercicio> obtenerEjercicios(Cliente cliente){
		ArrayList<Ejercicio> ejercicios = new ArrayList<>();
		
		connection = openConnection();
		String query = "SELECT * FROM ejercicios WHERE cliente_id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, cliente.getId());
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Ejercicio ejercicio = new Ejercicio(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getInt("repeticiones"),
						rs.getInt("series"),
						cliente
						);
				ejercicios.add(ejercicio);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		closeConnection();
		
		return ejercicios;
	}
	
	
	public ArrayList<Ejercicio> obtenerEjerciciosPorClienteId(int cliente_id){
		ArrayList<Ejercicio> ejercicios = new ArrayList<>();
		
		connection = openConnection();
		String query = "SELECT * FROM ejercicios WHERE ejercicio_id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, cliente_id);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Ejercicio ejercicio = new Ejercicio(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getInt("repeticiones"),
						rs.getInt("series"),
						buscarPorId(cliente_id)
						);
				ejercicios.add(ejercicio);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return ejercicios;
	}


	@Override
	public void borrar(Cliente cliente) {
		int cliente_id = cliente.getId();
		
		EjercicioDao ejercicioDao = new EjercicioDao();
		ejercicioDao.borrarPorCliente(cliente_id);
		
		connection = openConnection();
		
		
		String query = "DELETE FROM cliente WHERE id = ?";
		
		 
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, cliente_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		closeConnection();	
		
	}

}
