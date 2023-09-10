package co.edu.unbosque.controller;

import java.util.Date;

import co.edu.unbosque.model.MascotaDTO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.QueueImpl;
import co.edu.unbosque.util.StackImpl;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	
	private VistaConsola vista;
	private FileHandler archivo;
	private StackImpl<Long> blanckets;
	private QueueImpl<MascotaDTO> pets;
	
	public Controller() {
		vista= new VistaConsola();
		archivo= new FileHandler();
		blanckets=new StackImpl<>();
		pets=new QueueImpl<>();
		
		funcionar();
	}
	
	public void funcionar() {
		
		for (int i = 0; i < 3; i++) {
			blanckets.push(((long)i));		
		}
		
		System.out.println("BIENVENIDO A LA VETERINARIA");
		String opcion = "MENU:\n"
				+ "1. Solicitar turno.\n"
				+ "2. Mostrar cola de mascotas.\n"
				+ "2.Salir.\n";
		vista.mostrarInformacion(opcion);
		int rta=vista.leerDatoEntero("Seleccione una opción:");
		String auxpetname,auxrace,auxownername="";
		long auxid,auxphone;
		int sizeStack= blanckets.size();
		
		switch (rta) {
		
		case 1:
			
			int aux=1;
			if(aux<= sizeStack) {
				auxownername= vista.leerCadenaCaracteres("Ingrese nombre del propietario de la mascota");
				auxphone=vista.leerDato("Digite su numero de celular");
				auxid=vista.leerDato("Digite su numero de identificacion");
				auxpetname= vista.leerCadenaCaracteres("Ingrese el nombre de la mascota");
				auxrace= vista.leerCadenaCaracteres("Ingrese la raza de la mascota");
				pets.enqueue(new MascotaDTO(auxpetname, auxrace, auxownername,auxid,auxphone,true));
				System.out.println("Se le ha asignado un turno");
				blanckets.pop();
				sizeStack--;
				vista.mostrarInformacion(opcion);
				int rta1=vista.leerDatoEntero("Seleccione una opción:");	
			}else {
				
				System.out.println("Lo sentimos,no podemos atenderlo, el numero de cobijas no es suficiente");
				
			}
			break;
			
		case 2:
			System.out.println(pets.toString());
			break;
			
		case 3:
			vista.mostrarInformacion("Hasta la próxima <3");
			break;
		}
		if( rta !=4) {
			funcionar();
		}
		
		
			
		
		
			
	}

}
