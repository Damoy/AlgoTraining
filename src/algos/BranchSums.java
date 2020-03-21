package algos;

import java.util.ArrayList;
import java.util.List;

// Worst: O(n) time - O(n) space
public class BranchSums {
  
  public static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    List<Integer> list = new ArrayList<>();
    branchSumsUtil_rec(root, list, 0);
    return list;
  }
  
  private static void branchSumsUtil_rec(BinaryTree root, List<Integer> results, int currentSum) {
    currentSum += root.value;
    
    if(root.left == null && root.right == null) {
     results.add(currentSum);
     return;
    }
    
    if(root.left != null) {
      branchSumsUtil_rec(root.left, results, currentSum);
    }
    
    if(root.right != null) {
      branchSumsUtil_rec(root.right, results, currentSum);
    }
  }

}
