import java.util.HashMap;
import java.util.Scanner;

public class madLib {
  
  public static void print(Object str) {
    System.out.print(str);
  }
  
  public static void println(Object str) {
    System.out.println(str);
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
  
  public static String getAnswer(String answerKey) {
    return answers.get(answerKey);
  }

  public static void printMadLib() {
    println("On a very " + getAnswer("color 1") + " day, " + getAnswer("name 1") + " and " + getAnswer("name 2") + " were on their way to the nearest " + getAnswer("food establishment 1") + ".");
    println("What they didn't know is that there was " + aOrAnBasedOnWord(getAnswer("animal/person 1"), false) + " " + getAnswer("animal/person 1") + " who had just sudo rm -rf'd their entire database!!");
    println("Luckily, their " + getAnswer("communication device 1") + " buzzed with a notification of it happening.");
    
    println("");
    println("So, " + getAnswer("name 1") + " picked up the " + getAnswer("communication device 1") + ", and their " + getAnswer("body part 1") + " fell agape.");
    println("Now " + getAnswer("name 1") + " and " + getAnswer("name 2") + " KNEW they had to run and use their " + getAnswer("transportation method 1") + " to go home and stop the evil ass " + getAnswer("animal/person 1") + " from ruining their database!!");
    println("So they hopped on, but not before getting their " + getAnswer("edible thing 1") + " from their beloved " + getAnswer("food estabishment 1") + ".");
    println("After a short snack, the tuah them rode the " + getAnswer("transportation method 1") + " as fast as they could, running over all of the " + getAnswer("vehicle 1") + "s and running every single " + getAnswer("color 2") + " " + getAnswer("vehicle 2") + " off the road.");
    
    println("");
    println("Once they got home, at " + getAnswer("address 1") + ", they " + getAnswer("verb 1") + " the door to the house and " + getAnswer("verb 2") + " " + getAnswer("animal/person1") + "'s bones and stole their " + getAnswer("a thing you would use money for 1") + " money.");
    println(getAnswer("name 1") + " and " + getAnswer("name 2") + " thought that all of their data was permanently " + getAnswer("adjective 1") + ", but the foolish " + getAnswer("animal/person 1") + " saved all the data to a USB drive in their backpack, along with the fool's " + getAnswer("thing you would find in a backpack 1") + " and " + getAnswer("thing you would find in a backpack 2") + ".");
    println("So, all the two had to do was " + getAnswer("verb 3") + " the data from the USB onto their computer and the " + getAnswer("noun 1") + " was saved!!!!!!!!");
  }

  public static void startMadLib(Scanner scanner) { 
    String[] questions = {"color 1", "name 1", "name 2", "food establishment 1", "animal/person 1", "communication device 1", "transportation method 1", "body part 1", "edible thing 1", "color 2", "vehicle 1", "vehicle 2", 
                          "address 1", "verb 1", "verb 2", "a thing you would use money for 1", "adjective 1", "thing you would find in a backpack 1", "thing you would find in a backpack 2", "verb 3", "noun 1"};
    
    for (String question : questions) {
      answers.put(question, askUserQuestion(scanner, "Give " + question + ": "));
    }

    println("\nYour answers:");
    println(answers);
    println("");
    
    printMadLib();

    if (askUserQuestion(scanner, "Do you want to play again? (y/n) ").equals("y")) {
      startMadLib(scanner);
    }
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    startMadLib(scanner);
    
    scanner.close();
  }
}
