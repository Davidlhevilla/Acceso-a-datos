package pojo;

public class Ejercicio {
	private int id;
	private String nombre;
	private int repeticiones;
	private int series;
	private Cliente cliente;
	
	
	
	public Ejercicio() {
		super();
	}



	public Ejercicio(int id, String nombre, int repeticiones, int series, Cliente cliente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.repeticiones = repeticiones;
		this.series = series;
		this.cliente = cliente;
	}
	public Ejercicio(int id, String nombre, int repeticiones, int series) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.repeticiones = repeticiones;
		this.series = series;
		
	}


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
