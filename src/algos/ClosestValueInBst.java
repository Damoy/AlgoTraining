package algos;

import model.Algo;
import model.BST;
import model.Input;
import utils.Utils;

public class ClosestValueInBst implements Algo {

  @Override
  public void run(Input input) {
    BST tree = (BST) input.getFirstEntry(BST.class);
    int target = (Integer) input.getFirstEntry(Integer.class);
    process(tree, target);
  }
  
  private void process(BST tree, int target) {
    int result = closestValueInBst_ite(tree, target, tree.value);
    printAlgoCall(tree, target);
    Utils.println(result);
  }
  
  // Average: O(Log(n)) time - O (Log(n)) space
  // Worst: O(n) time - O(n) space
  @SuppressWarnings("unused")
  private Integer closestValueInBst_rec(BST tree, int target, int currentClosest) {
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
  private Integer closestValueInBst_ite(BST tree, int target, int currentClosest) {
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
  
  private static void printAlgoCall(BST bst, int target) {
    StringBuilder sb = new StringBuilder();
    sb.append("#");
    sb.append(ClosestValueInBst.class.getSimpleName());
    sb.append("-launch;input:");
    sb.append(bst.toString());
    sb.append("-");
    sb.append(target);
    sb.append("#");
    Utils.println(sb.toString());
  }

}
