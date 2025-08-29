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
    println("What they didn't know is that there was " + aOrAnBasedOnWord(getAnAnswer("animal/person 1"), false) + " " + getAnAnswer("animal/person 1") + " who had just sudo rm -rf'd their entire database!!");
    println("Luckily, their " + getAnAnswer("communication device 1") + " buzzed with a notification of it happening.");
    println("So, " + getAnAnswer("name 1") + " picked up the " + getAnAnswer("communication device 1") + ", and their " + getAnAnswer("body part 1") + " fell agape.");
    println("Now " + getAnAnswer("name 1") + " and " + getAnAnswer("name 2") + " KNEW they had to run and use their " + getAnAnswer("transportation method 1") + " to go home and stop the evil ass " + getAnAnswer("animal/person 1") + " from ruining their database!!");
    println("So they hopped on, but not before getting their " + getAnAnswer("edible thing 1") + " from their beloved " + getAnAnswer("food estabishment 1") + ".");
    println("After a short snack, the tuah them rode as fast as they could, running over all of the " + getAnAnswer("vehicle 1") + "s on their way, and running every single " + getAnAnswer("color 2"));
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    String[] questions = {"color 1", "name 1", "name 2", "food establishment 1", "animal/person 1", "communication device 1", "transportation method 1", "body part 1", "edible thing 1", "vehicle 1", "color 2"};

    for (String question : questions) {
      answers.put(question, askUserQuestion(scanner, "Give " + question + ": "));
    }

    scanner.close();

    println("\nYour answers:");
    println(answers);

    printMadLib();
  }
}
