import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.time.LocalDateTime;

public class EventTest {

	@Test
	public void testEventConstructor() {
		LocalDateTime s1 = LocalDateTime.of(2020, 10, 1, 9, 45);
		LocalDateTime s2 = LocalDateTime.of(2020, 10, 1, 10, 45);
		
		Event e1 = new Event(s1, s2, "WLH 2005");
		
		assertEquals(e1.start, s1);
		assertEquals(e1.end, s2);
		assertEquals(e1.location, "WLH 2005");
	}

	@Test
	public void testConflict() {
		LocalDateTime s1 = LocalDateTime.of(2020, 10, 1, 9, 45);
		LocalDateTime s2 = LocalDateTime.of(2020, 10, 1, 10, 45);
		
		LocalDateTime longAgo = LocalDateTime.of(2019, 10, 1, 9, 45);
		LocalDateTime inTheFuture = LocalDateTime.of(2021, 10, 1, 10, 45);
				
		Event e1 = new Event(s1, s2, "WLH 2005");
		Event e2 = new Event(longAgo, inTheFuture, "WLH 2005");
		
		assertEquals(e1.conflict(e2), true);
		
		//event completely outside another event
		//event completely contained within an event
		//events in different places
	}
}
