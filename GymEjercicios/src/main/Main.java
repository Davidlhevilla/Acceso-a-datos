package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.ClienteDao;
import dao.EjercicioDao;
import dao.ObjetoDao;
import pojo.Cliente;
import pojo.Ejercicio;
import util.DatabaseConnection;

public class Main {

	public static void main(String[] args) {
		
		
		
		
		ClienteDao cd=new ClienteDao();
		
		EjercicioDao ed=new EjercicioDao();
		
		
		ed.eliminarTableEjercicios();
		cd.eliminarTableCliente();
		cd.crearTableCliente();
		ed.crearTableEjercicios();
		
//		Creacion de cliente antes del ejercicio
		Cliente c=new Cliente("Jenaro",30,"Hombre",null);
		
		
		cd.insertar(c);
		
		Cliente miCliente=cd.buscarPorId(1);
		
		
		//Creamos ejercicio a partir del buscado por id
		Ejercicio e1=new Ejercicio("Press de banca",10,4,miCliente);
		Ejercicio abs = new Ejercicio("Abdominales",10,3,miCliente);
		
		ed.insertar(e1);
		ed.insertar(abs);
		
		

		
		ArrayList<Cliente> clientes = cd.buscarTodos();
		
		for(Cliente cliente : clientes) {
			System.out.println("CLIENTE: "+cliente.getNombre());
			System.out.println("----------------------------");
			for(Ejercicio ejercicio : cliente.getEjercicios()) {
				System.out.println("EJERCICIO: "+ejercicio.getNombre());
				
			}
			System.out.println("");
		}
		
		System.out.println("----------------------------");
		
		System.out.println(cd.buscarPorSexo("Hombre"));

	}

}
