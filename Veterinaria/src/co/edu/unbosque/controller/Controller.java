package co.edu.unbosque.controller;

import co.edu.unbosque.model.MascotaDTO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.model.persistence.MascotaDAO;
import co.edu.unbosque.util.QueueImpl;
import co.edu.unbosque.util.StackImpl;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	
	private VistaConsola vista;
	private StackImpl<Long> blanckets;
	private MascotaDAO mdao;
	private int sizeStack;
	
	public Controller() {
		vista= new VistaConsola();
		blanckets=new StackImpl<>();
		mdao = new MascotaDAO();
		
		funcionar();
	}
	
	public void funcionar() {
		
		System.out.println("BIENVENIDO A LA VETERINARIA");
		String opcion = "MENU:\n"
				+ "Recomendacion: Una vez se solicita el turno y se diligencian\n"
				+ " los datos, por favor registrar su consulta\n"
				+ " para que esta sea validada.\n"
				+ "1. Solicitar turno.\n"
				+ "2. Registrar consulta.\n"
				+ "3. Mostrar cola de mascotas.\n"
				+ "4. Salir.\n";
		vista.mostrarInformacion(opcion);
		int rta=vista.leerDatoEntero("Seleccione una opción:");
		String auxpetname,auxrace,auxownername,auxanswer="";
		long auxid,auxphone;
		
		
		switch (rta) {
		
		case 1:
			
			int aux=1;
			if(aux<= sizeStack) {
				auxownername= vista.leerCadenaCaracteres("Ingrese nombre del propietario de la mascota");
				auxphone=vista.leerDato("Digite su numero de celular");
				auxid=vista.leerDato("Digite su numero de identificacion");
				auxpetname= vista.leerCadenaCaracteres("Ingrese el nombre de la mascota");
				auxrace= vista.leerCadenaCaracteres("Ingrese la raza de la mascota");
				mdao.add(new MascotaDTO(auxpetname, auxrace, auxownername,auxid,auxphone));
				System.out.println("Se le ha asignado un turno");
				sizeStack--;
				System.out.println(sizeStack);
			}else {
				
				System.out.println("Lo sentimos,no podemos atenderlo, el numero de cobijas no es suficiente");
				
			}
			break;
			
		case 2:
			auxanswer=vista.leerCadenaCaracteres("Se llevo a cabo la consulta a su mascota?(Si/No)");
			if(auxanswer.equals("Si")) {
				mdao.delete();
				System.out.println(mdao.showPets());
				System.out.println("Siguiente en la fila!");	
			}else if(auxanswer.equals("No")) {
				System.out.println("Espere un momento a que llegue su turno de consulta");
			}
			break;
			
		case 3:
			System.out.println(mdao.showPets());
			break;
			
		case 4:
			vista.mostrarInformacion("Hasta Pronto :)");
			break;
		}
		if( rta !=5) {
			funcionar();
		}
			
	}
	
	public int pushStack() {
		for (int i = 0; i < 6; i++) {
			blanckets.push(((long)i));
			sizeStack= blanckets.size();
		}
		return sizeStack;
	}

}
