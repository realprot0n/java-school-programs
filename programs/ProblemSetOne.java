import java.util.Arrays;
import java.util.List;
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
  static boolean lastWasInt = false;

  public static void initialize() {
    if (initialized) {
      return;
    }
    scanner = new Scanner(System.in);
    initialized = true;
    lastWasInt = false;
  }

  public static int askForInt(String stem) {
    if (scanner == null) {
      return -1;
    }
    lastWasInt = true;
    Output.print(stem);
    return scanner.nextInt();
  }

  public static String getString(String stem) {
    if (scanner == null) {
      return null;
    } else if (lastWasInt) {
      return null;
    }
    Output.print(stem);
    return scanner.nextLine();
  }
  
  public static char getChar(String stem) {
    if (lastWasInt) {
      return '\0';
    }
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
    
    // The space character's ascii value is 32, and the space between the uppercase and lowercase sections of ascii is 32 characters apart.
    // Uppercase comes before lowercase in ascii, so we subtract 32 from the char.
    return (char) (character - ' ');
  }
}

class Book {
  private String title;
  private String author;
  private int year;
  private boolean checkedOut;
  private String checkouter;
  
  public Book(String setTitle, String setAuthor, int setYear) {
    title = setTitle;
    author = setAuthor;
    year = setYear;
    checkedOut = false;
    checkouter = "";
  }
  
  public String getTitle() {
    return title;
  }
  
  public String getAuthor() {
    return author;
  }
  
  public int getYear() {
    return year;
  }
  
  public boolean isCheckedOut() {
    return checkedOut;
  }
  
  public String getCheckouter() {
    return checkouter;
  }
  
  public String getAsString() {
    if (!checkedOut){
      return String.format("\"%s\", by %s in %d", title, author, year);
    }
    
    return String.format("\"%s\", by %s in %d (CHECKED OUT)", title, author, year);
  }
  
  public static Book[] getSampleBooks() {
    return new Book[] {
      new Book("1984", "George Orwell", 1949),
      new Book("Ultimate Guide to Fort Nite", "Kyle Haynes", 2019),
      new Book("Why Java is the Best Language", "Not Kyle Haynes", 2025),
      new Book("Why my Rocks are Blue", "Walter White", 2013),
      new Book("Why my Balls are Also Blue", "Walter White", 2014),
      new Book("How to Write a Book", "John Johnenstein", 1987),
      new Book("How to Write a Book About Writing a Book", "Jane Surname", 1979),
      new Book("All Chairs Need Cushioning", "Jessie Pinkman", 2001),
      new Book("All About Pipis", "Spamton G. Spamton", 2022),
      new Book("Huh? What?", "Tonald Drump", 2026)
    };
  }
  
  public boolean checkBookOut(String newCheckouter) {
    if (checkedOut) {
      return false;
    }
    
    checkedOut = true;
    checkouter = newCheckouter;
    return true;
  }
}

class Library {
  public List<Book> books;
  
  public Library(List<Book> setBooks) {
    books = setBooks;
  }
  
  public Library(Book[] setBooks) {
    books = Arrays.asList(setBooks);
  }
  
  public void addBook(Book book) {
    books.add(book);
  }
  
  public void addBooks(Book[] booksToAdd) {
    for (Book book : booksToAdd) {
      addBook(book);
    }
  }
  
  public void printBooks() {
    for (Book book : books) {
      Output.println(book.getAsString());
    }
  }
}

public class ProblemSetOne {
  public static void main(String[] args) {
    Library library = new Library(Book.getSampleBooks());
    
    library.printBooks();
    
  }
}