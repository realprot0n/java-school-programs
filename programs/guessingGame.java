public class guessingGame {
  private static int secretNumber;
  public static int guess;
  public static int guessesRemaining = 10;
  public static Host host;
  
  public static String getResponseByHost(Result result) {
    if (result == Result.Invalid) {
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
          return "It has approximately " + guessesRemaining + " days to live.\n";
        default:
          return "\n" + guessesRemaining + "\n";
      }
    }
  }
  
  public static void main(String[] args) {
    
  }
}

enum Host {
  Normal,
  Kyle,
  DrMario,
  Dog
}

enum Result {
  PreGame,
  TooHigh,
  TooLow,
  Perfect,
  Invalid,
  GuessesRemaining,
  Lose,
  Win
}