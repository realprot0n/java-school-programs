import java.util.Scanner;

public class AlphaFun {
  public static char charAtS(String str, int index) {
    if (index >= str.length()) {
      return ' ';
    }
    return str.charAt(index);
  }
  
  public static String StrToAlphaFun(String str) {
    return String.valueOf(new char[] {
      charAtS(str, 2),
      charAtS(str, 4),
      str.charAt(str.length()-1),
      str.charAt(0)
    });
  }
  
  public static String[] readStringArr(Scanner scan) {
    int elementCount = scan.nextInt();
    scan.nextLine();

    String[] strings = new String[elementCount];
    for (int elementIndex = 0; elementIndex < elementCount; elementIndex++) {
      strings[elementIndex] = scan.nextLine();
    }

    return strings;
  }
}
