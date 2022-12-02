package main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;

import pojo.Animal;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
//
//		Animal a1 = new Animal("Yorkshire", "Casa", new BigDecimal(1));
//		
//		session.save(a1);
		
//		int id = 4;
//		
//		Animal a = (Animal) session.get(Animal.class,id);
//		
//		System.out.println(a.getNombre());
		
		//Esto es otra manera de hacer con animales para mostrar la lista entera
//	//	Query<Animal> q = session.createQuery("From animales");
//		List <Animal>animales=q.list();
		
		//ESto es la otra manera principal con animales para mostrar la lista entera
//		List animales = session.createQuery("FROM animales").getResultList();
		
		
		
		
		//Para hacer consultas usamos esto 
		String hql = "FROM animales where habitad = :habitad";
//		List animales = session.createQuery(hql).getResultList();
		Query q = session.createQuery(hql);
		q.setParameter("habitad", "Bosque");
		List animales =q.getResultList();
		
		
		for(Iterator i = animales.iterator();i.hasNext();) {
			Animal a = (Animal)i.next();
			System.out.println(a.getNombre());
		}
		
		session.close();
	}

}
