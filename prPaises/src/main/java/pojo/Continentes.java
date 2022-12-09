package pojo;
// Generated 9 dic 2022, 14:17:42 by Hibernate Tools 5.5.9.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Continentes generated by hbm2java
 */
public class Continentes implements java.io.Serializable {

	private int id;
	private String nombre;
	private int poblacion;
	private Set paiseses = new HashSet(0);

	public Continentes() {
	}

	public Continentes(int id, String nombre, int poblacion) {
		this.id = id;
		this.nombre = nombre;
		this.poblacion = poblacion;
	}

	public Continentes(int id, String nombre, int poblacion, Set paiseses) {
		this.id = id;
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.paiseses = paiseses;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPoblacion() {
		return this.poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public Set getPaiseses() {
		return this.paiseses;
	}

	public void setPaiseses(Set paiseses) {
		this.paiseses = paiseses;
	}

}
