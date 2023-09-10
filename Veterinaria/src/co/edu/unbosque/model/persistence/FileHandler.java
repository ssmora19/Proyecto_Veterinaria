package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import co.edu.unbosque.model.MascotaDTO;
import co.edu.unbosque.util.DequeList;
import co.edu.unbosque.util.QueueImpl;

public class FileHandler {

	private static ObjectInputStream entrada;
	private static ObjectOutputStream salida;
	private static File archivo;

	public FileHandler() {
		archivo = new File("data/mascota.txt");
		if (archivo.exists()) {
			System.out.println("El archivo ya existe");
		} else {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void escribirEnArchivo(QueueImpl<MascotaDTO> pets) {
		try {
			salida = new ObjectOutputStream(new FileOutputStream("data/mascota.txt"));

			salida.writeObject(pets);
			salida.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static QueueImpl<MascotaDTO> readFile() {
		QueueImpl<MascotaDTO> pets = new QueueImpl<MascotaDTO>();
		try {
			entrada = new ObjectInputStream(new FileInputStream("data/mascota.txt"));
			pets = (QueueImpl<MascotaDTO>) entrada.readObject();
			entrada.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
		return pets;
	}

	public static ObjectInputStream getEntrada() {
		return entrada;
	}

	public static void setEntrada(ObjectInputStream entrada) {
		FileHandler.entrada = entrada;
	}

	public static ObjectOutputStream getSalida() {
		return salida;
	}

	public static void setSalida(ObjectOutputStream salida) {
		FileHandler.salida = salida;
	}

	public File getArchivo() {
		return archivo;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

}
