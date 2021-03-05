import java.util.*;

public class Range implements Iterable<Integer> {

	class RangeIterator implements Iterator<Integer> {
		int current;
		
		public RangeIterator(int start) {
			this.current = start;
		}
		
		public Integer next() {
			int currentVal = this.current;
			this.current += 1;
			return currentVal;
		}
		
		public boolean hasNext() {
			return this.current < high;		//exclusive
			//return this.current <= high;	//inclusive
		}
	}
	
	public Range(int low, int high) {
		this.low = low;
		this.high = high;
	}
	
	int low, high;
	
	public Iterator<Integer> iterator() {
		return new RangeIterator(this.low);
	}
}
