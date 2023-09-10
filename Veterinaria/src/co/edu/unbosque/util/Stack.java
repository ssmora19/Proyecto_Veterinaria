package co.edu.unbosque.util;

public interface Stack <T>{
	
	public void push(T info); // poner encima de la fila 
	
	public  T pop(); // quitar de arriba 
	
	public int size();
	
	public T peek();// traer el que esta en la parte de arriba de la cola
	
	

}
