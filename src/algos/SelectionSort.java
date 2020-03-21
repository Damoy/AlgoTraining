package algos;

public class SelectionSort {

  public static int[] selectionSort(int[] array) {
    for (int i = 0; i < array.length; ++i) {
      int imin = i;
      for (int j = i + 1; j < array.length; ++j) {
        if (array[j] < array[imin]) {
          imin = j;
        }
      }
      int tmp = array[i];
      array[i] = array[imin];
      array[imin] = tmp;
    }
    return array;
  }
  
}
