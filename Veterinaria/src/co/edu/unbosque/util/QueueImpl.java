package co.edu.unbosque.util;

import java.io.Serializable;

public class QueueImpl <T> implements Queue<T>, Serializable //cola
{
	private static final long serialVersionUID = 1L;
	private DequeList<T> infos;
	
	public QueueImpl() {
		
		infos= new DequeList<T>();
	}

	@Override
	public void enqueue(T info) {
		infos.insertFirst(info);
		
	}

	@Override
	public T dequeue() {
		
		return infos.removeLast();
	}

	@Override
	public int size() {
		return infos.size();
	}

	@Override
	public T peek() {
		T temp = infos.removeFirst();
		infos.insertFirst(temp);
		return temp;
	}
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append("Back[");
		DNode <T> aux= infos.getHead();
		for(int i=0; i<infos.getSize();i++) {
			sb.append(aux.getInfo());
			if(aux== infos.getTail()) {
				break;
			}
			sb.append("-");
			aux= aux.getNext();
		}
		sb.append("]Front");
		return sb.toString();
	}

}
