package run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algos.BinarySearch;
import algos.BranchSums;
import algos.BranchSums.BinaryTree;
import algos.BubbleSort;
import algos.CaesarCypherEncryptor;
import algos.ClosestValueInBst;
import algos.DepthFirstSearch.Node;
import algos.DoublyLinkedList;
import algos.FindThreeLargestNumbers;
import algos.GetNthFib;
import algos.InsertionSort;
import algos.IsPalindrome;
import algos.MoveElementToEnd;
import algos.ProductSum;
import algos.SelectionSort;
import algos.SmallestDifference;
import algos.ThreeNumberSum;
import algos.TwoNumberSum;
import model.BST;
import utils.Utils;

public class Main {

  public static void main(String[] args) {
    twoSumNumberSum();
    closestValueInBst();
    branchSums();
    depthFirstSearch();
    linkedListConstruction2();
    getNthFib();
    productSum();
    binarySearch();
    bubbleSort();
    insertionSort();
    selectionSort();
    isPalindrome();
    caesarCypherEncryptor();
    threeNumberSum();
    smallestDifference();
    moveElementToEnd();
  }
  
  public static void moveElementToEnd() {
    Utils.println(MoveElementToEnd.moveElementToEnd(Arrays.asList(new Integer[] { 2, 1, 2, 2, 2, 3, 4, 2 }), 2));
    Utils.println(MoveElementToEnd.moveElementToEnd(Arrays.asList(new Integer[] { 3, 3, 3, 3 }), 3));
  }
  
  public static void smallestDifference() {
    Utils.printLnIntArray(
        SmallestDifference.smallestDifference(new int[] { -1, 5, 10, 20, 28, 3 },
            new int[] { 26, 134, 135, 15, 17 }));
  }
  
  public static void threeNumberSum() {
    ThreeNumberSum.printThreeNumberSum(
      ThreeNumberSum.threeNumbersSum(new int[] { 12, 3, 1, 2, -6, 5, -8, 6 }, 0));
  }
  
  public static void caesarCypherEncryptor() {
    Utils.println(CaesarCypherEncryptor.caesarCypherEncryptor("xyz", 2));
  }
  
  public static void isPalindrome() {
    Utils.println(IsPalindrome.isPalindrome("test"));
    Utils.println(IsPalindrome.isPalindrome("abba"));
    Utils.println(IsPalindrome.isPalindrome("abbaa"));
    Utils.println(IsPalindrome.isPalindrome("zabbaz"));
  }
  
  public static void selectionSort() {
    Utils.printLnIntArray(SelectionSort.selectionSort(new int[] { 8, 1, 6, 4, 6, 1, 2, 58, 5, 1 }));
  }
  
  public static void insertionSort() {
    Utils.printLnIntArray(InsertionSort.insertionSort(new int[] { 1, 3, 2 }));
    Utils.printLnIntArray(InsertionSort.insertionSort(new int[] { 8, 1, 6, 4, 6, 1, 2, 58, 5, 1 }));
  }
  
  public static void bubbleSort() {
    Utils.printLnIntArray(BubbleSort.bubbleSort(new int[] { 8, 1, 6, 4, 6, 1, 2, 58, 5, 1 }));
  }
  
  public static void threeLargestNumbers() {
    int[] arr2 = new int[] { 141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7 };
    Utils.printLnIntArray(FindThreeLargestNumbers.findThreeLargestNumbers(arr2));

    int[] arr3 = new int[] { 55, 43, 11, 3, -3, 10 };
    Utils.printLnIntArray(FindThreeLargestNumbers.findThreeLargestNumbers(arr3));
  }
  
  public static void binarySearch() {
    int[] arr = new int[] { 0, 1, 21, 33, 45, 46, 61, 71, 72, 73 };
    Utils.println(BinarySearch.binarySearch(arr, 0));
  }
  
  public static void productSum() {
    List<Object> test = new ArrayList<Object>(Arrays.asList(1, 2, 3, 4, 5));
    Utils.println(ProductSum.productSum(test));

    List<Object> test2 = new ArrayList<Object>(Arrays.asList(1, 2, new ArrayList<Object>(Arrays.asList(3)), 4, 5));
    Utils.println(ProductSum.productSum(test2));

    List<Object> test3 = new ArrayList<Object>(
        Arrays.asList(new ArrayList<Object>(Arrays.asList(1, 2)), 3, new ArrayList<Object>(Arrays.asList(4, 5))));
    Utils.println(ProductSum.productSum(test3));
  }
  
  public static void getNthFib() {
    Utils.println(GetNthFib.getNthFib(254));
  }

  public static void linkedListConstruction2() {
    DoublyLinkedList list = new DoublyLinkedList();
    DoublyLinkedList.Node node = new DoublyLinkedList.Node(1);
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
    Utils.println(BranchSums.branchSums(tree));
  }

  public static void twoSumNumberSum() {
    TwoNumberSum.twoNumberSum_v2(new int[] { 3, 5, -4, 8, 11, 1, -1, 6 }, 10);
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

    ClosestValueInBst.closestValueInBst(tree, 12);
  }

}
