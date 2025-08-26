import java.util.Scanner;

public class practiceInput {
  public static void println(Object obj) {
    System.out.println(obj);
  }
  
  public static void print(Object obj) {
    System.out.print(obj);
  }

  public static void sayHello(Scanner scanner) {
    println("What is your name?");
    print("Name: ");
    String userName = scanner.nextLine();

    println("What is your favorite animal?");
    print("Favorite animal: ");
    String userFavAnimal = scanner.nextLine();

    println(String.format("Hello %s. Your favorite animal is the %s.", userName, userFavAnimal));
  }

  public static void repeatFavNumber(Scanner scanner) {
    println("What is your favorite number?");
    print("Favorite number: ");
    int favoriteNumber = scanner.nextInt();

    for (int i = 0; i < 3; i++) {
      println(favoriteNumber);
    }
  }
  
  public static float getATestScore(Scanner scanner, String numberAsWord) {
    println(String.format("Enter your %s test score", numberAsWord));
    print("Score: ");
    return scanner.nextFloat();
  }

  public static void calculateAverageTestScore(Scanner scanner) {
    float scoreOne = getATestScore(scanner, "first");
    float scoreTwo = getATestScore(scanner, "second");
    float scoreThree = getATestScore(scanner, "third");

    double sum = scoreOne + scoreTwo + scoreThree;
    double average = sum / 3;

    println(String.format("The average of your test score is %.2f", average));
  }

  public static String getAWord(Scanner scanner) {
    println("Input a word");
    print("Word: ");
    return scanner.nextLine();
  }

  public static void printWordsReversed(Scanner scanner) {
    String wordOne = getAWord(scanner);
    String wordTwo = getAWord(scanner);
    String wordThree = getAWord(scanner);

    println(wordThree);
    println(wordTwo);
    println(wordOne);

  }

  public static void printAreaOfRectangle(Scanner scanner) {
    println("Length of the rectangle");
    print("Length: ");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    // sayHello(scanner);
    // 
    // repeatFavNumber(scanner);
    // 
    // calculateAverageTestScore(scanner);
    // 
    // print("Just press enter if you get stuck here");
    // scanner.nextLine();
    // println("");
    // 
    // printWordsReversed(scanner);

    printAreaOfRectangle(scanner);

    scanner.close();
  }
}