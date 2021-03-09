import java.util.*;
import java.io.*;

public class FileOutputIntegerStream implements OutputDataStream<Integer>{
	private final static int DEFAULT_CAPCITY = 1024;

	Integer[] buffer;
	int size = 0;
	Writer writer;
	
	public FileOutputIntegerStream(String filename) throws IOException {
		this.buffer = new Integer[DEFAULT_CAPCITY];
		initFile(filename);
	}
	
	public FileOutputIntegerStream(String filename, int capacity) throws IOException {
		this.buffer = new Integer[capacity];
		initFile(filename);
	}
	
	private void initFile(String filename) throws IOException {
		writer = new FileWriter(filename);
	}
	
	public void flush() {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < size; i++) {
			sb.append(this.buffer[i]);
			sb.append(' ');			//add delimiter
			this.buffer[i] = null;	//remove reference
		}
		
		try {
			writer.write(sb.toString());
			writer.flush();
		}
		catch (IOException ex) {
			throw new RuntimeException();
		}
		
		this.size = 0;		
	}
	
	public void write(Integer data) {
		if (this.size == this.buffer.length) {
			this.flush();
		}
		
		this.buffer[this.size] = data;
		this.size++;
	}

	public void close() {
		try {
			this.flush();
			writer.close();
		}
		catch (IOException ex) {
			throw new RuntimeException();
		}
	}
	
	public String toString() {
		return Arrays.deepToString(this.buffer);
	}
}
