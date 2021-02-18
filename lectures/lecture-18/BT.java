import java.util.*;

class Node<K,V> {
  K key;
  V value;
  Node<K,V> left;
  Node<K,V> right;
  public Node(K key, V value, Node<K,V> left, Node<K,V> right) {
    this.key = key;
    this.value = value;
    this.left = left;
    this.right = right;
  }
  public String toString() {
    String children = "";
    if(left != null || right != null) {
      children = ", " + left + ", " + right;
    }
    return "(" + key + ": " + value + children + ")";
  }
}

class Tree<K,V> {
  Node<K,V> root;
  Tree() { this.root = null; }
  Tree(Node<K,V> root) { this.root = root; }

  int countNodes(Node<K,V> node) {
	  if (node == null) { return 0; }
	  return 1 + countNodes(node.left) + countNodes(node.right);
  }

  int countNodes() {
	  return this.countNodes(this.root);
  }

  V get(Node<K,V> node, K key) {
	  if (node == null) { return null; }
	  
	  if (node.key.equals(key)) { return node.value; }
	  
	  V leftResult = get(node.left, key);
	  V rightResult = get(node.right, key);
	  
	  if (leftResult != null) { return leftResult; }
	  if (rightResult != null) { return rightResult; }
	  
	  return null;
  }

  V get(K key) {
	  return this.get(this.root, key);
  }
}






class BST<K,V> {
  Node<K,V> root;
  
  BST() {
    this.root = null;
  }
  
  BST(Node<K,V> root) {
    this.root = root;
  }













  V get(K key) {
    return null;




  }




















  void set(K key) {




  }

}
