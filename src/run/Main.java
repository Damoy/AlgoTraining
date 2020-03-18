package run;

import algos.ClosestValueInBst;
import algos.TwoNumberSum;
import model.Array;
import model.BST;
import model.Input;

public class Main {

	public static void main(String[] args) {
		twoSumNumberSum();
		closestValueInBst();
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
