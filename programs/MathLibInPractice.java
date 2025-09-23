import java.util.Scanner;

public class MathLibInPractice {
  private static Scanner scanner;
  
  public static void print(Object obj) {
    System.out.print(obj);
  }
  
  public static void println(Object obj) {
    System.out.println(obj);
  }
  
  public static void initScanner() {
    scanner = new Scanner(System.in);
  }

  public static int askForInt(String stem) {
    print(stem);
    return scanner.nextInt();
  }

  public static int rollDie() {
    return (((int) (Math.random() * Integer.MAX_VALUE)) % 5) + 1;
  }

  public static void main(String[] args) {
    initScanner();
    
    int givenInt = askForInt("What int do you want to square root? ");
    
    println(String.format("The square root of that number is: %f", Math.sqrt(givenInt)));
    println("");
    
    int num1 = askForInt("Give a number. ");
    int num2 = askForInt("Give another number. ");
    println(String.format("The largest number of those two is: %d", Math.max(num1, num2)));
    println("");
    
    println(String.format("You (I) rolled a die!\nYou (I) got: %d", rollDie()));
  }
}
