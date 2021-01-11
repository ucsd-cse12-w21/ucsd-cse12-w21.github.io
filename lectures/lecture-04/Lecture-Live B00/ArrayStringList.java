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
  
  }  
  
  public void remove(int index) {

  }
  
  public String get(int index) {
	  return this.elements[index];
  }
  
  public int size() {
	  return this.size;
  }
  
  private void expandCapacity() {
	  int currentCapacity = this.elements.length;
	  if(this.size < currentCapacity) { return; }

	  String[] expanded = new String[currentCapacity * 2];

	  for(int i = 0; i < this.size; i += 1) {
		  expanded[i] = this.elements[i];
	  }

	  this.elements = expanded;
  }
  
  public void foo(){
      String[] tmp = elements;
      add("a");
      add("b");
      add("c");
      expandCapacity();
      System.out.println(tmp == elements);
  }
  public static void main(String[] args){
      ArrayStringList ref = new ArrayStringList();
      ref.foo();
  }
}
