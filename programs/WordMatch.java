public class WordMatch {
  private String secret;
  
  public WordMatch(String word) {
    this.secret = word;
  }
  
  private static int numbOfOccurances(String searched, String matched) {
    int occurances = 0;
    
    for (int strIndex = 0; strIndex <= searched.length()-matched.length(); strIndex++) {
      if (searched.substring(strIndex, strIndex + matched.length()).equals(matched)) {
        occurances++;
      }
    }
    return occurances;
  }
  
  public int scoreGuess(String guess) {
    int guesslen = guess.length();
    return numbOfOccurances(this.secret, guess) * guesslen * guesslen;
  }

  public String findBetterGuess(String first, String second) {
    return scoreGuess(first) > scoreGuess(second) ? first : second;
  }

  public static void main(String[] args) {
    WordMatch game = new WordMatch("concatenation");

    System.out.println(game.scoreGuess("ten"));
    System.out.println(game.scoreGuess("nation"));
    System.out.println(game.findBetterGuess("ten", "nation"));
  }
}
