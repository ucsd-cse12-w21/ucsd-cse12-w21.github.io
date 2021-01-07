public class Human implements Earthling{
	String name;
	int age;
	public void breathe() {
		System.out.println("breath in o2, out co2");
	}
	public String speak() {
		if (age > 2) {
			return "language";
		}
		else {
			return "gibberish";
		}
	}
	public boolean reproduce() {
		return true;
	}
}