package algos;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {
  
  public static int productSum(List<Object> array) {
    return productSum(array, 1);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static int productSum(List<Object> arr, int depth) {
    int sum = 0;
    for (Object o : arr) {
      if (o instanceof ArrayList) {
        sum += productSum((ArrayList) o, depth + 1);
      } else {
        sum += ((int) o);
      }
    }
    return sum * depth;
  }
  
}
