package utils;

public final class Utils {

  private Utils() {}
  
  public static void print(Object o) {
    System.out.print(o.toString());
  }
  
  public static void println(Object o) {
    System.out.println(o.toString());
  }
  
  public static <T> String arrayToString(T[] arr) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for(int i = 0; i < arr.length - 1; ++i) {
      sb.append(arr[i].toString());
      sb.append(", ");
    }
    
    sb.append(arr[arr.length - 1].toString());
    sb.append("]");
    return sb.toString();
  }
  
  public static <T> void printArray(T[] arr) {
    print(arrayToString(arr));
  }
  
  public static <T> void printLnArray(T[] arr) {
    println(arrayToString(arr));
  }
  
  public static String intArrayToString(int[] arr) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for(int i = 0; i < arr.length - 1; ++i) {
      sb.append(arr[i]);
      sb.append(", ");
    }
    
    if(arr.length > 0) {
      sb.append(arr[arr.length - 1]);
    }
    sb.append("]");
    return sb.toString();
  }
  
  public static void printIntArray(int[] arr) {
    print(intArrayToString(arr));
  }
  
  public static void printLnIntArray(int[] arr) {
    println(intArrayToString(arr));
  }
  
}
