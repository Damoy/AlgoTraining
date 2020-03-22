package algos;

public class NumberOfWaysToMakeChange {

  // array contains positive integers
  // O(nd) | O(n) space
  public static int numberOfWaysToMakeChange(int n, int[] denoms) {
    int[] ways = new int[n + 1];
    ways[0] = 1;
    
    for(int i = 0; i < denoms.length; ++i) {
      int denom = denoms[i];
      for(int amount = 1; amount < n + 1; ++amount) {
        if(denom <= amount) {
          ways[amount] += ways[amount - denom];
        }
      }
    }
    
    return ways[n];
  }
  
}
