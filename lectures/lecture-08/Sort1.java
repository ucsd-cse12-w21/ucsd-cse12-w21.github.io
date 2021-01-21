class Sort1 {

  public static boolean isSorted1(int[] arr) {
    for(int i = 0; i < arr.length - 1; i += 1) {
      if(arr[i] > arr[i + 1]) { return false; }
    }
    return true;
  }

  public static void main(String[] args) {
    for(int size = 0; size < 10000000; size += 1000000) {
      int[] values = new int[size];
      for(int i = 0; i < values.length; i += 1) {
        values[i] = i;
      }
      long start = System.currentTimeMillis();
      isSorted1(values);
      long duration = System.currentTimeMillis() - start;
      System.out.println(size + ": \t" + duration);
    }
    //System.out.println(all);
  }
}
