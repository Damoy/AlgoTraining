package algos;

public class GetNthFib {

  public static int getNthFib(int n) {
    int[] mem = new int[] { 0, 1 };
    --n;

    if (n < 2 && n >= 0) {
      return mem[n];
    }

    int currentSum = 1;
    for (int i = 2; i <= n; ++i) {
      currentSum = mem[0] + mem[1];
      mem[0] = mem[1];
      mem[1] = currentSum;
    }

    return mem[1];
  }
  
}
