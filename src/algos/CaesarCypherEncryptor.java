package algos;

public class CaesarCypherEncryptor {

  public static String caesarCypherEncryptor(String str, int key) {
    String dico = "abcdefghijklmnopqrstuvwxyz";
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); ++i) {
      char c = str.charAt(i);
      int index = dico.indexOf(c);
      sb.append(dico.charAt((index + key) % 26));
    }
    return sb.toString();
  }
  
}
