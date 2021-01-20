import java.util.ArrayList;

public interface Stack<E> {
  void push(E element);
  E pop();
  int size();
}

class ALStack<E> implements Stack<E> {
	private ArrayList<E> contents;
	
	public ALStack() {
		contents = new ArrayList<E>();
	}
	public void push(E element) {
		contents.add(element);
		
	}
	public E pop() {
		E ref = contents.remove(contents.size()-1);
		return ref;
	}
	public int size() {
		return contents.size();
	}

	public String toString() {
		return "top -> " + this.contents.toString();
	}	
}
