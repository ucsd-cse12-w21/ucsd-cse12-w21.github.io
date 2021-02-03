import java.util.Arrays;

public class Sort {
  public static void swap(String[] array, int i1, int i2) {
    String temp = array[i1];
    array[i1] = array[i2];
    array[i2] = temp;
  }
  public static int partition(String[] array, int low, int high) {
	  int pivotStartIndex = high - 1;
	  String pivot = array[pivotStartIndex];
	  int smallerBefore = low, largerAfter = high - 2;
	  
	  while (smallerBefore <= largerAfter) {
		  if (array[smallerBefore].compareTo(pivot) < 0) {
			  smallerBefore += 1;
		  }
		  else {
			  swap(array, smallerBefore, largerAfter);
			  largerAfter -= 1;
		  }
	  }
	  
	  swap(array, smallerBefore, pivotStartIndex);
	  return smallerBefore;
  }

  //QuickSort
  public static void qsort(String[] array, int low, int high) {
	  if (high - low <= 1) { return; }
	  int splitAt = partition(array, low, high);
	  qsort(array, low, splitAt);
	  qsort(array, splitAt + 1, high);
  }

  public static void sort(String[] array) {
	  qsort(array, 0, array.length);
  }
  
  public static void main (String[] args)
  {
	  String[] a = {"b", "e", "a", "f", "c" };
	  
	  //System.out.println(partition(a, 0, 5));
	  
	  Sort.sort(a);
	  System.out.println(Arrays.deepToString(a));
  }
}
