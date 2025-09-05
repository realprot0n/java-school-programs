import java.util.Scanner;
import java.util.Arrays;

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
    if (scanner == null) {
      return -1;
    }
    Output.print(stem);
    return scanner.nextInt();
  }

  public static String getString(String stem) {
    if (scanner == null) {
      return null;
    }
    Output.print(stem);
    return scanner.nextLine();
  }

  public static char getChar(String stem) {
    String userResponse = Input.getString(stem);
    
    return userResponse.toCharArray()[0];
  }

  public static char getCharInArray(String stem, char[] charArray) {
    char returnChar = '\0';
    returnChar = getChar(stem + Arrays.toString(charArray));
    
    while (!BasicArithmetic.isCharInArray(returnChar, charArray)) {
      Output.println("Please input a character in the array.");
      returnChar = getChar(stem);
    }
    
    return returnChar;
  }
}

class BasicArithmetic {
  public static byte boolToByte(boolean bool) {
    return (byte) (bool ? 1 : 0);
  }

  public static int getRandomInt() {
    return (int) (Math.random() * Integer.MAX_VALUE);
  }

  public static int getRandomInt(int max) {
    return getRandomInt() % max;
  }

  public static byte getRandomByte() {
    return (byte) (Math.random()*256);
  }

  public static byte getRandomByte(byte max) {
    return (byte) (getRandomByte() % max);
  }

  public static String intIntoTwoWide(int integer) {
    if ((integer < 10) && (integer >= 0)) {
      return integer + " ";
    }

    return String.valueOf(integer);
  }

  public static boolean isCharInArray(char character, char[] charArray) {
    for (char currentChar : charArray) {
      if (character == currentChar) {
        return true;
      }
    }
    return false;
  }

  public static boolean isCharUpper(char character) {
    if (character >= 'A' && (character <= 'Z')) {
      return true;
    }
    return false;
  }

  public static boolean isCharLower(char character) {
    if ((character >= 'a') && (character <= 'z')) {
      return true;
    }
    return false;
  }

  public static char makeCharUpper(char character) {
    if (isCharUpper(character)) {
      return character;
    }
    
    // The space character's ascii value is 32, and the space between the uppercase and lowercase sections of ascii are 32 characters apart.
    // Uppercase comes before lowercase in ascii, so we subtract 32 from the char.
    return (char) (character - ' ');
  }
}

enum Direction {
  LEFT,
  UP,
  RIGHT,
  DOWN
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

  public static Position addDirection(Direction direction, Position position) {
    return addDirection(direction, 1, position);
  }
  
  public static Position addDirection(Direction direction, int amount, Position position) {
    Position newPosition = new Position(position.x, position.y);
    
    if (direction.equals(Direction.LEFT)) {
      newPosition.x -= amount;
    } else if (direction.equals(Direction.RIGHT)) {
      newPosition.x += amount;
    } else if (direction.equals(Direction.UP)) {
      newPosition.y += amount;
    } else if (direction.equals(Direction.DOWN)) {
      newPosition.y -= amount;
    }

    return newPosition;
  }

  public void addDirectionToSelf(Direction direction) {
    addDirectionToSelf(direction, 1);
  }

  public void addDirectionToSelf(Direction direction, int amount) {
    Position newPosition = addDirection(direction, amount, new Position(x, y));
    x = newPosition.x;
    y = newPosition.y;
  }

  public static Position[] getFourDirectionsAdded(Position position) {
    return new Position[]{
      addDirection(Direction.LEFT, 1, position),
      addDirection(Direction.RIGHT, 1, position),
      addDirection(Direction.UP, 1, position),
      addDirection(Direction.DOWN, 1, position)
    };
  }

  public static Position[] getEightDirectionsAdded(Position position) {
    return new Position[]{
      addDirection(Direction.LEFT, position),
      addDirection(Direction.UP, addDirection(Direction.LEFT, 1, position)),
      addDirection(Direction.RIGHT, position),
      addDirection(Direction.DOWN, addDirection(Direction.RIGHT, position)),
      addDirection(Direction.UP,position),
      addDirection(Direction.RIGHT, addDirection(Direction.UP,position)),
      addDirection(Direction.DOWN, position),
      addDirection(Direction.LEFT, addDirection(Direction.DOWN, position))
    };
  }
}

class Cell {
  static int numbOfCells = 0;
  static int numbOfMines = 0;
  static int numbOfFlags = 0;
  boolean isMine;
  boolean revealed;
  boolean flagged;
  boolean exploded;
  byte neighborMines;

  public Cell() {
    numbOfCells += 1;
    isMine = false;
    revealed = false;
  }
  
  public char getAsChar() {
    if (exploded) {
      return '*';
    }
    
        if (flagged) {
          return 'F';
        }
    
    if (!revealed) {
      return '#';
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
  
  public boolean isPositionOutOfBound(Position position) {
    if ((position.x >= width) || (position.x < 0)) {
      return true;
    } else if ((position.y >= height) || (position.y < 0)) {
      return true;
    }
    return false;
  }
  
  public boolean attemptToAddMines(int amountOfMines) {
    if (amountOfMines > width*height) {
      return false;
    }
    
    int randomX, randomY;
    
    while (Cell.numbOfMines < amountOfMines) {
      randomX = BasicArithmetic.getRandomInt(width);
      randomY = BasicArithmetic.getRandomInt(height);

      board[randomX][randomY].attemptTurnIntoMine();
    }

    return true;
  }

  public void printBoard() {
    Output.print("   ");
    for (int xIndex = 0; xIndex < width; xIndex++) {
      Output.print(BasicArithmetic.intIntoTwoWide(xIndex));
    }
    Output.println();

    for (int yIndex = 0; yIndex < height; yIndex++) {
      Output.print(BasicArithmetic.intIntoTwoWide(yIndex) + " ");
      for (int xIndex = 0; xIndex < width; xIndex++) {
        Output.print(board[xIndex][yIndex].getAsChar());
        Output.print(" ");
      }
      Output.println();
    }
  }
  
  public byte isCellAMine(Position position) {
    if (isPositionOutOfBound(position)) {
      return 0;
    }
    
    return BasicArithmetic.boolToByte(board[position.x][position.y].isMine);
  }
  
  public void calcCellsNeighbors(Position position) {
    Cell currentCell = board[position.x][position.y];
    
    if (currentCell.isMine) {
      return;
    }
    
    byte foundMines = 0;
    for (int xIndex = -1; xIndex <= 1; xIndex++) {
      foundMines += isCellAMine(new Position(position.x + xIndex, position.y + 1));
    }
    foundMines += isCellAMine(new Position(position.x - 1, position.y));
    foundMines += isCellAMine(new Position(position.x + 1, position.y));
    
    for (int xIndex = -1; xIndex <= 1; xIndex++) {
      foundMines += isCellAMine(new Position(position.x + xIndex, position.y - 1));
    }
    currentCell.neighborMines = foundMines;
  }
  
  public void calculateAllNeighbors() {
    for (int xIndex = 0; xIndex < width; xIndex++) {
      for (int yIndex= 0; yIndex < height; yIndex++) {
        calcCellsNeighbors(new Position(xIndex, yIndex));
      }
    }
  }
  
  public void revealCell(Position position) {
    if (isPositionOutOfBound(position)) {
      return;
    }
    
    Cell currentCell = board[position.x][position.y];
    
    if (currentCell.revealed) {
      return;
    }
    currentCell.revealed = true;
    
    if (currentCell.neighborMines == 0) {
      Position[] neighbors = Position.getEightDirectionsAdded(position);
      
      for (Position neighbor : neighbors) {
        revealCell(neighbor);
      }
    }
  }
  
  public Position getRandomZeroCellsPos() {
    Cell currentCell = null;
    
    int randomX = 0;
    int randomY = 0;
    while (currentCell == null || currentCell.isMine || currentCell.neighborMines != 0) {
      randomX = BasicArithmetic.getRandomInt(width);
      randomY = BasicArithmetic.getRandomInt(height);
      
      currentCell = board[randomX][randomY];
    }
    
    return new Position(randomX, randomY);
  }
  
  public void revealRandomZeroCell() {
    revealCell(getRandomZeroCellsPos());
  }
}

class GameLogic {
  public Field field;
  boolean playingRound = false;
  
  public GameLogic(int width, int height) {
    field = new Field(width, height);
  }
  
  public void gameLoop() {
    playingRound = true;
    
    char flagOrReveal = '\0';
    while (playingRound) {
      flagOrReveal = Input.getCharInArray("Input either \"F\"lag or \"R\"eveal", new char[]{'f', 'F', 'r', 'R'});
      flagOrReveal = BasicArithmetic.makeCharUpper(flagOrReveal);
      
      int chosenX = Input.askForInt("X position? ");
      int chosenY = Input.askForInt("Y position? ");

      if (flagOrReveal == 'F') {
        

      }
      
      
      playingRound = false;
    }
  }
  
  public void startGame() {
    double percentageOfMines = Input.askForInt("Percentage of mines? %") / 100d;
    Output.println();

    field.attemptToAddMines((int) (percentageOfMines * field.width * field.height));
    field.calculateAllNeighbors();
    
    field.revealRandomZeroCell();
    field.printBoard();
  }
}

public class Minesweeper {
  public static void main(String[] args) {
    Input.initialize();
    int width = Input.askForInt("Width? ");
    int height = Input.askForInt("Height? ");
    GameLogic game = new GameLogic(width, height);
    
    game.startGame();
  }
}
