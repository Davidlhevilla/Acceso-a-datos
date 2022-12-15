package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Cliente;
import pojo.Ejercicio;



public class EjercicioDao extends ObjetoDao implements InterfazDao<Ejercicio> {
	private static Connection connection;

	@Override
	public ArrayList<Ejercicio> buscarTodos() {
		connection = openConnection();

		String query = "Select * from ejercicio";
		Ejercicio ejercicio = null;
		
		ArrayList<Ejercicio> listaEjercicios = new ArrayList<Ejercicio>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				
				
				rs.getInt("serie_id");
				ClienteDao clienteDao=new ClienteDao();
				Cliente c = clienteDao.buscarPorId(0);
	
				
				ejercicio = new Ejercicio(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getInt("repeticiones"),
						rs.getInt("series"),
						c);
				listaEjercicios.add(ejercicio);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaEjercicios;
	}
	

	@Override
	public Ejercicio buscarPorId(int i) {
		connection = openConnection();
		String query = "select * from ejercicios where id = ?";
		Statement statement;
		Ejercicio ejercicio = new Ejercicio();

		try {

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ClienteDao clienteDao=new ClienteDao();
				Cliente c=clienteDao.buscarPorId(ejercicio.getCliente().getId());
				ejercicio = new Ejercicio(rs.getInt("id"), 
						rs.getString("nombre"),
						rs.getInt("repeticiones"),
						rs.getInt("series"),
						c	
						);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ejercicio;
	}

	@Override
	public void insertar(Ejercicio t) {
		// TODO Auto-generated method stub
				connection = openConnection();

				String query = "insert into ejercicios (nombre, repeticiones, series, cliente_id) values (?,?,?,?)";
				try {
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(1, t.getNombre());
					ps.setInt(2, t.getRepeticiones());
					ps.setInt(3, t.getSeries());
					ps.setInt(4, t.getCliente().getId());
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				closeConnection();

		
	}

	@Override
	public void modificar(Ejercicio ejercicio) {
		connection = openConnection();
		
		String query="UPDATE ejercicios SET id= ?, nombre= ?,repeticiones= ?, series= ? where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, ejercicio.getId());
			ps.setString(2, ejercicio.getNombre());
			ps.setInt(3, ejercicio.getRepeticiones());
			ps.setInt(4, ejercicio.getSeries());
			ps.setInt(5, ejercicio.getCliente().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
	}

	@Override
	public void borrar(Ejercicio t) {
		connection = openConnection();
		
		int id = t.getId();
		
		String query = "DELETE FROM ejercicios WHERE id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
	}
	
	
	
	
	public void borrarPorCliente(int cliente_id) {
		connection = openConnection();
		
		String query ="DELETE FROM ejercicios WHERE cliente_id = ?";
		
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
	
	public void eliminarTableEjercicios() {
        connection=openConnection();
        String query = "drop table ejercicios";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        closeConnection();
    }

	public void crearTableEjercicios() {
        connection=openConnection();
        String query = "CREATE TABLE ejercicios(\n"
        		+ "	id INT PRIMARY KEY AUTO_INCREMENT,\n"
        		+ "    nombre VARCHAR(100) NOT NULL,\n"
        		+ "	repeticiones INT NOT NULL,\n"
        		+ "    series INT NOT NULL,\n"
        		+ "    cliente_id INT NOT NULL,\n"
        		+ "    CONSTRAINT fk_ejercicios_cliente\n"
        		+ "		FOREIGN KEY(cliente_id)\n"
        		+ "        REFERENCES cliente(id)\n"
        		+ ");";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        closeConnection();
    }

	

}
