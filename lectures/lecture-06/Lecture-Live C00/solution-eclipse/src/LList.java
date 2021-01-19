class NodeLL<E> {
  E value;
  NodeLL<E> next;
  public NodeLL(E value, NodeLL<E> next) {
    this.value = value;
    this.next = next;
  }
}

public class LList<E> implements List<E> {

  NodeLL<E> front;
  int size;

  // How will we construct it?
  public LList() {
    this.front = new NodeLL<E>(null, null);
  }

  // How will we implement the methods?
  public void prepend(E s) {
    this.front.next = new NodeLL<E>(s, this.front.next);;
    this.size += 1;
  }

  public E get(int index) {
	if (index < 0 || index >= this.size) {
		throw new IndexOutOfBoundsException();
	}
	
    NodeLL<E> current = this.front.next;
    for(int i = 0; i < index; i += 1) {
      current = current.next;
    }
    return current.value;
  }

  public void add(E s) {
    // NOTE: we start at this.front, because what we need
    // for add() is a reference to a node to add to, which may
    // be front itself if the list is empty.

    // If we didn't have the dummy/sentinel node at the
    // beginning, we would need to check if front was null,
    // special case that behavior, and then have the loop
    // below.
    NodeLL<E> current = this.front;
    while(current.next != null) {
      current = current.next;
    }
    current.next = new NodeLL<E>(s, null);
    this.size += 1;
  }

  public void remove(int index) {
    NodeLL<E> current = this.front;
    for(int i = 0; i < index; i += 1) {
      current = current.next;
    }
    current.next = current.next.next;
	this.size -= 1;
  }

  public void insert(int index, E s) {
    NodeLL<E> current = this.front;
    for(int i = 0; i < index; i += 1) {
      current = current.next;
    }
    current.next = new NodeLL<E>(s, current.next);
	this.size += 1;
  }

  public int size() {
    return this.size;
  }

}

