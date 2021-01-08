import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestJUnit {
		
	@Test
	public void testQuestion1() {
		
		//assertEquals(true, false);
	}
	
	private void helper() {
		
	}
	
	public void otherHelper() {
		
	}

	public int sumNumbers(String input) {
		return 0;
	}
	
	@Test
	public void testNull() {
		String s = null;		
		assertEquals(0, sumNumbers(s));
	}
	
	@Test
	public void testEmptyString() {
		String s = "";		
		assertEquals(0, sumNumbers(s));
	}
	
	@Test
	public void testString1() {
		String s = "abc123xyz";		
		assertEquals(123, sumNumbers(s));
	}

	@Test
	public void testString2() {
		String s = "aa11b33";		
		assertEquals(44, sumNumbers(s));
	}

	@Test
	public void testString3() {
		String s = "7 11";		
		assertEquals(18, sumNumbers(s));
	}
	
	@Test
	public void testZero() {
		String s = "0";		
		assertEquals(0, sumNumbers(s));

		s = "0 0 0 0";		
		assertEquals(0, sumNumbers(s));

		s = "00 00";		
		assertEquals(0, sumNumbers(s));
	}
	
	@Test
	public void testAllNumbers() {
		String s = "123456789";		
		assertEquals(123456789, sumNumbers(s));
	}
	
	@Test
	public void testNumbersBeg() {
		String s = "123 abc def";		
		assertEquals(123, sumNumbers(s));
	}
	
	@Test
	public void testNumbersEnd() {
		String s = "abc def 123";		
		assertEquals(123, sumNumbers(s));
	}
	
	public void test4() {
		String s = "123 abc def 123";		
		assertEquals(246, sumNumbers(s));
	}

	@Test
	public void testAllLetters() {
		String s = "abcdedfghib";		
		assertEquals(0, sumNumbers(s));
	}
}
