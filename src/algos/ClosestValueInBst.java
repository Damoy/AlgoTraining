package algos;

public final class ClosestValueInBst {
  
  public static class BST {

    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
    
  }

  
  public static Integer closestValueInBst(BST tree, int target) {
    return closestValueInBst_ite(tree, target, 0);
  }

  // Average: O(Log(n)) time - O (Log(n)) space
  // Worst: O(n) time - O(n) space
  public static Integer closestValueInBst_rec(BST tree, int target, int currentClosest) {
    if(tree == null) {
      return currentClosest;
    }
    
    if(Math.abs(target - currentClosest) > Math.abs(target - tree.value)) {
      currentClosest = tree.value;
    }
    
    if(target < tree.value) {
      currentClosest = closestValueInBst_rec(tree.left, target, currentClosest);
    } else if(target > tree.value) {
      currentClosest = closestValueInBst_rec(tree.right, target, currentClosest);
    } 
    
    return currentClosest;
  }
  
  // Average: O(Log(n)) time - O (1) space
  // Worst: O(n) time - O(1) space
  public static Integer closestValueInBst_ite(BST tree, int target, int currentClosest) {
    BST currentTree = tree;
    
    while(currentTree != null) {
      if(Math.abs(target - currentClosest) > Math.abs(target - currentTree.value)) {
        currentClosest = currentTree.value;
      }
      if(target < currentTree.value) {
        currentTree = currentTree.left;
      } else if(target > currentTree.value) {
        currentTree = currentTree.right;
      } else {
        break;
      }
    }
    return currentClosest;
  }
  
}
