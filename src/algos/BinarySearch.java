package algos;

public class BinarySearch {
  
  public static int binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      int elt = array[mid];
      if (elt == target) {
        return mid;
      } else if (elt < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }
  
}
