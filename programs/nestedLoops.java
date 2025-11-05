public class nestedLoops {
  public static void main(String[] args) {
    for (int rowIndex = 10; rowIndex > 0; rowIndex--) {
      for (int numbIndex = 0; numbIndex < rowIndex; numbIndex++) {
        System.out.print(rowIndex + " ");
      }
      System.out.println("");
    }
  }
}
