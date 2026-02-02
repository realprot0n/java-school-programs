public class FifteenArrayProblems {
  private static int getSum(int[] nums) {
    int sum = 0;

    for (int number : nums) {
      sum += number;
    }
    return sum;
  }
  
  private static double getMax(Number[] array) {
    double max = Double.MIN_VALUE;
    
    for (Number numb : array) {
      if (numb.doubleValue() > max) {
        max = numb.doubleValue();
      }
    }
    
    return max;
  }
  
  
  private static int getMaxIndex(Number[] array) {
    double max = Double.MIN_VALUE;
    int maxIndex = -1;
    
    for (int arrIndex = 0; arrIndex < array.length; arrIndex++) {
      if (array[arrIndex].doubleValue() > max) {
        max = array[arrIndex].doubleValue();
        maxIndex = arrIndex;
      }
    }
    
    return maxIndex;
  }
  
  /*
   *~O(3N) time?
   */
  public static int mostFrequentInArray(Integer[] array) {
    // not the most efficient way but im using arrays !!
    Integer[] frequencies = new Integer[array[getMaxIndex(array)]];
    
    for (int itemIndex = 0; itemIndex < array.length; itemIndex++) {
      if (frequencies[array[itemIndex] - 1] == null) {
        frequencies[array[itemIndex] - 1] = 0;
      }
      frequencies[array[itemIndex] - 1]++;
    }
    
    return getMaxIndex(frequencies) + 1;
  }
  
  public static int missingNumber(int[] array) {
    int length = array.length;
    int expected_sum = (length * (length + 1)) / 2;
    return expected_sum - getSum(array);
  }
  
  public static void main(String[] args) {
    System.out.println(mostFrequentInArray(
      new Integer[] {1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 7, 7, 7}
    ));
  }
}
