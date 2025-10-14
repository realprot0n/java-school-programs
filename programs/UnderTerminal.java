import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class UnderTerminal {
  public static void main(String[] args) {
    
  }
}

class Input {
  public static Scanner scanner;
  static boolean initialized = false;
  
  public static void initialize() {
    if (initialized) {
      return;
    }
    scanner = new Scanner(System.in);
    initialized = true;
  }
  
  public static int askForInt(String stem) {
    if (scanner == null) {
      return -1;
    }
    Output.print(stem);
    int userInput = scanner.nextInt();
    scanner.nextLine();
    return userInput;
  }
  
  public static String getString(String stem) {
    if (scanner == null) {
      return null;
    }
    
    Output.print(stem);
    return scanner.nextLine();
  }
  
  public static char getChar(String stem) {
    String userResponse = Input.getString(stem);
    
    return userResponse.toCharArray()[0];
  }
  
  public static char getCharInArray(String stem, char[] charArray) {
    if (charArray.length <= 0) {
      return '\0';
    }
    
    char returnChar = '\0';
    returnChar = getChar(stem + " " +  Arrays.toString(charArray) + " ");
    
    while (!BasicArithmetic.isCharInArray(returnChar, charArray)) {
      Output.println("Please input a character in the array.");
      returnChar = getChar(stem);
    }
    
    return returnChar;
  }
}

class Item {
  public static Hashtable<String, Item> itemNames = new Hashtable<String, Item>();
  public String name;
  public String description;
  
  public static void initializeItemNames() {
    itemNames.clear();
    
    itemNames.put("Stick", new Weapon("Stick", "Its bark is worse than its bite.", 0));
    
    itemNames.put("Monster Candy", new HealingItem("Monster Candy", "Has a distinct, non-licorice flavor.", 10));
    itemNames.put("Bandage", new HealingItem("Bandage", "It has already been used several times.", 10));
    
    itemNames.put("Bandage", new Armor("Bandage", "It has already been used several times.", 0));
  }
  
  public Item(String name, String description) {
    this.name = name;
    this.description = description;
  }

  @Override
  public String toString() {
    return String.format("%s: %s", name, description);
  }
}

class HealingItem extends Item {
  public int healAmount;

  public HealingItem(String name, String description, int healAmount) {
    super(name, String.format("Heals %d HP. %s", healAmount, description));
    this.healAmount = healAmount;
  }
}

class Weapon extends Item {
  public int damage;

  public Weapon(String name, String description, int damage) {
    super(name, String.format("Weapon, AT %d. %s", damage, description));
    this.damage = damage;
  }
}

class Armor extends Item {
  public int defense;

  public Armor(String name, String description, int defense) {
    super(name, String.format("Armor, DF %d. %s", defense, description));
    this.defense = defense;
  }
}

class Player {
  public String name;
  public int health;
  public int maxHealth;
  public int exp;
  public int love;
  public int gold;
  public Item[] inventory;

  public Player(String name, int maxHealth) {
    this.name = name;
    this.maxHealth = maxHealth;
  }
}

class Output {
  public static void println(Object obj) {
    System.out.println(obj);
  }

  public static void print(Object obj) {
    System.out.print(obj);
  }
  
  public static void printf(String template, Object... args) {
    println(String.format(template, args));
  }
}
