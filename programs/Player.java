public class Player {
  private static int numPlayers = 0;
  private Vector3 position;
  private Direction direction;
  private int health;
  private String name;
  
  public Player(String name)
  
  public Player(String name,
                int x, int y, int z,
                int health,
                int direction) {
    this.name = name;
    position = new Vector3(x, y, z);
    this.health = health;
    this.direction = Direction.fromInt(direction);
  }
  
  public int getNumPlayers() {
    return numPlayers;
  }
  
  public String getName() {
    return name;
  }
  
  public int getX() {
    return position.x;
  }

  public int getY() {
    return position.y;
  }

  public int getZ() {
    return position.z;
  }

  public int getHP() {
    return health;
  }

  public int getDirection() {
    return direction.asInt;
  }

  public String toString() {
    return String.format(
      "Name: %s\nHealth: %d\nCoordinates: %s\nDirection: %d\n",
      getName(), getHP(), position.toString(), direction.asInt
    );
  }
}

class Vector3 {
  public int x;
  public int y;
  public int z;
  
  public Vector3(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public String toString() {
    return String.format(
      "X %d Y %d Z %d"
    );
  }
}

enum Direction {
  Unknown(-1),
  North(1),
  South(2),
  Up(3),
  Down(4),
  East(5),
  West(6);
  
  public int asInt;
  
  private Direction(int value) {
    asInt = value;
  }

  public static Direction fromInt(int value) {
    switch (value) {
      case 1: return North;
      case 2: return South;
      case 3: return Up;
      case 4: return Down;
      case 5: return East;
      case 6: return West;
      default: return Unknown;
    }
  }
}
