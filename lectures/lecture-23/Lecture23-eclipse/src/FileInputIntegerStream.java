import java.io.*;
import java.util.*;

public class FileInputIntegerStream implements InputDataStream<Integer> {
	private final static int DEFAULT_CAPCITY = 1024;
	
	MemoryStream<Integer> buffer;
	Scanner scanner;
	
	public FileInputIntegerStream(String filename) throws IOException {
		this.buffer = new MemoryStream<Integer>(DEFAULT_CAPCITY);
		initFile(filename);
	}
	
	public FileInputIntegerStream(String filename, int capacity) throws IOException {
		this.buffer = new MemoryStream<Integer>(capacity);
		initFile(filename);
	}
	
	private void initFile(String filename) throws IOException {
		this.scanner = new Scanner(new File(filename));
	}
	
	private void fill() {
		while (this.scanner.hasNext() &&
			   this.buffer.size() < this.buffer.capacity()) {
			this.buffer.write(this.scanner.nextInt());
		}
	}
	
	public Integer next() {
		if (this.buffer.size() == 0) {
			fill();
		}
		
		if (this.buffer.size() == 0) {
			//no more data to read
			//throw new NoSuchElementException();
			return null;
		}
		
		return this.buffer.next();
	}
	
	public boolean hasNext() {
		return scanner.hasNext() || (this.buffer.size() > 0);
	}
	
	public void close() {
		this.scanner.close();
		this.buffer.close();
	}
	
	public String toString() {
		return this.buffer.toString();
	}
}
