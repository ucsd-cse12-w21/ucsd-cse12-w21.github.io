import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestList {

  @Test(expected = IndexOutOfBoundsException.class)
  public void testNegativeIndex() {
    List<String> slist = new LList<String>();
    slist.add("banana");
    slist.get(-1);
  }	

  @Test
  public void testNegativeIndexTC() {
	List<String> slist = new LList<String>();
	slist.add("banana");
	
	try
	{
	  slist.get(-1);
	  fail();
	}
	catch (IndexOutOfBoundsException e) {
		//this is what I expect
	}
  }	
  
  @Test
  public void testAdd() {
    List<String> slist = new LList<String>();
    slist.add("banana");
    slist.add("apple");

    assertEquals("banana", slist.get(0));
    assertEquals("apple", slist.get(1));
  }

  @Test
  public void testAddThenSize() {
    List<Integer> ilist = new LList<Integer>();
    ilist.add(500);
    ilist.add(12);

    assertEquals(2, ilist.size());
  }

  @Test
  public void testListOfLists() {

	List<List<String>> bllist = new LList<List<String>>();		//E

    bllist.add(new LList<String>());
    bllist.add(new LList<String>());
    bllist.get(0).add("a");
    bllist.get(0).add("b");
    bllist.get(1).add("c");
    bllist.get(1).add("d");
    bllist.get(1).add("e");

    assertEquals("a", bllist.get(0).get(0));
    assertEquals("b", bllist.get(0).get(1));
    assertEquals("c", bllist.get(1).get(0));
    assertEquals("d", bllist.get(1).get(1));
    assertEquals("e", bllist.get(1).get(2));
  }
}
