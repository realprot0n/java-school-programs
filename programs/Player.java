public class Player {
  private static int numPlayers = 0;
  private Vector3i position;
  private Direction6 direction;
  private int health;
  private String name;
  
  public Player() {
    this(
      String.format("P%d", numPlayers + 1),
      0, 0, 0
    );
  }
  
  final static int DEFAULT_HEALTH = 20;
  public Player(String name,
                int x, int y, int z) {
    this(name,
      x, y, z, 
      DEFAULT_HEALTH, 
      1
    );
  }
  
  public Player(String name,
                int x, int y, int z,
                int health,
                int direction) {
    this.name = name;
    position = new Vector3i(x, y, z);
    this.health = health;
    this.direction = Direction6.fromInt(direction);
    if (this.direction == Direction6.Unknown) {
      System.err.println("Invalid direction passed to player constructor. It has defaulted to Direction6.Unknown.");
    }
    numPlayers += 1;
  }
  
  public static int getNumPlayers() {
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
  
  public String getPositionString() {
    return position.toString();
  }
  
  public int getHP() {
    return health;
  }
  
  public int getDirection() {
    return direction.asInt;
  }
  
  @Override
  public String toString() {
    return String.format(
      "Name: %s\nHealth: %d\nCoordinates: %s\nDirection: %d\n",
      getName(), getHP(), position.toString(), direction.asInt
    );
  }
  
  public void setHP(int health) {
    this.health = health;
    
    if (this.health < 0) {
      this.health = 0;
    }
  }
  
  public void setDirection(int direction) {
    setDirection(Direction6.fromInt(direction));
  }
  
  public void setDirection(Direction6 direction) {
    if (direction == Direction6.Unknown) {
      return; // Don't modify direction if the given direction is unknown.
    }
    
    this.direction = direction;
  }
  
  public void move(Direction6 direction, int units) {
    this.position = this.position.add(direction.toVector3().multiply(units));
  }
  
  public void move(int direction, int units) {
    move(Direction6.fromInt(direction), units);
  }
  
  public void teleport(Vector3i newPosition) {
    this.position = newPosition;
  }
  
  public void teleport(int x, int y, int z) {
    teleport(new Vector3i(x, y, z));
  }
  
  public void teleport(Player otherPlayer) {
    teleport(otherPlayer.position);
  }
  
  public void attack(Player attackedPlayer, int damage) {
    attackedPlayer.setHP(attackedPlayer.health - damage);
  }
  
  public double getDistance(Vector3i position) {
    return this.position.getDistance(position);
  }
  
  public double getDistance(int x, int y, int z) {
    return getDistance(new Vector3i(x, y, z));
  }
  
  public double getDistance(Player otherPlayer) {
    return getDistance(otherPlayer.position);
  }
}

class Vector3i {
  public int x;
  public int y;
  public int z;
  
  public Vector3i(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public Vector3i add(Vector3i other) {
    return new Vector3i(
      this.x + other.x,
      this.y + other.y,
      this.z + other.z
    );
  }
  
  public Vector3i multiply(int factor) {
    this.x *= factor;
    this.y *= factor;
    this.z *= factor;
    return this;
  }
  
  public double getDistance(Vector3i other) {
    double xDifferenceSquared = Math.pow((other.x - x), 2);
    double yDifferenceSquared = Math.pow((other.y - y), 2);
    double zDifferenceSquared = Math.pow((other.z - z), 2);
    
    return Math.sqrt(
      xDifferenceSquared + yDifferenceSquared + zDifferenceSquared
    );
  }
  
  public String toString() {
    return String.format(
      "X %d Y %d Z %d",
      x, y, z
    );
  }
}

/*
* for some reason the program wouldn't run with this file named as just "Direction"...
* I think its because i made another class named "Direction" in another file
* But still it shouldn't change anything because that class was ALSO a private class
* so enragingeth...
*/
enum Direction6 { 
  Unknown(-1),
  North(1),
  South(2),
  Up(3),
  Down(4),
  East(5),
  West(6);
  
  public int asInt;
  
  private Direction6(int value) {
    asInt = value;
  }

  public static Direction6 fromInt(int value) {
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
  
  public Vector3i toVector3() {
    switch (this) {
      case Unknown:
        return new Vector3i(0, 0, 0);
      case North:
        return new Vector3i(1, 0, 0);
      case South:
        return new Vector3i(-1, 0, 0);
      case Up:
        return new Vector3i(0, 1, 0);
      case Down:
        return new Vector3i(0, -1, 0);
      case East:
        return new Vector3i(0, 0, 1);
      case West:
        return new Vector3i(0, 0, -1);
      default:
        return new Vector3i(0, 0 ,0);
    }
  }
}
