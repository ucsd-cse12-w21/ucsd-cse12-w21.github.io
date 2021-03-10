interface List<Element> {
  /* Add an element at the end of the list */
  void add(Element s);
  /* Get the element at the given index */
  Element get(int index);
  /* Get the number of elements in the list */
  int size();
}

public class CAList<E> implements List<E> {
  E[] contents;
  int size;
  int start;

  @SuppressWarnings("unchecked")
  public CAList(int capacity) {
    this.contents = (E[])(new Object[capacity]);
    this.size = 0;
    this.start = 0;
  }
  
  private int indexFor(int index) {
    int ans = (this.start + index) % this.contents.length;
    //System.out.println("Index for " + index + " is " + ans);
    return ans;
  }

  @SuppressWarnings("unchecked")
  private void expandCapacity() {
    int currentCapacity = this.contents.length;
    if(this.size < currentCapacity) { return; }

    //save old array
    E[] oldArray = this.contents;
    
    //create new array
    E[] newArray = (E[]) new Object[currentCapacity * 2];
    
    //for loop - iterate through the old array
    for (int i=0; i < this.size; i++) {
    	//copy contents to new array
    	newArray[i] = oldArray[this.indexFor(i)];
    }
    
    //copy new array into this.contents
    this.contents = newArray;
    
    //reset start
    this.start = 0;    
  }
  
  public E get(int index) {
    // ASSUME index is in bounds
    int toLookup = this.indexFor(index);
    return this.contents[toLookup];
  }
  
  public void prepend(E value) {
    expandCapacity();
    this.size += 1;
    this.start -= 1;
    if (this.start == -1) {
      this.start = this.contents.length - 1;
    }
    this.contents[this.start] = value;
  }

  public void add(E value) {
    expandCapacity();
    this.contents[this.indexFor(this.size)] = value;
    this.size += 1;
  }
  
  public String toString() {
    return java.util.Arrays.deepToString(this.contents);
  }
  
  public int size() {
    return this.size;
  }
  
  void shiftUp(int target) {
    int i;
	for(i = target - 1; i > 0; i -= 1) {
	  this.contents[indexFor(i + 1)] =  this.contents[indexFor(i)];
	}
  }

  void shiftDown(int target) {
	int i;
	for(i = target; i < this.size; i += 1) {
	  this.contents[indexFor(i)] = this.contents[indexFor(i + 1)];
	}
  }

  void removeAt(int index) {
	if(index > (this.size / 2)) {
	  shiftDown(index);
	}
	else {
	  shiftUp(index);
	  this.start = indexFor(1);
	}
	
	this.size -= 1;
	return;
  }
  
  public static void main(String[] args) {
    CAList<Integer> a = new CAList<>(2);
    System.out.println(a);
    a.prepend(30);
    System.out.println(a);
    a.add(40);
    System.out.println(a);
    a.prepend(20);
    System.out.println(a);
    a.add(70);
    System.out.println(a);
    a.add(100);
    System.out.println(a);
    a.prepend(10);
    System.out.println(a);
    a.add(150);
    System.out.println(a);
    a.prepend(5);
    System.out.println(a);
    a.add(200);
    System.out.println(a);
  }
}
