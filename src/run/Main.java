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

import algos.BranchSums.BinaryTree;
import algos.BranchSums;
import algos.ClosestValueInBst;
import algos.DepthFirstSearch.Node;
import algos.DoublyLinkedList;
import algos.TwoNumberSum;
import model.BST;
import utils.Array;
import utils.Input;
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

    List<Object> test2 = new ArrayList<Object>(Arrays.asList(1, 2, new ArrayList<Object>(Arrays.asList(3)), 4, 5));
    Utils.println(productSum(test2));

    List<Object> test3 = new ArrayList<Object>(
        Arrays.asList(new ArrayList<Object>(Arrays.asList(1, 2)), 3, new ArrayList<Object>(Arrays.asList(4, 5))));
    Utils.println(productSum(test3)); // 3 * (1 + 2) + 3 + 3 * (4 + 5) = 9 + 3 + 12 + 15 = 28+12 = 40

    int[] arr = new int[] { 0, 1, 21, 33, 45, 46, 61, 71, 72, 73 };

    Utils.println(binarySearch(arr, 0));

    int[] arr2 = new int[] { 141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7 };
    Utils.printLnIntArray(findThreeLargestNumbers(arr2));

    int[] arr3 = new int[] { 55, 43, 11, 3, -3, 10 };
    Utils.printLnIntArray(findThreeLargestNumbers(arr3));
    Utils.printLnIntArray(bubbleSort(arr2));
    Utils.printLnIntArray(bubbleSort(new int[] { 1, 3, 2 }));
    Utils.printLnIntArray(insertionSort(new int[] { 1, 3, 2 }));
    Utils.printLnIntArray(insertionSort(new int[] { 8, 1, 6, 4, 6, 1, 2, 58, 5, 1 }));
    Utils.printLnIntArray(selectionSort(new int[] { 8, 1, 6, 4, 6, 1, 2, 58, 5, 1 }));
    Utils.println(isPalindrome("test"));
    Utils.println(isPalindrome("abba"));
    Utils.println(isPalindrome("abbaa"));
    Utils.println(isPalindrome("zabbaz"));
    Utils.println(caesarCypherEncryptor("xyz", 2));
    printThreeNumberSum(threeNumberSum(new int[] { 12, 3, 1, 2, -6, 5, -8, 6 }, 0));
    Utils.printLnIntArray(
        smallestDifference_sort(new int[] { -1, 5, 10, 20, 28, 3 }, new int[] { 26, 134, 135, 15, 17 }));
    Utils.println(moveElementToEnd(Arrays.asList(new Integer[] { 2, 1, 2, 2, 2, 3, 4, 2 }), 2));
    Utils.println(moveElementToEnd(Arrays.asList(new Integer[] { 3, 3, 3, 3 }), 3));
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
