import java.util.Scanner;

public class CastingPractice {
  public static void println(Object obj) {
    System.out.println(obj);
  }

  public static void print(Object obj) {
    System.out.print(obj);
  }

  private static Scanner scanner;
  public static int askForInt(String stem) {
    print(stem);
    return scanner.nextInt();
  }


  public static void miniProject() {
    float applePrice = 0.50f;
    float bananaPrice = 0.75f;

    double total = 0;
    println("");

    total += applePrice * askForInt("How many apples? ");
    total += bananaPrice * askForInt("How many bananas? ");

    println(total);
    
    if (total > 10) {
      println("Your order is over $10, 20% discount available!");
      total *= .8;
      println(String.format("New total: %.2f", total));
    }
  }

  @SuppressWarnings("unused")
  public static void main(String[] args) {
    int x = 10;
    int y = 4;
    double z = x / (double) y;
    println(z);

    double result = (double) 15/2;
    println(result);

    byte age;
    int daysSinceStart;
    float bankAccountBalance;

    x += 10;
    int total = 24;
    int count = 100;

    total *= 4;
    count /= 2;

    int n = 20;
    n -= 4;
    n *= 2;
    n /= 8;
    println(n);

    double points = 50;

    points += 20;
    points -= 5;
    points *= 2;
    points /= 5;
    println(points);

    scanner = new Scanner(System.in);
    miniProject();
    scanner.close();
  }
}
