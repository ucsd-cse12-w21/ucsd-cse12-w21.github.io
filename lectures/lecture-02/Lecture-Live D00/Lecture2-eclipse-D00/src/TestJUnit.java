import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestJUnit {

	@Test
	public void testJava1() {

		//assertEquals(true, false);
	}
	
	void helper1() {
		
	}
	
	public void helperTest1() {
		
	}
	
	public int sumNumbers(String input) {
		return 0;
	}
	
	@Test
	public void testTest1() {
		String s = "abc123xyz";
		assertEquals(123, sumNumbers(s));
	}
	
	@Test
	public void testTest2() {
		String s = "aa11b33";
		assertEquals(44, sumNumbers(s));
	}
	
	@Test
	public void testTest3() {
		String s = "7 11";
		assertEquals(18, sumNumbers(s));
	}
	
	@Test
	public void testEmtpyString() {
		String s = "";
		assertEquals(0, sumNumbers(s));
	}
	
	@Test
	public void testNullString() {
		String s = null;
		assertEquals(0, sumNumbers(s));
	}
	
	@Test
	public void testNoNumbers() {
		String s = "abcdefg";
		assertEquals(0, sumNumbers(s));
	}
	
	@Test
	public void testLargeInteger() {
		String s = "123456789";
		assertEquals(123456789, sumNumbers(s));
	}
	
	@Test
	public void test4() {
		String s = "1null2";
		assertEquals(3, sumNumbers(s));
	}
	
	@Test
	public void testBreaks() {
		String s = "20\n\n\n35\n\n\n40";
		assertEquals(95, sumNumbers(s));
	}
	
	@Test
	public void testNegative() {
		String s = "-20";
		assertEquals(20, sumNumbers(s));
	}
	
	@Test
	public void testZeros() {
		String s = "0";
		assertEquals(0, sumNumbers(s));
		
		s = "000000";
		assertEquals(0, sumNumbers(s));
		
		s = "00 00";
		assertEquals(0, sumNumbers(s));
	}
}
