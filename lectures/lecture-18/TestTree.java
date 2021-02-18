
public class TestTree {
	public static void main(String[] args) {
		
		Node<String, Integer> node1 =
		  new Node<>("a", 10,
		    new Node<>("c", 80,
		      new Node<>("b", 200, null, null),
		      new Node<>("g", 200, null, null)),
		    null);
		
		Node<String, Integer> node2 =
		  new Node<>("a", 10,
		    null,
		    new Node<>("c", 80,
		      new Node<>("b", 200, null, null),
		      new Node<>("g", 200, null, null)));
		
		Node<String, Integer> node3 =
		  new Node<>("a", 10,
		    new Node<>("c", 80,
		      new Node<>("b", 200, null, null),
		      null),
		    new Node<>("g", 200, null, null));
		
		Tree<String, Integer> t = new Tree<>(node1);
		System.out.println(node1);
		//System.out.println(t.countNodes());
		
		System.out.println(t.get("a"));
		System.out.println(t.get("b"));
		System.out.println(t.get("g"));
		System.out.println(t.get("c"));
		System.out.println(t.get("not here"));
	}
}
