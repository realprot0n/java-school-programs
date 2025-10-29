import java.util.Scanner;

public class practiceWhile {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Input a word:");
    String string = scan.nextLine();
    int strIndex = 0;
    
    while (strIndex < string.length()) {
      if (strIndex > string.length()-2) {
        System.out.print(string.substring(strIndex));
        break;
      }
      
      System.out.print(string.substring(strIndex, strIndex+2));
      strIndex += 3;
    }
    scan.close();
  }
}
