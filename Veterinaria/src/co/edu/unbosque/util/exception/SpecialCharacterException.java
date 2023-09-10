package co.edu.unbosque.util.exception;

public class SpecialCharacterException extends Exception {
	
	public SpecialCharacterException() {
		super("Este parametro no puede contener caracteres especiales");
	}

}
