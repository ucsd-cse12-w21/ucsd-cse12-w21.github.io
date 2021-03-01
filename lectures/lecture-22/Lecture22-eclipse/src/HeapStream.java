import java.util.*;

public class HeapStream<E> implements InputDataStream<E>, OutputDataStream<E> {
	PriorityQueue<E> contents;
	
	public HeapStream(Comparator<? super E> comparator) {
		this.contents = new PriorityQueue<E>(comparator);
	}
	
	public HeapStream(Comparator<? super E> comparator, E[] data) {
		this.contents = new PriorityQueue<E>(comparator);
		fill(data);
	}
	
	private void fill(E[] data) {
		for (E element : data) {
			this.contents.add(element);
		}
	}
	
	public E next() {
		if (this.contents.size() == 0) {
			throw new NoSuchElementException();
		}
		
		return this.contents.poll();
	}
	
	public boolean hasNext() {
		return this.contents.size() > 0;
	}
	
	public void close() {
		
	}
	
	public void write(E data) {
		this.contents.add(data);
	}
	
	public String toString() {
		return this.contents.toString();
	}
}
