import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Casting {
  private static int charToInt(char character) {
    return character - 48;
  }
  
  private static int castNum(long number) {
    int sum = 0;
    for (char digitChar : String.valueOf(number).toCharArray()) {
      sum += charToInt(digitChar);
    }
    return sum;
  }
  
  public static int castOutNines(long number) {
    int times = 0;
    while (number > 9) {
      times += 1;
      number = castNum(number);
    }
    return times;
  }
  
  
  public static Long[] readLongArray(Scanner scan) {
    int elementCount = scan.nextInt();
    //scan.nextLine();
    
    Long[] longs = new Long[elementCount];
    for (int elementIndex = 0; elementIndex < elementCount; elementIndex++) {
      longs[elementIndex] = scan.nextLong();
      //System.out.println(scan.nextLong());
    }
    
    return longs;
  }
  
  public static void main(String[] args) {
    File file = new File("programs\\casting.dat");
    Scanner scanner;
    
    try {
      scanner = new Scanner(file);
    } catch (FileNotFoundException e) {
      System.out.println("fah.");
      return;
    }
    
    Long[] longs = readLongArray(scanner);
    for (long number : longs) {
      System.out.println(castOutNines(number));
    }
    
    scanner.close();
  }
}
