package algos;

public class KadanesAlgo {

  public static int kadanesAlgorithm(int[] array) {
    if(array == null || array.length == 0)
      return 0;

    int maxEnding = array[0];
    int currentMax = array[0];
    
    for(int i = 1; i < array.length; ++i) {
      int n = array[i];
      maxEnding = Math.max(n, maxEnding + n);
      currentMax = Math.max(currentMax, maxEnding);
    }
    
    return currentMax;
  }
  
}
