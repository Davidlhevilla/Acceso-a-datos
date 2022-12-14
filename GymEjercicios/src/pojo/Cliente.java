package pojo;

import java.util.ArrayList;
/**
 * Pojo de Cliente
 * @author davidlhevilla
 *
 */
public class Cliente {
	
	private int id;
	private String nombre;
	private int edad;
	private String sexo;
	private ArrayList<Ejercicio> ejercicios;
	
	
	/**
	 * 
	 * @param nombre nombre del cliente
	 * @param edad edad del cliente
	 * @param sexo sexo del cliente
	 * @param ejercicios ejercicios del cliente
	 */
	public Cliente(String nombre, int edad, String sexo, ArrayList<Ejercicio> ejercicios) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.ejercicios = ejercicios;
	}

	/**
	 * Constructor del cliente
	 * @param id id del cliente
	 * @param nombre nombre del cliente
	 * @param edad edad del cliente
	 * @param sexo sexo del cliente
	 * @param ejercicios ejercicios del cliente
	 */
	public Cliente(int id, String nombre, int edad, String sexo, ArrayList<Ejercicio> ejercicios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.ejercicios = ejercicios;
	}
	
	



	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public ArrayList<Ejercicio> getEjercicios() {
		return ejercicios;
	}


	public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", ejercicios="
				+ ejercicios + "]";
	} 
	
	
	
	

}
