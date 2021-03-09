import java.util.*;

interface List<Element> {
  /* Add an element at the end of the list */
  void add(Element s);
  /* Get the element at the given index */
  Element get(int index);
  /* Get the number of elements in the list */
  int size();
}

class AList<E> implements List<E>, Iterable<E> {

  class AListIterator implements Iterator<E> {

	  int currentIndex;
	  int size;
	  AList<E> alist;
	  
	  public AListIterator(int index, int size, AList<E> alist) {
		  this.currentIndex = index;
		  this.size = size;
		  this.alist = alist;
	  }

	  //TODO: next() and hasNext()
	  public E next() {
		  if (!this.hasNext()) { throw new NoSuchElementException(); }
		  E answer = elements[this.currentIndex];
		  this.currentIndex += 1;
		  return answer;
	  }
	  
	  public boolean hasNext() {
		  return this.currentIndex < this.size;
	  }
  }

  E[] elements;
  int size;

  @SuppressWarnings("unchecked")
  public AList() {
    this.elements = (E[])(new Object[2]);
    this.size = 0;
  }

  public Iterator<E> iterator() {
	  //return something
	  return new AListIterator(0, this.size, this);
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
    // NOTE(joe): I changed currentSize to currentCapacity below
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
