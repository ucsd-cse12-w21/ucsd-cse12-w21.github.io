import java.util.*;
import java.nio.BufferOverflowException;

public class MemoryStream<E> implements OutputDataStream<E>, 
								        InputDataStream<E> {
	private final static int DEFAULT_CAPCITY = 1024;
	E[] contents;
	int size = 0;
	int start = 0;
	
	@SuppressWarnings("unchecked")
	public MemoryStream() {
		this.contents = (E[]) new Object[DEFAULT_CAPCITY];		
	}
	
	@SuppressWarnings("unchecked")
	public MemoryStream(int capacity) {
		this.contents = (E[]) new Object[capacity];		
	}
	
	private int indexFor(int index) {
		return (this.start + index) % this.contents.length;
	}
	
	public void write(E data) {
		if (this.size == this.contents.length) {
			throw new BufferOverflowException();
		}
		
		this.contents[this.indexFor(this.size)] = data;
		this.size++;
	}
	
	@SuppressWarnings("unchecked")
	public void close() {
		this.size = 0;
		this.start = 0;
		this.contents = (E[]) new Object[this.contents.length];		
	}
	
	public E next() {
		if (this.size == 0) {
			throw new NoSuchElementException();
		}
		
		E temp = this.contents[this.start];
		this.contents[this.start] = null;	//remove reference
		this.start++;
		this.start %= this.contents.length;	//wrap around
		this.size--;
		
		return temp;
	}
	
	public boolean hasNext() {
		return this.size != 0;
	}
	
	public String toString() {
		return Arrays.deepToString(this.contents);
	}
}
