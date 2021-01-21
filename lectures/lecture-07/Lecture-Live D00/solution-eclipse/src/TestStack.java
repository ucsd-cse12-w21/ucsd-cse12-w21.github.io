
public class TestStack {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new ALStack<Integer>();
		
		stack.push(4);
		stack.push(10);
		stack.push(19);
		
		System.out.println(stack);
		
		System.out.println(stack.pop());
		System.out.println(stack);
				
	}
}
