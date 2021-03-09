import java.util.*;
import java.util.function.*;

class AddThree implements Function<Integer, Integer> {
    public Integer apply(Integer value) {
        return value + 3;
    }
}

class ModValue implements Function<Integer, Integer> {
	
	int mod;
	
	public ModValue(int mod) {
		this.mod = mod;
	}
	
    public Integer apply(Integer value) {
        return value % mod;
    }
}

public class Transformed<E> implements Iterable<E> {

	class TransformedIterator implements Iterator<E> {
		
		Iterator<E> iterator = iter.iterator();
		
		public E next() {
			return transformer.apply(this.iterator.next());
		}
		
		public boolean hasNext() {
			return this.iterator.hasNext();
		}
	}
	
	Function<E, E> transformer;
	Iterable<E> iter;
	
	public Transformed(Iterable<E> iter, Function<E, E> f) {
		this.iter = iter;
		this.transformer = f;
	}
	
	public Iterator<E> iterator() {
		return new TransformedIterator();
	}
}
