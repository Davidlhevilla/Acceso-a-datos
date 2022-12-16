package pojo;
/**
 * Pojo de Ejercicios 
 * @author davidlhevilla
 *
 */
public class Ejercicio {
	private int id;
	private String nombre;
	private int repeticiones;
	private int series;
	private Cliente cliente;
	
	
	
	public Ejercicio() {
		super();
	}

	/**
	 * Constructor del ejercicio
	 * @param id id del ejercicio
	 * @param nombre nombre del ejercicio
	 * @param repeticiones repeticiones del ejercicio
	 * @param series series del ejercicio
	 * @param cliente cliente que tiene el ejercicio
	 */

	public Ejercicio(int id, String nombre, int repeticiones, int series, Cliente cliente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.repeticiones = repeticiones;
		this.series = series;
		this.cliente = cliente;
	}
	/**
	 * Constructor del ejercicio
	 * @param id id del ejercicio
	 * @param nombre nombre del ejercicio
	 * @param repeticiones repeticiones del ejercicio
	 * @param series series del ejercicio
	 */
	public Ejercicio(int id, String nombre, int repeticiones, int series) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.repeticiones = repeticiones;
		this.series = series;
		
	}
	/**
	 * Constructor del ejercicio
	 * @param nombre nombre del ejercicio
	 * @param repeticiones repeticiones del ejercicio
	 * @param series series del ejercicio
	 * @param cliente cliente que tiene el ejercicio
	 */

	public Ejercicio(String nombre, int repeticiones, int series, Cliente cliente) {
		super();
		this.nombre = nombre;
		this.repeticiones = repeticiones;
		this.series = series;
		this.cliente = cliente;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getRepeticiones() {
		return repeticiones;
	}



	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}



	public int getSeries() {
		return series;
	}



	public void setSeries(int series) {
		this.series = series;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public int getId() {
		return id;
	}



	@Override
	public String toString() {
		return "Ejercicio [id=" + id + ", nombre=" + nombre + ", repeticiones=" + repeticiones + ", series=" + series
				+ ", cliente=" + cliente + "]";
	}
	
	

	
	
	
}
