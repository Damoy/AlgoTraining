package algos;

import java.util.List;

public class MoveElementToEnd {

  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    if (array == null || array.isEmpty())
      return array;

    int n = array.size();
    int endPtr = n - 1;

    while (array.get(endPtr) == toMove && endPtr > 0) {
      --endPtr;
    }

    for (int i = 0; i < endPtr; ++i) {
      if (array.get(i) == toMove) {
        array.set(i, array.get(endPtr));
        array.set(endPtr, toMove);
        while (array.get(endPtr) == toMove) {
          --endPtr;
        }
      }
    }
    return array;
  }
  
}
