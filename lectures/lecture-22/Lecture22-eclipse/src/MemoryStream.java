import java.util.*;
import java.nio.BufferOverflowException;

public class MemoryStream<E> implements OutputDataStream<E>, 
								        InputDataStream<E> {
	private final static int DEFAULT_CAPCITY = 1024;
	E[] contents;
	int back = 0;
	int front = 0;
	
	@SuppressWarnings("unchecked")
	public MemoryStream() {
		this.contents = (E[]) new Object[DEFAULT_CAPCITY];		
	}
	
	@SuppressWarnings("unchecked")
	public MemoryStream(int capacity) {
		this.contents = (E[]) new Object[capacity];		
	}
	
	public void write(E data) {
		if (this.back == this.contents.length) {
			throw new BufferOverflowException();
		}
		
		this.contents[this.back]= data;
		this.back++;
	}
	
	@SuppressWarnings("unchecked")
	public void close() {
		this.back = 0;
		this.front = 0;
		this.contents = (E[]) new Object[this.contents.length];		
	}
	
	public E next() {
		if (this.back == this.front) {
			throw new NoSuchElementException();
		}
		
		E temp = this.contents[this.front];
		this.front++;
		return temp;
	}
	
	public boolean hasNext() {
		return this.back != this.front;
	}
	
	public String toString() {
		return Arrays.deepToString(this.contents);
	}
}
