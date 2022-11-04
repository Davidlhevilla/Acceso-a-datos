package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Serie;
import pojo.Temporada;
import util.DatabaseConnection;

public class TemporadaDao extends ObjetoDao implements InterfazDao<Temporada> {
	private static Connection connection;

	@Override
	public ArrayList<Temporada> buscarTodos() {
		connection = openConnection();

		String query = "Select * from temporadas";
		Temporada temporada = null;
		
		ArrayList<Temporada> listaTemporada = new ArrayList<Temporada>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				
				
				rs.getInt("serie_id");
				SerieDao serieDao=new SerieDao();
				Serie s=serieDao.buscarPorId(0);
	
				
				temporada = new Temporada(
						rs.getInt("id"),
						rs.getInt("num_temporada"),
						rs.getString("titulo"),
						s);
				listaTemporada.add(temporada);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaTemporada;
	}

	@Override
	public Temporada buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Temporada t) {
		// TODO Auto-generated method stub
		connection = openConnection();

		String query = "insert into temporadas (num_temporada, titulo, " + "serie_id) values (?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, t.getNum_temporada());
			ps.setString(2, t.getTitulo());
			ps.setInt(3, t.getSerie().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

//		t.getSerie().getId();

	}

	@Override
	public void modificar(Temporada t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Temporada t) {
		connection = openConnection();
		
		String query = "delete from temporadas where serie_id = "+t.getSerie().getId();
		
		try {
			
			PreparedStatement preparedStatement =
					connection.prepareStatement(query);
			preparedStatement.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		closeConnection();

	}

//	private static Connection openConnection() {
//		DatabaseConnection dbConnection = new DatabaseConnection();
//		connection = dbConnection.getConnection();
//		return connection;
//	}
//	
//	private static void closeConnection() {
//		
//		try {
//			connection.close();
//			connection = null;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

}
