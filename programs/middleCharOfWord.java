public class middleCharOfWord {
  private static void println(Object object) {
    System.out.println(object);
  }

  public static String middle(String string) {
    float middleOfString = string.length() / 2;
    if ((string.length() % 2) == 0) {
      return String.valueOf(string.charAt((int) middleOfString)) +
             string.charAt((int) middleOfString + 1);
    }
    
    return String.valueOf(string.charAt((int) middleOfString));
  }
  
  public static void main(String[] args) {
    println(middle("car"));
    println(middle("word"));
    println(middle("albuquerque"));
  }
}
