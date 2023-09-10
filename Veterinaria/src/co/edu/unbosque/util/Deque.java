package co.edu.unbosque.util;

public interface Deque <T>{
	// CREAR LA ESTRUCTURA GENERAL
	
	public void insertLast(T info);
	
	public T removeLast();// traer el ultimo dato quitar y mostrar
	
	public void insertFirst(T info);
	
	public T removeFirst();
	
	public int size();
		
	

}
