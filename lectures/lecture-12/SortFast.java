public class SortFast {

  public static String s(int[] arr) { return Arrays.toString(arr); }

  public static int[] combine(int[] part1, int[] part2) {
    int index1 = 0, index2 = 0;
    int[] combined = new int[part1.length + part2.length];
    while(index1 < part1.length && index2 < part2.length) {
      if(part1[index1] < part2[index2]) {
        combined[index1 + index2] = part1[index1];
        index1 += 1;
      }
      else {
        combined[index1 + index2] = part2[index2];
        index2 += 1;
      }
    }
    while(index1 < part1.length) {
      combined[index1 + index2] = part1[index1]; index1 += 1;
    }
    while(index2 < part2.length) {
      combined[index1 + index2] = part2[index2]; index2 += 1;
    }
    System.out.println(s(part1) + " + " + s(part2) + " -> " + s(combined));
    return combined;
  }

  public static int[] sortC(int[] arr) {
    if(arr.length <= 1) { return arr; }
    else {
      int[] part1 = Arrays.copyOfRange(arr, 0, arr.length / 2);
      int[] part2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
      System.out.println(s(arr) + " -> " + s(part1) + " + " + s(part2));
      int[] sortedPart1 = sortC(part1);
      int[] sortedPart2 = sortC(part2);
      int[] sorted = combine(sortedPart1, sortedPart2);
      return sorted;
    }
  }

/*
  public int sortC(int[] arr, int start, int end) {
    if(end == start) { return new int[0]; }
    else if (end - 1 == start) {
      
    }
    else {
      int middle = start + arr.length / 2;
      sortC(arr, start, middle);
      sortC(arr, middle, end);
      int[] merged = merge(arr, start, middle, middle, end);
      return merged;
    }
  }
*/
}
