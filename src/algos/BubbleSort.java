package algos;

public class BubbleSort {

  public static int[] bubbleSort(int[] array) {
    for (int i = 0; i < array.length - 1; ++i) {
      boolean updated = false;
      for (int j = i + 1; j < array.length; ++j) {
        if (array[i] > array[j]) {
          updated = true;
          int tmp = array[i];
          array[i] = array[j];
          array[j] = tmp;
        }
      }
      if (!updated && i == array.length - 2) {
        break;
      }
    }

    return array;
  }
  
}
