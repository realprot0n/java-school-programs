import java.util.Arrays;

public class ReversingArrays {
  public static Object[] reverseArray(Object[] array) {
    int leftPointer = 0;
    int rightPointer = array.length - 1;
    
    while (leftPointer < rightPointer) {
      Object temp;
      
      temp = array[leftPointer];
      array[leftPointer] = array[rightPointer];
      array[rightPointer] = temp;
      
      leftPointer++;
      rightPointer--;
    }
    return array;
  }
  
  private static void reverseArrayDebug(Object[] array) {
    System.out.println(String.format("Input: %s\nOutput: %s\n",
      Arrays.toString(array), Arrays.toString(reverseArray(array))));
  }
  
  public static void main(String[] args) {
    reverseArrayDebug(new Integer[] {1, 4, 3, 2, 6, 5});
    reverseArrayDebug(new Integer[] {4, 5, 1, 2});
  }
}
