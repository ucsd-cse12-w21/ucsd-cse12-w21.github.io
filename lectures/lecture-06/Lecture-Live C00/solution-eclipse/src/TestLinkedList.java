import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestLinkedList {

  @Test
  public void testAdd() {
    LList<String> slist = new LList<String>();
    slist.prepend("banana");
    slist.prepend("apple");

    assertEquals("banana", slist.get(1));
    assertEquals("apple", slist.get(0));
  }

  @Test
  public void testAddThenSize() {
    LList<String> slist = new LList<String>();
    slist.prepend("banana");
    slist.prepend("apple");

    assertEquals(2, slist.size());
  }


  @Test
  public void testAddMany() {
    LList<String> slist = new LList<String>();
    slist.add("a");
    slist.add("b");
    slist.add("c");
    slist.add("d");
    slist.add("e");

    assertEquals("e", slist.get(4));
    assertEquals("d", slist.get(3));
    assertEquals("c", slist.get(2));
    assertEquals("b", slist.get(1));
    assertEquals("a", slist.get(0));

  }
  

  @Test
  public void testAddManyIntegers() {
    LList<Integer> slist = new LList<Integer>();
    slist.add(1);
    slist.add(2);
    slist.add(3);
    slist.add(4);
    slist.add(5);

    assertEquals(5, (int) slist.get(4));
    assertEquals(new Integer(5), slist.get(4));
    assertEquals(new Integer(4), slist.get(3));
    assertEquals(new Integer(3), slist.get(2));
    assertEquals(new Integer(2), slist.get(1));
    assertEquals(new Integer(1), slist.get(0));

  }
  
  @Test(expected = IndexOutOfBoundsException.class)
  public void testNegativeIndex() {
    List<String> slist = new LList<String>();
    slist.add("banana");
    slist.get(-1);
  }


}

