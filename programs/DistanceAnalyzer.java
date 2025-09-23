public class DistanceAnalyzer {
  public static int getDistance(int a, int b) {
    return Math.abs(a-b);
  }
  
  public static int getClosestSquareFromDistance(int a, int b) {
    int distance = getDistance(a, b);
    double root = Math.sqrt(distance);
    return (int) root;
  }
  
  public static void main(String[] args) {
    System.out.println(getClosestSquareFromDistance(3, 12)); // Is a perfect square (9)
    System.out.println(getClosestSquareFromDistance(5, 20)); // Not a perfect square, returns closest perfect square (9)
    System.out.println(getClosestSquareFromDistance(7, 7));  // Is a "perfect" square (0)
  }
}
