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
		
		ArrayList<Serie> series = serieDao.buscarTodos();
		
		for(Serie serie : series) {
			System.out.println("SERIE: "+serie.getTitulo());
			for(Temporada temporada : serie.getTemporadas()) {
				System.out.println("TEMPORADA: "+temporada.getTitulo());
			}
		}
		
		
		
		
//		Serie s =serieDao.buscarPorId(1);
		
		
		
//		s.setEdad(18);
//		serieDao.modificar(s);
//		
//		ArrayList<Serie> series = serieDao.buscarTodos();
//		
//		for(Serie serie : series) {
//			System.out.println(serie.getTitulo());
//		}
		
		
		
		
		
		
//		Temporada temporada1=new Temporada(1,"Temporada 1",);
//		ArrayList<Temporada> temporadas = serieDao.obtenerTemporadas(s);
//		for(Temporada temporada : temporadas) {
//			
//			System.out.println(temporada);
//		}
		
		
		
//		SerieDao serieDao = new SerieDao();
//		TemporadaDao temporadaDao = new TemporadaDao();
//		
//		Serie s = serieDao.buscarPorId(3);
//		Temporada t1 = new Temporada(1, "The Mandalorian Season 1", s);
//		Temporada t2 = new Temporada(2, "The Mandalorian Season 2", s);
//		Temporada t3 = new Temporada(3, "The Mandalorian Final Season", s);
//		temporadaDao.insertar(t1);
//		temporadaDao.insertar(t2);
//		temporadaDao.insertar(t3);
//		temporadaDao.borrarPorSerie(3);
		
//		Serie s = serieDao.buscarPorId(1);
//		serieDao.borrar(s);
		
	}

}
