import java.util.ArrayList;
import java.util.List;

enum Direction {
  LEFT,
  UP,
  RIGHT,
  DOWN
}

class Output {
  public static void println(Object obj) {
    System.out.println(obj);
  }
  
  public static void print(Object obj) {
    System.out.print(obj);
  }
  
  public static void printerr(Object obj) {
    System.err.println(obj);
  }
}

class Position {
  int x, y;
  
  public Position(int setX, int setY) {
    x = setX;
    y = setY;
  }
  
  public Position(int[] position) {
    if (position.length != 2) {
      Output.printerr("Position array must be 2 ints long");
    }
    
    x = position[0];
    y = position[1];
  }

  public static Position getDefault() {
    return new Position(-1, -1);
  }
  

  public void addDirectionToSelf(Direction direction) {
    addDirectionToSelf(direction, 1);
  }

  public void addDirectionToSelf(Direction direction, int amount) {
    if (direction.equals(Direction.LEFT)) {
      x -= amount;
    } else if (direction.equals(Direction.RIGHT)) {
      x += amount;
    } else if (direction.equals(Direction.UP)) {
      y += amount;
    } else if (direction.equals(Direction.DOWN)) {
      y -= amount;
    }
  }
}

class GridSquare {
  public boolean sunk;
  public boolean shot;
  public boolean visible;
  public boolean hasShip;
  public int shipID;

  public void reveal() {
    visible = true;
  }

  public void hide() {
    visible = false;
  }

  public void getShot() {
    shot = true;
    visible = true;
  }

  public char getAsChar() {
    if (visible) {
      if (!hasShip) {
        return 'O';
      }

      if (sunk) {
        return 'X';
      }

      return '!';
    }

    return '.';
  }
}

class Ship {
  
  public int length;
  public Direction direction;
  public String name;
  public Position position;
  public int shipID;

  public Ship(int setLength, String shipName) {
    
    if (length <= 0) {
      Output.printerr("Ship length must be more than 0.");
    }
    length = setLength;

    position = Position.getDefault();
  }

  public List<Position> getOccupiedSquares() {
    List<Position> returnSquares = new ArrayList<>();
    
    for (int squareIndex = 0; squareIndex < length; squareIndex++) {
      returnSquares.add(Position.getDefault()); // TODO: THIS
    }
    
    return returnSquares;
  }
}

class Grid {
  GridSquare[][] squares;
  
  public Grid(int size) {
    squares = new GridSquare[size][size];
  }

  public void printState() {
    
  }
}


public class Battleship {
  public static void main(String[] args) {
    
  }
}
