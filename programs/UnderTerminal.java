import java.util.Hashtable;

public class UnderTerminal {
  public static void main(String[] args) {
    
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

class Player {
  public String name;
  public int health;
  public int gold;
}

class MyOutput {
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
