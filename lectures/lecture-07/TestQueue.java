
public class TestQueue {

	public static void main(String[] args) {
		
		Queue<Integer> queue = new ALQueue<Integer>();
		
		queue.enqueue(4);
		queue.enqueue(10);
		queue.enqueue(19);
		
		System.out.println(queue);
	}
}
