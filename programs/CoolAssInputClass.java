import java.util.Scanner;

class Input {
  static Scanner scanner;
  static boolean initialized;
  static boolean lastWasInt;
  
  public static void initialize(Scanner setScanner) {
    if (initialized) {
      return;
    }
    
    scanner = setScanner;
    lastWasInt = false;
  }

  static public void fixIntNewline() {
    if (!initialized) {
      return;
    }

    scanner.nextLine();
  }

  static public void initialize() {
    initialize(new Scanner(System.in));
  }

  static public int nextInt() {
    if (!initialized) {
      return -1;
    }
    lastWasInt = true;
    int userInput = scanner.nextInt();
    
    scanner.nextLine(); // Fix the bug with nextInt
    return userInput;

  }

  static public String nextLine() {
    return scanner.nextLine();
  }
}


public class CoolAssInputClass {
  public static void main(String[] args) {
    
  }
}