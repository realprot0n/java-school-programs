import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Encryption {
  private static int encryptDigit(int digit) {
    return (digit + 7) % 10;
  }
  
  private static int[] strIntoDigitArr(String str) {
    int[] returnDigits = new int[str.length()];
    
    for (int index = 0; index < str.length(); index++) {
      returnDigits[index] = Character.digit(str.charAt(index), 10);
    }
    
    return returnDigits;
  }
  
  private static int[] swapDigits(int[] digits, int offset) {
    if (digits.length < 4) {
      return new int[] {};
    }
    return new int[] {
      digits[2 + offset],
      digits[3 + offset],
      digits[0 + offset],
      digits[1 + offset]
    };
  }
  
  private static long digitArrToLong(int[] digits) {
    long result = 0;
    for (int digitIndex = 0; digitIndex < digits.length; digitIndex++) {
      result += (long) (Math.pow(10, digitIndex) * digits[digits.length-digitIndex-1]);
    }
    return result;
  }
  
  public static long encryptCreditCardNum(String number) {
    int[] digits = strIntoDigitArr(number);

    for (int digitIndex = 0; digitIndex < digits.length; digitIndex++) {
      digits[digitIndex] = encryptDigit(digits[digitIndex]);
    }
    
    for (int offset = 0; offset < 4; offset++) {
      int[] result = swapDigits(digits, offset*4);
      
      for (int resultIndex = 0; resultIndex < result.length; resultIndex++) {
        digits[resultIndex+offset*4] = result[resultIndex];
      }
    }
    
    return digitArrToLong(digits);
  }
  
  public static long encryptCreditCardNum(long number) {
    return encryptCreditCardNum(String.valueOf(number));
  }
  
  public static void main(String[] args) throws FileNotFoundException {
    // IF THIS LINE THROWS AN ERROR, REPLACE THE STRING WITH THE RELATIVE PATH TO Encryption.dat !! !!
    File file = new File("programs\\Encryption.dat");
    Scanner scan = new Scanner(file);
    
    int numOfInputs = scan.nextInt();
    for (int inputIndex = 0; inputIndex < numOfInputs; inputIndex++) {
      System.out.println(String.format(
        "%016d",
        encryptCreditCardNum(scan.nextLong())
      ));
    }
    scan.close();
  }
}
