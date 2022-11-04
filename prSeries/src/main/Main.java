package main;

import java.util.ArrayList;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		
		//Serie serie = new Serie("Los Simpsons", 7, "Disney Plus");
		SerieDao serieDao = new SerieDao();
//		serieDao.insertar(serie);
		
	//	System.out.println(serieDao.buscarPorId(1));
//		Serie serie = serieDao.buscarPorId(1);
//		Temporada t1 = new Temporada(1, "Temporada 1", serie);
//		Temporada t2 = new Temporada(2, "Temporada 2", serie);
//		
//		TemporadaDao temporadaDao = new TemporadaDao();
//		temporadaDao.insertar(t1);
//		temporadaDao.insertar(t2);
//		Serie s=new Serie("The mandalorian",13,"Disney Plus");
//		serieDao.insertar(s);
		
		Serie s =serieDao.buscarPorId(1);
//		s.setEdad(18);
//		serieDao.modificar(s);
//		
//		ArrayList<Serie> series = serieDao.buscarTodos();
//		
//		for(Serie serie : series) {
//			System.out.println(serie.getTitulo());
//		}
		ArrayList<Temporada> temporadas = serieDao.obtenerTemporadas(s);
		for(Temporada temporada : temporadas) {
			System.out.println(temporada);
		}
	}

}
