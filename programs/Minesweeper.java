class Output {
  public static void println(Object obj) {
    System.out.println(obj);
  }

  public static void println() {
    println("");
  }
  
  public static void print(Object obj) {
    System.out.print(obj);
  }
}

class Position {
  int x, y;
  
  public Position(int setX, int setY) {
    x = setX;
    y = setY;
  }
  
  public Position(int[] position) throws IllegalArgumentException {
    if (position.length != 2) {
      throw new IllegalArgumentException("Position array must be 2 ints long");
    }
    
    x = position[0];
    y = position[1];
  }

  public static Position getDefault() {
    return new Position(-1, -1);
  }

  public Position addDirection(Direction direction) {
    return addDirection(direction, 1);
  }

  public Position addDirection(Direction direction, int amount) {
    return addDirection(direction, amount, new Position(x, y));
  }
  
  public Position addDirection(Direction direction, int amount, Position position) {
    if (direction.equals(Direction.LEFT)) {
      position.x -= amount;
    } else if (direction.equals(Direction.RIGHT)) {
      position.x += amount;
    } else if (direction.equals(Direction.UP)) {
      position.y += amount;
    } else if (direction.equals(Direction.DOWN)) {
      position.y -= amount;
    }

    return position;
  }

  public void addDirectionToSelf(Direction direction) {
    addDirectionToSelf(direction, 1);
  }

  public void addDirectionToSelf(Direction direction, int amount) {
    Position newPosition = addDirection(direction, amount, new Position(x, y));
    x = newPosition.x;
    y = newPosition.y;
  }
}

class Cell {
  static int numbOfCells;
  static int numbOfMines;
  static int numbOfFlags;
  boolean isMine;
  boolean revealed;
  boolean flagged;
  int neighborMines;

  public Cell() {
    numbOfCells += 1;
    isMine = false;
    revealed = false;
  }
  
  public char getAsChar() {
    if (!revealed) {
      return '#';
    }

    if (flagged) {
      return 'F';
    }

    if (isMine) {
      return 'X';
    }

    if (neighborMines == 0) {
      return '.';
    }

    return (char) (neighborMines + '0');
  }
}

class Field {
  int width, height;
  Cell[][] board;

  public Field(int setWidth, int setHeight) {
    width = setWidth;
    height = setHeight;

    board = new Cell[setWidth][setHeight];

    for (int xIndex = 0; xIndex < width; xIndex++) {
      for (int yIndex = 0; yIndex < height; yIndex++) {
        board[xIndex][yIndex] = new Cell();
      }
    }
  }
  
  public Field(int size) {
    this(size, size);
  }
}

class GameLogic {
  public Field field;
  
  public GameLogic() {
    field = new Field(10);
  }

  public void calcCellsNeighbors(Position position) {
   
  }

  public void calculateAllNeighbors() {
    for (int xIndex = 0; xIndex < field.width; xIndex++) {
      for (int yIndex= 0; yIndex < field.height; yIndex++) {
        calcCellsNeighbors(new Position(xIndex, yIndex));
      }
    }
  }
}

public class Minesweeper {
  public static void main(String[] args) {

  }
}
