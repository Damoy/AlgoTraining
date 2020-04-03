package algos;
import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {

  public static int[] twoNumberSum_v1(int[] array, int targetSum) {
    for(int i = 0; i < array.length; ++i){
      for(int j = 0; j < array.length; ++j){
        if(i == j) continue;
        int nb1 = array[i];
        int nb2 = array[j];
        if(nb1 + nb2 == targetSum){
          return new int[]{nb1, nb2};
        }
      }
    }
    return new int[]{};
  }
  
  public static int[] twoNumberSum_v2(int[] array, int targetSum) {
    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < array.length; ++i){
      int diff = targetSum - array[i];
      if(set.contains(diff)) {
         return new int[] {diff, array[i]};
      } 
       set.add(array[i]);
    }
    
    return new int[] {};
  }

}
