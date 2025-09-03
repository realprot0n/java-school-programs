public class persistentBugger {
  public static void println(Object obj) {
    System.out.println(obj);
  }
  
  public static void print(Object obj) {
    System.out.print(obj);
  }

  private static int charIntoInt(char character) {
    if (character < '0' || character > '9') {
      return -1;
    }
    return character - '0';
  }

  private static int persistenceRecursion(long number, int level) {
    if (String.valueOf(number).length() <= 1) {
      return 0;
    }
    long result = 1;

    for (char digitChar : String.valueOf(number).toCharArray()) {
      result = result * charIntoInt(digitChar);
    }

    return persistenceRecursion(result, level) + 1;
  }

  public static int persistence(long number) {
    return persistenceRecursion(number, 0);
  }

  public static void main(String[] args) {
    print(persistence(999));
  }
}
