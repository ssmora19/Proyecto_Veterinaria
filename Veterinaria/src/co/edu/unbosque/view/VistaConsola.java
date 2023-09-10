package co.edu.unbosque.view;

import java.util.Scanner;

public class VistaConsola {
	
	private Scanner sc;
	
	public VistaConsola() {
		sc= new Scanner(System.in);
	}
	
	public int leerDatoEntero(String mensaje) {
		int dato=0;
		System.out.println(mensaje);
		dato= sc.nextInt();
		return dato;
	}
	
	public long leerDato(String mensaje) {
		long dato=0;
		System.out.println(mensaje);
		dato=sc.nextLong();
		return dato;
	}
	
	public String leerCadenaCaracteres(String mensaje) {
		String dato="";
		System.out.println(mensaje);
		dato=sc.next();
		return dato;
	}
	
	public void mostrarInformacion(String mensaje) {
		System.out.println(mensaje);
	}

}
