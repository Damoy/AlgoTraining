package algos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class SmallestDifference {
  
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    return smallestDifference_sort(arrayOne, arrayTwo);
  }

  public static int[] smallestDifference_sort(int[] arrayOne, int[] arrayTwo) {
    Arrays.sort(arrayOne);
    Arrays.sort(arrayTwo);

    int ptr1 = 0;
    int ptr2 = 0;
    int bestDiff = Integer.MAX_VALUE;
    int bestElt1 = 0;
    int bestElt2 = 0;

    while (ptr1 < arrayOne.length && ptr2 < arrayTwo.length) {
      int elt1 = arrayOne[ptr1];
      int elt2 = arrayTwo[ptr2];

      if (elt1 == elt2) {
        return new int[] { elt1, elt2 };
      }
      if (elt1 < elt2) {
        ++ptr1;
      } else {
        ++ptr2;
      }

      int diff = Math.abs(elt1 - elt2);
      if (diff < bestDiff) {
        bestDiff = diff;
        bestElt1 = elt1;
        bestElt2 = elt2;
      }
    }

    return new int[] { bestElt1, bestElt2 };
  }

  public static int[] smallestDifference_nosort(int[] arrayOne, int[] arrayTwo) {
    Map<Integer, int[]> m = new HashMap<Integer, int[]>();

    for (int x : arrayOne) {
      for (int v : arrayTwo) {
        m.put(Math.abs(x - v), new int[] { x, v });
      }
    }

    Set<Entry<Integer, int[]>> entrySet = m.entrySet();
    Iterator<Entry<Integer, int[]>> it = entrySet.iterator();
    Entry<Integer, int[]> smallest = it.next();

    while (it.hasNext()) {
      Entry<Integer, int[]> entry = it.next();
      if (smallest.getKey() > entry.getKey()) {
        smallest = entry;
      }
    }

    return smallest.getValue();
  }
  
}
