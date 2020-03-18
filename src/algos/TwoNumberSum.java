package algos;
import java.util.HashSet;
import java.util.Set;

import model.Algo;
import model.Array;
import model.Input;
import utils.Utils;

@SuppressWarnings("unchecked")
public class TwoNumberSum implements Algo {

  @Override
	public void run(Input input) {
		Array<Integer> array = (Array<Integer>) input.getFirstEntry(Array.class);
		int targetSum = (int) input.getFirstEntry(Integer.class);
		process(array, targetSum);
	}
  
  private void process(Array<Integer> inArray, int targetSum) {
    int[] array = format(inArray);
    int[] result = twoNumberSum_v2(array, targetSum);
    printAlgoCall(array, targetSum);
    Utils.printIntArray(result);
    Utils.println();
  }
  
  @SuppressWarnings("unused")
  private int[] twoNumberSum_v1(int[] array, int targetSum) {
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
  
  private int[] twoNumberSum_v2(int[] array, int targetSum) {
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
  
  private int[] format(Array<Integer> inArray) {
    return inArray.toList().stream()
        .mapToInt(Integer::intValue)
        .toArray();
  }
  
  private static void printAlgoCall(int[] array, int targetSum) {
    StringBuilder sb = new StringBuilder();
    sb.append("#");
    sb.append(TwoNumberSum.class.getSimpleName());
    sb.append("-launch;input:");
    sb.append(Utils.intArrayToString(array));
    sb.append("-");
    sb.append(targetSum);
    sb.append("#");
    Utils.println(sb.toString());
  }

}
