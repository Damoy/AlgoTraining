package algos;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {

  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    int[] nums = new int[n + 1];
    Arrays.fill(nums, Integer.MAX_VALUE);
    nums[0] = 0;
    int cmp = 0;
    
    for(int i = 0; i < denoms.length; ++i) {
      int denom = denoms[i];
      for(int amount = 0; amount < nums.length; ++amount) {
        if(denom <= amount) {
          if(nums[amount - denom] == Integer.MAX_VALUE) {
            cmp = nums[amount - denom]; 
          } else {
            cmp = nums[amount - denom] + 1;
          }
          nums[amount] = Math.min(nums[amount], cmp);
        }
      }
    }
    
    return nums[n] != Integer.MAX_VALUE ? nums[n] : -1;
  }
  
}
