import java.util.Arrays;

public class TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    
    for (int outerIndex = 0; outerIndex < nums.length; outerIndex++) {
      for (int innerIndex = outerIndex+1; innerIndex < nums.length; innerIndex++) {
        if ((nums[outerIndex] + nums[innerIndex]) == target) {
          return new int[] {outerIndex, innerIndex};
        }
      }
    }
    return new int[] {-1, -1};
  }
  
  private static void printTwoSumDebug(int[] nums, int target) {
    System.out.println(
      "nums = " + Arrays.toString(nums) + ", target = " + target + 
      "\nresult: " + Arrays.toString(twoSum(nums, target)) + "\n"
    );
  }
  
  public static void main(String[] args) {
    printTwoSumDebug(new int[] {2, 7, 11, 15}, 9);
    printTwoSumDebug(new int[] {3, 2, 4}, 6);
    printTwoSumDebug(new int[] {3, 3}, 6);
    System.out.println("woo hoo yippee yay woo hoo yay yay");
  }
}
