package co.edu.unbosque.util;

import java.io.Serializable;

public class MyDoubleLinkedList <T> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//solo se maneja la posicion 0 y la ultima
	//sus atributos van a ser protegidos 
	//solo se maneja lo que esta a la derecha y a la izquierda 
	//funciones: mover nodos hacia adelante y hacia atras

	protected DNode<T> head;
	protected DNode<T> currentPosition;

	public MyDoubleLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public DNode<T> getHead() {
		return head;
	}

	public void setHead(DNode<T> head) {
		this.head = head;
	}

	public DNode<T> getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(DNode<T> currentPosition) {
		this.currentPosition = currentPosition;
	}

	//mover para adelante
	public void forward(int ... numposition) {//multiatributo, decirle cuantas posiciones quiere que este node valla para el frente
		//el multiparametro genera un arreglo 
		if(numposition[0] > 0 && head != null) {
			int positionForward = numposition[0];

			if(currentPosition == null) {
				currentPosition = head;
				positionForward --;
			}
			while(currentPosition.getNext() != null && positionForward > 0) {
				currentPosition = currentPosition.getNext();
				positionForward --;
			}
		}
	}

	public void insert(T data) {
		
		//
		DNode<T> temporary = new DNode<T>(data);
		
		if(currentPosition == null ) {
			temporary.setNext(head);
			
			if(head != null) {
				head.setPrevious(temporary);
			}
			head = temporary;
		 }else {
			 temporary.setNext(currentPosition.getNext());
			 temporary.setPrevious(currentPosition);
			 
			 if(currentPosition.getNext() != null) {
				currentPosition.getNext().setPrevious(temporary);
			 }
			 currentPosition.setNext(temporary);
		 }
		currentPosition = temporary;
	}
	//triga la informacion, quite el nodo y actualice la informacion
	public T extract() {
		T info = null;
		
		if(currentPosition != null) {
			info = currentPosition.getInfo();
			if(head == currentPosition) {
				head = currentPosition.getNext();
			}else {
				currentPosition.getPrevious().setNext(currentPosition.getNext());
			}
			if(currentPosition.getNext() != null) {
				currentPosition.getNext().setPrevious(currentPosition.getPrevious());
			}
			currentPosition = currentPosition.getNext();
		}
		return info;
	}
	
	public void backward(int ... numPosition) {
		if(numPosition[0] <= 0 || head == null || currentPosition == null) {
			return;
		}
		
		int positionback = numPosition[0];
		while(currentPosition != null && positionback > 0) {
			currentPosition = currentPosition.getPrevious();
			positionback --;
		}
	}
	
	@Override
	public String toString() {
		DNode<T> temporary = head;
		StringBuilder sb = new StringBuilder();
		
		while(temporary != null) {
			sb.append(temporary.getInfo());
			if(temporary.getNext() != null) {
				sb.append("<->");
			}
			temporary = temporary.getNext();
		}
		return sb.toString();
	}


}


