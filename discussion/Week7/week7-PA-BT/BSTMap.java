package ucsdcse12pa7student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Queue;

class StringComparator implements Comparator<String> {
	public int compare(String s1, String s2) { return s1.compareTo(s2); }
}

//==================================================================================================
// NODE CLASS
//==================================================================================================

/**
 * The Node class will hold all the contents for a BSTMap
 *
 * @param <K>
 * @param <V>
 */
 class Node<K, V> {
   K key;
	 V value;
	 Node<K, V> left, right;

	public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

//==================================================================================================
// ENTRY CLASS
//==================================================================================================

/**
 * This class is for use in the return of .entries()
 *
 * @param <K>
 * @param <V>
 */
class Entry<K,V> {
	K key; V value;
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
}

//==================================================================================================
// BSTMAP CLASS
//==================================================================================================
public class BSTMap<K, V> implements OrderedDefaultMap<K, V> {

	public Node<K, V> root;
	int size;
	public Comparator<K> comparator;
	V defaultValue;

	public BSTMap(Comparator<K> comparator, V defaultValue) {
		this.root = null;
		this.size = 0;
		this.comparator = comparator;
		this.defaultValue = defaultValue;
	}

	public BSTMap(Comparator<K> comparator) {
		this.root = null;
		this.size = 0;
		this.comparator = comparator;
		this.defaultValue = null;
	}

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public V defaultValue() {
    return this.defaultValue;
  }

  //================================================================================================
  // containsKey
  //================================================================================================
	boolean containsKey(Node<K, V> node, K k) {
		if (node == null) {
			return false;
		}
		if (this.comparator.compare(node.key, k) < 0) {
			return containsKey(node.right, k);
		} else if (this.comparator.compare(node.key, k) > 0) {
			return containsKey(node.left, k);
		} else {
			return true;
		}
	}
	@Override
	public boolean containsKey(K key) {
		return this.containsKey(this.root, key);
	}

  //================================================================================================
  // Keys
  //================================================================================================

	@Override
	public List<K> keys() {
		// TODO: must be implemented by student for this to compile
		return null;
	}

  //================================================================================================
  // Values
  //================================================================================================

	@Override
	public List<V> values() {
		// TODO: must be implemented by student for this to compile
		return null;
	}

  //================================================================================================
  // get
  //================================================================================================

	/**
	 * Internal helper method for get
	 *
	 * Recursive on the node argument. Throws NoSuchElementException if the key is
	 * not found in the tree and the defaultValue is null, returns the defaultValue
	 * if it is defined.
	 *
	 * @param node
	 * @param k
	 * @return
	 */
	V get(Node<K, V> node, K k) {
		if (node == null) {
			if(this.defaultValue == null) {
				throw new NoSuchElementException(k.toString());
			}
			else {
				return this.defaultValue();
			}
		}
		if (this.comparator.compare(node.key, k) < 0) {
			return get(node.right, k);
		} else if (this.comparator.compare(node.key, k) > 0) {
			return get(node.left, k);
		} else {
			return node.value;
		}
	}

	@Override
	public V get(K key) {
		return this.get(this.root, key);
	}

  //================================================================================================
  // set
  //================================================================================================
	/**
	 * Internal helper method for set.
	 *
	 * Recursive on the node argument. Returns a new node if it reaches a leaf,
	 * indicating that the key is not yet in the tree, otherwise it returns a
	 * reference to the Node that was passed in (after changing it).
	 *
	 * @param node
	 * @param key
	 * @param value
	 * @return
	 */
	Node<K, V> set(Node<K, V> node, K key, V value) {
		if (node == null) {
			this.size += 1;
			return new Node<K, V>(key, value, null, null);
		}
		if (this.comparator.compare(node.key, key) < 0) {
			node.right = this.set(node.right, key, value);
			return node;
		} else if (this.comparator.compare(node.key, key) > 0) {
			node.left = this.set(node.left, key, value);
			return node;
		} else {
			node.value = value;
			return node;
		}
	}

	@Override
	public void set(K key, V value) {
		if (key == null) {
			throw new IllegalArgumentException();
		}
		this.root = this.set(this.root, key, value);
	}

	//Assumes a binary tree (not necessarily a BST)
	//Binary search would make more sense than BFS for a BST
	V BFS(K key){
		if(key == null){
			throw new IllegalArgumentException();
		}

		// Nodes visited by BFS
		Queue<Node<K,V>> queue = new LinkedList<>();
		queue.add(this.root);

		while(!queue.isEmpty()){
			Node<K, V> current = queue.remove();

			// If the key is found, return its node it
			if (current.key.equals(key)) {
				System.out.println("Found key: " + current.key);
				this.size--;
				return current.value;
			}

			// Add left child of current node
			if(current.left != null){
				queue.add(current.left);
			}
			// Add right child of current node
			if(current.right != null){
				queue.add(current.right);
			}
		}
		// Key to remove was not found
		throw new NoSuchElementException();
	}

	// For when our key has a left child
	// Replace our key's node with the smallest node in this left subtree
	public void replaceNodeWithLeftSubtreeMinimum(Node<K, V> nodeToReplace, Node<K, V> leftChild, Node<K, V> parent){
		// keep going left as much as possible
		while (leftChild.left != null){
			parent = parent.left;
			leftChild = leftChild.left;
		}

		nodeToReplace.key = leftChild.key;
		nodeToReplace.value = leftChild.value;

		if(leftChild.right != null){
			parent.left = leftChild.right;
		}
		else{
			parent.left = null;
		}
	}

	// For when our key has a right child, but no left
	// Replace our key's node with the smallest node in this right subtree
	public void replaceNodeWithRightSubtreeMinimum(Node<K, V> nodeToReplace, Node<K, V> rightChild, Node<K,V> parent){
		if(rightChild.left != null){
			Node<K, V> leftChild = rightChild.left;
			parent = rightChild;

			while (leftChild.left != null){
				parent = parent.left;
				leftChild = leftChild.left;
			}

			nodeToReplace.key = leftChild.key;
			nodeToReplace.value = leftChild.value;

			if(leftChild.right != null){
				parent.left = leftChild.right;
			}
			else {
				leftChild = null;
			}
		}
	    else {
  			nodeToReplace.key = rightChild.key;
  			nodeToReplace.value = rightChild.value;
  			parent.right = null;
	    }
		return;
	}

	// For when our key has no left nor right child (is a leaf node)
	// Replace our key's node with null
	public void removeLeafNode(Node<K,V> nodeToRemove, Node<K,V> previous){

		if(previous == null){
			this.root = null;
		}
		if(nodeToRemove.key.equals(previous.left.key)){
			previous.left = null;
		}
		else{
			previous.right.key = null;
		}
	}

	// Use BFS with a queue worklist to find key to remove, then remove its node from the map
	public void removeIteratively(K keyToRemove){
		if(keyToRemove == null){
			return;
		}

		// Nodes visited by BFS
		Queue<Node<K,V>> queue = new LinkedList<>();
		queue.add(this.root);

		// Parent nodes of nodes visited by BFS
		Queue<Node<K, V>> previousNodes = new LinkedList<>();
		previousNodes.add(null);

		while(!queue.isEmpty()){
			Node<K, V> current = queue.remove();
			Node<K, V> previous = previousNodes.remove();

			// If the key is found, remove it
			if (current.key.equals(keyToRemove)) {
				this.size--;

				// if keyToRemove is the only node in the map
				if(this.size()<1){
					this.root = null;
					return;
				}

				/* We want to replace the node that our keyToRemove belongs to
				 * with the next smallest value (smallest key that is larger than
				 * our key). There are three possible cases we may have:
				 *
				 * 	1) Our keyToRemove belongs to a node with two children
				 *  2) Our keyToRemove belongs to a node with one child
				 *  3) Out keyToRemove belongs to a node with no children (is a leaf node)
				 *
				 *  We first check if a left subtree exists. If so, find the minimum key
				 *  in this left subtree and replace our keyToRemove's node with it.
				 *
				 *  If not, then we check if a right subtree exists. If so, find the
				 *  minimum key in this right subtree and replace our keyToRemove's
				 *  node with it.
				 *
				 *  If not, our keyToRemove belongs to a leaf node, which we simply
				 *  want to remove by having its parent node have null instead of this
				 *  node as a child (left or right child, depending on which case we have).
				 */

				Node<K, V> parent = current;
				Node<K, V> leftChild = current.left;
				Node<K, V> rightChild = current.right;

				// our key to remove has a left node
				// replace our key's node with the smallest node in this left subtree
				if(leftChild != null){
					this.replaceNodeWithLeftSubtreeMinimum(current, leftChild, parent);
				}

				// our key to remove has no left child, but a right child
				// replace our key's node with the smallest node in this right subtree
				else if (rightChild != null){
					this.replaceNodeWithRightSubtreeMinimum(current, rightChild, parent);
				}

				// our key to remove is a leaf node
				// replace our key's node with null
				else{
					removeLeafNode(current, previous);
				}
				return;
			}

			// Add left child of current node
			if(current.left != null){
				queue.add(current.left);
				previousNodes.add(current);
			}
			//Add right child of current node
			if(current.right != null){
				queue.add(current.right);
				previousNodes.add(current);
			}
		}
		// Key to remove was not found
		throw new NoSuchElementException(keyToRemove.toString());
	}
	
	// Used in the method below to find the node with the minimum
	// key in a subtree
    Node<K, V> nodeWithMinimumKey(Node<K, V> root){ 
    	Node<K, V> minimum = root; 
        while (root.left != null){ 
            minimum = root.left; 
            root = root.left; 
        } 
        return minimum; 
    }

	public Node<K, V> removeRecursively(Node<K, V> node, K keyToRemove) throws NoSuchElementException {
		// If tree is empty
	    if (node == null) {
	    	return null;
	    }
	    
	    int compared = this.comparator.compare(node.key, keyToRemove);
	    if (compared > 0) {
	    	System.out.println("Calling remove on left child: <" + node.key + ", " + node.value + ">");
	    	node.left = removeRecursively(node.left, keyToRemove);
	    } else if (compared < 0){
	    	System.out.println("Calling remove on right child: <" + node.key + ", " + node.value + ">");
	    	node.right = removeRecursively(node.right, keyToRemove);
	    }else {
	    	System.out.println("We found the key we're looking for: <" + node.key + ", " + node.value + ">");
	    	
	    	// Case: node with only one child or no children
	    	if (node.left == null){
	    		return node.right;
	    	} else if (node.right == null){
	    		return node.left;
	    	}
	
	      // Case: node with two children
	      // Get minimum from right subtree, then remove it
	      Node<K, V> nextLargest = nodeWithMinimumKey(node.right);
	      node.key = nextLargest.key;
	      node.value = nextLargest.value;
	
	      // Remove nextLargest node
	      node.right = removeRecursively(node.right, node.key);
	    }
	    return node;
	}

	// This calls the above method to recursively remove a key. If the number of
	// keys in the map afterwards is the same, we did not find our key, so we
	// throw a NoSuchElementException. Otherwise, we decrement the size of the map.
	public void removeRecursively(K keyToRemove) throws NoSuchElementException{
		int beginningSize = this.keys().size();
		this.root = removeRecursively(this.root, keyToRemove);
		if(beginningSize == this.keys().size()){
			throw new NoSuchElementException();
		}
		this.size--;
	}

  //================================================================================================
  // Printing helper methods
  //================================================================================================
	public void printEntries(){
		List<K> keys = this.keys();
		System.out.print("Entries in map: [ ");
		for(int i = 0; i < keys.size(); i++){
			System.out.print("<" + keys.get(i) + ", " + this.get(keys.get(i)) + "> ");
		}
		System.out.println("]\n");
	}

  public void setEntries(BSTMap<String, Integer> myMap, String[] keysToAdd) {
	  for(int i = 0; i < keysToAdd.length; i++) {
		  myMap.set(keysToAdd[i], i+1);
	  }
	  myMap.printEntries();
  }

  public static void printSectionHeading(String section) {
	  System.out.println("=======================================================================");
	  System.out.println(section);
	  System.out.println("=======================================================================");
  }

  //================================================================================================
  // Main
  //================================================================================================
  public static void main (String[] args){
	Comparator<String> c = new StringComparator();
	BSTMap<String, Integer> myMap = new BSTMap<String,Integer>(c, null);

    //==============================================================================================
		// Remove WITHOUT recursion
    //==============================================================================================
    printSectionHeading("Remove WITHOUT recursion");

    // add k|v pairs
    String[] arr1 = { "q", "f", "w", "b", "c"};
    myMap.setEntries(myMap, arr1);

    // remove k|v pairs WITHOUT recursion
    String[] arr2 = { "b", "c", "q", "f", "w"};
    for(int i = 0; i < arr2.length; i++) {
    	System.out.println("Attempting to remove \""+ arr2[i] +"\"");
  		myMap.removeIteratively(arr2[i]);
  		myMap.printEntries();
    }

    //==============================================================================================
		// Remove WITH recursion
    //==============================================================================================
    printSectionHeading("Remove WITH recursion");

    // add k|v pairs
    myMap.setEntries(myMap, arr2);

    // remove k|v pairs
    for(int i = 0; i < arr2.length; i++) {
    	System.out.println("Attempting to remove \""+ arr2[i] +"\"");
    	myMap.removeRecursively(arr2[i]);
    	myMap.printEntries();
    }

    //==============================================================================================
    // Try out BFS
    //==============================================================================================
    printSectionHeading("Find with BST");

    // add k|v pairs
    myMap.setEntries(myMap, arr1);
    int val = myMap.BFS("w");
    System.out.println("Found value for w: " + val);
  }
}
