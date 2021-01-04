import java.time.LocalDateTime;

public class Event {
  LocalDateTime start;
  LocalDateTime end;
  String location;

  public Event(LocalDateTime start, LocalDateTime end, String location) {
    this.start = start;
    this.end = end;
    this.location = location;
  }

  // Return true if the other event is in 
  // the same room at an overlapping time
  public boolean conflict(Event other) {
	  
	  if (!location.equals(other.location)) { return false; }
	  
	  if ((this.start.compareTo(other.start) <= 0) &&
	  	  (this.end.compareTo(other.start) > 0))
	  {
		  return true;
	  }
	  
	  
	  return false;
  }
}
