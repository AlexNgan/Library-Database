/* Author: Gloria Ngan
 * 
 * This is the class that acts as the library, holding
 * the books and allowing interactions with the books
 * using methods to add, remove, borrow, return, and
 * browse the books.
 */

public class Library{
  //Untested; ArrayList of Strings or Book objects???.
  private ArrayList<Book> database = new ArrayList<Book>();     //Holds all books.
  
  //Constructor.
  public Library(){
    //Need to import books from .txt file.
  }
  
  //Modifier method to add a books to database.
  public addNewBook(Book book){
    database.add(book);
  }
  
  //Modifier method to remove books from database.
  public removeOldBook(Book book){
    database.remove(book);
  }
  
  //NOTE: DO WE NEED????
  //Method to mark a book as borrowed if it is available.
  public void borrowBook(Book book){
    book.makeBorrowed();
  }
  
  public void returnBook(Book book){
    book.makeReturned();
  }
  
  //Method to display all books in the library.
  public void browse(){
     System.out.println(database);
  }
}
