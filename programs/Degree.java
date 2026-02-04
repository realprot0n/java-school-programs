import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Degree {
  public static int sum(int[] array) {
    int sum = 0;
    for (int number : array) {
      sum += number;
    }
    return sum;
  }
  
  public static int[] subDegreesOfArray(int[] array) {
    int length = array.length;
    int[] subDegrees = new int[length];
    for (int index = 0; index < length; index++) {
      for (int subIndex = index; subIndex < length; subIndex++) {
        subDegrees[index] += array[index] > array[subIndex] ? 1 : 0;
      }
    }
    return subDegrees;
  }
  
  public static int[] stringIntoIntArray(String str, String delimiter) {
    String[] strNums = str.split(delimiter);
    int[] nums = new int[strNums.length];
    for (int index = 0; index < strNums.length; index++) {
      nums[index] = Integer.valueOf(strNums[index]);
    }
    return nums;
  }
  
  public static void main(String[] args) throws FileNotFoundException {
    // IF THIS LINE THROWS AN ERROR, REPLACE THE STRING WITH THE RELATIVE PATH TO degree.dat !! !!
    File file = new File("programs\\degree.dat");
    Scanner scan = new Scanner(file);
    
    int arrays = scan.nextInt();
    scan.nextLine();
    for (int lineIndex = 0; lineIndex < arrays; lineIndex++) {
      int[] numbers = stringIntoIntArray(scan.nextLine(), " ");
      int[] subDegrees = subDegreesOfArray(numbers);
      System.out.println(sum(subDegrees));
    }

    scan.close();
  }
}
