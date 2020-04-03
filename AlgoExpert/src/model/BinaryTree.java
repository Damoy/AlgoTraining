package model;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
  public int value;
  public BinaryTree left;
  public BinaryTree right;

  public BinaryTree(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
  
  // O(n) time | O(h) space
  public static void invertBinaryTree_rec(BinaryTree tree) {
    if(tree == null)
      return;
    
    invertNode(tree);
    invertBinaryTree_rec(tree.left);
    invertBinaryTree_rec(tree.right);
  }
  
  // O(n) time | O(n) space (queue can contain all nodes)
  public static void invertBinaryTree(BinaryTree tree) {
    if(tree == null)
      return;
    
    Queue<BinaryTree> queue = new ArrayDeque<BinaryTree>();
    queue.add(tree);
    
    while(!queue.isEmpty()) {
      BinaryTree current = queue.poll();
      invertNode(current);
      
      if(current.left != null) {
        queue.add(current.left);
      }
      
      if(current.right != null) {
        queue.add(current.right);
      }
    }
  }
  
  private static void invertNode(BinaryTree node) {
    BinaryTree left = node.left;
    node.left = node.right;
    node.right = left;
  }
  
  public static List<Integer> inOrderTraverse(BinaryTree tree, List<Integer> array) {
    if(tree == null)
      return array;
    
    if(tree.left != null) {
      inOrderTraverse(tree.left, array);
    }
    
    array.add(tree.value);
    
    if(tree.right != null) {
      inOrderTraverse(tree.right, array);
    }
    
    return array;
  }
  
}