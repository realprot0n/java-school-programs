public class runner_Player {
  public static void testEveryMethod(Player player) {
    System.out.println(String.format(
      "\n# of players: %d\n" +
      "info: \n%s",
      Player.getNumPlayers(),
      player.toString()
    ));
    
    player.setHP(6);
    System.out.println(String.format("after setHP(6): HP = %d", player.getHP()));
    
    player.setDirection(1);
    System.out.println(String.format("after setDirection(1): Direction = %d", player.getDirection()));
    
    player.move(3, 4);
    System.out.println(String.format("after move(3, 4): Position = %s", player.getPositionString()));
    
    player.teleport(10, 21, 67);
    System.out.println(String.format("after teleport(10, 21, 67): Position = %s", player.getPositionString()));
    
    System.out.println(String.format(
      "from getDistance(10, 30, 67): %f",
      player.getDistance(10, 30, 67)
    ));
  }
  
  public static void main(String[] args) {
    Player player1 = new Player();
    testEveryMethod(player1);

    Player player2 = new Player(
      "Lord Farquad",
      100, 2000, 4012,
      200,
      5
    );

    testEveryMethod(player2);
  }
}
