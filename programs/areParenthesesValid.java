public class areParenthesesValid {
  private static void println(Object str) {
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
      
      // A closing parenthesis appeared without a preceeding parenthesis.
      if (openParenthesesCounter < 0) {
        return false;
      }
    } 
    // Not all open parenthesis have a corresponding closing parenthesis.
    if (openParenthesesCounter != 0) {
      return false;
    }
    
    return true;
  }
  
  public static void printParenthesesValidity(String parentheses, int spaces) {
    String spacerSpaces = "";

    for (int i = 0; i < spaces-parentheses.length(); i++) {
      spacerSpaces += " ";
    }

    println(String.format("\"%s\"%s=> %s", parentheses, spacerSpaces, checkParenthesesValidity(parentheses)));
  }

  private static int findLongestString(String[] strings) {
    int longestString = 0;

    for (String string : strings) {
      if (string.length() > longestString) {
        longestString = string.length();
      }
    }

    return longestString;
  }

  public static void printManyParenthesesValidity(String[] parenthesesStrings) {
    int longestParentheses = findLongestString(parenthesesStrings);

    for (String parentheses : parenthesesStrings) {
      printParenthesesValidity(parentheses, longestParentheses+1);
    }
  }
  
  public static void main(String[] args) {
    String[] parentheseses = {
      "()",
      ")(()))",
      "(",
      "(())((()())())",
      ")(",
      "()(()())((()(()()))()())"
    };

    printManyParenthesesValidity(parentheseses);
  }
}
