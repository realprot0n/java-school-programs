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

class BasicArithmetic {
  public static byte boolToByte(boolean bool) {
    return (byte) (bool ? 1 : 0);
  }
  
  public static int getRandomInt() {
    return (int) (Math.random() * Integer.MAX_VALUE);
  }
  
  public static int getRandomInt(int max) {
    return getRandomInt() % max;
  }
  
  public static byte getRandomByte() {
    return (byte) (Math.random()*256);
  }
  
  public static byte getRandomByte(byte max) {
    return (byte) (getRandomByte() % max);
  }
  
  public static String intIntoTwoWide(int integer) {
    if ((integer < 10) && (integer >= 0)) {
      return integer + " ";
    }
    
    return String.valueOf(integer);
  }
  
  public static String intIntoThreeWide(int integer) {
    if ((integer < 100) && (integer > -10)) {
      return intIntoTwoWide(integer) + " ";
    }
    
    return String.valueOf(integer);
  }
  
  public static boolean isCharInArray(char character, char[] charArray) {
    for (char currentChar : charArray) {
      if (character == currentChar) {
        return true;
      }
    }
    return false;
  }

  public static boolean isCharUpper(char character) {
    return (character >= 'A' && (character <= 'Z'));
  }

  public static boolean isCharLower(char character) {
    return ((character >= 'a') && (character <= 'z'));
  }

  public static char makeCharUpper(char character) {
    if (isCharUpper(character)) {
      return character;
    }
    
    // The space character's ascii value is 32, and the space between the uppercase and lowercase sections of ascii are 32 characters apart.
    // Uppercase comes before lowercase in ascii, so we subtract 32 from the char.
    return (char) (character - ' ');
  }
  
  public static boolean isCharNum(char character) {
    return ((character >= '0') && (character <= '9'));
  }
  
  // private static boolean isCharPartOfNum(char character) {
  //   return (
  //     ((character >= '0') && (character <= '9')) ||
  // 
  //   )
  // }
  
  public static boolean isStringNum(String string) {
    int charIndex = -1;
    for (char character : string.toCharArray()) {
      charIndex++;

       
    }
    return false;
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

  static public int askForInt(String stem) {
    if (!initialized) {
      return -1;
    }

    Output.print(stem);
    String userInput = nextLine();

    while (true) {

    }
  }
}


public class CoolAssInputClass {
  public static void main(String[] args) {
    
  }
}