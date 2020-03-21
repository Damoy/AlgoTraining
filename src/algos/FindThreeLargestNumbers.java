package algos;

public class FindThreeLargestNumbers {

  public static int[] findThreeLargestNumbers(int[] array) {
    int m1 = Integer.MIN_VALUE;
    int m2 = Integer.MIN_VALUE;
    int m3 = Integer.MIN_VALUE;

    for (int x : array) {
      if (x > m1) {
        m3 = m2;
        m2 = m1;
        m1 = x;
      } else if (x > m2) {
        m3 = m2;
        m2 = x;
      } else if (x > m3) {
        m3 = x;
      }
    }

    return new int[] { m3, m2, m1 };
  }
  
}
