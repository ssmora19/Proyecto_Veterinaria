package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.MascotaDTO;
import co.edu.unbosque.util.DequeList;
import co.edu.unbosque.util.QueueImpl;

public class MascotaDAO {
	
	private FileHandler archivo;
	private QueueImpl<MascotaDTO> pets;
	
	public MascotaDAO(FileHandler archivo) {
		this.archivo=archivo;
	}
	
	public String showPets() {
		pets=archivo.readFile();
		System.out.println("El archivo se esta leyendo");
		String texto ="";
		for(int i=0; i< pets.size();i++) {
			texto=texto.concat(pets.toString()+"\n");
		}
		return texto;	
	}
	
	public void add(Object obj) {
		pets.enqueue((MascotaDTO)obj);
		System.out.println("Estoy agregando y escribiendo");
		archivo.escribirEnArchivo(pets);
	}

}
