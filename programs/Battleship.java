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

  public static void println() {
    println("");
  }
  
  public static void print(Object obj) {
    System.out.print(obj);
  }
}

class Positions {
  int x, y;
  
  public Positions(int setX, int setY) {
    x = setX;
    y = setY;
  }
  
  public Positions(int[] position) throws IllegalArgumentException {
    if (position.length != 2) {
      throw new IllegalArgumentException("Position array must be 2 ints long");
    }
    
    x = position[0];
    y = position[1];
  }

  public static Positions getDefault() {
    return new Positions(-1, -1);
  }

  public Positions addDirection(Direction direction) {
    return addDirection(direction, 1);
  }

  public Positions addDirection(Direction direction, int amount) {
    return addDirection(direction, amount, new Positions(x, y));
  }
  
  public Positions addDirection(Direction direction, int amount, Positions position) {
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
    Positions newPosition = addDirection(direction, amount, new Positions(x, y));
    x = newPosition.x;
    y = newPosition.y;
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
    if (shot) {
      return;
    }
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
  public Positions position;
  public int shipID;

  public Ship(int setLength, String shipName) throws IllegalArgumentException {
    
    if (length <= 0) {
      throw new IllegalArgumentException("Ship length must be more than 0.");
    }
    length = setLength;

    position = Positions.getDefault();
  }

  public List<Positions> getOccupiedSquaresPositions() {
    List<Positions> returnSquares = new ArrayList<>();
    Positions deltaPosition = position;

    for (int squareIndex = 0; squareIndex < length; squareIndex++) {
      returnSquares.add(deltaPosition.addDirection(direction, squareIndex));
    }
    
    return returnSquares;
  }
}

class Grid {
  public GridSquare[][] squares;
  public int width, height;

  public final char[] rowLabels = {
    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'
  };
  

  public Grid(int size) {
    width = size;
    height = size;
    squares = new GridSquare[size][size];

    // To initialize every grid square; they're null if i don't for some reason????
    for (int xIndex = 0; xIndex < width; xIndex++) {
      for (int yIndex = 0; yIndex < height; yIndex++) {
        squares[xIndex][yIndex] = new GridSquare();
      }
    }
  }

  public GridSquare getSquareAt(Positions position) {
    return squares[position.x][position.y];
  }

  public void printSquareAt(Positions position, boolean includeSpace) {
    char squareChar = getSquareAt(position).getAsChar();
    Output.print(squareChar);
    if (includeSpace) {
      Output.print(' ');
    }
  }

  public void printSquareAt(Positions position) {
    printSquareAt(position, true);
  }

  public void printState(boolean printLabels) {
    printState(printLabels, true);
  }

  public void printState(boolean printLabels, boolean reveal) {
  if (printLabels) {
    for (int xIndex = 0; xIndex < width; xIndex++) {
      Output.print(String.valueOf(xIndex) + " ");
    }
    Output.println();
  }

    for (int yIndex = 0; yIndex < height; yIndex++) {
      for (int xIndex = 0; xIndex < width; xIndex++) {
        if (reveal) {
          squares[yIndex][xIndex].reveal();
        }
        
        printSquareAt(new Positions(yIndex, xIndex));
        
        if (reveal) {
          squares[yIndex][xIndex].hide();
        }
      
      }
      if (printLabels) {
        Output.print(" " + rowLabels[yIndex]);
      }
      Output.println();
    }
  }
}


public class Battleship {
  public static void main(String[] args) {
    Grid grid = new Grid(10);
    grid.printState(true);
  }


  public static void startGame() {
    
  }
}
