import java.util.*;
import java.nio.BufferOverflowException;

public class MemoryStream<E> implements OutputDataStream<E>, 
								        InputDataStream<E> {
	private final static int DEFAULT_CAPCITY = 1024;
	E[] contents;
	int back = 0;
	int front = 0;
    int size = 0;//something to help detect over/under flow
	
	@SuppressWarnings("unchecked")
	public MemoryStream() {
		this.contents = (E[]) new Object[DEFAULT_CAPCITY];		
	}
	
	@SuppressWarnings("unchecked")
	public MemoryStream(int capacity) {
		this.contents = (E[]) new Object[capacity];		
	}
	
	public void write(E data) {
		if (this.size == contents.length) {
			throw new BufferOverflowException();
		}
		
		this.contents[this.back] = data;
		this.back++;
        this.back %= this.contents.length;
        this.size++;
	}
	
	@SuppressWarnings("unchecked")
	public void close() {
		this.back = 0;
		this.front = 0;
        this.size = 0;
		this.contents = (E[]) new Object[this.contents.length];		
	}
	
	public E next() {
		if (this.size == 0) {
			throw new NoSuchElementException();
		}
		
		E temp = this.contents[this.front];
		this.front++;
        this.front %= this.contents.length;
        this.size--;
		return temp;
	}
	
	public boolean hasNext() {
		return this.size > 0;
	}
	
	public String toString() {
		return Arrays.deepToString(this.contents);
	}
}
