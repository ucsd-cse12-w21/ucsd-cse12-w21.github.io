import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestLinkedList {

  @Test
  public void testAdd() {
    LList<String> slist = new LinkedList<>();
    slist.prepend("banana");
    slist.prepend("apple");

    assertEquals("banana", slist.get(1));
    assertEquals("apple", slist.get(0));
  }

  @Test
  public void testAddThenSize() {
    LList<String> slist = new LinkedList<>();
    slist.prepend("banana");
    slist.prepend("apple");

    assertEquals(2, slist.size());
  }


  @Test
  public void testAddMany() {
    LList<String> slist = new LinkedList<>();
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
  @Test (expected = IndexOutOfBoundsException.class)
  public void testIndex() {
	  LList<Integer> ref = new LinkedList<>();
	  ref.add(12);
	  ref.get(-2);
  }

}

