import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.util.*;
import java.nio.BufferOverflowException;

public class TestStreams {
	
	@Test
	public void testHeapStreamConstructor() {
		Integer[] a = { 5, 2, 4, 1, 7 };
		
		HeapStream<Integer> heapStream = new HeapStream<>(Integer::compare, a);
		System.out.println(heapStream);
		
		assertEquals(new Integer(1), heapStream.contents.peek());
	}

	@Test
	public void testHeapStreamMultipleReads() {
		Integer[] a = { 5, 2, 4, 1, 7 };
		
		HeapStream<Integer> heapStream = new HeapStream<>(Integer::compare, a);
		//System.out.println(heapStream);
		
		assertEquals(new Integer(1), heapStream.next());
		assertEquals(new Integer(2), heapStream.next());
		assertEquals(new Integer(4), heapStream.next());
		assertEquals(new Integer(5), heapStream.next());
		assertEquals(new Integer(7), heapStream.next());
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testHeapStreamEmpty() {
		Integer[] a = { 5, 2, 4, 1, 7 };
		
		HeapStream<Integer> heapStream = new HeapStream<>(Integer::compare, a);
		
		while (true) {
			heapStream.next();
		}
	}
	
	@Test
	public void testHeapStreamComplete() {
		Integer[] a = { 5, 2, 4, 1, 7 };
		
		HeapStream<Integer> heapStream = new HeapStream<>(Integer::compare, a);
		
		while (heapStream.hasNext()) {
			heapStream.next();
		}
		
		assertEquals(0, heapStream.contents.size());
		
		heapStream.close();
	}
	
	@Test
	public void testHeapStreamWrite() {
		Integer[] a = {  };
		
		HeapStream<Integer> heapStream = new HeapStream<>(Integer::compare, a);
		
		heapStream.write(5);
		heapStream.write(2);
		heapStream.write(4);
		heapStream.write(1);
		heapStream.write(7);
		
		assertEquals(new Integer(1), heapStream.next());
		assertEquals(new Integer(2), heapStream.next());
		assertEquals(new Integer(4), heapStream.next());
		assertEquals(new Integer(5), heapStream.next());
		assertEquals(new Integer(7), heapStream.next());
		
		heapStream.close();
	}
	
	@Test
	public void testMemoryStreamWrite() {
		
		Integer[] testArray = { new Integer(1), new Integer(2), null, null };
		
		MemoryStream<Integer> memoryStream = new MemoryStream<>(4);
		
		memoryStream.write(1);
		memoryStream.write(2);
		System.out.println(memoryStream);

		assertArrayEquals(testArray, memoryStream.contents);
		//assertEquals(2, memoryStream.size);
		assertEquals(2, memoryStream.back);
	}
	
	@Test (expected = BufferOverflowException.class)
	public void testMemoryStreamOverflow() {
		
		MemoryStream<Integer> memoryStream = new MemoryStream<>(1);
		
		memoryStream.write(1);
		memoryStream.write(2);
	}
	
	@Test
	public void testMemoryStreamMultipleReads() {
		Integer[] a = { 5, 2, 4, 1, 7 };
		
		MemoryStream<Integer> memoryStream = new MemoryStream<>(5);
		
		for (Integer i : a) {
			memoryStream.write(i);
		}
		
		assertEquals(new Integer(5), memoryStream.next());
		assertEquals(new Integer(2), memoryStream.next());
		assertEquals(new Integer(4), memoryStream.next());
		assertEquals(new Integer(1), memoryStream.next());
		assertEquals(new Integer(7), memoryStream.next());
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testMemoryStreamEmpty() {
		Integer[] a = { 5, 2, 4, 1, 7 };
		
		MemoryStream<Integer> memoryStream = new MemoryStream<>(5);
		
		for (Integer i : a) {
			memoryStream.write(i);
		}
		
		while (true) {
			memoryStream.next();
		}
	}
	
	@Test
	public void testMemoryStream() {
		Integer[] a = { 5, 2, 4, 1, 7 };
		
		MemoryStream<Integer> memoryStream = new MemoryStream<>(5);
		
		for (Integer i : a) {
			memoryStream.write(i);
		}
		
		System.out.println(memoryStream);
		
		while (memoryStream.hasNext()) {
			memoryStream.next();
		}
		
		assertEquals(5, memoryStream.front);
		
		memoryStream.close();
	}
}
