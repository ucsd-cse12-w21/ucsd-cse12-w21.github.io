public class AList<E> implements List<E> {

  E[] elements;
  int size;

  @SuppressWarnings("unchecked")
  public AList() {
    this.elements = (E[])(new Object[2]);
    this.size = 0;
  }

  public void add(E s) {
    expandCapacity();
    this.elements[this.size] = s;
    this.size += 1;
  }

  public E get(int index) {
    if(index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException();
    }
    return this.elements[index];
  }

  public int size() {
    return this.size;
  }

  @SuppressWarnings("unchecked")
  private void expandCapacity() {

    int currentCapacity = this.elements.length;
    if(this.size < currentCapacity) { return; }

    // How to construct a new array here?


    for(int i = 0; i < this.size; i += 1) {
      expanded[i] = this.elements[i];
    }
    this.elements = expanded;
  }
}
