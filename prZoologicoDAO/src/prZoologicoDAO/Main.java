package prZoologicoDAO;

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
		System.out.println(a);
	}

}
