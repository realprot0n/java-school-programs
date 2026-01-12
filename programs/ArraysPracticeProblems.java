public class ArraysPracticeProblems {
  private static String arrayToString(Object[] array) {
    String returnString = "[";
    for (Object obj : array) {
      returnString += String.valueOf(obj) + ", ";
    }
    returnString = returnString.substring(0, returnString.length() - 2);
    return returnString + "]";
  }
  
  public static Integer findSecondLargest(Integer[] ints) {
    if (ints.length < 2) {
      return null;
    }
    
    Integer largest = null;
    Integer secondLargest = null;
    
    for (Integer numb : ints) {
      if (largest == null) {
        largest = numb;
        
      } else if (numb > largest) {
        secondLargest = largest;
        largest = numb;
        
      } else if (numb != largest) {
        if ((secondLargest == null) || (numb > secondLargest)) {
          secondLargest = numb;
        }
      }
    }
    return secondLargest;
  }
  
  public static Integer findThirdLargest(Integer[] ints) {
    if (ints.length < 3) {
      return null;
    }
    
    Integer largest = null;
    Integer secondLargest = null;
    Integer thirdLargest = null;
    
    for (Integer numb : ints) {
      if (largest == null) {
        largest = numb;
        continue;
      }
      else if (numb > largest) {
        thirdLargest = secondLargest;
        secondLargest = largest;
        largest = numb;
        continue;
      }
      else if (numb == largest) {
        continue;
      }
      
      if (secondLargest == null) {
        secondLargest = numb;
        continue;
      }
      else if (numb > secondLargest) {
        thirdLargest = secondLargest;
        secondLargest = numb;
        continue;
      }
      else if (numb == secondLargest) {
        continue;
      }
      
      if ((thirdLargest == null) || (numb > thirdLargest)) {
        thirdLargest = numb;
      }
    }
    
    return thirdLargest;
  }
  
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
  
  private static Object[] subarray(Object[] array, int beginIndex, int endIndex) {
    Object[] retArray = new Object[endIndex-beginIndex];
    for (int index = beginIndex; index < endIndex; index++) {
      if (array.length <= index) {
        break;
      }
      retArray[index-beginIndex] = array[index];
    }
    return retArray;
  }
  
  private static int countInnerObjs(Object[][] array) {
    int count = 0;
    
    for (Object[] innerArray : array) {
      for (Object obj : innerArray) {
        if (obj != null) {
          count++;
        }
      }
    }
    
    return count;
  }
  
  private static Object[] mergeArrays(Object[][] array) {
    Object[] retArray = new Object[countInnerObjs(array)];
    
    int index = 0;
    for (Object[] innerArray : array) {
      for (Object obj : innerArray) {
        if (obj == null) {
          continue;
        }
        retArray[index] = obj;
        index++;
      }
    }
    
    return retArray;
  }
  
  public static Object[] reverseArrayGroups(Object[] array, int groupSize) {
    if (groupSize >= array.length) {
      return reverseArray(array);
    }
    Object[][] groups = new Object[(array.length / groupSize) + 1][groupSize];
    
    int arrIndex = 0;
    while (arrIndex < array.length) {
      
      groups[arrIndex/groupSize] = reverseArray(subarray(array, arrIndex, arrIndex + groupSize));
      
      arrIndex += groupSize;
    }
    
    return mergeArrays(groups);
  }
  
  private static void findSecondLargestDebug(Integer[] ints) {
    System.out.println("Second largest of " + arrayToString(ints) + " is " + findSecondLargest(ints));
  }
  
  private static void findThirdLargestDebug(Integer[] ints) {
    System.out.println("Third largest of " + arrayToString(ints) + " is " + findThirdLargest(ints));
  }
  
  private static void reverseArrayDebug(Object[] array) {
    System.out.println(arrayToString(array) + " reversed is " + arrayToString(reverseArray(array)));
  }
  
  private static void reverseArrayGroupsDebug(Object[] array, int groupSize) {
    System.out.println(arrayToString(array) + " with " + groupSize + " sized groups reversed is " + 
                      arrayToString(reverseArrayGroups(array, groupSize))
  );
  }
  
  public static void main(String[] args) {
    findSecondLargestDebug(new Integer[] {12, 35, 1, 10, 34, 1});
    findSecondLargestDebug(new Integer[] {10, 5, 10});
    findSecondLargestDebug(new Integer[] {10, 10, 10});
    
    System.out.println();
    
    findThirdLargestDebug(new Integer[] {2, 4, 1, 3, 5});
    findThirdLargestDebug(new Integer[] {10, 2});
    findThirdLargestDebug(new Integer[] {5, 5, 5});
    
    System.out.println();
    
    reverseArrayDebug(new Integer[] {1, 4, 3, 2, 6, 5});
    reverseArrayDebug(new Integer[] {4, 5, 2});
    reverseArrayDebug(new Integer[] {1});
    
    System.out.println();
    
    reverseArrayGroupsDebug(new Integer[] {1, 2, 3, 4, 5}, 3);
  }
}
