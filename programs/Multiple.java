import java.util.Scanner;

public class Multiple {
  private static boolean hasAnyChars(String checked, String chars) {
    for (char character : chars.toCharArray()) {
      if (checked.contains(String.valueOf(character))) {
        return true;
      }
    }
    return false;
  }
  
  private static void doACase(Scanner scan) {
    int product = scan.nextInt();
    String digits = scan.nextLine().trim();
    int multiple = -1;
    int iterations = 0;
    while (hasAnyChars(String.valueOf(multiple), digits) || (multiple == -1)) {
      multiple = product*(iterations+2);
      iterations++;
    }
    System.out.println(multiple);
  }
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int cases = scan.nextInt();

    for (int caseNum = 0; caseNum < cases; caseNum++) {
      doACase(scan);
    }
  }
}
