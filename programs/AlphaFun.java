import java.util.Scanner;
import java.util.Arrays;

public class AlphaFun {
  public static char charAtS(String str, int index) {
    if (index >= str.length()) {
      return ' ';
    }
    return str.charAt(index);
  }
  
  public static String strToAlphaFun(String str) {
    return String.valueOf(new char[] {
      charAtS(str, 1),
      charAtS(str, 3),
      str.charAt(str.length()-1),
      str.charAt(0)
    });
  }
  
  public static String[] strsToAlphaFun(String[] strings) {
    String[] retArray = new String[strings.length];
    for (int index = 0; index < strings.length; index++) {
      retArray[index] = strToAlphaFun(strings[index]);
    }
    
    return retArray;
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
  
  public static void main(String[] args) {
    String[] strings = readStringArr(new Scanner(System.in));
    
    System.out.println(Arrays.toString(strings));
    
    String[] alphaFuns = strsToAlphaFun(strings);
    
    System.out.println(Arrays.toString(strings));
  }
}
