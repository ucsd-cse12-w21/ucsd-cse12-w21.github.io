class Node {
  String value;
  Node next;
  public Node(String value, Node next) {
    this.value = value;
    this.next = next;
  }
}

public class LinkedStringList implements StringList {

  Node front;
  int size;

  // How will we construct it?
  public LinkedStringList() {
    this.front = new Node(null, null);
  }

  // How will we implement the methods?
  public void prepend(String s) {
    this.front.next = new Node(s, this.front.next);;
    this.size += 1;
  }

  public String get(int index) {
    Node current = this.front.next;
    for(int i = 0; i < index; i += 1) {
      current = current.next;
    }
    return current.value;
  }

  public void add(String s) {
    // NOTE: we start at this.front, because what we need
    // for add() is a reference to a node to add to, which may
    // be front itself if the list is empty.

    // If we didn't have the dummy/sentinel node at the
    // beginning, we would need to check if front was null,
    // special case that behavior, and then have the loop
    // below.
    Node current = this.front;
    while(current.next != null) {
      current = current.next;
    }
    current.next = new Node(s, null);
    this.size += 1;
  }

  public void remove(int index) {
    Node current = this.front;
    for(int i = 0; i < index; i += 1) {
      current = current.next;
    }
    current.next = current.next.next;
	this.size -= 1;
  }

  public void insert(int index, String s) {
    Node current = this.front;
    for(int i = 0; i < index; i += 1) {
      current = current.next;
    }
    current.next = new Node(s, current.next);
	this.size += 1;
  }

  public int size() {
    return this.size;
  }

}

