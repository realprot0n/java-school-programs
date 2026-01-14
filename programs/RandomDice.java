import java.util.Scanner;
public class RandomDice {
  public static int rollDie(int sides) {
    return (int) (Math.random() * sides) + 1;
  }
  
  private final static int defaultSides = 6;
  public static int rollDie() {
    return rollDie(defaultSides);
  }
  
  public static int sum(int[] ints) {
    int sum = 0;
    for (int numb : ints) {
      sum += numb;
    }
    
    return sum;
  }
  
  public static double getAverageOfNRolls(int rolls) {
    // because i apparently have to use an array
    int[] eachRoll = new int[rolls];
    
    for (int index = 0; index < rolls; index++) {
      eachRoll[index] = rollDie();
      //System.out.println(eachRoll[index]);
    }
    
    return ((float) sum(eachRoll))/((float) rolls);
  }
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    System.out.print("How many rolls to average?!?!\nRolls: ");
    int rollNum = scan.nextInt();
    scan.nextLine(); // consume the "\n" om nom nom nom nom nom
    scan.close();
    
    double average = getAverageOfNRolls(rollNum);
    
    System.out.println(String.format(
      "\nAverage of da rolls: %f",
      average
    ));
  }
}
