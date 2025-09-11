import java.util.Scanner;

class Output {
  public static void println(Object obj) {
    System.out.println(obj);
  }
  
  public static void println() {
    println("");
  }
  
  public static void print(Object obj) {
    System.out.print(obj);
  }
}

class Input {
  static Scanner scanner;
  static boolean initialized;
  
  public static void initialize(Scanner setScanner) {
    if (initialized) {
      return;
    }
    
    scanner = setScanner;
  }

  static public void initialize() {
    initialize(new Scanner(System.in));
  }

  static public int nextInt() {
    if (!initialized) {
      return -1;
    }
    int userInput = scanner.nextInt();
    
    scanner.nextLine(); // Fix the bug with nextInt adding a newline to the buffer
    return userInput;
  }

  static public String nextLine() {
    if (!initialized) {
      return null;
    }

    return scanner.nextLine();
  }

  static public String askForString(String stem) {
    Output.print(stem);
    return nextLine();
  }
}


public class CoolAssInputClass {
  public static void main(String[] args) {
    
  }
}