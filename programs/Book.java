public class Book {
  String title;
  String author;
  
  public Book(String setTitle, String setAuthor) {
    title = setTitle;
    author = setAuthor;
  }
  
  private static void println(Object obj) {
    System.out.println(obj);
  }

  public void printBookInfo() {
    println(String.format(
      "%s, by %s", title, author
    ));
  }
  
  public static void main(String[] args) {
    Book bookOne = new Book("1984", "George Orwell");
    Book bookTwo = new Book("Kyle's Guide to Being a Sigma", "Kyle Haynes");
    
    println("Book one is:");
    bookOne.printBookInfo();
    println("");
    
    println("Book two is:");
    bookTwo.printBookInfo();
  }
}
