import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.time.LocalDateTime;

public class EventTestComplete {
  LocalDateTime nine45 = LocalDateTime.of(2018, 1, 10, 9, 45);
  LocalDateTime ten30 = LocalDateTime.of(2018, 1, 10, 10, 30);
  LocalDateTime ten45 = LocalDateTime.of(2018, 1, 10, 10, 45);
  LocalDateTime eleven45 = LocalDateTime.of(2018, 1, 10, 11, 45);

  LocalDateTime farPast = LocalDateTime.of(2017, 1, 10, 9, 45);
  LocalDateTime farFuture = LocalDateTime.of(2020, 1, 10, 10, 45);

  @Test
  public void testBetween() {
    // These are basic tests to make sure that the helper method works as
    // expected. Note how much typing is saved, and how much readability is
    // added, by creating the fields above and re-using them.
    assertEquals(true, EventComplete.between(this.ten30, this.nine45, this.ten45));
    assertEquals(false, EventComplete.between(this.nine45, this.ten30, this.ten45));
    assertEquals(true, EventComplete.between(this.nine45, this.farPast, this.farFuture));
  }

  public void testBetweenInclusiveStartExclusiveEnd() {
    // These three tests help give me confidence that I implemented a between
    // that is *exclusive* on end times but *inclusive* on start times.
    assertEquals(false, EventComplete.between(this.nine45, this.nine45, this.nine45));
    assertEquals(true, EventComplete.between(this.nine45, this.nine45, this.ten30));
    assertEquals(false, EventComplete.between(this.ten30, this.nine45, this.ten30));
  }

  // In each of the following tests, I tried to make the name of the method
  // explain the purpose of the test. In each, I tried both orderings
  // (e1.conflict(e2) and e2.conflict(e1)) because conflicts should be
  // symmetric -- if e1 conflicts with e2 then e2 must conflict with e1.

  @Test
  public void testEventConstructor() {

	EventComplete e1 = new EventComplete(this.nine45, this.ten45, "York 2622");

    assertEquals(this.nine45, e1.start);
    assertEquals(this.ten45, e1.end);
    assertEquals("York 2622", e1.location);
  }

  @Test
  public void testConflictSameTimes() {
	EventComplete e1 = new EventComplete(this.nine45, this.ten45, "11111");
	EventComplete e2 = new EventComplete(this.nine45, this.ten45, "11111");

    assertEquals(true, e1.conflict(e2));
    assertEquals(true, e2.conflict(e1));
  }

  @Test
  public void testConflictSameTimesDifferentLocation() {
    Event e1 = new Event(this.nine45, this.ten45, "Warren");
    Event e2 = new Event(this.nine45, this.ten45, "York");

    assertEquals(false, e1.conflict(e2));
    assertEquals(false, e2.conflict(e1));
  }

  @Test
  public void testConflictContained() {
    Event e1 = new Event(this.nine45, this.ten45, "Warren 2005");
    Event e2 = new Event(this.farPast, this.farFuture, "Warren 2005");

    assertEquals(true, e1.conflict(e2));
    assertEquals(true, e2.conflict(e1));
  }

  @Test
  public void testConflictBackToBack() {
    Event e1 = new Event(this.nine45, this.ten45, "Warren 2005");
    Event e2 = new Event(this.ten45, this.eleven45, "Warren 2005");

    assertEquals(false, e1.conflict(e2));
    assertEquals(false, e2.conflict(e1));
  }

  @Test
  public void testConflictOverlap() {
    Event e1 = new Event(this.nine45, this.ten45, "CSE 260B");
    Event e2 = new Event(this.ten30, this.eleven45, "CSE 260B");

    assertEquals(true, e1.conflict(e2));
    assertEquals(true, e2.conflict(e1));
  }

}
