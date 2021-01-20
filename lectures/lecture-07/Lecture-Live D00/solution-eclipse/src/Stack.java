import java.util.ArrayList;

public interface Stack<E> {
  void push(E element);
  E pop();
  int size();
}

class ALStack<E> implements Stack<E> {

	ArrayList<E> contents;
	
	public ALStack() {
		this.contents = new ArrayList<E>();
	}

	public void push(E element) {
		this.contents.add(element);
	}
	
	public E pop() {
		return this.contents.remove(this.contents.size() - 1);
	}
	
	public E peek() {
		return this.contents.get(this.contents.size() - 1);
	}
	
	public int size() {
		return this.contents.size();
	}
	
	public String toString() {
		return this.contents.toString() + " <- top";
	}
}
