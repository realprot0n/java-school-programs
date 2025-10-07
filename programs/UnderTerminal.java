import java.util.Hashtable;

public class UnderTerminal {
  public static void main(String[] args) {
    
  }
}

class Item {
  static public Hashtable<String, Item> itemNames = new Hashtable<String, Item>();
  public String name;
  public String description;
  
  
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
