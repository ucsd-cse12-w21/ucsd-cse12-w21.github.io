import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;

public class TestIterator {

	@Test
	public void testIterartor() {
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("a");
		list.add("b");
		list.add("c");

		Iterator<String> iter = list.iterator();
		System.out.println(iter);
		
		//System.out.println(iter.next());

		//list.add("d");
		//list.set(1, "zzzzz");
		
		//System.out.println(iter.next());
		
		
		
		//Iterator<String> iter2 = list.iterator();
		//System.out.println(iter2.next());
		//System.out.println(iter2.next());
		
		AList<Integer> a = new AList<Integer>();
		//a.add(1);
		//a.add(2);
		//a.add(3);
		
		Iterator<Integer> iter1 = a.iterator();
		System.out.println(iter1);
		//System.out.println(iter1.next());
		//System.out.println(iter1.next());
		//System.out.println(iter1.next());
		//System.out.println(iter1.next());
		
		//for (Integer i : a) {
		//	System.out.println(i);
		//}
	}
	
}
