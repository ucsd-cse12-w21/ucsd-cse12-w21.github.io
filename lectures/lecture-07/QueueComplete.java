import java.util.ArrayList;

public interface Queue<E> {
  void enqueue(E element);
  E dequeue();
  int size();
}

class ALQueue<E> implements Queue<E> {
  ArrayList<E> contents;
  public ALQueue() {
    this.contents = new ArrayList<>();
  }
  public int size() {
    return this.contents.size();
  }
  public void enqueue(E element) {
    this.contents.add(this.contents.size(), element);
  }
  public E dequeue() {
    E toReturn = this.contents.get(0);
    this.contents.remove(0);
    return toReturn;
  }
  public String toString() {
    return "front → " + this.contents.toString() + " ← back";
  }
}
