import java.util.Scanner;

public class StringAssignmentOne {
  static Scanner scanner;

  private static void println(Object obj) {
    System.out.println(obj);
  }

  private static void print(Object obj) {
    System.out.print(obj);
  }

  private static void printf(String template, Object... args) {
    for (Object arg : args) {
      template = String.format(template, arg);
    }
    println(template);
  }

  public static void main(String[] args) {
    scanner = new Scanner(System.in);

    print("Word: ");
    String word = scanner.nextLine();
    
    printf("Length: %d", word.length());
    
    printf("First character: %c", word.charAt(0));
    printf("Last character: %c", word.charAt(word.length() - 1));

    printf("Uppercase: %s", word.toUpperCase());
    printf("Lowercase: %s", word.toLowerCase());
  }
}