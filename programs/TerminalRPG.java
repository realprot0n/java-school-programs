import java.util.Scanner;

public class TerminalRPG {
  static Scanner scan;
  
  public static void print(Object obj) {
    System.out.print(obj);
  }
  
  public static void println(Object obj) {
    System.out.println(obj);
  }
  
  public static void println() {
    println("");
  }
  
  public static void printf(String format, Object... args) {
    println(String.format(format, args));
  }
  
  public static String askForStr(String stem) {
    print(stem);
    return scan.nextLine();
  }

  public static int askForInt(String stem) {
    print(stem);
    int retValue = scan.nextInt();
    scan.nextLine();
    return retValue;
  }

  public static void main(String[] args) {
    scan = new Scanner(System.in);
    Player player = new Player();

    player.printIntro();
    
    int choice1 = askForInt("You see two paths. Do you go into the forest (1) or the cave (2)? \n  Choice: ");
    println();
    
    if (choice1 == 2) {
      println("You head into the cave... And find a spiky spike that spikes you on your head." + 
                "\n  You lose six health.");
      player.health -= 6;
    } else {
      println("You enter the forest and find a treasure chest.\n  +5 gold!");
      player.gold += 5;
    }
    player.printCurrentStats();
    println();
    
    int choice2 = askForInt("A goblin jumps out! Do you fight (1) or run (2)? \n  Choice:");
    println();
    
    if (choice2 == 2) {
      println("You run away.\nLike a COWARD.\nLuckily, you find a single coin on the ground.\n  +1 gold!");
      player.gold += 1;
    } else {
      println("You fight bravely but lose 3 health.\n  +10 gold.");
      player.health -= 3;
      player.gold += 10;
    }

    player.printFinalStats();
  }
}

class Player {
  String name;
  int health;
  int gold;

  public Player() {
    this.name = TerminalRPG.askForStr("Enter your hero's name: ");
    this.health = 10;
    this.gold = 0;
  }

  public void printIntro() {
    TerminalRPG.printf("Hello, %s. You start with 10 health & 0 gold.", name);
  }

  public void printCurrentStats() {
    TerminalRPG.printf("Current stats: Health = %d, Gold = %d", health, gold);
  }

  public void printFinalStats() {
    TerminalRPG.printf("Final stats: %s, Health = %d, Gold = %d", name, health, gold);
  }
}