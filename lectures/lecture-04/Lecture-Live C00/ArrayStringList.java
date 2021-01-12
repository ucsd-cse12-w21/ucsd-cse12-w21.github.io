public class ArrayStringList implements StringList {

  String[] elements;
  int size;				// How many elements are in the list?

  // How will we construct it?
  public ArrayStringList() {
	  this.elements = new String[2];	// Capacity of 2
	  this.size = 0;					// Number of elements added
  }

  public ArrayStringList(int capacity) {
	  this.elements = new String[capacity];
	  this.size = 0;
  }

  // How will it implement the methods?
  public void add(String s) {
	  expandCapacity();
	  this.elements[this.size] = s;
	  this.size += 1;
  }
  
  public void insert(int index, String s) {
	  expandCapacity();
	  
	  for (int i = size - 1; i >= index ; i--) {		  
		  this.elements[i+1] = this.elements[i];
	  }
	  
	  this.elements[index] = s;

	  this.size += 1;
  }  
  
  public void remove(int index) {
	  for (int i = index; i < size - 1 ; i++) {		  
		  this.elements[i] = this.elements[i+1];
	  }
	  
	  this.elements[size - 1] = null;

	  this.size -= 1;
  }
  
  public String get(int index) {
	  return this.elements[index];
  }
  
  public int size() {
	  return this.size;
  }
  
  private void expandCapacity() {
	  // NOTE: I changed currentSize to currentCapacity below
	  // because it's a better name for the variable
	  int currentCapacity = this.elements.length;
	  if(this.size < currentCapacity) { return; }

	  String[] expanded = new String[currentCapacity * 2];

	  for(int i = 0; i < this.size; i += 1) {
		  expanded[i] = this.elements[i];
	  }

	  this.elements = expanded;
  }
}
