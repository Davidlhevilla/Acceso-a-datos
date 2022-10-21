package prZoologicoDAO;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
//		Animal a = new Animal ("Ardilla", "Bosque", 0.1);
//		AnimalDAO.insertAnimal(a);
//		AnimalDAO.deleteAnimal();
//		Animal a = new Animal("Kakapoo", "Bosque",5);
//		AnimalDAO.insertAnimal(a);
//		Animal a = new Animal("Cacatua", "Bosque",4);
//		AnimalDAO.insertAnimal(a);
//		AnimalDAO.deleteAnimalByNombre("Ardilla");
//		AnimalDAO.deleteAllAnimal();
		
		Animal a = AnimalDAO.findById(2);
		a.setPeso_aproximado(1.00);
		AnimalDAO.updateAnimal(a);
		
		ArrayList<Animal> animales = AnimalDAO.findAllAnimales();
		for(int i=0; i< animales.size();i++) {
			System.out.println(animales.get(i));
		}
		
	}

}
