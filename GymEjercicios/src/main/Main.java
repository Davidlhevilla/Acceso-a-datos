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
		
		
		
		

		
		
		
		
//		Cliente cliente1=new Cliente("Miguel",38,"H",null);
//		Cliente cliente2 =new Cliente("David",30,"H",null);
//		Cliente cliente3=new Cliente("Jenaro",30,"H",null);
//		Cliente cliente4= new Cliente("Pepe",25,"H",null);
		ClienteDao cd=new ClienteDao();
//		cd.insertar(cliente4);
//		System.out.println(cd.buscarPorId(4));
//		Cliente cliente = cd.buscarPorId(4);
		
//		cd.borrar(cliente4);
		
//		cd.insertar(cliente4);
		
//		Ejercicio abs = new Ejercicio("Abdominales",10,3,cliente);
//		Ejercicio pressBanca = new Ejercicio("Press de banca",10,4,cliente4);
//		
//		EjercicioDao ed=new EjercicioDao();
//		ed.insertar(abs);
//		cd.insertar(cliente2);
		
//		ed.insertar(pressBanca);
//		ed.insertar(abs);
		
		
//		EjercicioDao ejercicioDao = new EjercicioDao();
		
		ArrayList<Cliente> clientes = cd.buscarTodos();
		
		for(Cliente cliente : clientes) {
			System.out.println("CLIENTE: "+cliente.getNombre());
			System.out.println("----------------------------");
			for(Ejercicio ejercicio : cliente.getEjercicios()) {
				System.out.println("EJERCICIO: "+ejercicio.getNombre());
				
			}
			System.out.println("");
		}
//		Cliente cliente = cd.buscarPorId(1);
//		cd.borrar(cliente);
//		
		
		

	}

}
