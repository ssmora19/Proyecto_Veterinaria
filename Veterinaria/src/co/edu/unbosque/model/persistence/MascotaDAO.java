package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.MascotaDTO;
import co.edu.unbosque.util.DequeList;
import co.edu.unbosque.util.QueueImpl;

public class MascotaDAO {

	private QueueImpl<MascotaDTO> pets;

	public MascotaDAO() {
		pets = FileHandler.readFile();
	}

	public String showPets() {
		System.out.println("Muestro");
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < pets.size(); i++) {
			
		}
		return pets.toString();
	}

	public void add(Object obj) {
		pets.enqueue((MascotaDTO) obj);
		System.out.println("Estoy agregando y escribiendo");
		FileHandler.escribirEnArchivo(pets);
	}
	
	public void delete() {
		pets.dequeue();
		System.out.println("Estoy eliminando");
	}

}
