package co.edu.unbosque.util;

public class StackImpl <T> implements Stack<T>//pila
{
	
	private DequeList<T> infos;
	
	public StackImpl() {
		infos= new DequeList<>();
	}

	@Override
	public void push(T info) {
		infos.insertFirst(info);
		
	}

	@Override
	public T pop() {
		
		return infos.removeFirst();
	}

	@Override
	public int size() {
		
		return infos.getSize();
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
		sb.append("Top[");
		DNode <T> aux= infos.getHead();
		for(int i=0; i<infos.getSize();i++) {
			sb.append(aux.getInfo());
			if(aux== infos.getTail()) {
				break;
			}
			sb.append("-");
			aux= aux.getNext();
		}
		sb.append("]Bottom");
		return sb.toString();
	}

}
