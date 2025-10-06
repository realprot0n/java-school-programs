public class TextRPG {
  public static void main(String[] args) {
    
  }
}

class Item {
  String name;
  String description;
}

class Player {
  String name;
  int health;
  int gold;
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
