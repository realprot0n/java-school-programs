import java.util.HashMap;
import java.util.Scanner;

public class madLib {
  
  public static void print(Object str) {
    System.out.print(str);
  }

  public static void println(Object str) {
    System.out.println(str);
  }
  
  public static void printArray(Object[] objects) {
    int objectIndex = 0;
    
    print("[");
    
    for (Object obj : objects) {
      objectIndex++;
      print(obj);
      if (objectIndex < objects.length) {
        print(", ");
      }
    }
    
    println("]");
  }
  
  public static boolean isVowel(char character) {
    char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    
    for (char vowel : vowels) {
      if (vowel == character) {
        return true;
      }
    }
    
    return false;
  }
  
  public static String aOrAnBasedOnWord(String word, boolean capital) {
    char wordFirstChar = word.charAt(0);
    boolean firstIsVowel = isVowel(wordFirstChar);
    
    if (firstIsVowel) {
      if (capital) {
        return "An";
      }
      return "an";
    }

    if (capital) {
      return "A";
    }
    return "a";
  }
  
  public static String askUserQuestion(Scanner scanner, String prompt) {
    print(prompt);
    return scanner.nextLine();
  }
  public static HashMap<String, String> answers = new HashMap<>();
  
  public static String getAnAnswer(String answerKey) {
    return answers.get(answerKey);
  }

  public static void printMadLib() {
    println("On a very " + getAnAnswer("color 1") + " day, " + getAnAnswer("name 1") + " and " + getAnAnswer("name 2") + " were on their way to the nearest " + getAnAnswer("food establishment 1") + ".");
    println("What they didn't know is that there was " + aOrAnBasedOnWord(getAnAnswer("animal/person 1"), false) + " " + getAnAnswer(" "));
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    String[] questions = {"color 1", "name 1", "name 2", "food establishment 1", "animal/person 1", "transportation method 1"};

    for (String question : questions) {
      answers.put(question, askUserQuestion(scanner, "Give " + aOrAnBasedOnWord(question, false) + " " + question + ": "));
    }



    println("\nYour answers:");
    println(answers);

    printMadLib();
  }
}
