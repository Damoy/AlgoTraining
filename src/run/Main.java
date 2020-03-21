package run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
    Utils.println(getNthFib(254));
    
    List<Object> test = new ArrayList<Object>(Arrays.asList(1, 2, 3, 4, 5));
    Utils.println(productSum(test));
    
    List<Object> test2 =
       new ArrayList<Object>(Arrays.asList(1, 2, new ArrayList<Object>(Arrays.asList(3)), 4, 5));
    Utils.println(productSum(test2));
    
    List<Object> test3 =
        new ArrayList<Object>(Arrays.asList(new ArrayList<Object>(Arrays.asList(1, 2)),
            3, new ArrayList<Object>(Arrays.asList(4, 5))));
     Utils.println(productSum(test3)); // 3 * (1 + 2) + 3 + 3 * (4 + 5) = 9 + 3 + 12 + 15 = 28+12 = 40
	
     int[] arr = new int[] {
       0, 1, 21, 33, 45, 46, 61, 71, 72, 73  
     };
     
     Utils.println(binarySearch(arr, 0));
     
     int[] arr2 = new int[] {
        141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7 
     };
     Utils.printLnIntArray(findThreeLargestNumbers(arr2));
     
     int[] arr3 = new int[] {
         55, 43, 11, 3, -3, 10
     };
     Utils.printLnIntArray(findThreeLargestNumbers(arr3));
     Utils.printLnIntArray(bubbleSort(arr2));
     Utils.printLnIntArray(bubbleSort(new int[] {1, 3, 2}));
     Utils.printLnIntArray(insertionSort(new int[] {1, 3, 2}));
     Utils.printLnIntArray(insertionSort(new int[] {8, 1, 6, 4, 6, 1, 2, 58, 5,1}));
     Utils.printLnIntArray(selectionSort(new int[] {8, 1, 6, 4, 6, 1, 2, 58, 5,1}));
     Utils.println(isPalindrome("test"));
     Utils.println(isPalindrome("abba"));
     Utils.println(isPalindrome("abbaa"));
     Utils.println(isPalindrome("zabbaz"));
     Utils.println(caesarCypherEncryptor("xyz", 2));
     printThreeNumberSum(threeNumberSum(
         new int[] {
            12, 3, 1, 2, -6, 5, -8, 6 
         }, 0));
     Utils.printLnIntArray(smallestDifference_sort(
         new int[] {
             -1, 5, 10, 20, 28, 3
         },
         new int[] {
             26, 134, 135, 15, 17
         }
      ));
     Utils.println(moveElementToEnd(
         Arrays.asList(new Integer[] {2, 1, 2, 2, 2, 3, 4, 2}), 2));
     Utils.println(moveElementToEnd(
         Arrays.asList(new Integer[] {3, 3, 3, 3}), 3));
	}
	
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    if(array == null || array.isEmpty())
      return array;
    
    int n = array.size();
    int endPtr = n - 1;
    
    while(array.get(endPtr) == toMove && endPtr > 0) {
      --endPtr;
    }
    
    for(int i = 0; i < endPtr; ++i) {
      if(array.get(i) == toMove) {
        array.set(i, array.get(endPtr));
        array.set(endPtr, toMove);
        while(array.get(endPtr) == toMove) {
          --endPtr;
        }
      }
    }
    return array;
  }
	
  public static int[] smallestDifference_sort(int[] arrayOne, int[] arrayTwo) {
    Arrays.sort(arrayOne);
    Arrays.sort(arrayTwo);
    
    int ptr1 = 0;
    int ptr2 = 0;
    int bestDiff = Integer.MAX_VALUE;
    int bestElt1 = 0;
    int bestElt2 = 0;
    
    while(ptr1 < arrayOne.length && ptr2 < arrayTwo.length) {
      int elt1 = arrayOne[ptr1];
      int elt2  = arrayTwo[ptr2];
      
      if(elt1 == elt2) {
        return new int[] {elt1, elt2};
      }
      if(elt1 < elt2) {
        ++ptr1;
      } else {
        ++ptr2;
      }
      
      int diff = Math.abs(elt1 - elt2);
      if(diff < bestDiff) {
        bestDiff = diff;
        bestElt1 = elt1;
        bestElt2 = elt2;
      }
    }
    
    return new int[] {bestElt1, bestElt2};
  }
	
  public static int[] smallestDifference_nosort(int[] arrayOne, int[] arrayTwo) {
    Map<Integer, int[]> m = new HashMap<Integer, int[]>();
    
    for(int x : arrayOne) {
      for(int v : arrayTwo) {
        m.put(Math.abs(x - v), new int[] {x, v});
      }
    }
    
    Set<Entry<Integer, int[]>> entrySet = m.entrySet();
    Iterator<Entry<Integer, int[]>> it = entrySet.iterator();
    Entry<Integer, int[]> smallest = it.next();
    
    while(it.hasNext()) {
      Entry<Integer, int[]> entry = it.next();  
      if(smallest.getKey() > entry.getKey()) {
        smallest = entry;
      }
    }
    
    return smallest.getValue();
  }
	
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    Arrays.sort(array); 
    List<Integer[]> results = new ArrayList<Integer[]>();
    
    for(int i = 0; i < array.length - 2; ++i) {
      int left = i + 1;
      int right = array.length - 1;
      while(left < right) {
        int leftElt = array[left];
        int rightElt = array[right];
        int sum = array[i] + leftElt + rightElt;
        if(sum == targetSum) {
          results.add(new Integer[] {array[i], leftElt, rightElt});
          ++left;
          --right;
        } else if(sum < targetSum) {
          ++left;
        } else if(sum > targetSum) {
          --right;
        }
      }
    }
    
    return results;
  }
  
  public static void printThreeNumberSum(List<Integer[]> list) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for(Integer[] arr : list) {
      sb.append("[");
      for(int i = 0; i < arr.length - 1; ++i) {
        sb.append(arr[i]);
        sb.append(",");
      }
      sb.append(arr[arr.length - 1]);
      sb.append("]");
    }
    sb.append("]");
    Utils.println(sb.toString());
  }
	
  public static String caesarCypherEncryptor(String str, int key) {
   String dico = "abcdefghijklmnopqrstuvwxyz";
   StringBuilder sb = new StringBuilder();
   for(int i = 0; i < str.length(); ++i) {
     char c = str.charAt(i);
     int index = dico.indexOf(c);
     sb.append(dico.charAt((index + key) % 26));
   }
   return sb.toString();
  }
	
  public static boolean isPalindrome(String str) {
    int len = str.length();
    for(int i = 0; i < len >> 1; ++i) {
      if(str.charAt(i) != str.charAt(len - 1 - i)) {
        return false;
      }
    }
    return true;
  }
	
  public static int[] selectionSort(int[] array) {
    for(int i = 0; i < array.length; ++i) {
      int imin = i;
      for(int j = i + 1; j < array.length; ++j) {
        if(array[j] < array[imin]) {
          imin = j;
        }
      }
      int tmp = array[i];
      array[i] = array[imin];
      array[imin] = tmp;
    }
    return array;
  }
	
  public static int[] insertionSort(int[] array) {
    for(int i = 1; i < array.length; ++i) {
      int j = i;
      while(j > 0 && array[j] < array[j - 1]) {
        int tmp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = tmp;
        --j;
      }
    }
    return array;
  }
	
  public static int[] bubbleSort(int[] array) {
    for(int i = 0; i < array.length - 1; ++i) {
      boolean updated = false;
      for(int j = i + 1; j < array.length; ++j) {
        if(array[i] > array[j]) {
          updated = true;
          int tmp = array[i];
          array[i] = array[j];
          array[j] = tmp;
        }
      }
      if(!updated && i == array.length - 2) {
        break;
      }
    }
    
    return array;
  }
  
	
  public static int[] findThreeLargestNumbers(int[] array) {
    int m1 = Integer.MIN_VALUE;
    int m2 = Integer.MIN_VALUE;
    int m3 = Integer.MIN_VALUE;
    
    for(int x : array) {
      if(x > m1) {
        m3 = m2;
        m2 = m1;
        m1 = x;
      } else if(x > m2) {
        m3 = m2;
        m2 = x;
      } else if(x > m3) {
        m3 = x;
      }
    }
    
    return new int[] {m3, m2, m1};
  }
	
  public static int binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    
    while(left <= right) {
      int mid = (left + right) / 2;
      int elt = array[mid];
      if(elt == target) {
        return mid;
      } else if(elt < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    
    return -1;
  }
	
  public static int productSum(List<Object> array) {
    return productSum(array, 1);
  }

  public static int productSum(List<Object> arr, int depth) {
    int sum = 0;
    for(Object o : arr) {
      if(o instanceof ArrayList) {
        sum += productSum((ArrayList) o, depth + 1);
      } else {
        sum += ((int) o);
      }
    }
    return sum * depth;
  }
	
  public static int getNthFib(int n) {
    int[] mem = new int[] {0, 1};
    --n;
    
    if(n < 2 && n >= 0){
      return mem[n];
    }
    
    int currentSum = 1;
    for(int i = 2; i <= n; ++i){
      currentSum = mem[0] + mem[1];
      mem[0] = mem[1];
      mem[1] = currentSum;
    }
    
    return mem[1];
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
        insertBefore(head, node);
      }
    }

    public void setTail(Node2 node) {
      if(head == null) {
        setHead(node);
      } else {
        insertAfter(tail, node);
      }
    }

    public void insertBefore(Node2 node, Node2 nodeToInsert) {
      // don't want to insert head before itself
      if(nodeToInsert == head && nodeToInsert == tail)
        return;
      
      // want to remove before insertion
      remove(nodeToInsert);
      
      nodeToInsert.prev = node.prev;
      nodeToInsert.next = node;
      
      if(node.prev == null) {
        head = nodeToInsert;
      } else {
        node.prev.next = nodeToInsert;
      }
      
      node.prev = nodeToInsert;
    }

    public void insertAfter(Node2 node, Node2 nodeToInsert) {
      // don't want to insert head before itself
      if(nodeToInsert == head && nodeToInsert == tail)
        return;
      
      // want to remove before insertion
      remove(nodeToInsert);
      
      nodeToInsert.prev = node;
      nodeToInsert.next = node.next;
      
      if(node.next == null) {
        tail = nodeToInsert;
      } else {
        node.next.prev = nodeToInsert;
      }
      
      node.next = nodeToInsert;
    }

    public void insertAtPosition(int position, Node2 nodeToInsert) {
      if(position == 1) {
        setHead(nodeToInsert);
      } else {
        Node2 node = head;
        
        for(int i = 1; i < position && node != null; ++i) {
          node = node.next;
        }
        
        if(node != null) {
          insertBefore(node, nodeToInsert);
        } else {
          setTail(nodeToInsert);
        }
      }
    }

    public void removeNodesWithValue(int value) {
      Node2 node = head;
      while(node != null) {
        Node2 nodeTmp = node;
        node = node.next;
        if(nodeTmp.value == value) {
          remove(nodeTmp);
        }
      }
    }
    
    public void remove(Node2 node) {
      if(node == head) {
        head = head.next;
      }
      
      if(node == tail) {
        tail = tail.prev;
      }
      
      removeNode(node);
    }
    
    public void removeNode(Node2 node) {
      if(node.prev != null) {
        node.prev.next = node.next;
      }
      
      if(node.next != null) {
        node.next.prev = node.prev;
      }
      
      node.prev = null;
      node.next = null;
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
