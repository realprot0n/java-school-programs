import java.util.Scanner;
import java.util.ArrayList;

public class Perfection {
  
  private static ArrayList<Integer> getFactors(int number) {
    ArrayList<Integer> factors = new ArrayList<Integer>();
    for (int testNum = 1; testNum <= number/2; testNum++) {
      if ((number % testNum) == 0) {
        factors.add(testNum);
      }
    }
    return factors;
  }
  
  private static int getSum(ArrayList<Integer> nums) {
    int sum = 0;
    for (int number : nums) {
      sum += number;
    }
    return sum;
  }
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int cases = scan.nextInt();
    
    for (int caseNum = 0; caseNum < cases; caseNum++) {
      int number = scan.nextInt();
      ArrayList<Integer> factors = getFactors(number);
      int sumOfFactors = getSum(factors);

      if (number == sumOfFactors) {
        System.out.println("PERFECT");
      } else if (number < sumOfFactors) {
        System.out.println("ABUNDANT");
      } else {
        System.out.println("DEFICIENT");
      }
      
    }
    scan.close();
  }
}
