import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StringShortener {
  private static void print(Object obj) {
    System.out.print(obj);
  }
  
  private static void println(Object obj) {
    System.out.println(obj);
  }
  
  private static Scanner scanner;
  private static void initScanner(Scanner givenScanner) {
    if (givenScanner == null) {
      givenScanner = new Scanner(System.in);
    }
    scanner = givenScanner;
  }
  
  private static String askForString(String prompt) {
    print(prompt);
    return scanner.nextLine();
  }
  
  private static boolean isCharInArray(Character[] array, Character obj) {
    for (Character arrayObj : array) {
      if (obj.equals(arrayObj)) {
        return true;
      }
    }
    return false;
  }
  
  /*
  * If the char is a vowel and it doesn't come at the start of the word, this returns a null character. Otherwise, it returns the given char.
  */
  private static Character[] vowels = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
  private static Character getCharIfNotVowel(Character character, int charIndexInWord) {
    if (charIndexInWord == 0) {
      return character;
    } else if (isCharInArray(vowels, character)) {
      return '\0';
    }
    return character;
  }
  
  public static int vowelsRemovedAlgorithmOne = 0;
  public static int repeatsRemovedAlgorithmOne = 0;
  public static String applyAlgorithmOne(String string) {
    string = string.toLowerCase();
    vowelsRemovedAlgorithmOne = 0;
    repeatsRemovedAlgorithmOne = 0;
    String retString = "";
    String[] words = string.split("\s+");

    for (String word : words) {
      Character lastChar = '\0';
      for (int charIndex = 0; charIndex < word.length(); charIndex++) {
        Character charToAdd = getCharIfNotVowel(word.charAt(charIndex), charIndex);
        if (charToAdd.equals('\0')) {
          lastChar = charToAdd;
          vowelsRemovedAlgorithmOne++;
          continue;
        }

        if ((!lastChar.equals('\0')) && charToAdd.equals(lastChar)) {
          lastChar = charToAdd;
          repeatsRemovedAlgorithmOne++;
          continue;
        }
        retString += charToAdd;
        lastChar = charToAdd;
      }
      retString += ' ';
    }
    return retString;
  }
  
  static String convertMapToString(Map<Character, Integer> map) {
    String retString = "";
    for (Character key : map.keySet()) {
      retString += String.format("%s%d", key, map.get(key));
    }
    return retString;
  }
  
  static Map<Character, Integer> charAmounts = new LinkedHashMap<Character, Integer>();
  private static String applyAlgorithmTwo(String inputStr) {
    inputStr = inputStr.toLowerCase();
    charAmounts.clear();
    for (Character character : inputStr.toCharArray()) {
      if (character.toString().matches("\s+")) {
        continue;
      }
      
      if (!charAmounts.containsKey(character)) {
        charAmounts.put(character, 0);
      }
      charAmounts.replace(character, charAmounts.get(character) + 1);
    }
    return convertMapToString(charAmounts);
  }
  
  private static void testAlgorithmOne(String input) {
    println("Algorithm One");
    String result = applyAlgorithmOne(input);
    println(String.format("Vowels Removed: %d\nRepeats removed: %d",
                          vowelsRemovedAlgorithmOne, repeatsRemovedAlgorithmOne
                        ));
    println(String.format("Algorithm one message: %s\nAlgorithm one characters saved: %d",
                          result, vowelsRemovedAlgorithmOne + repeatsRemovedAlgorithmOne
                        ));
  }

  
  private static void testAlgorithmTwo(String input) {
    println("Algorithm Two");
    String result = applyAlgorithmTwo(input);
    println(String.format("Unique characters found: %d",
                          charAmounts.size()
                        ));
    println(String.format("Algorithm two message: %s\nAlgorithm two characters saved: %d",
                          result, input.length() - result.length()
                        ));
  }
  
  public static void main(String[] args) {
    initScanner(null);
    String inputString = askForString("Type the message to get shortened:\n");
    testAlgorithmOne(inputString);
    println("");
    testAlgorithmTwo(inputString);
  }
}