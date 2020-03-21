package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Utils;

public class ThreeNumberSum {

  public static List<Integer[]> threeNumbersSum(int[] array, int targetSum) {
    Arrays.sort(array);
    List<Integer[]> results = new ArrayList<Integer[]>();

    for (int i = 0; i < array.length - 2; ++i) {
      int left = i + 1;
      int right = array.length - 1;
      while (left < right) {
        int leftElt = array[left];
        int rightElt = array[right];
        int sum = array[i] + leftElt + rightElt;
        if (sum == targetSum) {
          results.add(new Integer[] { array[i], leftElt, rightElt });
          ++left;
          --right;
        } else if (sum < targetSum) {
          ++left;
        } else if (sum > targetSum) {
          --right;
        }
      }
    }

    return results;
  }
  
  public static void printThreeNumberSum(List<Integer[]> list) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (Integer[] arr : list) {
      sb.append("[");
      for (int i = 0; i < arr.length - 1; ++i) {
        sb.append(arr[i]);
        sb.append(",");
      }
      sb.append(arr[arr.length - 1]);
      sb.append("]");
    }
    sb.append("]");
    Utils.println(sb.toString());
  }
  
}
