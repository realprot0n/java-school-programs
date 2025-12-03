import java.util.Scanner;

public class guessingGame {
  private int secretNumber;
  public int guess;
  public int guessesRemaining = 10;
  public Host host;
  
  private Scanner scanner;
  
  private void print(Object obj) {
    System.out.print(obj);
  }
  
  private void println(Object obj) {
    System.out.println(obj);
  }
  
  private void initScanner(Scanner scan) {
    if (scan == null) {
      scan = new Scanner(System.in);
    }
    scanner = scan;
  }
  
  public int askForInt(String stem) {
    if (scanner == null) {
      return -1;
    }
    print(stem);
    int userInput = scanner.nextInt();
    scanner.nextLine();
    return userInput;
  }
  
  public String getResponseByHost(Result result) {
    if (result == Result.PreGame) {
      switch (host) {
        case Normal:
          return "Welcome to the game folks! Our daring contestant here will partake in the hardest game known to man: a guessing game!";
        case Kyle:
          return "welcome to the game. you are gonna play a guessing game. you better have fun or i'll, uhh, do something";
        case Dog:
          return "Woof woof woof woof woof, woof bark bark woof. Woof woof wood arf arf bark!";
        case DrMario:
          return "Hello spectators! Today we have a patient competing in a guessing game! The prize? Who knows! Now, lets-a-go!";
        default:
          return "pregame";
      }
    } else if (result == Result.Invalid) {
      switch (host) {
        case Normal:
          return "That's not a valid number. Please input your guess again!";
        case Kyle:
          return "you IDIOT!! you input an invalid number!! try again dumbahh!!";
        case Dog: 
          return "Woof.";
        case DrMario:
          return "Oh no! Your input is not-a valid! Try that again, eh?";
        default: 
          return "invalid";
      }
    } else if (result == Result.TooHigh) {
      switch (host) {
        case Normal:
          return "Oof! Your guess was too high! Try again?";
        case Kyle:
          return "bUDDY. your guess is too high.";
        case Dog:
          return "woooooooooooof.";
        case DrMario:
          return "Your guess is suffering from hypertension. ";
        default:
          return "toohigh";
      }
    } else if (result == Result.TooLow) {
      switch (host) {
        case Normal:
          return "Oof, that's missing the mark! Your guess is too low.";
        case Kyle:
          return "your guess is too low, just like your iq!!!";
        case Dog:
          return "wof.";
        case DrMario:
          return "Your guess is suffering from hypotension. ";
        default:
          return "toolow";
      }
    } else if (result == Result.GuessesRemaining) {
      switch (host) {
        case Normal:
          return "\nYou have " + guessesRemaining + " guesses left. What will be your next one?\n";
        case Kyle:
          return "\nyou have " + guessesRemaining + " guesses remaining before i-\n\noh im not allowed to say that? dam. just putin your next guess\n";
        case Dog:
          String retString = "\n";
          for (int i = 0; i < guessesRemaining; i++) {
            retString += "woof ";
          }
          return retString + ".\n";
        case DrMario:
          return "Your guess has approximately " + guessesRemaining + " days to live.\n";
        default:
          return "\n" + guessesRemaining + "\n";
      }
    } else if (result == Result.Lose) {
      switch (host) {
        case Normal:
          return "Awh darn! You've ran out of guesses and lost the game. The secret number you so desperately needed was " + secretNumber + ". Come again soon, I'm sure you can win next time!";
        case Kyle:
          return "well you lost. am i suprised? no. will i stil make fun of you?? of course! the secret number was " + secretNumber + ".";
        case Dog:
          return "f. wof wof. f f f. (" + secretNumber + ")";
        case DrMario:
          return "Yeeouch!! It seems like you have lost. Unfortunately, or perhaps fortunately, we have to take your liver now. Bye bye! (the number was " + secretNumber + ")";
        default:
          return "Lose";
      }
    } else if (result == Result.Win) {
      switch (host) {
        case Normal:
          return "You did it! You guessed the number! Well done! Your prize is one MILLION dollars!! (taxes still applied) Come back again soon!";
        case Kyle:
          return "wow, i didnt expect you to actually win. good job brah";
        case Dog:
          return "WOOOOF!!! WOOF WOOF!! woof wof. wow wow.";
        case DrMario:
          return "Wowzers! you've won the guessing game! What's that? You wanna know your prize? Its not getting your liver taken! Okay, now bye bye! And you BETTER not try to sue me.";
        default:
          return "Win";
      }
    }
    
    return "unimplemented";
  }
  
  public void generateNumber(int lowerBound, int upperBound) {
    secretNumber = (int) (lowerBound + (Math.random() * (upperBound + 1)));
  }
  
  private void selectHost() {
    println("Welcome to the game! We have a broad(ish) selection of hosts for you today!\nYou can choose from one of them, here they are!\n");
    Host.printHosts();
    host = Host.fromInt(askForInt("\nWhich host do you want? (input the number next to their name)\n"));
  }
  
  private void finishGame() {
    if (guess == secretNumber) {
      println("\n" + getResponseByHost(Result.Win));
    } else {
      println("\n" + getResponseByHost(Result.Lose));
    }
  }
  
  private void gameLoop() {
    while (guess != secretNumber && guessesRemaining > 0) {
      println(getResponseByHost(Result.GuessesRemaining));
      guess = askForInt("");
      
      Result guessResult = Result.getResult(secretNumber, guess);
      
      if (guessResult == Result.Win) {
        break;
      }
      
      print(getResponseByHost(guessResult));
      
      guessesRemaining -= 1;
    }
    
    finishGame();
  }
  
  public void startGame() {
    initScanner(null);
    selectHost();
    
    generateNumber(0, 100);
    println(getResponseByHost(Result.PreGame));
    gameLoop();
  }
  
  public static void main(String[] args) {
    guessingGame game = new guessingGame();
    game.startGame();
  }
}

enum Host {
  Normal(0),
  Kyle(1),
  DrMario(2),
  Dog(3);
  
  public int toInt; 
  private Host(int intVal) {
    toInt = intVal;
  }

  public static void printHosts() {
    for (Host currHost : Host.values()) {
      System.out.println(String.valueOf(currHost.toInt) + ": " + currHost.toString());
    }
  }
  
  public static Host fromInt(int hostNum) {
    switch (hostNum) {
      case 0:
        return Normal;
      case 1:
        return Kyle;
      case 2:
        return DrMario;
      case 3:
        return Dog;
      default:
        return Normal;
    }
  }
}

enum Result {
  PreGame,
  TooHigh,
  TooLow,
  Invalid,
  GuessesRemaining,
  Lose,
  Win;

  public static Result getResult(int actualNumb, int triedNum) {
    if (triedNum == actualNumb) {
      return Win;
    } else if (triedNum > actualNumb) {
      return TooHigh;
    } else {
      return TooLow;
    }
  }
}