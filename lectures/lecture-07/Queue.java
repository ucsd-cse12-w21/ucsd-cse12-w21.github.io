import java.util.ArrayList;

public interface Queue<E> {
  void enqueue(E element);
  E dequeue();
  int size();
}

// Adapter pattern
class ALQueue<E> implements Queue<E> {

	ArrayList<E> contents;		//<-- use type parameter

	public ALQueue() {			//<-- do not use type parameter
		this.contents = new ArrayList<E>();
	}
	
	public int size() {
		return this.contents.size();
	}

	public void enqueue(E element) {
		//this.contents.add(element);
		this.contents.add(this.contents.size(), element);
	}

	public E dequeue() {
		return this.contents.remove(0);
	}
	
	public String toString() {
		return "front -> " + this.contents.toString() + " <- back";
	}
}
