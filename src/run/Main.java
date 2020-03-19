package run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import algos.ClosestValueInBst;
import algos.TwoNumberSum;
import model.Array;
import model.BST;
import model.Input;
import utils.Utils;

public class Main {

	public static void main(String[] args) {
		twoSumNumberSum();
		closestValueInBst();
		branchSums();
		depthFirstSearch();
		linkedListConstruction2();
	}
	
	public static void linkedListConstruction() {
	  DoublyLinkedList list = new DoublyLinkedList();
	  list.setHead(new Node2(1));
	  list.setHead(new Node2(2));
	  list.setTail(new Node2(8));
	  list.insertAfter(list.head.next, new Node2(4));
	  list.insertBefore(list.head.next, new Node2(6));
	  list.insertBefore(list.head.next, new Node2(6));
	  Utils.println(list);
	  list.removeNodesWithValue(6);
	  Utils.println(list);
	  list.remove(list.head.next);
	  Utils.println(list);
	  list.remove(list.head);
	  Utils.println(list);
	  list.remove(list.tail);
	  Utils.println(list);
	}
	
	 public static void linkedListConstruction2() {
	    DoublyLinkedList list = new DoublyLinkedList();
	    Node2 node = new Node2(1);
	    list.setHead(node);
	    Utils.println(list.head == list.tail && list.tail != null);
	    list.remove(node);
	    Utils.println(list.head == list.tail && list.tail == null);
	    list.setTail(node);
	    Utils.println(list.head == list.tail && list.tail != null);
	    list.removeNodesWithValue(1);
	    Utils.println(list.head == list.tail && list.tail == null);
	    list.insertAtPosition(1, node);
	    Utils.println(list.head == list.tail && list.tail != null);
	 }
	
  static class DoublyLinkedList {
    public Node2 head;
    public Node2 tail;

    public void setHead(Node2 node) {
      if(head == null) {
        head = node;
        tail = node;
      } else {
        head.prev = node;
        node.next = head;
        head = node;
        node.prev = null;
      }
    }

    public void setTail(Node2 node) {
      if(tail == null) {
        head = node;
        tail = node;
      } else {
        tail.next = node;
        node.prev = tail;
        tail = node;
        node.next = null;
      }
    }

    public void insertBefore(Node2 node, Node2 nodeToInsert) {
      Node2 tmp = node.prev;
      node.prev = nodeToInsert;
      nodeToInsert.next = node;
      nodeToInsert.prev = tmp;
      tmp.next = nodeToInsert;
    }

    public void insertAfter(Node2 node, Node2 nodeToInsert) {
      Node2 tmp = node.next;
      node.next = nodeToInsert;
      nodeToInsert.prev = node;
      nodeToInsert.next = tmp;
      tmp.prev = nodeToInsert;
    }

    public void insertAtPosition(int position, Node2 nodeToInsert) {
      Node2 node = head;
      for(int i = 1; i < position && node != null; ++i) {
        node = node.next;
      }
      if(node != null) {
        insertAfter(node, nodeToInsert);
      }
    }

    public void removeNodesWithValue(int value) {
      Node2 node = head;
      while(node != null) {
        if(node.value == value) {
          remove(node);
        }
        node = node.next;
      }
    }

    public void remove(Node2 node) {
      if(node != null) {
        if(node != head && node != tail) {
          node.prev.next = node.next;
          node.next.prev = node.prev;
        } else if (node == head){
          if(head == tail) {
            tail = null;
          }
          head = head.next;
          if(head != null) {
            head.prev = null;
          }
        } else if(node == tail) {
          if(head == tail) {
            head = null;
          }
          tail = tail.prev;
          if(tail != null) {
            tail.next = null;
          }
        }
      }
    }

    public boolean containsNodeWithValue(int value) {
      Node2 node = head;
      while(node != null && node.value != value) {
        node = node.next;
      }
      return node != null;
    }
    
    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      Node2 node = head;
      while(node != null) {
        if(node.prev != null) {
          sb.append("<-");
        }
        sb.append(node.value);
        if(node.next != null) {
          sb.append("->");
        }
        node = node.next;
      }
      return sb.toString();
    }
  }

  // Do not edit the class below.
  static class Node2 {
    public int value;
    public Node2 prev;
    public Node2 next;

    public Node2(int value) {
      this.value = value;
    }
    
    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      if(prev != null) {
        sb.append(prev.value);
        sb.append("<-");
      }
      sb.append(value);
      if(next != null) {
        sb.append("->");
        sb.append(next.value);
      }
      return sb.toString();
    }
  }
	
	public static void depthFirstSearch() {
	  Node root = new Node("A");
	  Node nodeB = new Node("B");
	  Node nodeD = new Node("D");
	  Node nodeF = new Node("F");
	  Node nodeG = new Node("G");
	  root.addChild(nodeB).addChild(new Node("C")).addChild(nodeD);
	  nodeB.addChild(new Node("E")).addChild(nodeF);
	  nodeF.addChild(new Node("I")).addChild(new Node("J"));
	  nodeD.addChild(nodeG).addChild(new Node("H"));
	  nodeG.addChild(new Node("K"));
	  Utils.println(root.depthFirstSearch(new ArrayList<>()));
	}
	
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }
    
    // Time O(V+E) | Space O(V)
    public List<String> depthFirstSearch(List<String> array) {
      Set<String> visited = new HashSet<>();
      Stack<Node> stack = new Stack<>();
      stack.push(this);
      Node currentNode;
      
      while(!stack.isEmpty()) {
        currentNode = stack.pop();
        
        if(!visited.contains(currentNode.name)) {
          array.add(currentNode.name);
          visited.add(currentNode.name);
        }
        
        for(int i = currentNode.children.size() - 1; i >= 0; --i) {
          if(!visited.contains(currentNode.children.get(i).name)) {
            stack.push(currentNode.children.get(i));
          }
        }
      }
      
      return array;
    }

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
    
    public Node addChild(Node child) {
      children.add(child);
      return this;
    }
  }
	
	private static void branchSums() {
	  BinaryTree tree = new BinaryTree(1);
    tree.left = new BinaryTree(2);
    tree.left.left = new BinaryTree(4);
    tree.left.right = new BinaryTree(5);
    tree.left.right.right = new BinaryTree(10);
    tree.left.left.left = new BinaryTree(8);
    tree.left.left.right = new BinaryTree(9);
    tree.right = new BinaryTree(3);
    tree.right.left = new BinaryTree(6);
    tree.right.right = new BinaryTree(7);
    Utils.println(branchSums(tree));
	}
	
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
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
  
	public static void twoSumNumberSum() {
		Input input = new Input();
		input.addEntry(Array.class, Array.from(new Integer[] {3, 5, -4, 8, 11, 1, -1, 6}));
		input.addEntry(Integer.class, 10);
		new TwoNumberSum().run(input);
	}
	
	 public static void closestValueInBst() {
	   BST tree = new BST(10);
	   tree.left = new BST(5);
	   tree.left.left = new BST(2);
	   tree.left.right = new BST(5);
	   tree.left.left.left = new BST(1);
	   tree.right = new BST(15);
	   tree.right.left = new BST(13);
	   tree.right.right = new BST(22);
	   tree.right.left.right = new BST(14);
	   
	   Input input = new Input();
	   input.addEntry(BST.class, tree);
	   input.addEntry(Integer.class, 12);
	   ClosestValueInBst closestValueInBstAlgo = new ClosestValueInBst();
	   closestValueInBstAlgo.run(input);
	   input.overrideEntry(Integer.class, 8);
	   closestValueInBstAlgo.run(input);
	 }

}
