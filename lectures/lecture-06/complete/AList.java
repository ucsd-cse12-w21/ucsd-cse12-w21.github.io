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
    // TODO: Check for out-of-bounds
    // throw IndexOutOfBoundsException
    return this.elements[index];
  }

  public int size() {
    return this.size;
  }

  @SuppressWarnings("unchecked")
  private void expandCapacity() {
    // NOTE: I changed currentSize to currentCapacity below
    // because it's a better name for the variable
    int currentCapacity = this.elements.length;
    if(this.size < currentCapacity) { return; }

    E[] expanded = (E[])(new Object[currentCapacity * 2]);

    for(int i = 0; i < this.size; i += 1) {
      expanded[i] = this.elements[i];
    }
    this.elements = expanded;
  }
}
