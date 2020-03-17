package run;

import algos.TwoNumberSum;
import model.Array;
import model.Input;

public class Main {

	public static void main(String[] args) {
		twoSumNumberSum();
	}
	
	public static void twoSumNumberSum() {
		Input input = new Input();
		input.addEntry(Array.class, Array.from(new Integer[] {3, 5, -4, 8, 11, 1, -1, 6}));
		input.addEntry(Integer.class, 10);
		new TwoNumberSum().run(input);
	}

}
