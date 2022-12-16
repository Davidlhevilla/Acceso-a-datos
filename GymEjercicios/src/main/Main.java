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
		Cliente c=new Cliente("David",30,"Hombre",null);
		Cliente c2=new Cliente("Sara",25,"Mujer",null);
		
		
		
		cd.insertar(c);
		cd.insertar(c2);
		
		Cliente miCliente=cd.buscarPorId(1);
		Cliente cliente2=cd.buscarPorId(2);
		
		
		//Creamos ejercicio a partir del buscado por id
		Ejercicio e1=new Ejercicio("Press de banca",10,4,miCliente);
		Ejercicio abs = new Ejercicio("Abdominales",10,3,miCliente);
		
		Ejercicio e2= new Ejercicio("Patada Triceps",10,5,cliente2);
		Ejercicio e3 = new Ejercicio("Biceps",10,3,cliente2);
		
		ed.insertar(e1);
		ed.insertar(abs);
		ed.insertar(e2);
		ed.insertar(e3);
		
		
		
		//Muestra los nombres de todos los clientes		
//	ArrayList<Cliente> listaClientes = cd.buscarTodos();
//	for(Cliente cliente : listaClientes) {
//		System.out.println(cliente.getNombre());
//	}
					
				
			
		
		
		//Modifica el nombre
//		miCliente.setNombre("Pepe");
//		cd.modificar(miCliente);
		
		
		//Borrar Cliente
//		miCliente.getId();
//		cd.borrar(miCliente);
		
		
		
		

		
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
		
		System.out.println(cd.buscarPorSexo("Mujer"));
		System.out.println("Hombre");

	}

}
