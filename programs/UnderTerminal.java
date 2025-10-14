import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class UnderTerminal {
  public static void main(String[] args) {
    TheInput.initialize();
    Player.getPlayerFromUser();
  }
}

class BasicArithmetic {
  public static byte boolToByte(boolean bool) {
    return (byte) (bool ? 1 : 0);
  }
  
  public static int getRandomInt() {
    return (int) (Math.random() * Integer.MAX_VALUE);
  }
  
  public static int getRandomInt(int max) {
    return getRandomInt() % max;
  }
  
  public static byte getRandomByte() {
    return (byte) (Math.random()*256);
  }
  
  public static byte getRandomByte(byte max) {
    return (byte) (getRandomByte() % max);
  }
  
  public static String intIntoTwoWide(int integer) {
    if ((integer < 10) && (integer >= 0)) {
      return integer + " ";
    }
    
    return String.valueOf(integer);
  }
  
  public static String intIntoThreeWide(int integer) {
    if ((integer < 100) && (integer > -10)) {
      return intIntoTwoWide(integer) + " ";
    }
    
    return String.valueOf(integer);
  }
  
  public static boolean isCharInArray(char character, char[] charArray) {
    String charsAsString = new String(charArray);
    if (charsAsString.indexOf(character) != -1) {
      return true;
    }
    return false;
  }
  
  public static boolean isCharUpper(char character) {
    return (character >= 'A' && (character <= 'Z'));
  }
  
  public static boolean isCharLower(char character) {
    return ((character >= 'a') && (character <= 'z'));
  }
  
  public static char makeCharUpper(char character) {
    if (isCharUpper(character)) {
      return character;
    }
    
    // The space character's ascii value is 32, and the space between the uppercase and lowercase sections of ascii are 32 characters apart.
    // Uppercase comes before lowercase in ascii, so we subtract 32 from the char.
    return (char) (character - ' ');
  }
  
  public static boolean isCharNum(char character) {
    return ((character >= '0') && (character <= '9'));
  }
}

class TheInput {
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

  public static int askForIntInRange(String stem, int lower, int higher) {
    if (scanner == null) {
      return -1;
    }
    int userInput = askForInt(stem);
    if (userInput < lower || userInput > higher) {
      Output.printf("Your input must be be between %d and %d. Input your option again.",
                    lower, higher);
      userInput = askForIntInRange(stem, lower, higher);
    }
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
    String userResponse = TheInput.getString(stem);
    
    return userResponse.toCharArray()[0];
  }
  
  public static char getCharInArray(String stem, char[] charArray) {
    if (charArray.length <= 0) {
      return '\0';
    }
    
    char returnChar = '\0';
    returnChar = getChar(stem + " " +  Arrays.toString(charArray) + " ");
    
    if (!BasicArithmetic.isCharInArray(returnChar, charArray)) {
      Output.println("Please input a character in the array.");
      returnChar = getCharInArray("stem", charArray);
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
    itemNames.put("Toy Knife", new Weapon("Toy Knife", "Made of plastic. A rarity nowadays.", 3));
    
    itemNames.put("Monster Candy", new HealingItem("Monster Candy", "Has a distinct, non-licorice flavor.", 10));
    itemNames.put("Bandage", new HealingItem("Bandage", "It has already been used several times.", 10));
    itemNames.put("Spider Donut", new HealingItem("Spider Donut", "A donut made with Spider Cider in the batter.", 12));
    itemNames.put("Spider Cider", new HealingItem("Spider Cider", "Made with whole spiders, not just the juice.", 24));
    
    itemNames.put("Bandage", new Armor("Bandage", "It has already been used several times.", 0));
    itemNames.put("Faded Ribbon", new Armor("Faded Ribbon", "If you're cuter, monsters won't hit you as hard.", 3));
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
  /*
   * Gets the response to a given name in the name select screen.
   * A Y as the first char means it is allowed, an N means it's not.
   */
  private static String getNameResponse(String givenName) {
    givenName = givenName.toLowerCase();
    switch (givenName) {
      case "aaaaaa":
        return "YNot very creative..?";
      case "alphy":
        return "YUh... OK?";
      case "bpants":
        return "YYou are really scraping the bottom of the barrel.";
      case "bratty":
        return "YLike, OK, I guess.";
      case "chara":
        return "YThe true name.";
      case "gerson":
        return "YWah ha ha! Why not?";
      case "jerry":
        return "YJerry.";
      case "mercy":
      case "murder":
        return "YThat's a little on-the-nose, isn't it...?";
      case "mett":
      case "metta":
      case "mtt":
        return "YOOOOH!!! ARE YOU PROMOTING MY BRAND?";
      case "blooky":
      case "napsta":
        return "Y..........\n(They're powerless to stop you.)";
      case "papyru":
        return "YI'LL ALLOW IT!!!!";
      case "shyren":
        return "Y...?";
      case "temmie":
        return "YhOI!";
      case "woshua":
        return "YClean name.";
      
      case "":
        return "NYou must choose a name.";
      case "alphys":
        return "ND-don't do that.";
      case "asgore":
        return "NYou cannot.";
      case "asriel":
        return "N...";
      case "catty":
        return "NBratty! Bratty! That's MY name!";
      case "flowey":
        return "NI already CHOSE that name.";
      case "sans":
        return "Nnope.";
      case "toriel":
        return "NI think you should think of your own name, my child.";
      case "undyne":
        return "NGet your OWN name!";
      default:
        return "YIs this name correct?";
    }
  }
  
  private static String getPlayerName() {
    String givenName = TheInput.getString("Name the fallen human.\n");
    String response = getNameResponse(givenName);
    
    if (response.toCharArray()[0] == 'N') {
      Output.println(response.substring(1) + "\n");
      givenName = getPlayerName();
    } else if (response.toCharArray()[0] == 'Y') {
      Output.println(response.substring(1));
      char userApproval = TheInput.getCharInArray("Is this your name? (Yes or No)", new char[] {'Y', 'y', 'N', 'n'});
      if (BasicArithmetic.makeCharUpper(userApproval) == 'N') {
        givenName = getPlayerName();
      }
    }
    
    return givenName;
  }
  
  public static Player getPlayerFromUser() {
    return new Player(getPlayerName(), 20);
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
