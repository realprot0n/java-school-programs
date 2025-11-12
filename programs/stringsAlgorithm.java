import java.util.Scanner;

public class stringsAlgorithm {
  public static void print(Object obj) {
    System.out.print(obj);
  }
  
  public static void println(Object obj) {
    print(obj + "\n");
  }
  
  public static String reverseString(String str) {
    String retString = "";
    
    for (int index = str.length() - 1; index >= 0; index--) 
      retString += str.charAt(index);
    
    return retString;
  }
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    println("Enter two strings:");
    
    String str1 = scan.nextLine();
    String str2 = scan.nextLine();
    
    if (str1.length() != str2.length()) {
      println("error");
      scan.close();
      return;
    }
    
    str1 = reverseString(str1);
    str2 = reverseString(str2);
    
    for (int i = 0; i < str1.length(); i++) {
      print(str2.charAt(i));
      print(str1.charAt(i));
    }
    
    scan.close();
  }
}
