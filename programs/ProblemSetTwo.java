public class ProblemSetTwo {
  public static void println(Object obj) {
    System.out.println(obj);
  }

  public static String getMiddleChars(String string) {
    if ((string.length() % 2) == 1) {
      return Character.toString(
        string.charAt(string.length()/2)
      );
    }
    
    double middleOfString = ((double) string.length()+1)/2d;
    
    return String.format("%c%c",
      string.charAt((int) Math.floor(middleOfString)),
      string.charAt((int) Math.ceil(middleOfString))
    );
  }


  public static void main(String[] args) {
    println(getMiddleChars("car"));
    println(getMiddleChars("word"));
  }
}
