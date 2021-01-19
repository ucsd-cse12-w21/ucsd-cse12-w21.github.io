import java.util.ArrayList;

public interface Stack<E> {
  void push(E element);
  E pop();
  int size();
}

class ALStack<E> implements Stack<E> {
  ArrayList<E> contents;
  public ALStack() {
    this.contents = new ArrayList<>();
  }
  public int size() {
    return this.contents.size();
  }
  public void push(E element) {
    this.contents.add(0, element);
  }
  public E pop() {
    E toReturn = this.contents.get(0);
    this.contents.remove(0);
    return toReturn;
  }
  public String toString() {
    return "top → " + this.contents.toString();
  }
}
