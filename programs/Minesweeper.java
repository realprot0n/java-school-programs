import java.util.Scanner;
import java.util.Arrays;

public class Minesweeper {
  public static void main(String[] args) {
    Input.initialize();
    int width = Input.askForInt("Width? ");
    int height = Input.askForInt("Height? ");
    GameLogic game = new GameLogic(width, height);
    
    game.startGame();
  }
}

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

class ConsoleColors {
  public static final String RESET = "\u001B[0m";
  public static String createTrueColorTag(boolean isBackground, int red, int green, int blue) {
    if (isBackground) {
      return String.format("\033[48;2;%d;%d;%dm", red, green, blue);
    }
    return String.format("\033[38;2;%d;%d;%dm", red, green, blue);
  }
  
  public static String createTrueColorTag(int red, int green, int blue) {
    return createTrueColorTag(false, red, green, blue);
  }
  
  public static String createTrueColorTag(int[] color) {
    if (color.length != 3) {
      return "\0";
    }
    return createTrueColorTag(color[0], color[1], color[2]);
  }
  
  public static String colorStringBackgroundByColor(String string, int[] color) {
    if (color.length != 3) {
      return "Your color array is not three you stinky stinky stinky idi ot";
    }

    return createTrueColorTag(true, color[0], color[1], color[2]) + string + RESET;
  }
  public static String colorStringBackgroundByColor(String string, int red, int blue, int green) {
    return createTrueColorTag(true, red, blue, green) + string + RESET;
  }

  public static String colorStringByColor(String string, int red, int blue, int green) {
    return createTrueColorTag(red, blue, green) + string + RESET;
  }

  public static String colorStringByColor(String string, int[] color) {
    if (color.length != 3) {
      return "Your color array is not three you stinky stinky stinky idi ot";
    }
    
    return colorStringByColor(string, color[0], color[1], color[2]);
  }
  
  public static String colorNumbByValue(int number) {
    int[][] colors = new int[][] {
      new int[]{255,255,255},
      new int[]{0,0,255},
      new int[]{0,128,0},
      new int[]{255,0,0},
      new int[]{0,0,128},
      new int[]{128,0,0},
      new int[]{0,128,128},
      new int[]{255,192,0},
      new int[]{128,128,128},
      new int[]{255,255,255}
    };
    
    return colorStringByColor(Integer.toString(number) + " ", colors[number]);
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
    int userInput = scanner.nextInt();
    scanner.nextLine();
    return userInput;
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
    if (charArray.length <= 0) {
      return '\0';
    }
    
    char returnChar = '\0';
    returnChar = getChar(stem + " " +  Arrays.toString(charArray) + " ");
    
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
  
  public static String intIntoThreeWide(int integer) {
    if ((integer < 100) && (integer > -10)) {
      return intIntoTwoWide(integer) + " ";
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
    return (character >= 'A' && (character <= 'Z'));
  }

  public static boolean isCharLower(char character) {
    return ((character >= 'a') && (character <= 'z'));
  }

  public static char makeCharUpper(char character) {
    if (isCharUpper(character)) {
      return character;
    }
    
    // The space character's ascii value is 32, and the space between the uppercase and lowercase sections of ascii are 32 characters apart.
    // Uppercase comes before lowercase in ascii, so we subtract 32 from the char.
    return (char) (character - ' ');
  }
  
  public static boolean isCharNum(char character) {
    return ((character >= '0') && (character <= '9'));
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

  public String getAsString() {
    return getAsString(false);
  }


  final private int[] revealedColor = new int[] {192, 192, 192};
  final private int[] unrevealedColor = new int[] {64, 64, 64};
  public String getAsString(boolean addSpace) {
    char charValue = getAsChar();
    String coloredString = "" + charValue;
    if (addSpace) coloredString += " ";

    if (BasicArithmetic.isCharNum(charValue)) {
      coloredString =  ConsoleColors.colorNumbByValue(Integer.valueOf(charValue - '0'));
    } else if (charValue == 'F') {
      coloredString =  ConsoleColors.colorStringByColor(coloredString, 255, 0, 0);
    } else {
      coloredString = ConsoleColors.colorStringByColor(coloredString, 255, 255, 255);
    }

    if (revealed) {
      coloredString = ConsoleColors.colorStringBackgroundByColor(coloredString, revealedColor);
    } else {
      coloredString = ConsoleColors.colorStringBackgroundByColor(coloredString, unrevealedColor);
    }
    
    
    return coloredString;
  }
  
  public void attemptTurnIntoMine() {
    if (isMine) {
      return;
    }
    
    isMine = true;
    numbOfMines += 1;
  }
  
  public void flagOrUnflag() {
    if (flagged) {
      flagged = false;
    } else {
      flagged = true;
    }
  }
  
  public boolean isCleared() {
    if (isMine && (!flagged)) {
      return false;
    } else if ((!isMine) && (!revealed)) {
      return false;
    }
    
    return true;
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
  
  public boolean isPositionOutOfBounds(Position position) {
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
      Output.print(BasicArithmetic.intIntoThreeWide(yIndex));
      for (int xIndex = 0; xIndex < width; xIndex++) {
        Output.print(board[xIndex][yIndex].getAsString(true));
        // Output.print(" "); Uneeded; the extra space is now in `getAsString`
      }
      Output.println();
    }
  }
  
  public byte isCellAMine(Position position) {
    if (isPositionOutOfBounds(position)) {
      return 0;
    }
    
    return BasicArithmetic.boolToByte(board[position.x][position.y].isMine);
  }

  public void flagOrUnflag(Position position) {
    board[position.x][position.y].flagOrUnflag();
  }
  
  public void calcCellsNeighbors(Position position) {
    Cell currentCell = board[position.x][position.y];
    
    if (currentCell.isMine) {
      return;
    }
    
    byte foundMines = 0;
    for (Position deltaPosition : Position.getEightDirectionsAdded(position)) {
      foundMines += (byte) isCellAMine(deltaPosition);
    }
    currentCell.neighborMines = (byte) foundMines;
  }
  
  public void calculateAllNeighbors() {
    for (int xIndex = 0; xIndex < width; xIndex++) {
      for (int yIndex= 0; yIndex < height; yIndex++) {
        calcCellsNeighbors(new Position(xIndex, yIndex));
      }
    }
  }
  
  public boolean neighborMinesFlagged(Position position) {
    for (Position neighborPosition : Position.getEightDirectionsAdded(position)) {
      if (isPositionOutOfBounds(neighborPosition)) {
        continue;
      }
      
      Cell currentNeighbor = board[neighborPosition.x][neighborPosition.y];
      if (currentNeighbor.isMine && !currentNeighbor.flagged) {
        return false;
      }
    }
    return true;
  }
  
  public void revealCellsAroundRevealed(Position position) {
    if (isPositionOutOfBounds(position)) {
      return;
    }
    
    Cell currentCell = board[position.x][position.y];
    
    if (currentCell.isMine) {
      return;
    } else if (!neighborMinesFlagged(position)) {
      return;
    }
    
    Position[] neighbors = Position.getEightDirectionsAdded(position);
    for (Position neighbor : neighbors) {
      if (board[neighbor.x][neighbor.y].flagged) {
        continue;
      }
      revealCell(neighbor, true);
    }
  }
  
  public boolean revealCell(Position position) {
    return revealCell(position, false);
  }
  
  public boolean revealCell(Position position, boolean isFromRevealAroundCell) {
    if (isPositionOutOfBounds(position)) {
      return false;
    }
    
    Cell currentCell = board[position.x][position.y];
    
    if (!isFromRevealAroundCell && currentCell.revealed) {
      revealCellsAroundRevealed(position);
    } else if (currentCell.revealed) {
      return false;
    }
    currentCell.revealed = true;

    if (currentCell.isMine) {
      board[position.x][position.y].exploded = true;
      return true;
    }
    
    if (currentCell.neighborMines == 0) {
      Position[] neighbors = Position.getEightDirectionsAdded(position);
      
      for (Position neighbor : neighbors) {
        revealCell(neighbor, true);
      }
    }
    return false;
  }

  public void revealAllCells() {
    for (int xIndex = 0; xIndex < width; xIndex++) {
      for (int yIndex = 0; yIndex < height; yIndex++) {
        board[xIndex][yIndex].revealed = true;
        if (board[xIndex][yIndex].isMine) {
          board[xIndex][yIndex].exploded = true;
        }
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

  public boolean isBoardCleared() {
    for (Cell[] rows: board) {
      for (Cell cell : rows) {
        if (!cell.isCleared()) {
          return false;
        }
      }
    }
    
    return true;
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
    boolean cellWasMine = false;
    while (playingRound) {
      field.printBoard();
      Output.println();
      
      flagOrReveal = Input.getCharInArray("Input either \"F\"lag/Unflag or \"R\"eveal", new char[]{'f', 'F', 'r', 'R'});
      flagOrReveal = BasicArithmetic.makeCharUpper(flagOrReveal);
      
      int chosenX = Input.askForInt("X position? ");
      int chosenY = Input.askForInt("Y position? ");
      
      Position chosenPosition = new Position(chosenX, chosenY);
      if (field.isPositionOutOfBounds(chosenPosition)) {
        continue;
      }
      
      if (flagOrReveal == 'F') {
        field.flagOrUnflag(chosenPosition);
      } else if (flagOrReveal == 'R') {
        cellWasMine = field.revealCell(chosenPosition);
      }
      
      if (cellWasMine) {
        playingRound = false;
        Output.println("\nyou TOUCHED a MINE!");

        field.revealAllCells();
        field.printBoard();
        break;
      }
      

      if (field.isBoardCleared()) {
        Output.println("\ngoog joob");
        break;
      }
    }
  }
  
  public void startGame() {
    double percentageOfMines = Input.askForInt("Percentage of mines? %") / 100d;
    Output.println();

    field.attemptToAddMines((int) (percentageOfMines * field.width * field.height));
    field.calculateAllNeighbors();
    
    field.revealRandomZeroCell();

    gameLoop();
  }
}
