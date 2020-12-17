class Calendar { /*  */ }

public class Event {

	// Time
	
	//Idea: represent date/time with an int
	int datetime;
	int secondsSinceJanFirst1970;	//long
	
	//Idea: represent date/time with a String
	String dateTime;	//"Jan 7 2019" - look up standard format
	
	//Idea: represent time + duration as TWO TIMES - start/end time
	String start;
	String end;
	
	//Idea: represent time as a new class
	DateTime startTime;		//java has a built one
	DateTime endTime;
	
	// Duration of the event
	int minutes;	
	
	// Location 
	String location;
	float latitude, longitude;
	
	Location location;	
		
	// Determine if two Events conflict
	
}
