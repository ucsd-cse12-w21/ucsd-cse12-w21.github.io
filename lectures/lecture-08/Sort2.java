class Sort2 {

  public static boolean isSorted2(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      for(int j = i + 1; j < arr.length; j += 1) {
        if(arr[i] > arr[j]) { return false; }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    for(int size = 0; size < 100000; size += 10000) {
      int[] values = new int[size];
      for(int i = 0; i < values.length; i += 1) {
        values[i] = i;
      }
      long start = System.currentTimeMillis();
      isSorted2(values);
      // System.out.println(isSorted2(values));
      long duration = System.currentTimeMillis() - start;
      System.out.println(size + ": \t" + duration);
    }
  }
}
