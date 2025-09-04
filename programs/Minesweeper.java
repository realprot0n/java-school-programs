import java.util.Scanner;

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

class Input {
  public static Scanner scanner;
  static boolean initialized = false;

  public static void initialize() {
    if (initialized) {
      return;
    }
    scanner = new Scanner(System.in);
    initialized = true;
  }

  public static int askForInt(String stem) {
    Output.print(stem);
    return scanner.nextInt();
  }

  public static String askForString(String stem) {
    Output.print(stem);
    return scanner.nextLine();
  }
}

class BasicArithmetic {
  public static byte boolToByte(boolean bool) {
    return (byte) (bool ? 1 : 0);
  }

  public static byte getRandomByte() {
    return (byte) (Math.random()*256);
  }

  public static byte getRandomByte(byte max) {
    return (byte) (getRandomByte() % max);
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
  static int numbOfCells = 0 ;
  static int numbOfMines = 0;
  static int numbOfFlags = 0;
  boolean isMine;
  boolean revealed;
  boolean flagged;
  byte neighborMines;

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

  public void attemptTurnIntoMine() {
    if (isMine) {
      return;
    }

    isMine = true;
    numbOfMines += 1;
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

  public boolean attemptToAddMines(int amountOfMines) {
    if (amountOfMines > width*height) {
      return false;
    }
    
    byte randomX, randomY;
    
    while (Cell.numbOfMines < amountOfMines) {
      randomX = BasicArithmetic.getRandomByte((byte) width);
      randomY = BasicArithmetic.getRandomByte((byte) height);

      board[randomX][randomY].attemptTurnIntoMine();
    }

    return true;
  }
}

class GameLogic {
  public Field field;
  
  public GameLogic() {
    field = new Field(10);
  }
  
  public byte isCellAMine(Position position) {
    if ((position.x > field.width) || (position.x < 0)) {
      return 0;
    } else if ((position.y > field.height) || (position.y < 0)) {
      return 0;
    }
    
    return BasicArithmetic.boolToByte(field.board[position.x][position.y].isMine);
  }
  
  
  
  public void calcCellsNeighbors(Position position) {
    Cell currentCell = field.board[position.x][position.y];
    byte foundMines = 0;
    for (int xIndex = 0; xIndex < field.width; xIndex++) {
      foundMines += isCellAMine(new Position(position.x + xIndex, position.y + 1));
    }
    foundMines += isCellAMine(new Position(position.x - 1, position.y));
    foundMines += isCellAMine(new Position(position.x + 1, position.y));
    
    for (int xIndex = 0; xIndex < field.width; xIndex++) {
      foundMines += isCellAMine(new Position(position.x + xIndex, position.y + 1));
    }
    currentCell.neighborMines = foundMines;
  }
  
  public void calculateAllNeighbors() {
    for (int xIndex = 0; xIndex < field.width; xIndex++) {
      for (int yIndex= 0; yIndex < field.height; yIndex++) {
        calcCellsNeighbors(new Position(xIndex, yIndex));
      }
    }
  }

  public void gameLogic() {
    
  }
}

public class Minesweeper {
  public static void main(String[] args) {
    GameLogic game = new GameLogic();
    
  }
}
