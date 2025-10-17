import java.util.Scanner;

public class LineSquatters {
  private static boolean strIsNumeric(String str) {
    for (char character : str.toCharArray()) {
      if (((character < '0') || (character > '9')) && (character != '-')) {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    while (scan.hasNext()) {
      String line = scan.nextLine();
      
      int sum = 0;
      for (String item : line.split(" ")) {
        if (strIsNumeric(item)) {
          sum += Integer.parseInt(item);
        }
      }
      
      if (sum == 0) {
        System.out.println("NONE");
      } else {
        System.out.println("SQUATTER SUM = "+ sum);
      }
    }
    scan.close();
  }
}
