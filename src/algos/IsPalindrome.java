package algos;

public class IsPalindrome {

  public static boolean isPalindrome(String str) {
    int len = str.length();
    for (int i = 0; i < len >> 1; ++i) {
      if (str.charAt(i) != str.charAt(len - 1 - i)) {
        return false;
      }
    }
    return true;
  }
  
}
