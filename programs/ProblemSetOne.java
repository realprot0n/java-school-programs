import java.util.Arrays;
import java.util.List;

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