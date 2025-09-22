import java.util.Scanner;

public class EfficientPrimes {
  public static void println(Object obj) {
    System.out.println(obj);
  }
  
  private static Scanner scanner = null;
  public static void initializeScanner() {
    scanner = new Scanner(System.in);
  }
  
  public static int askForInt(String stem) {
    println(stem);
    return scanner.nextInt();
  }
  
  public static boolean isPerfectSquare(int value) {
    if (value < 0) {
      return false;
    } else if (value == 0) {
      return true;
    }
    
    int root = (int) Math.sqrt(value);
    
    return (root*root) == value;
  }
  
  public static boolean isPrime(int value, int certainty) {
    if (value <= 1) {
      return false;
    }
    
    if (certainty >= value/2) {
      certainty = (value/2) - 1;
    }
    double a = Math.ceil(Math.sqrt(value));
    
    double bSquared = a*a - value;
    
    while (!isPerfectSquare((int) bSquared)) {
      a++;
      bSquared = a*a - value;
    }
    if ((Math.pow(certainty, value) % value) == (certainty % value)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    initializeScanner();
    println(isPrime(
      askForInt("What value do you want to test?"),
      askForInt("what certainty do you want to use?")
    ));
  }
}
