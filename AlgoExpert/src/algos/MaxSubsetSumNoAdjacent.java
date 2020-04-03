package algos;

public class MaxSubsetSumNoAdjacent {

  // array contains positive integers
  // O(n) time | O(1) space
  public static int maxSubsetSumNoAdjacent(int[] array) {
    if(array == null || array.length == 0){
      return 0;
    }
    
    if(array.length == 1) {
      return array[0];
    }
    
    int first = array[0];
    int second = Math.max(array[0], array[1]);
    
    if(array.length == 2) {
      return second;
    }
    
    for(int i = 2; i < array.length; ++i) {
      int current = Math.max(second,
          array[i] + first);
      first = second;
      second = current;
    }
    
    return second;
  }
  
}
