import static org.junit.Assert.*;
import org.junit.Test;
public class TestProgram{
	@Test
	public void testSumNumbers() {
		
		assertEquals("no digits", null, Program.sumNumbers("abc"));
		assertEquals("two numbers", new Integer(456), Program.sumNumbers("abc123cde333dd"));
		assertEquals("two numbers on both ends", new Integer(456), Program.sumNumbers("123cde333"));
		assertEquals("one number", new Integer(1234), Program.sumNumbers("1234"));
		assertEquals("two numbers with trailing letters", new Integer(456), Program.sumNumbers("123cde333dd"));
		assertEquals("three numbers", new Integer(777), Program.sumNumbers("123c321d333"));	
	}
	
	@Test
	public void testEvenOdd() {
		assertArrayEquals("null", null, Program.evenOdd(null));
		assertArrayEquals("empty array", null, Program.evenOdd(new int[0]));
		assertArrayEquals("all even", new int[] {2, 2, 4}, Program.evenOdd(new int[] {2, 2, 4}));		
		assertArrayEquals("all odd", new int[] {3, 3, 5}, Program.evenOdd(new int[] {3, 3, 5}));
		assertArrayEquals("mixed", new int[] {2, 4, 6, 1, 3, 5}, Program.evenOdd(new int[] {1, 3, 5, 2, 4, 6}));
		assertArrayEquals("mixed-2", new int[] {2, 4, 6, 1, 3, 5}, Program.evenOdd(new int[] {1, 2, 3, 4, 5, 6}));

	}
}

