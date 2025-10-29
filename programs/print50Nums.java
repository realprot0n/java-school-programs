import java.util.Scanner;

public class print50Nums {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Enter a number between 0 and 50:");
    int startNum = scan.nextInt();
    scan.nextLine();
    
    if (startNum < 0 || startNum > 50) {
      System.out.println("error");
      scan.close();
      return;
    }
    
    for (int currNum = startNum; currNum <= 50; currNum++) {
      System.out.print(currNum + " ");
      
      if ((currNum - startNum + 1) % 5 == 0) {
        System.out.println();
      }
    }
    
    scan.close();
  }
}
