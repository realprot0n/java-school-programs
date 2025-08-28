import java.util.Scanner;

public class practiceInput {
  public static void println(Object obj) {
    System.out.println(obj);
  }
  
  public static void print(Object obj) {
    System.out.print(obj);
  }

  public static String askQuestionForString(Scanner scanner, String question) {
    print(question);
    return scanner.nextLine();
  }

  public static int askQuestionForInt(Scanner scanner, String question) {
    print(question);
    return scanner.nextInt();
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
    return askQuestionForString(scanner, "Word: ");
  }

  public static void printWordsReversed(Scanner scanner) {
    String wordOne = getAWord(scanner);
    String wordTwo = getAWord(scanner);
    String wordThree = getAWord(scanner);

    println(wordThree);
    println(wordTwo);
    println(wordOne);
  }

  public static void printRectangle(int height, int width) {
    boolean printedWidth = false;
    for (int spaces = 0; spaces < width+2; spaces++) {
      print(" ");
      if (!printedWidth && spaces > width) {
        printedWidth = true;
        print(width);
      }
    }
    println("");

    print(" ");
    
    for (int widthIndex = 0; widthIndex < width*2; widthIndex++) {
      print("_");
    }
    print(" ");
    println("");

    boolean printedHeight = false;
    for (int heightIndex = 0; heightIndex < height; heightIndex++) {
      print("|");
      if (heightIndex != height - 1) {
        for (int widthIndex = 0; widthIndex < width*2; widthIndex++) {
          print(" ");
        }
      } else {
        for (int widthIndex = 0; widthIndex < width*2; widthIndex++) {
          print("_");
        }
      }
      print("|");

      if (!printedHeight && heightIndex > height/2) {
        printedHeight = true;
        print(" ");
        print(height);
      }

      println("");
    }
  }

  public static void printAreaOfRectangle(Scanner scanner) {
    println("Height of the rectangle");
    int rectangleHeight = askQuestionForInt(scanner, "Height: ");
    println("Width of the rectangle");
    int rectangleWidth = askQuestionForInt(scanner, "Width: ");

    printRectangle(rectangleHeight, rectangleWidth);    
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    sayHello(scanner);
    
    repeatFavNumber(scanner);
    
    calculateAverageTestScore(scanner);
    
    print("Just press enter if you get stuck here");
    scanner.nextLine();
    println("");
    
    printWordsReversed(scanner);

    printAreaOfRectangle(scanner);

    scanner.close();
  }
}