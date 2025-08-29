public class areParenthesesValid {
  public static void println(Object str) {
    System.out.println(str);
  }
  
  public static boolean checkParenthesesValidity(String parentheses) {
    int openParenthesesCounter = 0;
    for (char currParentheses : parentheses.toCharArray()) {
      if (currParentheses == ')') {
        openParenthesesCounter--;
      } else if (currParentheses == '(') {
        openParenthesesCounter++;
      }
      
      if (openParenthesesCounter < 0) {
        return false;
      }
    }
    
    if (openParenthesesCounter != 0) {
      return false;
    }
    
    return true;
  }
  
  public static void printParenthesesValidity(String parentheses) {
    println(String.format("\"%s\" => %s", parentheses, checkParenthesesValidity(parentheses)));
  }
  
  public static void main(String[] args) {
    printParenthesesValidity("()");
    printParenthesesValidity(")(()))");
    printParenthesesValidity("(");
    printParenthesesValidity("(())((()())())");
  }
}
