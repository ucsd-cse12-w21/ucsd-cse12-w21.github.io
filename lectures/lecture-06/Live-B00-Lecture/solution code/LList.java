class NodeLL<T> {
  T value;
  NodeLL<T> next;
  public NodeLL(T value, NodeLL<T> next) {
    this.value = value;
    this.next = next;
  }
}

public class LList<E> implements List<E> {
  NodeLL<E> front;
  int size;
  
  public LList() {
    this.front = new NodeLL<E>(null, null);
    this.size = 0;
  }

  public E get(int index) {
	if (index < 0 || index >= size) {
		throw new IndexOutOfBoundsException();
	}

    NodeLL<E> temp = this.front.next;
    for (int i = 0; i < index; i += 1) {
      temp = temp.next;
    }
    return temp.value;
  }

  public int size() {
    return this.size;
  }    

  public void add(E s) {
    NodeLL<E> temp = this.front;
    while (temp.next != null) {
      temp = temp.next;
    }  
    temp.next = new NodeLL<E>(s, null);
    this.size += 1;
  }
}
