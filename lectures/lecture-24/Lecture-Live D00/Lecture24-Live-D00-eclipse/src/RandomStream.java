import java.util.*;

public class RandomStream implements Iterable<Integer> {

	Random random;
	int bound;
	int size;
	
	class RandomIterator implements Iterator<Integer> {
		
		//instance variables
		int current = 0;
		
		public Integer next() {
			int value = random.nextInt(bound);
			this.current += 1;
			return value;
		}
		
		public boolean hasNext() {
			return this.current < size;
		}
	}
	
	public RandomStream(int size, int bound) { 
		this.random = new Random();
		this.size = size;
		this.bound = bound;
	}
	
	public Iterator<Integer> iterator() {
		return new RandomIterator();
	}
	
	public static void main(String[] args) {
		RandomStream r = new RandomStream(10, 100);
		
		for (Integer i : r) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (Integer i : r) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
