package algos;

import java.util.List;

public class BSTConstruction {
  
  public static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
    
    public void inOrderTraverse(List<Integer> array) {
      if(left != null) {
        left.inOrderTraverse(array);
      }
      
      array.add(value);
      
      if(right != null) {
        right.inOrderTraverse(array);
      }
    }
    
    // Average (log(n)) time | O(1) space
    // Worst (n) time | O(1) space
    public BST insert(int value) {
      BST current = this;
      boolean foundLocation = false;
      
      while(!foundLocation) {
        if(value < current.value) {
          if(current.left == null) {
            current.left = new BST(value);
            foundLocation = true;
          } else {
            current = current.left;
          }
        } else {
          if(current.right == null) {
            current.right = new BST(value);
            foundLocation = true;
          } else {
            current = current.right;
          }
        }
      }
      
      return this;
    }

    // Average (log(n)) time | O(1) space
    // Worst (n) time | O(1) space
    public boolean contains(int value) {
      BST current = this;
      
      while(current != null) {
        if(value < current.value) {
          current = current.left;
        } else if(value > current.value) {
          current = current.right;
        } else {
          return true;
        }
      }
      
      return false;
    }
    
    // Average (log(n)) time | O(1) space
    // Worst (n) time | O(1) space
    public BST remove(int value) {
      remove(value, null);
      return this;
    }
    
    public void remove(int value, BST father) {
      BST current = this;
      
      while(current != null) {
        if(value < current.value) {
          father = current;
          current = current.left;
        } else if (value > current.value) {
          father = current;
          current = current.right;
        } else {
          // node of given value is found here and also have 
          // his father
          if(current.left != null && current.right != null) {
            // smallest leftmost value of the right subtree
            current.value = current.right.getMinValue();
            // now remove the node from where it comes from
            current.right.remove(current.value, current);
          } else if(father == null){
            // if we reach here, it means we want to remove head
            if(current.left != null) {
              current.value = current.left.value;
              current.right = current.left.right;
              current.left = current.left.left;
            } else if(current.right != null) {
              current.value = current.right.value;
              current.left = current.right.left;
              current.right = current.right.right;
            } else {
              // it does not have any son node, we remove
              // the only node there is in the tree
              current.value = 0;
            }
          } else if(father.left == current) {
            // left child of father
            father.left = current.left != null 
                ? current.left
                : current.right;
          } else if(father.right == current) {
            father.right = current.left != null 
                ? current.left
                : current.right;
          }
          
          break;
        }
      }
    }
    
    public int getMinValue() {
      if(left == null) {
        return value;
      } else {
        return left.getMinValue();
      }
    }
    
    public void print() {
      System.out.println(value);
      if(left != null) {
        System.out.print("/");
        left.print();
      }
      if(right != null) {
        System.out.print("\\");
        right.print();
      }
    }
    
  }

}
