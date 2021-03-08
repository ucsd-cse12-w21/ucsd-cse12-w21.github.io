import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.nio.BufferOverflowException;
import java.util.NoSuchElementException;

import org.junit.Test;
import java.util.*;

public class TestMemoryStream {
	@Test
	public void testMemoryStreamWrite() {
		
		Integer[] testArray = { new Integer(1), new Integer(2), null, null };
		
		MemoryStream<Integer> memoryStream = new MemoryStream<>(4);
		
		memoryStream.write(1);
		memoryStream.write(2);
		//System.out.println(memoryStream);

		assertArrayEquals(testArray, memoryStream.contents);
		assertEquals(2, memoryStream.size);
		//assertEquals(2, memoryStream.back);
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
		
		//System.out.println(memoryStream);
		
		while (memoryStream.hasNext()) {
			memoryStream.next();
		}
		
		assertEquals(0, memoryStream.size);
		
		memoryStream.close();
	}
	
	@Test
	public void testMemoryStreamWrap() {
		Integer[] a = { 5, 2, 4, 1, 7 };
		
		MemoryStream<Integer> memoryStream = new MemoryStream<>(5);
		
		for (Integer i : a) {
			memoryStream.write(i);
		}
		
		//System.out.println(memoryStream);
		
		while (memoryStream.hasNext()) {
			memoryStream.next();
		}
		
		assertEquals(0, memoryStream.size);
		
		memoryStream.close();
	}
	
	@Test
	public void testInputWriteStream() {
		Integer[] a = { 5, 2, 4, 1, 7 };
		
		MemoryStream<Integer> memoryStream = new MemoryStream<>(5);
		
		for (Integer i : a) {
			memoryStream.write(i);
		}
		
		MemoryStream<Integer> stream = new MemoryStream<>(10);
		
		stream.write(memoryStream);
		
		assertEquals(5, stream.size());
		//System.out.println(stream);
		
		memoryStream.close();
		stream.close();
	}
	
	@Test
	public void testOutputReadStream() {
		Integer[] a = { 5, 2, 4, 1, 7 };
		
		MemoryStream<Integer> memoryStream = new MemoryStream<>(5);
		
		for (Integer i : a) {
			memoryStream.write(i);
		}
		
		MemoryStream<Integer> stream = new MemoryStream<>(10);
	
		memoryStream.next(stream);
		
		assertEquals(5, stream.size());
		//System.out.println(stream);
		
		memoryStream.close();
		stream.close();
	}
	
	@Test
	public void testIterator() {

		MemoryStream<Integer> stream = new MemoryStream<>(10);

		for (int i = 0; i < 10; i++) {
			stream.write(i);
		}
		
		//System.out.println("testIterator");
		//System.out.println(stream);
		for (Integer i : stream) {
			//System.out.print(i + " ");
		}
		//System.out.println();
		//System.out.println(stream);
		
		stream.close();
	}
	
	@Test
	public void testPQ() {
		PriorityQueue<Integer> pq = 
				new PriorityQueue<>(Integer::compare);
		
		pq.add(2);
		pq.add(1);
		pq.add(3);
		
		System.out.println("testIterator");
		for (Integer i : pq) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (Integer i : pq) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
